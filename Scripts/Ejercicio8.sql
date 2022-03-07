drop database if exists Oficina_Patentes;

create database Oficina_Patentes;

use Oficina_Patentes;

create or replace table Inventor (
	DNI char(9) primary key,
	nombre varchar (60) not null,
	direccion text not null,
	telefono varchar(15) not null
);

create or replace table Ayudante (
	DNI char (9) primary key,
	nombre varchar (60) not null,
	direccion text not null,
	telefono varchar(15) not null,
	DNI_i char(9),
	foreign key (DNI_i) references Inventor (DNI)
		on delete restrict
		on update cascade
);

create or replace table Empresa (
	id int auto_increment primary key,
	nombre varchar(50) not null,
	direccion text not null
);

create or replace table Telefono (
	id int,
	telefono varchar(15),
	primary key (id,telefono),
	foreign key (id) references Empresa (id)
		on delete restrict
		on update cascade
);

create or replace table Patente (
	num int auto_increment primary key,
	nombre_invento varchar(50) unique not null,
	fecha_obtencion date not null,
	fecha_compra date,
	DNI char (9) not null,
	id int,
	foreign key (DNI) references Inventor (DNI)
		on delete restrict
		on update cascade,
	foreign key (id) references Empresa (id)
		on delete restrict
		on update cascade
);

create or replace table Empresa_Inventor (
	DNI char(9),
	id int,
	fecha_contrato date not null,
	num_patente int,
	primary key (DNI,id),
	foreign key (DNI) references Inventor (DNI)
		on delete cascade
		on update cascade,
	foreign key (id) references Empresa (id)
		on delete cascade
		on update cascade,
	foreign key (num_patente) references Patente (num)
		on delete restrict
		on update cascade
);

create or replace table Empresa_Ayudante (
	DNI char(9),
	id int,
	fecha_contrato date not null,
	num_patente int,
	primary key (DNI,id),
	foreign key (DNI) references Ayudante (DNI)
		on delete cascade
		on update cascade,
	foreign key (id) references Empresa (id)
		on delete cascade
		on update cascade,
	foreign key (num_patente) references Patente (num)
		on delete restrict
		on update cascade
);

create or replace table Inventor_Asesor (
	inventor char(9),
	asesor char(9),
	num_patente int,
	primary key (inventor,asesor,num_patente),
	foreign key (inventor) references Inventor (DNI)
		on delete cascade
		on update cascade,
	foreign key (asesor) references Inventor (DNI)
		on delete cascade
		on update cascade,
	foreign key (num_patente) references Patente (num)
		on delete cascade
		on update cascade
);