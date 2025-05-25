program ejercicio2;
const 
	valoralto = 9999;
type 
	asistente = record
		numero: integer;
		apenom: string;
		dni:string;
		email:string;
		tel: string;
	end;
	
	archivo = file of asistente;
	
procedure leer (var arch: archivo ; var a: asistente);
begin
	if (not eof(arch)) then read(arch, a)
	else a.numero := 9999;
end;

procedure crearArchivo(var arch: archivo);
var
    a: asistente;
begin

    rewrite(arch);
    
    a.numero := 101; a.apenom := 'Juan Pérez'; a.dni := '12345678'; a.email := 'juan@email.com'; a.tel := '555-1234';
    write(arch, a);
    
    a.numero := 202; a.apenom := 'María López'; a.dni := '87654321'; a.email := 'maria@email.com'; a.tel := '555-5678';
    write(arch, a);
    
    a.numero := 1501; a.apenom := 'Carlos Gómez'; a.dni := '23456789'; a.email := 'carlos@email.com'; a.tel := '555-9876';
    write(arch, a);
    
    a.numero := 1623; a.apenom := 'Ana Fernández'; a.dni := '98765432'; a.email := 'ana@email.com'; a.tel := '555-6543';
    write(arch, a);
    
    a.numero := 303; a.apenom := 'Luis Rodríguez'; a.dni := '34567890'; a.email := 'luis@email.com'; a.tel := '555-4321';
    write(arch, a);
    
    close(arch);
end;

procedure imprimirArchivo(var arch: archivo);
var
    a: asistente;
begin
    reset(arch);
    
    leer(arch, a);
    while (a.numero <> valoralto) do
    begin
        writeln('Número: ', a.numero, ' | Nombre: ', a.apenom, ' | DNI: ', a.dni, ' | Email: ', a.email, ' | Teléfono: ', a.tel);
        leer(arch, a);
    end;

    close(arch);
end;

procedure eliminarAsistente (var arch: archivo);
var
	a:asistente;
begin
	reset (arch);
	
	leer (arch, a);
	while (a.numero <> valoralto) do
	begin
		if (a.numero >= 1000) then
		begin
			a.apenom := '@' + a.apenom;
			seek(arch, filePos(arch)-1);
			write(arch, a);
		end;
		leer (arch, a);
	end;
	close (arch);
end;


var
	arch: archivo;
	op: char;

BEGIN
	  assign(arch, 'asistentes.dat');

	  repeat
		writeln('--- Menú de Opciones ---');
		writeln('1. Crear archivo');
		writeln('2. Imprimir archivo');
		writeln('3. Eliminar asistente');
		writeln('0. Salir');
		writelm;
		write('Seleccione una opción: ');
		readln(opl);
		writeln;
		
		case op of
		  '1': crearArchivo(arch);
		  '2': imprimirArchivo(arch);
		  '3': eliminarAsistente(arch);
		  '0': writeln('Saliendo del programa...');
		else
		  begin
			 writeln('Opción no válida.');
			 writeln('Presione ENTER para continuar...');
			 readln;
		  end;
		end;
		
	  until op = '0';
	end.
END.

