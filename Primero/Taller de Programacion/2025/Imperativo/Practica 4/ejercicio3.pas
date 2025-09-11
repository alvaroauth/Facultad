{3. Implementar un programa modularizado para una librería. Implementar módulos para:
a. Almacenar los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados su código, la
cantidad total de unidades vendidas y el monto total. De cada venta se lee código de
venta, código del producto vendido, cantidad de unidades vendidas y precio unitario. El
ingreso de las ventas finaliza cuando se lee el código de venta -1.
b. Imprimir el contenido del árbol ordenado por código de producto.
c. Retornar el código de producto con mayor cantidad de unidades vendidas.
d. Retornar la cantidad de códigos que existen en el árbol que son menores que un valor
que se recibe como parámetro.
e. Retornar el monto total entre todos los códigos de productos comprendidos entre dos
valores recibidos (sin incluir) como parámetros.}
program untitled;
const
	corte = -1;
type
	producto = record
		cod: integer;
		unid: integer;
		monto: real;
	end;
	
	ventas = record
		codV: integer;
		codP: integer;
		cant: integer;
		precio: real;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: producto;
		hi: arbol;
		hd: arbol;
	end;
	
procedure agregarArbol (var a: arbol; v: ventas);
begin
	if (a= nil) then
	begin
		new(a);
		a^.dato.cod := v.codP;
		a^.dato.unid := v.cant;
		a^.dato.monto := v.cant * v.precio;
		a^.hi := nil;
		a^.hd := nil;
	end
	else
		if (v.codP = a^.dato.cod) then
		begin
			a^.dato.unid := a^.dato.unid + v.cant;
			a^.dato.monto := a^.dato.monto + v.cant * v.precio;
		end
		else if (v.codP < a^.dato.cod) then
			agregarArbol(a^.hi, v)
		else
			agregarArbol(a^.hd, v);
end;

procedure leerVenta(var v: ventas);
begin
	v.codV := random(12)-1;
	if (v.codV <> corte) then
	begin
		v.codP := random(10)+1;
		v.cant := random(21)+5;
		v.precio := random(1001)+200;
	end;
end;

procedure cargarArbol(var a: arbol);
var
	v: ventas;
begin
	leerVenta(v);
	while( v.codV <> corte ) do
	begin
		agregarArbol(a, v);
		leerVenta(v);
	end;
end;

procedure imprimirArbol(a: arbol);
begin
	if (a<>nil) then
	begin
		imprimirArbol(a^.hi);
		writeln(' ---> Codigo: ',a^.dato.cod,'   Unidades Vendidas: ',a^.dato.unid,'   Monto recaudado: ',a^.dato.monto:0:2);
		imprimirArbol(a^.hd);
	end;
end;

procedure maximo (a: arbol; var maxCod: integer;var  max: real);
begin
	if (a <> nil) then
	begin
		maximo(a^.hi,maxCod,max);
		if ( a^.dato.monto > max ) then
		begin
			maxCod := a^.dato.cod;
			max := a^.dato.monto;
		end;
		maximo(a^.hd,maxCod,max);
	end;
end;

function menorQue (a: arbol; men: integer): integer;
begin
	if ( a = nil) then
		menorQue := 0
	else
		if (a^.dato.cod < men) then
			menorQue := 1 + menorQue(a^.hi, men) + menorQue(a^.hd, men)
		else
			menorQue := menorQue(a^.hi, men);
end;

function montoTotal (a: arbol ; inf, sup: integer): real;
begin
	if ( a = nil) then
		montoTotal := 0
	else
		if ( a^.dato.cod > inf) then
			if ( a^.dato.cod < sup) then
				montoTotal := a^.dato.monto + montoTotal(a^.hi, inf, sup) + montoTotal(a^.hd, inf, sup)
			else
				montoTotal := montoTotal(a^.hi, inf, sup)
		else
			montoTotal := montoTotal(a^.hd, inf, sup);
end;

VAR
	a: arbol;
	max, men, inf, sup: integer;
	maxMonto: real;
BEGIN
	randomize;
	a := nil;
	maxMonto := -1;
	max := -1;
	cargarArbol(a);
	imprimirArbol(a);
	maximo(a, max, maxMonto);
	writeln;
	writeln('El maximo es: ',max);
	writeln;
	write('Ingrese un numero para imprimir los codigos menores: ');
	readln(men);
	writeln;
	writeln('La cantidad de codigos menores a ',men,' es de: ',menorQue(a,men));
	writeln;
	write('Ingrese dos valores para calcular el monto total: ');
	read(inf);
	write(', ');
	read(sup);
	writeln;
	writeln('El monto total entre esos valores es de: ',montoTotal(a, inf, sup):0:2);
END.

