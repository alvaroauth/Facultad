{
 Se cuenta con un archivo de productos de una cadena de venta de alimentos congelados.
De cada producto se almacena: código del producto, nombre, descripción, stock disponible,
stock mínimo y precio del producto.
Se recibe diariamente un archivo detalle de cada una de las 30 sucursales de la cadena. Se
debe realizar el procedimiento que recibe los 30 detalles y actualiza el stock del archivo
maestro. La información que se recibe en los detalles es: código de producto y cantidad
vendida. Además, se deberá informar en un archivo de texto: nombre de producto,
descripción, stock disponible y precio de aquellos productos que tengan stock disponible por
debajo del stock mínimo. Pensar alternativas sobre realizar el informe en el mismo
procedimiento de actualización, o realizarlo en un procedimiento separado (analizar
ventajas/desventajas en cada caso).

Nota: todos los archivos se encuentran ordenados por código de productos. En cada detalle
puede venir 0 o N registros de un determinado producto.

}

program ej4;
const 
	valoralto = 9999;
	dimf = 3;
type
	ranVector = 1..dimf;
	
	regMaestro = record
		codigo:integer;
		nombre:string;
		desc:string;
		stActual:integer;
		stMinimo:integer;
		precio:real;
		end;
		
	regDetalle = record
		codigo: integer;
		cantVendida: integer;
		end;
		
	maestro = file of regMaestro;
	
	detalle = file of regDetalle;
	
	vector = array[ranVector] of detalle;
	
	vecRegistros = array[ranVector] of regDetalle;
	
procedure leer(var det:detalle ; var rd:regDetalle);
begin
	if (not eof(det)) then read(det, rd)
	else rd.codigo := valoralto;
end;

procedure leerDetalle(var rd:regDetalle);
begin
	writeln(' +-+-+-+-+-+ Ingrese el codigo de producto +-+-+-+-+-+ ');
	readln(rd.codigo);
	if (rd.codigo <> valoralto) then
	begin
		writeln(' //\\ Ingrese la cantidad de productos vendida  //\\ ');
		readln(rd.cantVendida);
	end;
end;

procedure leerMaestro(var rm:regMaestro);
begin
	writeln(' +-+-+-+-+-+ Ingrese el codigo de producto +-+-+-+-+-+ ');
	readln(rm.codigo);
	if (rm.codigo <> valoralto) then
	begin
		writeln(' //\\ Ingrese el nombre  //\\ ');
		readln(rm.nombre);
		writeln(' //\\ Ingrese el la descripcion //\\ ');
		readln(rm.desc);
		writeln(' //\\ Ingrese el precio del producto //\\ ');
		readln(rm.Precio);
		writeln(' //\\ Ingrese el stock actual //\\ ');
		readln(rm.stActual);
		writeln(' //\\ Ingrese el stock minimo //\\ ');
		readln(rm.stMinimo);
		writeln;
	end;
end;
	
procedure crearMaestro(var mae:maestro);
var
	rm:regMaestro;
begin
	rewrite(mae);
	leerMaestro(rm);
	while(rm.codigo <> valoralto) do
	begin
		write(mae, rm);
		leerMaestro(rm);
	end;
	writeln(' :;:;:;: MAESTRO CREADO CON EXITO');
	close(mae);
end;	
	
procedure crearDetalles(var v:vector);
var
	rd:regDetalle;
	i:ranVector;
begin
	
	for i := 1 to dimf do
	begin
		rewrite(v[i]);
		leerDetalle(rd);
		while(rd.codigo <> valoralto) do
		begin
			write(v[i], rd);
			leerDetalle(rd);
		end;
		writeln(':;:;:;: DETALLE ',i,' CREADO CON EXITO...');
		close(v[i]);
	end;
end;

procedure imprimirMaestro(var mae:maestro);
var
	rm:regMaestro;
begin
	reset(mae);
	read(mae, rm);
	while(not eof(mae)) do
	begin
		writeln('\______________/ Codigo: ',rm.codigo,' \______________/');
		writeln('           Nombre: ',rm.nombre);
		writeln('           Precio: ',rm.precio:0:2);
		writeln('     Stock Actual: ',rm.stActual);
		writeln('     Stock Minimo: ',rm.stMinimo);
		writeln;
		read(mae, rm);
	end;
	writeln('\______________/ Codigo: ',rm.codigo,' \______________/');
	writeln('           Nombre: ',rm.nombre);
	writeln('           Precio: ',rm.precio:0:2);
	writeln('     Stock Actual: ',rm.stActual);
	writeln('     Stock Minimo: ',rm.stMinimo);
	writeln;
	writeln('--------------------------------------');
	close(mae);
end;

procedure imprimirDetalle(var v:vector);
var
	rd:regDetalle;
	i:ranVector;
begin
	for i := 1 to dimf do
	begin
		reset(v[i]);
		leer(v[i], rd);
		writeln('------------------------------- DETALLE ',i,' -------------------------------');
		writeln;
		while(rd.codigo <> valoralto) do
		begin
			writeln('----------->  Codigo: ',rd.codigo,'   ','Cantidad de productos vendidos: ',rd.cantVendida);
			writeln;
			leer(v[i], rd);
		end;
		writeln('------------------------------------------------------------------------------');
		close(v[i]);
	end;
end;
	
procedure minimo (var v:vector ; var vr:vecRegistros ; var min: regDetalle);
var
	i, minPos:ranVector;
begin
	min.codigo := valoralto;
	
	for i := 1 to dimf do
	begin
		if (min.codigo > vr[i].codigo) then
		begin
			min := vr[i];
			minPos := i;
		end;
	end;
	
	if (min.codigo <> valoralto) then
		leer(v[minPos], vr[minPos]);
end;
	
procedure actualizarMaestro(var mae:maestro ; var v:vector);
var
	vr: vecRegistros;
	min: regDetalle;
	i:ranVector;
	rm : regMaestro;
	cant, actual: integer;
begin
	
	reset(mae);
	for i := 1 to dimf do
	begin
		reset(v[i]);
		leer(v[i], vr[i]);
	end;
	minimo(v,vr,min);
	while(min.codigo <> valoralto) do
	begin
		actual := min.codigo;
		cant := 0;
		while (min.codigo = actual) do
		begin
			cant := cant + min.cantVendida;
			minimo(v,vr,min);
		end;
		
		read(mae,rm);
		while(rm.codigo <> actual) do 
			read(mae,rm);
		rm.stActual := rm.stActual - cant;
		seek(mae,filePos(mae)-1);
		write(mae, rm);
		
	end;
	
	for i := 1 to dimf do 
		close(v[i]);
	close(mae);
end;
	
var
	v: vector;
	mae: maestro;
	fin: boolean;
	op: integer;
begin
	fin := false;
	assign (v[1], 'detalle1.dat');
	assign (v[2], 'detalle2.dat');
	assign (v[3], 'detalle3.dat');
	assign (mae, 'maestro.dat');
	repeat
		writeln(' |!|!|!|!|!|!| INGRESE UNA OPCION |!|!|!|!|!|!|');
		writeln(' 0. Finalizar'); 
		writeln(' 1. Crear Archivo Maestro'); 
		writeln(' 2. Imprimir Archivo Maestro'); 
		writeln(' 3. Crear Archivo Detalle'); 
		writeln(' 4. Imprimir Archivo Detalle'); 
		writeln(' 5. Actualizar Maestro a partir del Detalle');
		readln(op);
		
		case op of
			0: fin := true;
			1: crearMaestro(mae);
			2: imprimirMaestro(mae);
			3: crearDetalles(v);
			4: imprimirDetalle(v);
			5: actualizarMaestro(mae,v);
		end;
		writeln('----------------------------------------');
	until (fin);
end.

