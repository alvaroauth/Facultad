program ej2;
const 
	valorAlto = 32767;
type
	regMaestro = record
		cod:integer;
		nom:string;
		precio:real;
		stActual:integer;
		stMinimo:integer;
		end;
	
	regDetalle = record
		cod:integer;
		uniVendidas:integer;
		end;
		
	maestro = file of regMaestro;
	detalle = file of regDetalle;
	
procedure leerDetalle(var rd:regDetalle);
begin
	writeln(' - Ingrese el codigo de producto - ');
	readln(rd.cod);
	if (rd.cod <> valorAlto) then
	begin
		writeln(' - Ingrese la cantidad de productos  - ');
		readln(rd.uniVendidas);
	end;
end;

procedure leerMaestro(var rm:regMaestro);
begin
	writeln(' * Ingrese el codigo de producto * ');
	readln(rm.cod);
	if (rm.cod <> valorAlto) then
	begin
		writeln(' - Ingrese el nombre comercial - ');
		readln(rm.nom);
		writeln(' - Ingrese el precio del producto - ');
		readln(rm.Precio);
		writeln(' - Ingrese el stock actual - ');
		readln(rm.stActual);
		writeln(' - Ingrese el stock minimo - ');
		readln(rm.stMinimo);
		writeln;
	end;
end;

procedure leerD(var det:detalle; var rd:regDetalle);
begin
	if (not eof(det)) then read(det, rd)
	else rd.cod := valorAlto;
end;

procedure leerM(var mae:maestro; var rm:regMaestro);
begin
	if (not eof(mae)) then read(mae, rm)
	else rm.cod := valorAlto;
end;

procedure crearMaestro(var mae:maestro);
var
	rm:regMaestro;
begin
	rewrite(mae);
	leerMaestro(rm);
	while(rm.cod <> valorAlto) do
	begin
		write(mae, rm);
		leerMaestro(rm);
	end;
	writeln(' //// CARGA COMPLETADA CON EXITO...');
	close(mae);
end;	
	
procedure crearDetalle(var det:detalle);
var
	rd:regDetalle;
begin
	rewrite(det);
	leerDetalle(rd);
	while(rd.cod <> valorAlto) do
	begin
		write(det, rd);
		leerDetalle(rd);
	end;
	writeln(' //// CARGA COMPLETADA CON EXITO...');
	close(det);
end;

procedure imprimirMaestro(var mae:maestro);
var
	rm:regMaestro;
begin
	reset(mae);
	leerM(mae, rm);
	while(rm.cod <> valorAlto) do
	begin
		writeln('-----------> Codigo: ',rm.cod,' <-----------');
		writeln('           Nombre: ',rm.nom);
		writeln('           Precio: ',rm.precio:0:2);
		writeln('     Stock Actual: ',rm.stActual);
		writeln('     Stock Minimo: ',rm.stMinimo);
		writeln;
		leerM(mae, rm);
	end;
	writeln('--------------------------------------');
	close(mae);
end;

procedure imprimirDetalle(var det:detalle);
var
	rd:regDetalle;
begin
	reset(det);
	leerD(det, rd);
	while(rd.cod <> valorAlto) do
	begin
		writeln('----------->  Codigo: ',rd.cod,'   ','Cantidad de productos vendidos: ',rd.uniVendidas);
		writeln;
		leerD(det, rd);
	end;
	writeln('--------------------------------------');
	close(det);
end;

procedure actualizarMaestro(var mae:maestro ; var det:detalle);
var
	rd:regDetalle;
	rm:regMaestro;
begin
	reset(det);
	reset(mae);
	leerD(det, rd);
	while(rd.cod <> valorAlto) do
	begin
		leerM(mae, rm);
		while(rd.cod <> valorAlto)and(rm.cod <> rd.cod) do
			leerM(mae, rm);
		while(rd.cod <> valorAlto) and (rm.cod = rd.cod) do
		begin
			rm.stActual := rm.stActual - rd.uniVendidas;
			leerD(det, rd);
		end;
		seek (mae, filePos(mae)-1);
		write(mae, rm);
	end;
	close(det);
	close(mae);
	writeln(' //// ACTUALIZACION COMPLETADA CON EXITO...');
end;

procedure generarTXTStock(var mae:maestro);
var
	texto:text;
	regMae:regMaestro;
begin
	assign(texto, 'stock_minimo.txt');
	reset(mae);
	rewrite(texto);
	leerM(mae, regMae);
	while(regMae.cod <> valorAlto) do
	begin
		if(regMae.stMinimo > regMae.stActual) then
		begin
			writeln(texto, regMae.nom);
			writeln(texto, regMae.cod, ' ',regMae.precio:0:2, ' ',regMae.stMinimo, '/',regMae.stActual);
		end;
		leerM(mae,regMae);
	end;
	writeln(' //// ARCHIVO DE TEXTO CREADO CON EXITO...');	
	close(mae);
	close(texto);
end;

var
	deta: detalle;
	maes: maestro;
	fin: boolean;
	op: integer;
begin
	fin := false;
	assign (deta, 'detalle.dat');
	assign (maes, 'maestro.dat');
	repeat
		writeln(' |!|!|!|!|!|!| INGRESE UNA OPCION |!|!|!|!|!|!|');
		writeln(' 0. Finalizar'); 
		writeln(' 1. Crear Archivo Maestro'); 
		writeln(' 2. Imprimir Archivo Maestro'); 
		writeln(' 3. Crear Archivo Detalle'); 
		writeln(' 4. Imprimir Archivo Detalle'); 
		writeln(' 5. Actualizar Maestro a partir del Detalle');
		writeln(' 6. Crear Archivo de Texto que Contenga los Productos con Stock por Debajo del Minimo');
		readln(op);
		
		case op of
			0: fin := true;
			1: crearMaestro(maes);
			2: imprimirMaestro(maes);
			3: crearDetalle(deta);
			4: imprimirDetalle(deta);
			5: actualizarMaestro(maes,deta);
			6: generarTXTStock(Maes);
		end;
		writeln('----------------------------------------');
	until (fin);
end.
	
	
	
	
	
	
	
	
	
	
