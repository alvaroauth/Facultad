{
Escribir un programa que: a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio. 
Para cada venta generar código de producto, fecha y cantidad de unidades vendidas. Finalizar con el código de producto 0. Un producto puede estar en más de una venta. 
	i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de producto. Los códigos repetidos van a la derecha. 
	ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por código de producto. Cada nodo del árbol debe contener el código de producto y la cantidad total de unidades vendidas. 
	iii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por código de producto. Cada nodo del árbol debe contener el código de producto y la lista de las ventas realizadas
del producto. Nota: El módulo debe retornar TRES árboles. 
	b. Implemente un módulo que reciba el árbol generado en i. y una fecha y retorne la cantidad total de productos vendidos en la fecha recibida. 
	c. Implemente un módulo que reciba el árbol generado en ii. y retorne el código de producto con mayor cantidad total de unidades vendidas. 
	c. Implemente un módulo que reciba el árbol generado en iii. y retorne el código de producto con mayor cantidad de ventas.
}


program untitled;
const 
	corte = 0;
type
	ranfecha = 1..31;
	
	ventas = record
		codigo:integer;
		fecha:ranfecha;
		vendido:integer;
	end;
		
	arbol=^nodo;
	
	nodo=record
		dato:ventas;
		hi: arbol;
		hd: arbol;
	end;
	
	productos = record
		codigo:integer;
		vendido:integer;
	end;

	arbol2=^nodo2;
	
	nodo2=record
		dato:productos;
		hi: arbol2;
		hd: arbol2;
	end;

	lista = ^nodoL;
	
	ventasL = record
		fecha : ranfecha;
		vendido:integer;
	end;
	
	nodoL = record
		dato:ventasL;
		sig:lista;
	end;
	
	registroL = record
		codigo : integer;
		l:lista;
	end;
	
	arbol3 = ^nodo3;
	
	nodo3 = record
		dato: registroL;
		hi:arbol3;
		hd:arbol3;
	end;

procedure randomm (var v:ventas);
begin
	v.codigo:=random(11);
	v.fecha:= 1 + random(32);
	v.vendido:=random(101);
end;	

procedure agregarArbol2 (var a2:arbol2; x:ventas);
begin
	if (a2 = nil) then
	begin
		new(a2);
		a2^.dato.codigo := x.codigo;
		a2^.dato.vendido := x.vendido;
		a2^.hi := nil;
		a2^.hd := nil;
	end
	else
	begin
		if (x.codigo < a2^.dato.codigo) then agregarArbol2(a2^.hi, x)
		else if (x.codigo > a2^.dato.codigo) then agregarArbol2(a2^.hd, x)
		else a2^.dato.vendido := a2^.dato.vendido + x.vendido;
	end;
end;

Procedure agregarAdelante (var l:lista ; f:ranfecha; cant: integer);
var
	nue:lista;
begin
	new(nue);
	nue^.dato.fecha:=f;
	nue^.dato.vendido:=cant;
	nue^.sig:=l;
	l:=nue;
end;

procedure agregarArbol3 (var a3:arbol3; x:ventas);
begin
	if (a3 = nil) then
	begin
		new(a3);
		a3^.dato.codigo := x.codigo;
		a3^.dato.l := nil;
		agregarAdelante (a3^.dato.l , x.fecha , x.vendido);
		a3^.hi := nil;
		a3^.hd := nil;
	end
	else
	begin
		if (x.codigo < a3^.dato.codigo) then agregarArbol3(a3^.hi, x)
		else if (x.codigo > a3^.dato.codigo) then agregarArbol3(a3^.hd, x)
		else agregarAdelante (a3^.dato.l , x.fecha , x.vendido);
	end;
end;


procedure agregarArbol (var a:arbol; x:ventas);
begin
	if (a = nil) then
	begin
		new(a);
		a^.dato := x;
		a^.hi := nil;
		a^.hd := nil;
	end
	else
	begin
		if (x.codigo <= a^.dato.codigo) then agregarArbol(a^.hi, x)
		else agregarArbol(a^.hd, x);
	end;
end;

procedure cargarArbol (var a:arbol;var a2:arbol2;var a3:arbol3);
var
	v:ventas;
begin
	randomm (v);
	while (v.codigo <> corte) do
	begin
		agregarArbol(a, v);
		agregarArbol2(a2,v);
		agregarArbol3(a3,v);
		randomm(v);
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then
	begin
		imprimirArbol(a^.hi);
		writeln('El codigo es ', a^.dato.codigo);
		writeln('La fecha es ', a^.dato.fecha);
		writeln('La cantidad vendida es', a^.dato.vendido);
		imprimirArbol(a^.hd);
	end;
end;

procedure imprimirArbol2 (a2:arbol2);
begin
	if (a2 <> nil) then
	begin
		imprimirArbol2(a2^.hi);
		writeln(a2^.dato.codigo);
		writeln(a2^.dato.vendido);
		imprimirArbol2(a2^.hd);
	end;
end;

procedure recorrerArbol1 (a:arbol ; f:ranfecha ; var cant:integer);
begin
	if (a <> nil) then
	begin
		recorrerArbol1(a^.hi,f,cant);
		if (a^.dato.fecha = f) then cant := cant + 1;
		recorrerArbol1(a^.hd,f,cant);
	end;
end;

procedure recorrerArbol2 (a2:arbol2; var max:integer);
begin
	if (a2 <> nil) then
	begin
		recorrerArbol2(a2^.hi, max);
		if (a2^.dato.vendido > max) then max := a2^.dato.vendido;
		recorrerArbol2(a2^.hd, max);
	end;
end;

VAR
	a:arbol;
	a2:arbol2;
	a3:arbol3;
	fecha, cantf, max:integer;
BEGIN
	a := nil;
	a2 := nil;
	a3 := nil;
	cantf := 0;
	max := -1;
	randomize();
	cargarArbol(a, a2, a3);
	imprimirArbol(a);
	writeln('-------------------------------');
	imprimirArbol2(a2);
	writeln('-------------------------------');
	writeln('Ingrese la fecha a buscar');
	readln(fecha);
	recorrerArbol1(a, fecha, cantf);
	writeln('La fecha ' , fecha , ' tiene ' , cantf , ' ventas');
	writeln('-------------------------------');
	writeln('El maximo del arbol 2 es ' , max);
END.

