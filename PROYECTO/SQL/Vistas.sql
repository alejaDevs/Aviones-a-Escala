use aviones_Escala;
-- VISTAS

-- VISTA VER PRODUCTOS
create view Productos as 
select A.id_aviones as ID, A.nombre as Nombre_Avion, A.modelo as Modelo, A.marca as Marca,
E.escala as Escala, P.proveedor as Proveedor, A.precio as Precio
from Aviones as A inner join Escala as E on A.id_escala = E.id_escala
inner join Proveedor as P on A.id_proveedor = P.id_proveedor;
-- ***
Select * from Productos;
-- ***
-- VISTA VER PRODUCTOS

-- VISTA VER PROVEEDORES
create view Proveedores as 
select id_proveedor as ID, proveedor as Nombre_Proveedor from Proveedor;
-- ***
select * from Proveedores;
-- ***
-- VISTA VER PROVEEDORES

-- VISTA VER ESCALAS 
create view Escalas as 
select id_escala as ID, escala as Escala from Escala;
-- ***
select * from Escalas;
-- ***
-- VISTA VER CATEGORIAS 

-- VISTA VER CLIENTES 
create view Clientes as 
select id_cliente as ID, nombre as Nombre, apellido as Apellido, direccion as Direccion, telefono as Telefono, 
email as Email, fecha as Fecha_Creacion from Cliente;
-- ***
select * from Clientes;
-- ***
-- VISTA VER CLIENTES 

-- VISTA VER USUARIOS 
create view Usuarios as 
select usuario as Usuario, contrasenia as Contraseña
from Usuario;
-- ***
select * from Usuarios;
select * from usuario where usuario = "cgarcia" and contrasenia = "free";
-- ***
-- VISTA VER USUARIOS 

-- VISTA VER VENTA/COMPRA 
create view Ventas_Compras as 
select Cv.id_compra_venta as ID_Compra, U.id_usuario as ID_Usuario, A.id_aviones as ID_Avion, CV.fecha as Fecha
from Compra_Venta as CV inner join Usuario as U on CV.id_usuario = U.id_usuario
inner join Aviones as A on CV.id_aviones = A.id_aviones;
-- ***
select * from Ventas_Compras;
-- ***
-- VISTA VER VENTA 