program ej4;
const 
	valoralto = 9999;
type
	reg_flor = record
		nombre: String[45];
		codigo: integer;
	end;
	
	tArchFlores = file of reg_flor;
	
procedure leer (var a: tArchFlores; var f: reg_flor);
begin
	if (not eof(a)) then read(a, f)
	else f.codigo := valoralto;
end;

procedure leerFlor(var f: reg_flor);
begin
	write(' Ingrese el codigo de la flor (-1 para terminar): ');
	readln(f.codigo);
	if (f.codigo <> -1) then
	begin
		write( 'Ingrese el nombre de la flor: ');
		readln(f.nombre);
	end;
end;

procedure cargarArchivo(var a: tArchFlores);
var
	f: reg_flor;
begin
	rewrite(a);
	f.codigo := 0;
	f.nombre := '';
	write(a, f);  //Cabecera
	leerFlor(f);
	while (f.codigo <> -1) do
	begin
		write(a, f);
		leerFlor(f);
	end;
	close(a);
end;

procedure altaFlor( var a: tArchFlores );
var
	f, cabecera: reg_flor;
begin
	reset(a);
	leerFlor(f);
	if (f.codigo <> -1) then
	begin
		leer(a, cabecera);
		if (cabecera.codigo = 0) then
		begin
			seek(a, filePos(a));
			write(a, f);
		end
		else
		begin
			seek(a, (cabecera.codigo)*-1);
			read(a, cabecera);
			seek(a, filePos(a)-1);
			write(a, f);
			seek(a, 0);
			write(a, cabecera);
		end;
	end;
	writeln('Se dio de alta correctamente :D');
	writeln;
	close(a);
end;
		
procedure bajaFlor(var a: tArchFlores);
var
	f, cabecera: reg_flor;
	codBaja: integer;
begin
	reset(a);
	leer(a, cabecera);
	write('Ingrese el codigo a dar de baja: ');
	readln(codBaja);
	
	leer(a, f);
	while (f.codigo <> valoralto) and (f.codigo <> codBaja) do
		leer(a, f);
		
	if (f.codigo = codBaja) then
	begin
		seek(a, filePos(a)-1);
		write(a, cabecera);
		cabecera.codigo := (filePos(a)-1)*-1;
		seek(a, 0);
		write(a, cabecera);
		writeln('Se borro correctamente el registro.');
	end
	else
		writeln('No se encontro la flor D:');
	writeln;
	close(a);
end;

procedure imprimirArchivo(var a:tArchFlores);
var
	f: reg_flor;
begin
	reset(a);
	
	seek(a, 1);   //Evito la cabecera
	leer(a, f);
	while (f.codigo <> valoralto) do 
	begin
		if (f.codigo > 0) then
			writeln (' ---> Nombre: ',f.nombre,'   Codigo: ',f.codigo)
		else
			writeln (' -x->  Lugar Disponible  <-x-');
		leer(a, f);
	end;
	
	writeln;
	close(a);
end;

procedure ejemplo( var archivo: tArchFlores);
var
	flor: reg_flor;
begin
	Rewrite(archivo);  { Crea el archivo nuevo, perdiéndose el contenido anterior si existiese }
	
	{ Cabecera }
	flor.nombre := '';
	flor.codigo := 0;
	write(archivo, flor);
  
    { Primera flor }
    flor.nombre := 'Rosa';
    flor.codigo := 1;
    Write(archivo, flor);
    
    { Segunda flor }
    flor.nombre := 'Tulipan';
    flor.codigo := 2;
    Write(archivo, flor);
    
    { Tercera flor }
    flor.nombre := 'Lirio';
    flor.codigo := 3;
    Write(archivo, flor);
    
    { Cuarta flor }
    flor.nombre := 'Orquidea';
    flor.codigo := 4;
    Write(archivo, flor);
    
    { Quinta flor }
    flor.nombre := 'Margarita';
    flor.codigo := 5;
    Write(archivo, flor);

    Close(archivo);  { Cierra el archivo para guardar los cambios }
end;

VAR
	arch: tArchFlores;
	op: integer;
	fin: boolean;
	
BEGIN
	fin := false;
	assign(arch, 'archivoFlores.dat');
	repeat 
		writeln ('    *-*-*-*-*-*-* MENU PRINCIPAL *-*-*-*-*-*-*');
		writeln (' 1. Finalizar.');
		writeln (' 1. Cargar Archivo Manualmente.');
		writeln (' 2. Cargar Archivo de Ejemplo.');
		writeln (' 3. Cargar una Nueva Persona.');
		writeln (' 4. Eliminar una persona.');
		writeln (' 5. Imprimir Archivo.');
		writeln;
		write( 'Seleccione una opcion: ');
		readln( op);
		writeln;
		case op of
			0: fin := true;
			1: cargarArchivo( arch );
			2: ejemplo( arch );
			3: altaFlor( arch );
			4: bajaFlor( arch );
			5: imprimirArchivo( arch );
		else
			writeln('Ingrese una opcion valida :p');
		end;
	until (fin = true);
end.
