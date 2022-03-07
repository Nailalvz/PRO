drop database if exists Reserva_Natural;

create database Reserva_Natural;

use Reserva_Natural;

create or replace table Empleado (
id int auto_increment primary key,
fecha_inicio date not null,
nombre varchar(50) not null,
telefono varchar(15) not null,
direccion text not null,
tipo enum ('CUIDADOR','GUÍA')
);

create or replace table Zona (
nombre varchar(100) primary key,
extension double (4,2) not null
);

create or replace table Especie (
nombre_cientifico varchar(30) not null primary key,
nombre_español varchar(30) not null,
descripcion text not null,
zona varchar(100),
foreign key (zona) references Zona (nombre)
	on delete restrict
	on update cascade
);

create or replace table Habitat (
nombre varchar(100) primary key,
vegetacion varchar(100) not null,
clima varchar(50) not null
);

create or replace table Especie_Habitat (
nombre_e varchar(30),
nombre_h varchar(100),
primary key (nombre_e,nombre_h),
foreign key (nombre_e) references Especie (nombre_cientifico)
	on delete cascade
	on update cascade,
foreign key (nombre_h) references Habitat (nombre)
	on delete cascade
	on update cascade
);

create or replace table Continente (
nombre_continente enum('ASIA','ANTÁRTIDA','EUROPA','ÁFRICA','OCEANÍA','AMÉRICA'),
nombre varchar(30),
primary key (nombre_continente, nombre),
foreign key (nombre) references Especie (nombre_cientifico)
	on delete cascade
	on update cascade
);

create or replace table Itinerario (
id char(10) primary key,
longitud decimal (3,2) not null,
duracion time not null,
max_visitantes int not null,
num_especies int not null
);

create or replace table Cuidador_Especie (
id int,
nombre_e varchar(30),
fecha_cuidado date not null,
primary key (id, nombre_e),
foreign key (id) references Empleado (id)
	on delete cascade
	on update cascade,
foreign key (nombre_e) references Especie (nombre_cientifico)
	on delete restrict
	on update cascade
);

create or replace table Guia_Itinerario (
id_e int,
id_i char(10),
hora_itinerario time not null,
primary key (id_e,id_i,hora_itinerario),
foreign key (id_e) references Empleado (id)
	on delete restrict
	on update cascade,
foreign key (id_i) references Itinerario (id)
	on delete restrict
	on update cascade
);

create or replace table Itinerario_Zona (
id char(10),
zona varchar(100),
primary key (id,zona),
foreign key (id) references Itinerario (id)
	on delete cascade
	on update cascade,
foreign key (zona) references Zona (nombre)
	on delete cascade
	on update cascade
);

