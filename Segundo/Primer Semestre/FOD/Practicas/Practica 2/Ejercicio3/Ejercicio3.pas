program untitled;
const
	valoralto = 'zzz';
type
	regMaestro = record
		prov:string;
		alfa:integer;
		encu:integer;
		end;
		
	regDetalle = record
		prov:string;
		localidad:integer;
		alfa:integer;
		encu:integer;
		end;
		
	detalle = file of regDetalle;
	maestro = file of regMaestro;
	
	
procedure leerDetalle(var rd:regDetalle);
begin
	writeln('  -*- Ingrese la provincia (zzz para terminar) -*- ');
	readln(rd.prov);
	if (rd.prov <> 'zzz') then
	begin
		writeln(' - Ingrese el codigo de la localidad         - ');
		readln(rd.localidad);
		writeln(' - Ingrese la cantidad de gente alfabetizada  - ');
		readln(rd.alfa);
		writeln(' - Ingrese la cantidad de gente encuestada   - ');
		readln(rd.encu);
		writeln;
	end;
end;

procedure leerMaestro(var rm:regMaestro);
begin
	writeln(' -*- Ingrese la provincia (zzz para terminar) -*- ');
	readln(rm.prov);
	if (rm.prov <> 'zzz') then
	begin
		writeln(' - Ingrese la cantidad de gente alfabetizada  - ');
		readln(rm.alfa);
		writeln(' - Ingrese la cantidad de gente encuestada   - ');
		readln(rm.encu);
		writeln;
	end;
end;

procedure leer(var det:detalle; var rd:regDetalle);
begin
	if (not eof(det)) then read(det, rd)
	else rd.prov := valoralto;
end;

procedure leerM(var m:maestro; var rm:regMaestro);
begin
	if (not eof(m)) then read(m, rm)
	else rm.prov := valoralto;
end;

procedure crearMaestro(var mae:maestro);
var
	rm:regMaestro;
begin
	rewrite(mae);
	leerMaestro(rm);
	while(rm.prov <> valoralto) do
	begin
		write(mae, rm);
		leerMaestro(rm);
	end;
	writeln(' ___ ... CARGA COMPLETADA CON EXITO ... ___ ');
	writeln;
	close(mae);
end;	
	
procedure crearDetalle(var det:detalle);
var
	rd:regDetalle;
begin
	rewrite(det);
	leerDetalle(rd);
	while(rd.prov <> valoralto) do
	begin
		write(det, rd);
		leerDetalle(rd);
	end;
	writeln(' ___ ... CARGA COMPLETADA CON EXITO ... ___ ');
	writeln;
	close(det);
end;

procedure imprimirMaestro(var mae:maestro);
var
	rm:regMaestro;
begin
	reset(mae);
	leerM(mae,rm);
	while(rm.prov <> valoralto) do
	begin
		writeln('***************** Provincia: ',rm.prov, ' *****************');
		writeln('   Alfabetizados: ',rm.alfa);
		writeln('     Encuestados: ',rm.encu);
		writeln('***********************************************************');
		writeln;
		leerM(mae,rm);
	end;
	writeln('--------------------------------------');
	close(mae);
end;

procedure minimo(var d1,d2:detalle ; var rd1,rd2,min:regDetalle);
begin
	if (rd1.prov <= rd2.prov) then
	begin
		min := rd1;
		leer(d1, rd1);
	end
	else
	begin
		min := rd2;
		leer(d2, rd2);
	end;
end;

procedure imprimirDetalle(var det1,det2:detalle);
var
	rd1,rd2 :regDetalle;
begin
	reset(det1);
	reset(det2);
	
	leer(det1, rd1);
	while(rd1.prov <> valoralto) do
	begin
		writeln('<***************** Provincia: ',rd1.prov, ' *****************>');
		writeln('       Localidad: ',rd1.localidad);
		writeln('   Alfabetizados: ',rd1.alfa);
		writeln('     Encuestados: ',rd1.encu);
		writeln('<***********************************************************>');
		writeln;
		leer(det1, rd1);
	end;
	
	leer(det2, rd2);
	while(rd2.prov <> valoralto) do
	begin
		writeln('hola');
		writeln('<***************** Provincia: ',rd2.prov, ' *****************>');
		writeln('       Localidad: ',rd2.localidad);
		writeln('   Alfabetizados: ',rd2.alfa);
		writeln('     Encuestados: ',rd2.encu);
		writeln('<***********************************************************>');
		writeln;
		leer(det2, rd2);
	end;
	
	writeln('--------------------------------------');
	close(det1);
	close(det2);
end;

procedure actualizarMaestro(var mae:maestro ; var det1,det2:detalle);
var
	rm:regMaestro;
	rd1,rd2,min:regDetalle;
begin
	reset(mae);
	reset(det1);
	reset(det2);
	leer(det1,rd1);
	leer(det2,rd2);
	minimo(det1,det2,rd1,rd2,min);
	while(min.prov <> valorAlto) do
	begin
		read(mae,rm);
		while ( rm.prov <> min.prov) do read(mae, rm);
		while(rm.prov = min.prov) do
		begin
			rm.alfa := rm.alfa + min.alfa;
			rm.encu := rm.encu + min.encu;
			minimo(det1,det2,rd1,rd2,min);
		end;
		seek(mae, filePos(mae)-1);
		write(mae, rm);
	end;
	close(mae);
	close(det1);
	close(det2);
end;
		
var
	det1,det2: detalle;
	mae: maestro;
	fin: boolean;
	op: integer;
begin
	fin := false;
	assign (det1, 'detalle1.dat');
	assign (det2, 'detalle2.dat');
	assign (mae, 'maestro.dat');
	repeat
		writeln('| **-*-*-*-*-*-*-*-* INGRESE UNA OPCION *-*-*-*-*-*-*-*-**');
		writeln('| 0. Finalizar'); 
		writeln('| 1. Crear Archivo Maestro'); 
		writeln('| 2. Imprimir Archivo Maestro'); 
		writeln('| 3. Crear Archivo Detalle Uno'); 
		writeln('| 4. Crear Archivo Detalle Dos'); 
		writeln('| 5. Imprimir Ambos Archivo Detalle'); 
		writeln('| 6. Actualizar Maestro a partir del Detalle');
		writeln('|__________________________________________________________');
		readln(op);
		
		case op of
			0: fin := true;
			1: crearMaestro(mae);
			2: imprimirMaestro(mae);
			3: crearDetalle(det1);
			4: crearDetalle(det2);
			5: imprimirDetalle(det1,det2);
			6: actualizarMaestro(mae,det1,det2);
		end;
		writeln('----------------------------------------');
	until (fin);
end.
	
	
