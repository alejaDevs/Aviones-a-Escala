create database aviones_Escala;
set global time_zone = "-6:00";
drop database aviones_Escala;
use aviones_Escala;

create table if not exists Usuario(
	id_usuario int not null auto_increment,
    primary key (id_usuario),
    usuario varchar (50),
	unique (usuario),
    contrasenia varchar (50)
);

create table if not exists Cliente (
	id_cliente int not null auto_increment,
    primary key (id_cliente),
    unique (id_cliente),
    nombre varchar (200),
    apellido varchar (250),
    direccion varchar (500),
    telefono varchar (10),
    email varchar (500),
    fecha datetime
);

create table if not exists Escala(
	id_escala int not null auto_increment,
    primary key (id_escala),
    unique (id_escala),
    escala varchar (100)
);

create table if not exists Proveedor(
	id_proveedor int not null auto_increment,
    primary key (id_proveedor),
    unique (id_proveedor),
    proveedor varchar (100)
);

create table if not exists Aviones(
	id_aviones int not null auto_increment,
    primary key (id_aviones),
    unique (id_aviones),
    nombre varchar (200),
	modelo varchar (50),
    marca varchar (100),
    id_escala int not null,
    id_proveedor int not null,
    precio float
);

create table if not exists Compra_Venta(
	id_compra_venta int not null auto_increment,
    primary key (id_compra_venta),
    unique (id_compra_venta),
    id_usuario int not null,
    id_aviones int not null,
    fecha datetime,
    foreign key (id_usuario) references Usuario(id_usuario),
    foreign key (id_aviones) references Aviones(id_aviones)
);