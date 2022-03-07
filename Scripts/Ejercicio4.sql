drop database if exists ejercicio4;

create database ejercicio4;

use ejercicio4;

create or replace table Clientes (
id int auto_increment primary key,
dni char(9) not null unique,
name varchar(50) not null,
phone varchar(15) not null,
adress varchar (150) not null,
aval int,
foreign key (aval) references Clientes (id)
	on delete restrict
	on update cascade
);

create or replace table Agencias (
id_ag int auto_increment primary key,
adress varchar(150) not null,
localidad varchar(60) not null
);

create or replace table Reservas (
id int,
fecha_inicio date,
fecha_fin date not null,
totalPrice double(4,2) not null,
id_ag int,
primary key (id,fecha_inicio),
foreign key (id) references Clientes (id)
	on delete cascade
	on update cascade,
foreign key (id_ag) references Agencias (id_ag)
	on delete restrict
	on update cascade
);

create or replace table Garajes (
id int auto_increment primary key,
num_pla int not null,
adress varchar(150) not null
);

create or replace table Coches (
license varchar(10) primary key,
color varchar(15) not null,
price double(4,2) not null,
model text not null,
marca text not null,
id_g int,
foreign key (id_g) references Garajes (id)
	on delete restrict
	on update cascade
);

create or replace table Coches_Reservas (
id int,
fecha_inicio date,
license varchar(10),
litros double (3,2) not nul l,
indicador bool not null,
primary key (id,fecha_inicio,license),
foreign key (id, fecha_inicio) references Reservas (id, fecha_inicio)
	on delete cascade
	on update cascade,
foreign key (license) references Coches (license)
	on delete restrict
	on update cascade
);

