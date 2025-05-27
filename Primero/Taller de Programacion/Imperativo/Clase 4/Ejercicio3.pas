{
3. Implementar un programa modularizado para una librería. Implementar módulos para:
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
valores recibidos (sin incluir) como parámetros.
}
program Libreria;
const
	corte = -1;
type
	producto = record
		codigo:integer;
		vendido:integer;
		monto:real;
		end;
		
	venta = record
		codigo:integer;
		producto:integer;
		unidades:integer;
		pxunidad:real;
		end;
	
	arbol = ^nodo;
	
	nodo = record
		dato:producto;
		HI:arbol;
		HD:arbol;
		end;
	
procedure aleatorio (var v:venta);
begin
	v.codigo := random (21)- 1;
	if (v.codigo <> corte) then
	begin
		v.producto := random(22) ;
		v.unidades := random (21);
		v.pxunidad := random (21);
	end;
end;

procedure cargarProducto (var p:producto ; v:venta);
begin 
	p.codigo := v.producto;
	p.vendido := v.unidades ;
	p.monto := v.unidades * v.pxunidad;
end;

procedure cargarProExistente (var p:producto ; v:venta);
begin
	p.vendido := p.vendido + v.unidades;
	p.monto := p.monto + (v.unidades * v.pxunidad);
end;

procedure agregarArbol (var a:arbol ; v:venta);
begin
	if (a = nil) then 
	begin
		new(a);
		cargarProducto(a^.dato,v);
		a^.hi := nil;
		a^.hd := nil;
	end
	else
		if (a^.dato.codigo > v.codigo) then agregarArbol(a^.hi,v)
		else if (a^.dato.codigo < v.codigo) then agregarArbol(a^.hd,v)
		else cargarProExistente (a^.dato, v);

end;

procedure cargarArbol (var a:arbol);
var
	v:venta;
begin
	aleatorio(v);
	while (v.codigo <> corte) do
	begin
		agregarArbol(a,v);
		aleatorio(v);
	end;
end;

procedure imprimir (p:producto);
begin
	writeln ('----> Producto: ', p.codigo);
	writeln ('               Cantidad vendida: ', p.vendido);
	writeln ('               Monto recaudado: ', p.monto:0:2);
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then
	begin
		imprimirArbol(a^.hi);
		imprimir(a^.dato);
		imprimirArbol(a^.hd);
	end;
end;

procedure masVendido (a:arbol ; var max:integer ; var maxcod:integer);
begin
	if (a <> nil) then
	begin
		masVendido(a^.hi, max, maxcod);
		if (a^.dato.vendido > max) then
		begin
			maxcod := a^.dato.codigo;
			max := a^.dato.vendido;
		end;
		masVendido(a^.hd, max, maxcod);
	end;
end;

procedure informarCodMin (a:arbol ; min:integer );
begin
	if (a <> nil) then
	begin
		informarCodMin(a^.hi, min);
		if (a^.dato.codigo < min) then 
		begin
			writeln('Lista de codigos menores al ingresado');
			writeln('                             -------> Codigo: ',a^.dato.codigo);
		informarCodMin(a^.hd, min);
		end;
	end;
end;

Procedure rangoArbol (a:arbol ; min, max:integer ; var total:real);
begin
	if (a <> nil ) then 
	begin
		if (a^.dato.codigo > min) then
			if (a^.dato.codigo < max ) then
			begin
				rangoArbol(a^.hi,min,max,total);
				total := total + a^.dato.monto;
				writeln (a^.dato.monto , a^.dato.codigo);
				rangoArbol(a^.hd,min,max,total);
			end
			else rangoArbol (a^.hi,min,max,total)
		else rangoArbol (a^.hd,min,max,total);
	end;
end;

VAR

	a:arbol;
	max, maxcod,buscar:integer;
	inf ,sup : integer;
	total : real;
BEGIN
	randomize;
	a := nil;
	max := -1;
	total := 0;
	cargarArbol(a);
	imprimirArbol(a);
	masVendido (a, max, maxcod);
	writeln ('__________________________________');
	writeln();
	writeln (' + + + El producto ', maxcod, ' Fue el mas vendido');
	writeln ('__________________________________');
	writeln();
	{writeln('Ingrese el codigo minimo a informar');
	Readln(buscar);
	informarCodMin(a,buscar);}
	writeln ('__________________________________');
	writeln();
	writeln('Ingrese el valor minimo a buscar');
	Readln (inf);
	writeln();
	writeln('Ingrese el valor maximo a buscar');
	Readln (sup);
	rangoArbol (a,inf,sup,total);
	writeln ('__________________________________');
	writeln (' - - - El monto total recaudado en ese rango es de: ', total:0:2);	
END.
	
		

