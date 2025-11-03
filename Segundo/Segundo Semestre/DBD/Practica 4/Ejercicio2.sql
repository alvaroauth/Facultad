/*
Localidad = (codigoPostal, nombreL, descripcion, nroHabitantes)
Arbol = (nroArbol, especie, anios, calle, nro, codigoPostal(fk))
Podador = (DNI, nombre, apellido, telefono, fnac, codigoPostalVive(fk))
Poda = (codPoda, fecha, DNI(fk), nroArbol(fk))
*/

/* 1. Listar especie, años, calle, nro y localidad de árboles podados por el podador ‘Juan Perez’ y por
el podador ‘Jose Garcia’. */

(SELECT a.especie, a.anios, a.calle, l.nombreL
FROM Arbol a NATURAL JOIN Poda pd NATURAL JOIN Podador p NATURAL JOIN Localidad l
WHERE p.nombre = 'Juan' AND p.apellido = 'Perez')
INTERSECT
(SELECT a.especie, a.anios, a.calle, l.nombreL
FROM Arbol a NATURAL JOIN Poda pd NATURAL JOIN Podador p NATURAL JOIN Localidad l
WHERE p.nombre = 'Jose' AND p.apellido = 'Garcia')

/* 2. Reportar DNI, nombre, apellido, fecha de nacimiento y localidad donde viven de aquellos
podadores que tengan podas realizadas durante 2023. */

SELECT DISTINCT p.DNI, p.nombre, p.apellido, p.fnac, l.nombreL
FROM Poda pd NATURAL JOIN Podador p INNER JOIN Localidad l ON (l.codigoPostal = p.codigoPostalVive)
WHERE pd.fecha BETWEEN '2023-01-01' AND '2023-12-31'

/* 3. Listar especie, años, calle, nro y localidad de árboles que no fueron podados nunca. */

SELECT a.especie, a.anios, a.calle, l.nombreL
FROM Arbol a INNER JOIN Localidad l ON (l.codigoPostal = a.codigoPostal)
WHERE a.nroArbol NOT IN (SELECT nroArbol FROM Poda)

/* 4. Reportar especie, años,calle, nro y localidad de árboles que fueron podados durante 2022 y no
fueron podados durante 2023 */

SELECT a.especie, a.anios, a.calle, l.nombreL
FROM Arbol a 
INNER JOIN Localidad l ON (l.codigoPostal = a.codigoPostal)
INNER JOIN Poda pd ON (a.nroArbol = pd.nroArbol)
WHERE pd.fecha BETWEEN '2022-01-01' AND '2022-12-31'
EXCEPT
SELECT a.especie, a.anios, a.calle, l.nombreL
FROM Arbol a 
INNER JOIN Localidad l ON (l.codigoPostal = a.codigoPostal)
INNER JOIN Poda pd ON (a.nroArbol = pd.nroArbol)
WHERE pd.fecha BETWEEN '2023-01-01' AND '2023-12-31'

/* 5. Reportar DNI, nombre, apellido, fecha de nacimiento y localidad donde viven de aquellos
podadores con apellido terminado con el string ‘ata’ y que tengan al menos una poda durante
2024. Ordenar por apellido y nombre. */

SELECT DISTINCT p.DNI, p.nombre, p.apellido, p.fnac, l.nombreL
FROM Podador p INNER JOIN Localidad l ON (l.codigoPostal = p.codigoPostalVive)
WHERE p.apellido LIKE "%ata" AND p.DNI IN (SELECT DNI FROM Poda)
ORDER BY p.apellido, p.nombre

