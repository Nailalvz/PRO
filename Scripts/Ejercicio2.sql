drop database if exists ejercicio2;

create database ejercicio2;

use ejercicio2;

create or replace table Becarios (
DNI char(9) primary key,
NSS char(13) not null unique,
nombre varchar(20) not null,
apellidos varchar(50) not null,
sustituto char(9) not null,
fecha_nacimiento date not null,
foreign key (sustituto) references Becarios (DNI)
	on delete restrict
	on update cascade
) ENGINE = InnoDB;


create or replace table Laboratorios (
id int primary key auto_increment,
num_planta int(2) not null,
supervisor char(9) not null,
foreign key (supervisor) references Becarios (DNI)
	on delete restrict
	on update cascade
) ENGINE = InnoDB;


create or replace table Ordenadores (
id int primary key auto_increment,
direc_ip varchar(15) not null,
fecha_compra date not null,
id_laboratorio int,
foreign key (id_laboratorio) references Laboratorios (id)
	on delete restrict
	on update cascade
) ENGINE = InnoDB;

create or replace table Fabricantes (
código varchar(10) primary key,
nombre varchar(40) not null,
direc_web varchar(20) unique not null,
telefono varchar(15) not null,
telefono2 varchar(15) null
) ENGINE = InnoDB;


create or replace table Componentes (
código_modelo varchar(10) primary key,
descripción varchar(70) not null,
id_fabricante varchar(10) not null,
foreign key (id_fabricante) references Fabricantes (código)
	on delete restrict
	on update cascade
) ENGINE = InnoDB;

create or replace table Ordenadores_Componentes (
código_modelo varchar(10) not null,
id_ordenador int not null,
primary key (código_modelo, id_ordenador),
foreign key (código_modelo) references Componentes (código_modelo)
	on delete restrict
	on update cascade,
foreign key (id_ordenador) references Ordenadores (id)	
	on delete restrict
	on update cascade
) ENGINE = InnoDB;



