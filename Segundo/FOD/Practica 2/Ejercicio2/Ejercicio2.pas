program ej2;
const
	valorAlto = -1;
type
	op = 0..9;
	
	Alumno = record
		codigo:integer;
		apellido:string;
		nombre:string;
		cursadas:integer;
		finales:integer;
		end;
		
	alumnoDet = record
		codigo:integer;
		nota:integer;
		end;
		
	detalle = file of alumnoDet;
	maestro = file of Alumno;

procedure leer(var det:detalle ; var a:alumnoDet);
begin
	if (not eof(det)) then read(det, a)
	else a.codigo := valorAlto;
end;

procedure leerAlumno(var a:alumnoDet);
begin
	writeln('  ---- Ingrese un codigo de Alumno ---');
	readln(a.codigo);
	if (a.codigo <> valorAlto) then
	begin
		writeln('  Ingrese a nota del alumno (4 aprueba cursada, 6 aprueba final)');
		readln(a.nota);
	end;
	writeln('  -------------------------------');
end;

procedure crearDetalleTxt (var det:text);
var
	al:alumnoDet;
begin
	rewrite(det);
	leerAlumno(al);
	while(al.codigo <> valorAlto) do
	begin
		writeln(det, al.codigo, al.nota);
		leerAlumno(al);
	end;
	writeln('------------------------------');
	writeln('La carga finalizo con exito...');
	writeln('------------------------------');
	close(det);
end;

procedure crearDetalleBin(var arc: detalle; var carga: text);
var
    det: alDetalle;
begin
    reset(carga);
    rewrite(arc);
    while(not eof(carga)) do
    begin
		with det do readln(carga, codigo, nota); 
        write(arc, det);
    end;
    writeln('Archivo binario detalle creado');
    close(arc);
    close(carga);
end;



