use aviones_Escala;
-- DML

-- INSERTA DATOS A LA TABLA USUARIO
insert into Usuario (usuario, contrasenia) 
values ("jrodrigues","rojos");
-- INSERTA DATOS A LA TABLA USUARIO

-- INSERTA DATOS A LA TABLA CLIENTE
insert into Cliente (nombre, apellido, direccion, telefono, email,fecha) 
values ("Josué","Rodrigues","zona 18","12345678","jrodrigues@kinal.gt",now());
-- INSERTA DATOS A LA TABLA CLIENTE

-- INSERTA DATOS A LA TABLA ESCALA
insert into Escala (escala) values ("1/200"),
("1/130"),
("1/150"),
("1/400");
-- INSERTA DATOS A LA TABLA ESCALA

-- INSERTA DATOS A LA TABLA PROVEEDOR
insert into Proveedor (proveedor) 
values ("AeroModelos502"),
("Amazon"),
("Jugueton"),
("Mercado Libre");
-- INSERTA DATOS A LA TABLA PROVEEDOR

-- INSERTA DATOS A LA TABLA AVIONES
insert into Aviones (nombre, modelo, marca, id_escala , id_proveedor, precio) 
values ('SAHSA Boeing 737-200','HR-SHO','ElAviadorModels',1,1,'895'),
('TACA International Airlines Boeing 767-300ER ','N768TA','ElAviadorModels',1,1,'2995'),
('Atlas Air B747-400ERF','N492MC','GeminisJets',1,1,'1675'),
('American B737 MAX8','SKR962','Skymarks',2,1,'425'),
('Avianca A321 Escala','SKR801-04','Skymarks',3,1,'445'),
('Air France Airbus A330-200','F-GZCH','Inflight200',1,1,'1095'),
('Revell Airbus A380 New Livery','B000BM61UU','Revell',3,2,'525'),
('herpa 610735 - Avión Hekla Aurora de Icelandair','B01B6KTTI6','Herpa',1,1,'154.49'),
('Avión Viva Air A320','SKGS15T','Aircraf Model',4,4,'62.56'),
('Avión lufthansa A340','SKUD151WA','Aircraf model',4,4,'1485');
-- INSERTA DATOS A LA TABLA PROVEEDOR

-- INSERTA DATOS A LA TABLA COMPRA_VENTA
insert into Compra_Venta (id_usuario, id_aviones,fecha)
values (1,1,now());
-- INSERTA DATOS A LA TABLA COMPRA_VENTA