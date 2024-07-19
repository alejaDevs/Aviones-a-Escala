use aviones_Escala;
-- STORED PROCEDURE

-- CREATE USUARIO 
DELIMITER //
create procedure sp_crearUsuario(in _usuario varchar (50),
    _contrasenia varchar (50)
    )
    begin insert into Usuario (usuario, contrasenia)
    values (_usuario, _contrasenia);
    end //
DELIMITER ;
call sp_crearUsuario ("jhernandez","kilos");
-- CREATE USUARIO 

-- UPDATE USUARIO
DELIMITER //
	create procedure sp_actualizarUsuario(in _id int, _usuario varchar (50),
    _contrasenia varchar (50)
    )
    begin update Usuario set usuario = _usuario, contrasenia = _contrasenia
	where id_usuario = _id;
    end //
DELIMITER ;
call sp_actualizarUsuario (1,"ksolano","free");
-- UPDATE USUARIO

-- DELETE USUARIO
DELIMITER // 
	create procedure sp_eliminarUsuario(in _id int)
	begin delete from Usuario where id_usuario = _id;
	end //
DELIMITER ;
call sp_eliminarUsuario (2);
-- DELETE USUARIO

-- BROWSE USUARIO
DELIMITER //
	create procedure sp_buscarUsuario (in _id int)
    begin select*from Usuario where id_usuario = _id;
    end //
DELIMITER ;
-- BROWSE USUARIO
call sp_buscarUsuario (1);

-- BROSE USUARIO NOMBRE 
DELIMITER //
	create procedure sp_buscarUsuarioU (in _usuario varchar(20))
    begin select * from Usuario where usuario = _usuario;
    end //
DELIMITER ;
call sp_buscarUsuarioU ("ksolano");
-- BROWSE USUARIO NOMBRE
-- ***************************************************************************************

-- ***************************************************************************************
-- CREATE CLIENTE 
DELIMITER //
create procedure sp_agregarCliente(in _nombre varchar (100),
    _apellido varchar (150),
    _direccion varchar (500),
    _telefono varchar (10),
    _email varchar (500),
    _fecha datetime
    )
    begin insert into Cliente (nombre, apellido, direccion, telefono, email,fecha)
    values (_nombre, _apellido, _direccion, _telefono, _email,_fecha);
    end //
DELIMITER ;
call sp_agregarCliente ("Alejandro","Garcia","18 av 10-68 zona 14","59202506","agarcia@kinal.gt",now());
SELECT * FROM Cliente;
-- CREATE CLIENTE 

-- UPDATE CLIENTE 
DELIMITER //
create procedure sp_actualizarClientes(in _id int, _nombre varchar (100),
    _apellido varchar (150),
    _direccion varchar (500),
    _telefono varchar (10),
    _email varchar (500),
    _fecha datetime
    )
    begin update Cliente set nombre = _nombre, apellido = _apellido, direccion = _direccion, telefono = _telefono, 
    email = _email, fecha = _fecha where id_cliente = _id;
    end // 
DELIMITER ;
call sp_actualizarClientes (1,"Manuel","Gonzales","14 av 12-32 zona 14","56362128","mgonzales@kinal.gt",now());
-- UPDATE CLIENTE 

-- DELETE CLIENTE
DELIMITER // 
	create procedure sp_eliminarClientes(in _id int)
	begin delete from Cliente where id_cliente = _id;
	end //
DELIMITER ;
call sp_eliminarClientes (3);
-- DELETE CLIENTE

-- BROWSE CLIENTE 
DELIMITER // 
	create procedure sp_buscarCliente (in _id int)
    begin select * from Cliente where id_cliente = _id;
    end //
DELIMITER ;
call sp_buscarCliente (1);
-- BROWSE CLIENTE

-- ***************************************************************************************

-- ***************************************************************************************
-- CREATE ESCALA AVIONES
DELIMITER //
	create procedure sp_agregarEscala (in _escala varchar (100))
	begin insert into Escala (escala) values (_escala);
	end //
DELIMITER ;
call sp_agregarEscala ("1/800");
-- CREATE ESCALA AVIONES 

-- UPDATE ESCALA AVIONES
DELIMITER //
	create procedure sp_actualizarEscala (in _id int,
    _escala varchar (100))
    begin update Escala set escala = _escala where id_escala = _id;
    end //
DELIMITER ;
call sp_actualizarEscala (1,"1/700");
-- UPDATE ESCALA AVIONES

-- DELETE ESCALA AVIONES 
DELIMITER //
	create procedure sp_eliminarEscala (in _id int)
    begin delete from Escala where id_escala = _id;
    end //
DELIMITER ;
call sp_eliminarEscala (5);
-- DELETE ESCALA AVIONES 

-- BROWSE ESCALA
DELIMITER //
	create procedure sp_buscarEscala(in _id int)
    begin select * from Escala where id_escala = _id;
    end //
DELIMITER ;
call sp_buscarEscala (1);
-- BROWSE ESCALA 
-- ***************************************************************************************

-- ***************************************************************************************
-- CREATE AVIONES 
DELIMITER //
	create procedure sp_agregarAvion (in _nombre varchar (200),
    _modelo varchar (50),
    _marca varchar (100),
    _id_escala int,
    _id_proveedor int,
    _precio float)
    begin insert into Aviones (nombre, modelo, marca, id_escala, id_proveedor, precio)
    values (_nombre,_modelo,_marca,_id_escala,_id_proveedor,_precio);
    end //
DELIMITER ;	
call sp_agregarAvion ("Dron DJI Mini SE combo","SKU-DJIMINISEC","DJI",1,2,39450.00);
-- CREATE AVIONES

-- UPDTAE AVIONES
DELIMITER //
	create procedure sp_actualizarAvion (in _id int, _nombre varchar (200),
    _modelo varchar (50),
    _marca varchar (100),
    _id_escala int,
    _id_proveedor int,
    _precio float)
    begin update Aviones set nombre=_nombre, modelo=_modelo, marca=_marca,
    id_escala = _id_escala, id_proveedor = _id_proveedor, precio = _precio where id_aviones = _id;
    end //
DELIMITER ;
call sp_actualizarAvion (1,'SAHSA Boeing 737-200','HR-SHO','ElAviadorModels',1,1,'895');
-- UPDATE AVIONES

-- DELETE AVIONES 
DELIMITER // 
	create procedure sp_eliminarAvion (in _id int)
    begin delete from Aviones where id_aviones = _id;
    end //
DELIMITER ;
call sp_eliminarAvion (11);
-- DELETE AVIONES

-- BROWSE AVIONES 
DELIMITER // 
	create procedure sp_buscarAvion (in _id int)
    begin select * from Aviones where id_aviones = _id;
    end //
DELIMITER ;
call sp_buscarAvion (1);
select * from Aviones;
-- BROWSE AVIONES
-- ***************************************************************************************

-- ***************************************************************************************
-- CREATE PROVEEDOR 
DELIMITER // 
	create procedure sp_agregarProveedor (in _proveedor varchar(100))
    begin 
    insert into Proveedor (proveedor) values (_proveedor);
    end //
DELIMITER ;
call sp_agregarProveedor("Walmart");
-- CREATE PROVEEDOR

-- UPDATE PROVEEDOR
DELIMITER //
	create procedure sp_actualizarProveedor (in _id int, 
    _proveedor varchar (100))
    begin update Proveedor set proveedor = _proveedor where id_proveedor = _id;
    end //
DELIMITER ;
call sp_actualizarProveedor (5,"Kemik");
-- UPDATE PROVEEDOR

-- DELETE PROVEEDOR 
DELIMITER // 
	create procedure sp_eliminarProveedor (in _id int)
    begin delete from Proveedor where id_proveedor = _id;
    end //
DELIMITER ;
call sp_eliminarProveedor (5);
-- DELETE PROVEEDOR

-- BROWSE PROVEEDOR 
DELIMITER //
	create procedure sp_buscarProveedor (in _id int)
    begin select * from Proveedor where id_proveedor = _id;
    end //
DELIMITER ;
call sp_buscarProveedor (3);
-- BROWSE PROVEEDOR 
-- ***************************************************************************************

-- ***************************************************************************************
-- CREATE COMPRA VENTA 
DELIMITER //
	create procedure sp_agregarCompra_Venta ( in _id_usuario int,
    _id_aviones int,
    _fecha datetime)
    begin insert into Compra_Venta (id_usuario,id_aviones,fecha) 
    values (_id_usuario, _id_aviones, _fecha);
    end // 
DELIMITER ;
call sp_agregarCompra_Venta (1,5,now());
-- CREATE COMPRA VENTA 

-- UPDATE COMPRA VENTA 
DELIMITER // 
	create procedure sp_actualizarCompra_Venta (in _id int, in _id_usuario int,
    _id_aviones int,
    _fecha datetime)
    begin update Compra_Venta set id_usuario = _id_usuario, id_aviones = _id_aviones, fecha = _fecha
    where id_compra_venta = _id;
    end //
DELIMITER ;
call sp_actualizarCompra_Venta (1,1,6,now());
-- UPDATE COMPRA VENTA 

-- DELETE COMPRA VENTA
DELIMITER // 
	create procedure sp_eliminarCompra_Venta(in _id int)
    begin delete from Compra_Venta where id_compra_venta = _id;
    end //
DELIMITER ;
call sp_eliminarCompra_Venta (2);
-- DELETE COMPRA VENTA 

-- BROWSE COMPRA VENTA 
DELIMITER //
	create procedure sp_buscarCompra_Venta (in _id int)
    begin select * from Compra_Venta where id_compra_venta = _id;
    end //
DELIMITER ;
call sp_buscarCompra_Venta (1);
-- BROWSE COMPRA VENTA 

-- BROSE COMPRA CON USUARIO
DELIMITER //
	create procedure sp_buscarCompra (in _usuario varchar(50))
    begin select CV.id_compra_venta as ID_de_la_compra, A.nombre, CV.fecha as Fecha
	from Compra_Venta as CV inner join Usuario as U on CV.id_usuario = U.id_usuario
	inner join Aviones as A on CV.id_aviones = A.id_aviones where U.usuario = _usuario;
    end //
DELIMITER ;
call sp_buscarCompra ("ksolano");
-- ***************************************************************************************