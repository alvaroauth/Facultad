program ej6;
const 
	valoralto = 999;
	dimf = 4;
type

	ranVector = 1..dimf;
	
	regCasos = record
		activos:integer;
		nuevos:integer;
		recuperados:integer;
		fallecidos:integer;
		end;

	regDetalle = record
		localidad:integer;
		cepa:integer;
		casos:regCasos;
		end;
		
	regMaestro = record
		localidad:integer;
		nombreLoc:string;
		cepa:integer;
		nombreCep:string;
		casos:regCasos;
		end;
	
	detalle = file of regDetalle;
	
	maestro = file od regMaestro;
	
	vector = array[ranVector] of detalle;
	
	vecRegistro = array[ranVector] of regDetalle;
	
	
procedure leer(var det:detalle ; var rd:regDetalle);
begin
	if (not eof(det)) then read(det, rd)
	else rd.localidad := -1;
end;

procedure leerDetalle(var rd:regDetalle);
begin
	writeln(' *-*-*-*-* Ingrese codigo de localidad *-*-*-*-*');
	readln(rd.localidad);
	if (rd.localidad <> valoralto) then
	begin
		writeln(' *-*-* Ingrese codigo de cepa *-*-*');
		readln(rd.cepa);
		writeln(' *-*-* Ingrese la cantidad de casos ACTIVOS *-*-*');
		readln(rd.casos.activos);
		writeln(' *-*-* Ingrese la cantidad de casos NUEVIOS *-*-*');
		readln(rd.casos.nuevos);
		writeln(' *-*-* Ingrese la cantidad de casos RECUPERADOS *-*-*');
		readln(rd.casos.recuperados);
		writeln(' *-*-* Ingrese la cantidad de casos FALLECIDOS *-*-*');
		readln(rd.casos.fallecidos);
	end;
end;

procedure leerMaestro(var rm:regMaestro);
begin
	writeln(' *-*-*-*-* Ingrese el codigo de localidad *-*-*-*-*');
	readln(rm.localidad);
	if (rd.localidad <> valoralto) then
	begin
		writeln(' *-*-* Ingrese el nombre de la localidad *-*-*');
		readln(rm.nombreLoc);
		writeln(' *-*-* Ingrese codigo de cepa *-*-*');
		readln(rm.cepa);
		writeln(' *-*-* Ingrese el nombre de la cepa *-*-*');
		readln(rm.nombreCep);
		writeln(' *-*-* Ingrese la cantidad de casos ACTIVOS *-*-*');
		readln(rm.casos.activos);
		writeln(' *-*-* Ingrese la cantidad de casos NUEVOS *-*-*');
		readln(rm.casos.nuevos);
		writeln(' *-*-* Ingrese la cantidad de casos RECUPERADOS *-*-*');
		readln(rm.casos.recuperados);
		writeln(' *-*-* Ingrese la cantidad de casos FALLECIDOS *-*-*');
		readln(rm.casos.fallecidos);
	end;
end;
	
procedure cargarDetalles (var v:vector);
var
	rd:regDetalle;
	i: ranVector;
begin
	for i := 1 to dimf do
	begin
		rewrite(v[i]);
		writeln(' |=-=-=-=-=-=| Detalle ',i,' |=-=-=-=-=-=|');
		leerDetalle(rd);
		while( rd.localidad <> valoralto );
		begin
			write(v[i], rd);
			leerDetalle(rd);
		end;
		writeln(' |=-=-=-=-=-=| Detalle ',i,' creado con exito... ');
		close(v[i]);
	end;
end;
	
procedure cargarMaestro(var mae:maestro);
var
	rm:regMaestro;
begin
	rewrite(mae);
	leerMaestro(rm);
	while( rm.localidad <> valoralto ) do
	begin
		write(mae, rm);
		leerMaestro(rm);
	end;
end;

procedure minimo( var v:vector ; var vr:vecRegistro ; var min: regDetalle);
var
	i, minPos:ranVector;
begin
	min.localidad := valoralto;
	
	for i := 1 to dimf do
	begin
		if (min.localidad > vr[i].localidad) then
		begin
			min := vr[i];
			minPos := i;
		end;
	end;
	
	if (min.localidad <> valoralto) then read(v[minPos], vr[minPos]);
end;

procedure imprimirMaestro( var mae:maestro);
var
	rm:regMaestro;
begin
	while (not eof(mae)) do
	begin
		


	
	
BEGIN
	
	
END.

