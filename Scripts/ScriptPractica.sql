drop database if exists Marketplace;

create database Marketplace;

use Marketplace;

create or replace table Usuario (
	dni char(9) primary key,
	nombre varchar(25) not null,
	apellidos varchar(60) not null,
	pais text not null,
	telefono varchar(15) not null
);

create or replace table Login (
	nickname varchar(50) primary key,
	email varchar(50) unique not null,
	contrasenha varchar(14) not null,
	dni char(9) not null,
	foreign key (dni) references Usuario (dni)
		on delete cascade
		on update cascade
);

create or replace table Direccion (
	id int auto_increment primary key,
	calle varchar(50) not null,
	numero int not null,
	piso int,
	letra char(1),
	cod_postal int not null,
	poblacion text not null
);

create or replace table Login_Direccion (
	nickname varchar(50),
	id int,
	primary key (nickname,id),
	foreign key (nickname) references Login (nickname)
		on delete cascade
		on update cascade,
	foreign key (id) references Direccion (id)
		on delete cascade
		on update cascade
);

create or replace table Producto (
	id int auto_increment primary key,
	stock int default(0),
	marca enum ('INTEL','AMD','MSI','NVIDIA','ACER','ASROCK','ASUS','DELL','GIGABYTE','BENQ',
		'CORSAIR','EVGA','HP','ALIENWARE','RAZER','LOGITECH','NZXT','SAPPHIRE','OTRO') not null default('OTRO'),
	modelo varchar(15) unique not null,
	PVP float(4,2) not null default(0),
	precio_venta float(4,2) not null default(0)
);

create or replace table Componente (
	id_p int primary key,
	tipo enum ('Tarjeta gráfica','Memoria RAM','Placa base','Disco duro SSD','Disco duro HDD',
		'Tarjeta de red','Tarjeta de sonido','Ventidalor','Refrigeración líquida','Fuente de alimentación','Procesador','Otros') not null default('Otros'),
	conexion enum ('Molex','SATA','Cable PCIe','ATX o ATX2','EPS','Socket','Slot',
		'Conector de ventilación','PCI-Express','Slot M.2','Thunderbolt','Firewire','AT Keyboard','Otros') not null default('Otros'),
	foreign key (id_p) references Producto (id)
		on delete cascade
		on update cascade
);

create or replace table Periferico (
	id_p int primary key,
	tipo enum ('Monitor','Teclado','Ratón','Impresora','Escáner',
		'Proyector','Auriculares','Altavoces','Impresora multifunción','Impresora 3D','Otros') not null default('Otros'),
	foreign key (id_p) references Producto (id)
		on delete cascade
		on update cascade
);

create or replace table Periferico_Conexion (
	id_p int,
	conexion enum ('USB','HDMI','VGA','BLUETOOHT','WIFI','LAN','USB-C','MICRO-HDMI','MICRO-USB','LIGTHNING','Otros') not null default('Otros'),
	primary key(id_p,conexion),
	foreign key (id_p) references Periferico (id_p)
		on delete cascade
		on update cascade
);

create or replace table Venta (
	albaran int auto_increment primary key,
	precio_final double(6,2) not null,
	fecha date not null,
	hora time not null,
	precio_total double(6,2) not null,
	nickname varchar(50) not null,
	foreign key (nickname) references Login (nickname)
		on delete restrict
		on update cascade
);

create or replace table Pack (
	id int auto_increment primary key,
	PVP double(5,2) not null default (0)
);

create or replace table Venta_Producto (
	albaran int,
	id int,
	primary key (albaran,id),
	foreign key (albaran) references Venta (albaran)
			on delete cascade
			on update cascade,
	foreign key (id) references Producto (id)
			on delete restrict
			on update cascade
);
	
create or replace table Venta_Pack (
albaran int,
id int,
primary key (albaran,id),
foreign key (albaran) references Venta (albaran)
		on delete cascade
		on update cascade,
foreign key (id) references Pack (id)
		on delete restrict
		on update cascade
);

create or replace table Producto_Pack (
id_prodc int,
id_pack int,
primary key (id_prodc,id_pack),
foreign key (id_prodc) references Producto (id)
		on delete cascade
		on update cascade,
foreign key (id_pack) references Pack (id)
		on delete cascade
		on update cascade
);

create or replace table Envio (
	id int auto_increment primary key,
	id_venta int,
	direccion_id int,
	fecha date,
	empresa_envio enum('SEUR','Correos','MRW','UPS','DHL Express','FedEx','GLS','NACEX','Cacesa','Envialia',
		'Monday Relay','Starpack','TNT','Zeleris') not null,
	foreign key (direccion_id) references Direccion (id)
		on delete restrict
		on update cascade,
	foreign key (id_venta) references Venta (albaran)
		on delete restrict
		on update cascade
);
