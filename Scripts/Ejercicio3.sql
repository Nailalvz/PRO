drop database if exists ejercicio3;

create database ejercicio3;

use ejercicio3;

create or replace table Departamento (
id int primary key auto_increment,
nombre varchar(25) not null unique,
director char(10)
);


create or replace table Profesores (
NRP char(10) primary key,
nombre varchar(50) not null,
area_conocimiento varchar(30) not null,
categoria varchar(20) not null,
id int default 0
);

alter table Departamento 
 add constraint director
	foreign key (director) references Profesores (NRP)
		on delete restrict
		on update cascade;

alter table Profesores
 add constraint id
		foreign key (id) references Departamento (id)
		on delete set default 
		on update cascade;

create or replace table Asignaturas (
id int auto_increment primary key,
nombre varchar(20) not null,
creditos int not null,
curso char(2) not null,
caracter enum('Troncal','Obligatorial','Optativa') not null,
NRP char(10) not null,
foreign key (NRP) references Profesores (NRP)
	on delete cascade # se podría poner se
	on update cascade
);

create or replace table Alumnos (
DNI char(9) primary key,
nombre varchar(5) not null,
fecha_nacimiento date not null,
direccion varchar(100) not null,
beca bool not null default false
);

create or replace table Grupo (
id int,
numero int not null,
max_alumnos int not null,
tipo enum('Práctica', 'Teoría') not null,
primary key (id, numero),
foreign key (id) references Asignaturas (id)
	on delete cascade
	on update cascade
);

create or replace table Profesores_Grupos (
NRP char(10),
id int,
numero int,
primary key (NRP, id, numero),
foreign key (NRP) references Profesores (NRP)
	on delete cascade
	on update cascade,
foreign key (id, numero) references Grupo (id,numero)
	on delete cascade
	on update cascade	
);

create or replace table Matricula (
DNI char(9),
id int,
convocatoria char(9) not null,
nota int,
primary key (DNI,id,convocatoria),
foreign key (DNI) references Alumnos (DNI)
	on delete restrict
	on update cascade,
foreign key (id) references Asignaturas (id)
	on delete cascade
	on update cascade
);

/*
alter table Grupos
	add constraint tiene_profesor 
	check((select Profesores_Grupos.id, Profesores_Grupos.numero, Grupo.id, Grupo.numero from Profesores_Grupos, Grupo where
	Profesores_Grupos.id=Grupo.id and Profesores_Grupos.numero=Grupo.numero) >= 1)
;
*/

create or replace table alumno_grupo (
id int,
numero int,
DNI char(9),
primary key (id,numero,DNI),
foreign key (id, numero) references Grupo (id,numero)
	on delete cascade
	on update cascade,	
foreign key (DNI) references Alumnos (DNI)
	on delete cascade
	on update cascade
);
/*
alter table Alumnos 
	add constraint tiene_matricula
	check(select Alumnos.DNI, Matricula.DNI, alumno_grupo.DNI, Matricula.id, alumno_grupo.id 
	from Alumnos, Matricula, alumno_grupo 
	where Alumnos.DNI=Matricula.DNI and alumno_grupo.DNI=Matricula.DNI and Matricula.id=alumno_grupo.id)
;
*/

