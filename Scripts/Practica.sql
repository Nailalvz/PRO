drop database if exists Marketplace3;

create database Marketplace3;

use Marketplace3;

create or replace table Usuario (
dni char(9) primary key,
nombre varchar(25) not null,
apellidos varchar(60) not null,
pais enum('España','Portugal') not null,
telefono varchar(15) not null,
id_venta int
);

create or replace table Direccion (
id int auto_increment primary key,
dni char(9) not null,
calle varchar(50) not null,
numero int not null,
piso int,
letra char(1),
cod_postal int not null,
poblacion enum('Pontevedra','Coruña','Ourense','Lugo','Álava','Albacete','Alicante','Almería','Asturias','Ávila','Badajoz','Barcelona','Burgos','Cáceres','Cádiz','Cantabria','Castellón','Ciudad real','Córdoba',
'Cuenca','Gerona','Granada','Guadalajara','Gipúzcoa','Huelva','Huesca','Islas Baleares','Jaén','León','Lérida','Madrid','Málaga','Murcia','Navarra','Palencia','Las Palmas','La Rioja','Salamanca','Segovia','Sevilla',
'Soria','Tarragona','Santa Cruz de Tenerife','Teruel','Toledo','Valencia','Valladolid','Vizcaya','Zamora','Zaragoza') not null,
foreign key (dni) references Usuario (dni)
	on delete cascade
	on update cascade
);

create or replace table Login (
nickname varchar(50) unique,
email varchar(50) unique not null,
contrasenha char(64) not null, /* Hay que cambiar la contraseña para encriptarla SHA-256 (Security Hash Algorithm)*/
dni char(9) not null,
primary key (nickname, dni),
foreign key (dni) references Usuario (dni)
	on delete cascade
	on update cascade
);

create or replace table Componente (
	modelo int auto_increment primary key,
	marca enum ('INTEL','AMD','MSI','NVIDIA','ACER','ASROCK','ASUS','DELL','GIGABYTE','BENQ',
	'CORSAIR','EVGA','HP','ALIENWARE','RAZER','LOGITECH','NZXT','SAPPHIRE','OTRO') not null,
	stock int default(0),
	PVP int not null,
	precio_venta int not null,
	tipo enum ('Tarjeta gráfica','Memoria RAM','Placa base','Disco duro SSD','Disco duro HDD',
		'Tarjeta de red','Tarjeta de sonido','Ventidalor','Refrigeración líquida','Fuente de alimentación','Procesador','Otros') not null,
	conexion enum ('Molex','SATA','Cable PCIe','ATX o ATX2','EPS','Socket','Slot',
		'Conector de ventilación','PCI-Express','Slot M.2','Thunderbolt','Firewire','AT Keyboard','Otros') not null
);

create or replace table Periferico (
	modelo int auto_increment primary key,
	marca enum ('INTEL','AMD','MSI','NVIDIA','ACER','ASROCK','ASUS','DELL',
		'GIGABYTE','BENQ','CORSAIR','EVGA','HP','ALIENWARE','RAZER','LOGITECH','NZXT','SAPPHIRE','OTRO') not null,
	stock int default(0),
	PVP int not null,
	precio_venta int not null,
	tipo enum ('Monitor','Teclado','Ratón','Impresora','Escáner',
		'Proyector','Auriculares','Altavoces','Impresora multifunción','Impresora 3D','Otros') not null default('Otros'),
	conexion enum ('USB','HDMI','VGA','BLUETOOHT','WIFI','LAN','USB-C','MICRO-HDMI','MICRO-USB','LIGTHNING','Otro') not null
);

create or replace table Venta (
albaran int auto_increment primary key,
fecha date not null,
hora time not null,
precio_total int not null,
precio_final int not null,
dni char(9),
foreign key (dni) references Usuario (dni)
	on delete restrict
	on update cascade
);

alter table Usuario 
	add constraint id_venta
		foreign key (id_venta) references Venta (albaran)
		on delete cascade
		on update cascade;

create or replace table Envio (
id int auto_increment primary key,
id_venta int,
direccion_id int,
fecha date,
empresa_envio enum('SEUR','Correos') not null,
foreign key (direccion_id) references Direccion (id)
	on delete restrict
	on update cascade,
foreign key (id_venta) references Venta (albaran)
	on delete restrict
	on update cascade
);

create or replace table Venta_Componente (
modelo int,
albaran int,
primary key (modelo, albaran),
foreign key (modelo) references Componente (modelo)
	on delete restrict
	on update cascade,
foreign key (albaran) references Venta (albaran)
	on delete cascade
	on update cascade
);

create or replace table Venta_Periferico (
modelo int,
albaran int,
primary key (modelo, albaran),
foreign key (modelo) references Periferico (modelo)
	on delete restrict
	on update cascade,
foreign key (albaran) references Venta (albaran)
	on delete cascade
	on update cascade
);

