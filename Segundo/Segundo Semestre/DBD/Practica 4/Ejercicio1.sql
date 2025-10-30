/*
Cliente = (idCliente, nombre, apellido, DNI, telefono, direccion)
Factura = (nroTicket, total, fecha, hora, idCliente (fk))
Detalle = (nroTicket (fk), idProducto (fk), cantidad, preciounitario)
Producto = (idProducto, nombreP, descripcion, precio, stock)
*/


/* 1. Listar datos personales de clientes cuyo apellido comience con el string ‘Pe’. Ordenar por DNI */

SELECT nombre, apellido, dni, telefono, direccion
FROM Cliente 
WHERE nombre LIKE "Pe%" 
ORDER BY DNI 

/* 2. Listar nombre, apellido, DNI, teléfono y dirección de clientes que realizaron compras solamente
durante 2024. */


(SELECT nombre, apellido, dni, telefono, direccion
FROM Cliente NATURAL JOIN Factura
WHERE Factura.fecha BETWEEN 2024-01-01 AND 2024-12-31)
EXCEPT
(SELECT nombre, apellido, dni, telefono, direccion
FROM Cliente NATURAL JOIN Factura
WHERE ((Factura.fecha <= 2023-12-31) and (Factura.fecha >= 2025-01-01)))

/* 3. Listar nombre, descripción, precio y stock de productos vendidos al cliente con DNI 45789456,
pero que no fueron vendidos a clientes de apellido ‘Garcia’. */

(SELECT nombreP, precio, descripcion, stock
FROM Cliente NATURAL JOIN Factura NATURAL JOIN Detalle NATURAL JOIN Producto
WHERE dni = "45789456")
EXCEPT
(SELECT nombreP, precio, descripcion, stock
FROM Cliente NATURAL JOIN Factura NATURAL JOIN Detalle NATURAL JOIN Producto
WHERE apellido = "Garcia")

