drop database if exists Parque_Natural;

create database Parque_Natural;

use Parque_Natural;

create or replace table Parque (
nombre varchar(100) primary key,
año date not null,
tipo enum ('RESERVAS NATURALES','ÁREAS MARINAS PROTEGIDAS','MONUMENTOS NATURALES','PAISAJES PROTEGIDOS') not null,
distincion varchar(100),
fecha date
);

create or replace table Parque_Conjunto_Espacio (
nombre varchar(100),
espacio_natural varchar(200) not null,
primary key (nombre,espacio_natural),
foreign key (nombre) references Parque (nombre)
	on delete restrict
	on update cascade
);

create or replace table Parque_Areas_Marinas (
nombre varchar(100),
elem_geo varchar(200) not null,
primary key (nombre,elem_geo),
foreign key (nombre) references Parque (nombre)
	on delete restrict
	on update cascade
);

create or replace table Parque_Monumentos_Naturales (
nombre varchar(100),
elem_natural enum ('ÁRBOLES SINGURALES','FORMACIONES GEOLÓGICAS','YACIMIENTOS PALEONTOLÓGICOS','MINERALÓGICOS','ESTRATOTIPOS') not null,
primary key (nombre,elem_natural),
foreign key (nombre) references Parque (nombre)
	on delete restrict
	on update cascade
);

create or replace table Provincia (
nombre varchar(100),
provincia varchar(50) not null,
primary key (nombre,provincia),
foreign key (nombre) references Parque (nombre)
	on delete restrict
	on update cascade
);

create or replace table Usuario (
DNI char(9) primary key,
nombre varchar(25) not null,
apellidos varchar(50) not null,
fecha_nac date not null,
direccion text not null,
cp int not null,
email varchar(50) not null
);

create or replace table Telefono (
DNI char(9),
telefono varchar(15),
primary key (DNI,telefono),
foreign key (DNI) references Usuario (DNI)
	on delete cascade
	on update cascade
);

create or replace table Usuario_Parque (
DNI char(9),
nombre varchar(100),
QR text not null,
primary key (DNI,nombre),
foreign key (DNI) references Usuario (DNI)
	on delete cascade
	on update cascade,
foreign key (nombre) references Parque (nombre)
	on delete restrict
	on update cascade
);

create or replace table Ruta_Panoramica (
id int auto_increment primary key,
dificultad enum ('INICIAL','MEDIO','DIFÍCIL','EXPERTO') not null,
localidad_comienzo text not null,
localidad_fin text not null
);

create or replace table Accidente_Geografico (
nombre varchar(100) primary key,
importancia enum ('NIVEL 1','NIVEL 2','NIVEL 3') not null,
tipo enum ('INCLINACIÓN','FLUVIAL','MONTAÑOSO','GLACIAR','VOLCÁNICO') not null
);

create or replace table Ruta_Accidente (
id int,
nombre varchar(100),
primary key (id,nombre),
foreign key (id) references Ruta_Panoramica (id)
	on delete restrict
	on update cascade,
foreign key (nombre) references Accidente_Geografico (nombre)
	on delete restrict
	on update cascade
);

create or replace table Parque_Accidente (
nombre_p varchar(100),
nombre_a varchar(100),
primary key (nombre_p,nombre_a),
foreign key (nombre_p) references Parque (nombre)
	on delete cascade
	on update cascade,
foreign key (nombre_a) references Accidente_Geografico (nombre)
	on delete restrict
	on update cascade
);






