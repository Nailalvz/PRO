drop database if exists Emisora;

create database Emisora;

use Emisora;

create or replace table Emisora (
id int auto_increment primary key,
ubicacion varchar(100) not null,
formato varchar(100) not null
);

create or replace table  Presentador (
DNI char(9) primary key,
nombre varchar(50) not null,
email varchar(100) not null
);

create or replace table Telefono (
DNI char(9),
telefono varchar(15),
primary key(DNI, telefono),
foreign key (DNI) references Presentador (DNI)
	on delete restrict
	on update cascade
);

create or replace table Coordinador (
DNI_Coordinador char(9),
DNI_coordinado char(9),
primary key (DNI_Coordinador, DNI_coordinado),
foreign key (DNI_Coordinador) references Presentador (DNI)
	on delete restrict
	on update cascade,
foreign key (DNI_Coordinado) references Presentador (DNI)
	on delete restrict
	on update cascade
);

create or replace table Programa (
nombre varchar(50) primary key,
tematica varchar(50) not null,
franja_horaria time not null,
DNI char(9) not null,
id int not null,
foreign key (DNI) references Presentador (DNI)
	on delete restrict
	on update cascade,
foreign key (id) references Emisora (id)
	on delete restrict
	on update cascade
);

create or replace table Edicion (
nombre varchar(50),
num_secuencial int not null,
fecha date not null,
hora_incio time not null,
hora_fin time not null,
num_oyentes int not null,
primary key (nombre, num_secuencial, fecha),
foreign key (nombre) references Programa (nombre)
	on delete restrict
	on update cascade
);

create or replace table Presentador_Edicion (
DNI char(9),
nombre varchar(50),
num_secuencial int,
fecha date,
primary key (DNI, nombre, num_secuencial, fecha),
foreign key (DNI) references Presentador (DNI)
	on delete restrict
	on update cascade,
foreign key (nombre, num_secuencial, fecha) references Edicion (nombre, num_secuencial, fecha)
	on delete restrict
	on update cascade
);




