drop database if exists ejercicio1;

create database ejercicio1;

use ejercicio1;

create or replace table Aplicaci�n (
	nombre VARCHAR(50) not null primary key,
	descripci�n VARCHAR(250) not null
);

create or replace table Programadores (
	NIF CHAR(9) primary key,
	nombre VARCHAR(50) not null,
	NSS CHAR(13) not null unique,
	email VARCHAR (100) not null unique
);

create or replace table Incidencias (
	c�digo int not null primary key auto_increment,
	fecha_apertura date not null,
	fecha_cierre date,
	id_pro CHAR(9) not null,
	id_app VARCHAR(100) not null,
	foreign key (id_pro) references Programadores (NIF)
		on delete restrict
		on update cascade,
	foreign key (id_app) references Aplicaci�n (nombre)
		on delete cascade
		on update cascade
);

create or replace table Versiones (
	nombre_app VARCHAR(100) not null,
	id VARCHAR(10) not null,
	primary key (nombre_app, id),
	foreign key (nombre_app) references Aplicaci�n (nombre)
		on delete cascade
		on update cascade
);

create or replace table Programador_Incidencia (
	c�digo int not null,
	NIF CHAR(9) not null,
	tiempo time not null,
	primary key (c�digo, NIF),
	foreign key (c�digo) references Incidencias (c�digo)
		on delete cascade
		on update cascade,
	foreign key (NIF) references Programadores (NIF)
		on delete cascade
		on update cascade
);





