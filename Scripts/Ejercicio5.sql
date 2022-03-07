drop database if exists ejercicio5;

create database ejercicio5;

use ejercicio5;

create or replace table Hoteles (
id int auto_increment primary key,
nombre varchar(100) not null,
direccion text not null,
telefono varchar(15) not null,
plazas_dispo int not null
);

create or replace table Vuelos (
num_vuelo varchar(15) primary key,
fecha date not null,
hora time not null,
origen varchar(50) not null,
destino varchar(50) not null,
plazas_totales int not null,
plazas_turista int not null
);

create or replace table Agencias (
id int auto_increment primary key,
direccion text not null,
telefono varchar(15) not null
);

create or replace table Clientes (
id int auto_increment primary key,
nombre varchar(25) not null,
apellidos varchar(30) not null,
direccion text not null,
telefono varchar(15) not null
);

create or replace table Clientes_Hoteles (
id_c int,
id_h int,
fecha_entrada date not null,
fecha_salida date not null,
regimen enum('HABITACIÓN','MEDIA PENSIÓN','DESAYUNO', 'PENSIÓN COMPLETA', 'TODO INCLUIDO') not null,
primary key (id_c,id_h,fecha_entrada),
foreign key (id_c) references Clientes (id)
	on delete cascade
	on update cascade,
foreign key (id_h) references Hoteles (id)
	on delete restrict
	on update cascade
);

create or replace table Clientes_Vuelos (
id_c int,
id_v varchar(15),
clase enum('TURISTA', 'PRIMERA') not null,
primary key (id_c, id_v),
foreign key (id_c) references Clientes (id)
	on delete cascade
	on update cascade,
foreign key (id_v) references Vuelos (num_vuelo)
	on delete restrict
	on update cascade
);

create or replace table Agencias_Clientes (
id_a int,
id_c int,
primary key (id_a,id_c),
foreign key (id_a) references Agencias (id)
	on delete restrict
	on update cascade,
foreign key (id_c) references Clientes (id)
	on delete cascade
	on update cascade	
);


