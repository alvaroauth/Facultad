program untitled;
const 
	valoralto = 9999;
type
	cursadas = record 
		alumno: integer;
		materia: integer;
		anio: integer;
		aprobado: boolean;
		end;
		
	finales = record 
		alumno: integer;
		materia: integer;
		anio: integer;
		nota: integer;
		end;
		
	regMaestro = record
		alumno: integer;
		apelido: string;
		nombre: string;
		cantFinales: integer;
		cantCursadas: integer;
		end;
		
	detalleF = file of finales;
	detalleC = file of cursadas;
	Maestro = file of regMaestro;
	
procedure leerF (var det:detalleF ; var rf:finales);
begin
	if (not eof(det)) then read(det, rf)
	else rf.alumno := valoralto;
end;
	
procedure leerC (var det:detalleC ; var rc:cursadas);
begin
	if (not eof(det)) then read(det, rc)
	else rc.alumno := valoralto;
end;	

procedure leerM (var mae:maestro ; var rm:regMaestro);
begin
	if (not eof(mae)) then read(mae, rm)
	else rm.alumno := valoralto;
end;

procedure asignar(var m: maestro; var df:detalleF; var dc:detalleC);
begin
	assign(m, 'maestro.dat');
	assign(df, 'detealleFinales.dat');
	assign(dc, 'detalleCursadas.dat');
end;

procedure LeerCursadas(var c: cursadas);
var
	aux:string;
begin
    writeln('Ingrese codigo de alumno:');
    readln(c.alumno);
    if c.alumno <> valoralto then
    begin
        writeln('Ingrese código de materia:');
        readln(c.materia);
        writeln('Ingrese año de cursada:');
        readln(c.anio);
        writeln('¿Aprobado? (true/false):');
        readln(aux);
        c.aprobado := (aux = 'true');
    end;
end;

procedure LeerFinales(var f: finales);
begin
    writeln('Ingrese codigo de alumno:');
    readln(f.alumno);
    if f.alumno <> valoralto then
    begin
        writeln('Ingrese código de materia:');
        readln(f.materia);
        writeln('Ingrese año del final:');
        readln(f.anio);
        writeln('Ingrese nota obtenida:');
        readln(f.nota);
    end;
end;

procedure LeerRegMaestro(var r: regMaestro);
begin
    writeln('Ingrese codigo de alumno:');
    readln(r.alumno);
    if r.alumno <> valoralto then
    begin
        writeln('Ingrese apellido:');
        readln(r.apelido);
        writeln('Ingrese nombre:');
        readln(r.nombre);
        writeln('Ingrese cantidad de finales aprobados:');
        readln(r.cantFinales);
        writeln('Ingrese cantidad de materias cursadas:');
        readln(r.cantCursadas);
    end;
end;

procedure cargarMaestro(var mae:maestro);
var
	rm:regMaestro;
begin
	rewrite(mae);
	LeerRegMaestro(rm);
	while( rm.alumno <> valoralto) do
	begin
		write(mae, rm);
		LeerRegMaestro(rm);
	end;
	close(mae);
end;

procedure cargarCursadas(var cur: detalleC);
var
    c: cursadas;
begin
    rewrite(cur);
    LeerCursadas(c);
    while (c.alumno <> valoralto) do
    begin
        write(cur, c);
        LeerCursadas(c);
    end;
    close(cur);
end;

procedure cargarFinales(var fin: detalleF);
var
    f: finales;
begin
    rewrite(fin);
    LeerFinales(f);
    while (f.alumno <> valoralto) do
    begin
        write(fin, f);
        LeerFinales(f);
    end;
    close(fin);
end;

procedure acutalizarMaestro(var mae:maestro ; var detf:detalleF ; var detc:detalleC);
var
	rm:regMaestro;
	rc:cursadas;
	rf:finales;
begin
	reset(mae);
	reset(detf);
	reset(detc);
	
	leerM(mae, rm);
	while(rm.alumno <> valoralto) do
	begin
	
		leerC(detc, rc);
		while (rm.alumno < rc.alumno) do leerC(detc, rc);
		
		while(rm.alumno = rc.alumno) do
		begin
			if (rc.aprobado) then
				rm.cantCursadas := rm.cantCursadas + 1;
			leerC(detc, rc);
		end;
		
		leerF(detf, rf);
		while (rm.alumno > rf.alumno) do leerF(detf, rf);
		
		while(rf.alumno = rm.alumno) do
		begin
			if(rf.nota >= 4) then
				rm.cantFinales := rm.cantFinales + 1;
			leerF(detf, rf);
		end;
		
		seek(mae, filePos(mae)-1);
		write(mae, rm);
	end;
	
	close(mae);
	close(detc);
	close(detf);
end;

var
	op: integer;
	detF: detalleF;
	detC: detalleC;
	mae: maestro;
BEGIN	
	asignar(mae,detF,detC);
	repeat
		writeln('= 0 = 0 =   Ingrese una opcion   = 0 = 0 =');
		writeln('0. fin');
		writeln('1. Crear Maestro');
		writeln('2. Crear Detalle de Finales');
		writeln('3. Crear Detalle de Cursadas');
		writeln('4. Actualizar Maestro');
		readln(op);
		case op of 
			1: cargarMaestro(mae);
			2: cargarFinales(detf);
			3: cargarCursadas(detc);
			4:actualizarMaestro(mae,detf,detc);
		end;
	until op = 0;
END.

