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

/* 4. Listar nombre, descripción, precio y stock de productos no vendidos a clientes que tengan
teléfono con característica 221 (la característica está al comienzo del teléfono). Ordenar por
nombre. */

(SELECT nombreP, precio, descripcion, stock
FROM Producto)
EXCEPT
(SELECT nombreP, precio, descripcion, stock
FROM Cliente NATURAL JOIN Factura NATURAL JOIN Detalle NATURAL JOIN Producto
WHERE telefono LIKE "221%");

/* 5. Listar para cada producto nombre, descripción, precio y cuantas veces fue vendido. Tenga en
cuenta que puede no haberse vendido nunca el producto. */

SELECT nombreP, precioUnitario, descripcion, SUM(cantidad) as cantVendida
FROM Producto LEFT JOIN Detalle ON (Producto.idProducto = Detalle.idProducto)
GROUP BY nombreP, precioUnitario, descripcion



