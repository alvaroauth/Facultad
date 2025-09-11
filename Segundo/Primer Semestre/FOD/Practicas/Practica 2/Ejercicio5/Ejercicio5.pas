program untitled;

uses SysUtils; //para el nombre del archivo

const
	valoralto = 999;
	dimf = 5;
type
	ranVector = 1..dimf;
	
	regDetalle = record
		cod_usuario:integer;
		fecha:string;	
		tiempo_sesion:real; 
		end;
		
	regMaestro = record
		cod_usuario:integer;
		fecha:string;
		tiempo_total_de_sesiones_abiertas: real;
		end;
		
	maestro = file of regMaestro;
	
	detalle = file of regDetalle;
	
	vector = array[ranVector] of detalle;
	
	vecRegistro = array[ranVector] of regDetalle;
	
procedure leer(var det:detalle ; var rd:regDetalle);
begin
	if (not eof(det)) then read(det, rd)
	else rd.cod_usuario := valoralto;
end;

procedure leerDetalle (var rd:regDetalle);
begin
	writeln(' ^v^v^v^v^v^v^ Ingrese el codigo de usuario ^v^v^v^v^v^v^');
	readln(rd.cod_usuario);
	writeln;
	if (rd.cod_usuario <> valoralto) then
	begin
		writeln(' ^v^v^v^v^ Ingrese la fecha ^v^v^v^v^');
		readln(rd.fecha);
		writeln;
		writeln(' ^v^v^v^v^ Ingrese la la cantidad de tiempo en sesion ^v^v^v^v^');
		readln(rd.tiempo_sesion);
		writeln;
		writeln;
	end;
end;

procedure leerMaestro (var rm:regMaestro);
begin
	writeln(' ^v^v^v^v^v^v^ Ingrese el codigo de usuario ^v^v^v^v^v^v^');
	readln(rm.cod_usuario);
	writeln;
	if (rm.cod_usuario <> valoralto) then
	begin
		writeln(' ^v^v^v^v^ Ingrese la fecha ^v^v^v^v^');
		readln(rm.fecha);
		writeln;
		writeln(' ^v^v^v^v^ Ingrese la la cantidad total de tiempo en sesion ^v^v^v^v^');
		readln(rm.tiempo_total_de_sesiones_abiertas);
		writeln;
	end;
end;
	
procedure cargarDetalles(var v:vector);
var
	rd: regDetalle;
	i: ranVector;
begin
	for i := 1 to dimf do
	begin
		rewrite(v[i]);
		leerDetalle(rd);
		while (rd.cod_usuario <> valoralto) do
		begin
			write(v[i], rd);
			leerDetalle(rd);
		end;
		close(v[i]);
		writeln(' [] [] [] Detalle ', i, ' creado exitosamente...');
	end;
end;

procedure minimo(var v:vector ; var vr:vecRegistro ; var min:regDetalle);
var
	minPos, i:ranVector;
begin	
	min.cod_usuario := valoralto;
	
	for i := 1 to dimf do
	begin
		if (min.cod_usuario > vr[i].cod_usuario) then
		begin
			minPos := i;
			min := vr[i];
		end;
	end;
	
	if (min.cod_usuario <> valoralto) then
		leer(v[minPos], vr[minPos]);
end;

procedure imprimirDetalles ( var v:vector );
var
	min:regDetalle;
	vr:vecRegistro;
	i: ranVector;
begin
	for i := 1 to dimf do
	begin
		reset(v[i]);
		leer(v[i], vr[i]);
	end;
	minimo(v,vr,min);
	
	while (min.cod_usuario <> valoralto) do
	begin
		with min do writeln(' <<<<>>>> Usuario: ',cod_usuario,'   Fecha: ',fecha, '   Tiempo de sesion: ',tiempo_sesion:0:2,' ---');
		minimo(v,vr,min);
		writeln;
	end;
	
	for i := 1 to dimf do
		close(v[i]);
end;

procedure crearMaestro (var mae:maestro ;  var v:vector);
var
	rm : regMaestro;
	i:ranVector;
	vr: vecRegistro;
	min: regDetalle;
	
begin
	rewrite(mae);
	
	for i:= 1 to dimf do
	begin
		reset(v[i]);
		leer(v[i], vr[i]);
	end;
	
	minimo (v, vr, min);
	while (min.cod_usuario <> valoralto) do
	begin
		rm.cod_usuario := min.cod_usuario;
		rm.tiempo_total_de_sesiones_abiertas := 0;
		rm.fecha := min.fecha;
		
		while (min.cod_usuario = rm.cod_usuario)and(min.fecha = rm.fecha)  do
		begin
			rm.tiempo_total_de_sesiones_abiertas := rm.tiempo_total_de_sesiones_abiertas + min.tiempo_sesion;
			minimo(v, vr, min);
		end;
		
		write(mae, rm);
		
	end;
	
	close(mae);
	for i:= 1 to dimf do
		close(v[i]);
end;
	
procedure imprimirMaestro(var mae:maestro);
var
	rm:regMaestro;
begin
	reset(mae);
	
	while (not eof(mae)) do
	begin
		read(mae, rm);
		with rm do writeln(' <<<<>>>> Usuario: ',cod_usuario,'   Fecha: ',fecha, '   Tiempo de sesion: ',tiempo_total_de_sesiones_abiertas:0:2,' ---');
		writeln;
	end;
	close(mae);
end;
	
var
	v:vector;
	mae:maestro;
	op:integer;
BEGIN
	for op:= 1 to dimF do
         assign(v[op],'det'+IntToStr(op)+'.dat');
	assign(mae, 'maestro.dat');
	
	repeat
		writeln('   <<<<<<< [] >>>>>>>  Ingrese una opcion  <<<<<<< [] >>>>>>> ');
		writeln('           1. Crear Detalles ');
		writeln('           2. Imprimir Detalles');
		writeln('           3. Crear Maestro');
		writeln('           4. Imprimir Maestro');
		writeln;
		readln(op);
		
		case op of
			1: cargarDetalles(v);
			2: imprimirDetalles(v);
			3: crearMaestro(mae, v);
			4: imprimirMaestro (mae);
		end;
	until op = 0;
END.

