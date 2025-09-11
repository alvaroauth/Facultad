program ej7;
const
	valoralto = 9999;

type
	aveExtinta = record
		codigo: integer;
		nombre: string[30];
		familia: string[30];
		descripcion: string;
		zona: string;
	end;
	
	archivo = file of aveExtinta;
	
procedure leer(var a: archivo; var ave: aveExtinta);
begin
	if (not eof(a)) then read(a, ave)
	else ave.codigo := valoralto;
end;

procedure leerAve(var a: aveExtinta);
begin
	write('Ingrese el codigo (-1 para terminar): ');
	readln(a.codigo);
	if (a.codigo <> -1) then
	begin
		write('Ingrese el nombre: ');
		readln(a.nombre);
		write('Ingrese la familia: ');
		readln(a.familia);
		write('Ingrese la descripcion: ');
		readln(a.descripcion);
		write('Ingrese la zona: ');
		readln(a.zona);
	end;
end;

procedure ejemplo( var archivo: archivo);
var
	a: aveExtinta;
begin
	rewrite(archivo);
	
	{ Cabecera }
	a.codigo := 0;
    a.nombre := '';
    a.familia := '';
    a.descripcion := '';
    a.zona := '';
    write(archivo, a);
	
    { Registro 1 }
    a.codigo := 1;
    a.nombre := 'Dodo';
    a.familia := 'Raphidae';
    a.descripcion := 'Ave extinta de gran tamanio que habitaba Mauricio';
    a.zona := 'Mauricio';
    write(archivo, a);
   
    { Registro 2 }
    a.codigo := 2;
    a.nombre := 'Great Auk';
    a.familia := 'Alcidae';
    a.descripcion := 'Ave marina incapaz de volar, extinta en el Atlantico Norte';
    a.zona := 'Atlantico Norte';
    write(archivo, a);
   
    { Registro 3 }
    a.codigo := 3;
    a.nombre := 'Labrador Duck';
    a.familia := 'Anatidae';
    a.descripcion := 'Pato silvestre que desaparecio por caza excesiva';
    a.zona := 'Noreste de America';
    write(archivo, a);
   
    { Registro 4 }
    a.codigo := 4;
    a.nombre := 'Moho Petrel';
    a.familia := 'Procellariidae';
    a.descripcion := 'Ave marina de habitos pelagicos que se extinguio';
    a.zona := 'Oceanos del Sur';
    write(archivo, a);

    { Registro 5 }
    a.codigo := 5;
    a.nombre := 'Elephant Bird';
    a.familia := 'Aepyornithidae';
    a.descripcion := 'Ave gigante de Madagascar, extinta desde hacia siglos';
    a.zona := 'Madagascar';
    write(archivo, a);
   
    { Registro 6 }
    a.codigo := 6;
    a.nombre := 'Moho Pardo';
    a.familia := 'Thamnophilidae';
    a.descripcion := 'Ave de plumaje pardo desaparecida hace decadas';
    a.zona := 'Islas del Caribe';
    write(archivo, a);
   
    { Se cierra el archivo }
    close(archivo);
end;

procedure imprimirArchivo(var a: archivo);
var
	ave:aveExtinta;
begin
	reset(a);
	seek(a, 1);
	{ Imprimimos la cabecera de la tabla }
    writeln('+--------+--------------------------------+--------------------------------+--------------------------------------------------------------+--------------------------------+');
    writeln('| Codigo | Nombre                         | Familia                        | Descripcion                                                  | Zona                           |');
    writeln('+--------+--------------------------------+--------------------------------+--------------------------------------------------------------+--------------------------------+');
	leer(a, ave);
	while (ave.codigo <> valoralto) do 
	begin
		  { Imprimimos la línea con los datos del registro }
		  writeln('| ', ave.codigo:6, ' | ', ave.nombre:30, ' | ', ave.familia:30, ' | ', ave.descripcion:60, ' | ', ave.zona:30, ' |');
		  writeln('+--------+--------------------------------+--------------------------------+--------------------------------------------------------------+--------------------------------+');
		  leer(a, ave);
	end;
	close(a);
end;

procedure bajaAve (var a: archivo);
var
	ave, cabecera: aveExtinta;
	cod: integer;
begin
	reset(a);
	
	leer(a, cabecera);
	leer(a, ave);
	writeln;
	write( 'Ingrese el codigo de ave a borrar: ');
	readln(cod);
	while( ave.codigo <> valoralto ) and ( ave.codigo <> cod) do
		leer(a, ave);
		
	if ( ave.codigo = cod) then
	begin
		seek (a, filePos(a)-1);
		write(a, cabecera);
		cabecera.codigo := (filePos(a)-1)*-1;
		seek (a, 0);
		write(a, cabecera);
		writeln( 'Se elimino correctamente :D');
	end
	else
		writeln( 'No existe ningun ave con ese codigo :(');
		
	close(a);
end;

procedure altaAve(var a: archivo);
var
	ave, cabecera: aveExtinta;
begin
	reset(a);
	writeln;
	leerAve(ave);
	leer(a, cabecera);
	
	if (cabecera.codigo = 0) then
	begin
		seek(a, filePos(a) -1);
		write(a, ave);
	end
	else
	begin
		seek(a, cabecera.codigo*-1);
		read(a, cabecera);
		seek(a, filePos(a)-1);
		write(a, ave);
		seek(a, 0);
		write(a, cabecera);
	end;
	writeln;
	writeln('Se dio de alta correctamente...');
	writeln;
	
	close(a);
end;
		
procedure eliminarFisico (var a: archivo);
var
	ave: aveExtinta;
	posBorrar: integer;
	
begin
	reset(a);
	leer(a, ave);
	while(ave.codigo <> valoralto) do
	begin
		if (ave.codigo < 0) then
		begin
			posBorrar := filePos(a)-1;
			seek(a, fileSize(a)-1);
			read(a, ave);
			while(ave.codigo > 0) do
			begin
				seek(a, fileSize(a)-1);
				truncate(a);
				seek(a, fileSize(a)-1);
				read(a, ave);
			end;
			seek(a, posBorrar);
			write(a, ave);
			seek(a, fileSize(a)-1);
			truncate(a);
			seek(a, posBorrar);
		end;
		leer(a, ave);
	end;
	close(a);
end;

var
  arch: archivo;
  opc: integer;
begin
  assign(arch, 'aves.dat');
  repeat
    writeln('==============================================');
    writeln('             Menu de Opciones               ');
    writeln('==============================================');
    writeln('1. Crear archivo de ejemplo');
    writeln('2. Imprimir archivo');
    writeln('3. Dar de baja ave');
    writeln('4. Alta de ave');
    writeln('5. Eliminar fisicamente registros borrados');
    writeln('6. Salir del programa');
    writeln('==============================================');
    write('Ingrese la opcion deseada: ');
    readln(opc);
    writeln;
    case opc of
      1: ejemplo(arch);
      2: imprimirArchivo(arch);
      3: bajaAve(arch);
      4: altaAve(arch);
      5: eliminarFisico(arch);
      6: writeln('Saliendo del programa...');
      else
         writeln('Opción no valida, intente nuevamente.');
    end;
    writeln;
  until opc = 6;
end.


