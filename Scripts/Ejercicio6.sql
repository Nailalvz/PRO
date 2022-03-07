drop database if exists Hospital;

create database Hospital;

use Hospital;

create or replace table Plantas (
num_planta int auto_increment primary key,
superficie double (4,2) not null
);

create or replace table Habitaciones (
num_habitacion int auto_increment,
num_planta int,
tipo enum ('INTERIOR','EXTERIOR') not null,
primary key (num_habitacion, num_planta),
foreign key (num_planta) references Plantas (num_planta)
	on delete restrict
	on update cascade
);

create or replace table Habitacion_Neonatal (
num_habitacion int,
num_planta int,
monotorizacion_cardiaca bool not null,
monotorizacion_respiratoria bool not null,
primary key (num_habitacion, num_planta),
foreign key (num_habitacion, num_planta) references Habitaciones (num_habitacion, num_planta)
	on delete restrict
	on update cascade
);

create or replace table Habitacion_Materna (
num_habitacion int,
num_planta int,
baño bool not null,
telefono int,
primary key (num_habitacion, num_planta),
foreign key (num_habitacion, num_planta) references Habitaciones (num_habitacion, num_planta)
	on delete restrict
	on update cascade
);

create or replace table Camas (
id int auto_increment primary key,
num_habitacion int,
num_planta int,
fecha_compra date not null,
foreign key (num_habitacion, num_planta) references Habitaciones (num_habitacion, num_planta)
	on delete restrict
	on update cascade
);

create or replace table Pacientes (
id_historial char(15) primary key,
NSS char(13) unique not null,
nombre varchar(25) not null,
apellidos varchar(30) not null
);

create or replace table Telefonos (
id_historial char(15),
telefono varchar(15),
primary key (id_historial,telefono),
foreign key (id_historial) references Pacientes (id_historial)
	on delete cascade
	on update cascade
);

create or replace table Pacientes_Camas (
id_c int,
id_p char(15),
fecha_entrada date,
fecha_salida date,
primary key (id_c,id_p,fecha_entrada),
foreign key (id_c) references Camas (id)
	on delete restrict
	on update cascade,
foreign key (id_p) references Pacientes (id_historial)
	on delete restrict
	on update cascade	
);
