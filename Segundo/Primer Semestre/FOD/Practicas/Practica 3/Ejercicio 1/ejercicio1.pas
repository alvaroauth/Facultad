program ejercicio1;
const
	valorAlto = 9999;
type
	empleado = record
		numEmpleado: integer;
		apeYNom: string[30];
		edad: integer;
		dni: integer;
	end;

	archivo_empleados = file of empleado;
	
procedure leer (var arch: archivo_empleados; var emp: empleado);
begin
	if (not eof(arch)) then read(arch, emp)
	else emp.numEmpleado := valorAlto;
end;

procedure eliminarEmpleado ( var arch: archivo_empleados; num: integer );
var
	e, aux: empleado;
begin
	reset (arch);
	
	seek( arch, fileSize(arch)-1 );
	leer( arch, aux );
	seek( arch, 0 );
	leer( arch, e );
	while (e.numEmpleado <> valorAlto) and (e.numEmpleado <> num) do
		leer( arch, e );
		
	writeln('num ',e.numEmpleado);
	
	if (e.numEmpleado = num) then
	begin
		seek(arch, filePos(arch)-1);
		write(arch, aux);
		seek( arch, fileSize(arch)-1 );
		truncate(arch);
	end
	else
		writeln( 'No se encontro el empleado :(' );
		
	close (arch);
end;


procedure imprimirArchivo(var arch: archivo_empleados);
var
    e: empleado;
begin
    reset(arch);
    leer(arch, e);
    while (e.numEmpleado <> valorAlto) do
    begin
        writeln('Numero de empleado: ', e.numEmpleado);
        writeln('Apellido y Nombre: ', e.apeYNom);
        writeln('Edad: ', e.edad);
        writeln('DNI: ', e.dni);
        writeln('------------------------');
        leer(arch, e);
    end;
    close(arch);
end;

procedure cargarArchivo(var arch: archivo_empleados);
var
  e: empleado;
begin
  { Se abre el archivo para escritura }
  rewrite(arch);

  { Registro 1 }
  e.numEmpleado := 1001;
  e.apeYNom := 'Gonzalez, Juan';
  e.edad := 30;
  e.dni := 12345;
  write(arch, e);

  { Registro 2 }
  e.numEmpleado := 1002;
  e.apeYNom := 'Martinez, Ana';
  e.edad := 25;
  e.dni := 8765;
  write(arch, e);

  { Registro 3 }
  e.numEmpleado := 1003;
  e.apeYNom := 'Perez, Carlos';
  e.edad := 40;
  e.dni := 11223;
  write(arch, e);
  { Registro 3 }
  e.numEmpleado := 1004;
  e.apeYNom := 'Villca, Facundo';
  e.edad := 21;
  e.dni := 12356;
  write(arch, e);



  { Se cierra el archivo }
  close(arch);
end;


var
  archivo: archivo_empleados;
  op, num: integer;
begin
  assign(archivo, 'empleados.dat');
  repeat
    writeln('----- MENU -----');
    writeln('1 - Cargar Archivo');
    writeln('2 - Imprimir Archivo');
    writeln('3 - Eliminar Empleado');
    writeln('4 - Salir');
    write('Ingrese la opcion: ');
    readln(op);
    case op of
      1: begin
           cargarArchivo(archivo);
           writeln('Archivo cargado exitosamente.');
         end;
      2: begin
           writeln('--- Contenido del archivo ---');
           imprimirArchivo(archivo);
         end;
      3: begin
           write('Ingrese número de empleado a eliminar: ');
           readln(num);
           eliminarEmpleado(archivo, num);
         end;
      4: writeln('Saliendo del programa...');
    else
      writeln('Opcion invalida.');
    end;
    writeln;
  until op = 4;
end.

