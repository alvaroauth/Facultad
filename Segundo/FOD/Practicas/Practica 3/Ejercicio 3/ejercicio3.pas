
program untitled;
const
	valoralto = 9999;
type
	novela = record
		codigo: integer;
		genero: string;
		nombre: string;
		duracion: real;
		director: string;
		precio: real;
	end;
		
	archivo = file of novela;
	
procedure leer (var ar: archivo ; var n: novela);
begin
	if (Not eof(ar)) then
		read(ar, n)
	else
		n.codigo := valoralto;
end;

procedure cargarArchivo(var ar: archivo);
var
  n: novela;
begin
	rewrite(ar);  { Abrimos el archivo para escribir }
	  
	{ Cabecera }
	n.codigo := 0;
	n.genero := '';
	n.nombre := '';
	n.duracion:=0;
	n.director:='';
	n.precio:=0;
	write(ar,n);
	  
	{ Primera novela }
	n.codigo := 100;          
	n.genero := 'Romantica';
	n.nombre := 'El Amor Eterno';
	n.duracion := 45.5;
	n.director := 'Sergio Martinez';
	n.precio := 120.75;
	write(ar, n);

	{ Segunda novela }
	n.codigo := 200;          
	n.genero := 'Accion';
	n.nombre := 'La Venganza';
	n.duracion := 50.0;
	n.director := 'Mariana Lopez';
	n.precio := 150.0;
	write(ar, n);

	{ Tercera novela }
	n.codigo := 300;           
	n.nombre := 'Vidas Cruzadas';
	n.duracion := 55.2;
	n.director := 'Carlos Gomez';
	n.precio := 130.5;
	write(ar, n);

	{ Cuarta novela }
	n.codigo := 400;          
	n.genero := 'Misterio';
	n.nombre := 'El Secreto';
	n.duracion := 60.0;
	n.director := 'Lucia Rodriguez';
	n.precio := 160.0;
	write(ar, n);

	{ Quinta novela }
	n.codigo := 500;          
	n.genero := 'Comedia';
	n.nombre := 'Risas y Llanto';
	n.duracion := 48.0;
	n.director := 'Juan Perez';
	n.precio := 110.0;
	write(ar, n);
	 
	close(ar);
end;

procedure leerNovela (var n: novela);
begin
	write('Codigo: ');
    readln(n.codigo);
	if (n.codigo <> valoralto) then
	begin
		write('Genero: ');
		readln(n.genero);
		
		write('Nombre: ');
		readln(n.nombre);
		
		write('Duracion en minutos: ');
		readln(n.duracion);
		
		write('Director: ');
		readln(n.director);
		
		write('Precio: ');
		readln(n.precio);
	end;
end;

	
	
procedure agregarNovela (var ar: archivo);
var
	nov, cabecera: novela;
	pos: integer;
begin
	leerNovela(nov);
	reset(ar);
	read(ar, cabecera);
	if (cabecera.codigo = 0) then
	begin
		seek(ar, fileSize(ar));
		write(ar, nov);
	end
	else
	begin
		pos := cabecera.codigo * -1;
		seek(ar, pos);
		read(ar, cabecera);
		seek(ar, filePos(ar)-1);
		write(ar, nov);
		seek(ar, 0);
		write(ar, cabecera);
	end;
	close(ar);
end;

	
procedure eliminarNovela(var ar: archivo);
var
	cod, pos: integer;
	cabecera, n: novela;
begin
	write('Ingrese el codigo de la novela a borrar: ');
	readln(cod);
	reset(ar);
	read(ar, cabecera);
	leer(ar, n);
	
	while (n.codigo <> valoralto) and (n.codigo <> cod) do leer(ar, n);
	
	if (n.codigo = cod) then
	begin
		pos := filePos(ar)-1;
		seek(ar, pos);
		write(ar, cabecera); 
		n.codigo := pos * -1;
		seek(ar, 0);
		write(ar, n);
		writeln('Se elimino la novela correctamente :D');
	end
	else
		writeln('La novela no se encontro D:');
end;

procedure modificarNovela(var ar:archivo);
var
	n:novela;
	cod, opcion: integer;
begin
	reset(ar);
	write('Ingrese el codigo a buscar: ');
	readln(cod);
	leer(ar, n);
	while (n.codigo <> valoralto) and (n.codigo <> cod) do leer(ar, n);
	if (cod = n.codigo) then
	begin
		writeln('Seleccione el campo que desea modificar:');
		writeln('1. Genero');
		writeln('2. Nombre');
		writeln('3. Duracion');
		writeln('4. Director');
		writeln('5. Precio');
		write('Ingrese una opcion (1-5): ');
		readln(opcion);
		writeln;

		case opcion of
		  1: begin
			   write('Ingrese el nuevo genero: ');
			   readln(n.genero);
			 end;
		  2: begin
			   write('Ingrese el nuevo nombre: ');
			   readln(n.nombre);
			 end;
		  3: begin
			   write('Ingrese la nueva duracion: ');
			   readln(n.duracion);
			 end;
		  4: begin
			   write('Ingrese el nuevo director: ');
			   readln(n.director);
			 end;
		  5: begin
			   write('Ingrese el nuevo precio: ');
			   readln(n.precio);
			 end;
		else
		  writeln('Opción no valida.');
		end;	
		
		seek(ar, filePos(ar)-1);
		write(ar, n);
	end
	else
		writeln('La novela no se encontro D:');
end;

procedure listarNovelasTxt(var arch : archivo); 
var
	n: novela; 
	archTxt : Text; 
begin
	reset(arch); 
	assign(archTxt,'ListaNovelas.txt'); 
	rewrite(archTxt); 
	seek(arch,1);
	leer(arch,n); 
	while (n.codigo <> valorAlto) do 
	begin
		writeln (archTxt,'-----------------------------------------------------');
		if (n.codigo > 0) then 
		begin 
			Writeln(archTxt, ' Codigo de novela: ',n.codigo, '    Nombre: ',n.nombre); 
			Writeln(archTxt,' Duracion:  ',n.duracion:0:2, '    Genero: ',n.genero); 
			Writeln(archTxt, ' Precio: $',n.precio:0:2, '    Director: ',n.director); 
		end;
		leer(arch,n); 
	end; 
	close(arch); 
	close(archTxt); 
end;
 
procedure imprimirArchivoPantalla(var ar: archivo);
var
	n: novela;
begin
	reset(ar);
	seek(ar, 1);
	leer( ar, n);
	while (n.codigo <> valoralto) do
	begin
		if (n.codigo > 0) then
		begin
			Writeln(' -*-*-*-*-*- Codigo de novela: ',n.codigo, ' -*-*-*-*-*-'); 
			writeln('             Nombre: ',n.nombre);
			writeln('             Duracion: ',n.duracion:0:2);
			writeln('             Genero: ',n.genero);
			writeln('             Precio: ',n.precio:0:2);
			writeln('             Director: ',n.director);
			writeln;
		end;
		leer(ar, n);
	end;
	close(ar);
end;

var
  arNovelas: archivo;
  opcion: integer;
begin
  assign(arNovelas, 'novelas.dat');
  repeat
    writeln('===== MENU PRINCIPAL =====');
    writeln('1. Cargar archivo de ejemplo');
    writeln('2. Imprimir archivo en pantalla');
    writeln('3. Alta (Agregar novela)');
    writeln('4. Baja (Eliminar novela)');
    writeln('5. Modificacion');
    writeln('6. Pasar a texto (Exportar a ListaNovelas.txt)');
    writeln('7. Salir');
    write('Seleccione una opcion: ');
    readln(opcion);
    writeln;
    
    case opcion of
      1: begin
           cargarArchivo(arNovelas);
           writeln('Archivo de ejemplo cargado.');
           readln;
         end;
      2: begin
           imprimirArchivoPantalla(arNovelas);
           readln;
         end;
      3: begin
           agregarNovela(arNovelas);
           writeln('Novela agregada.');
           readln;
         end;
      4: begin
           eliminarNovela(arNovelas);
           readln;
         end;
      5: begin
           modificarNovela(arNovelas);
           readln;
         end;
      6: begin
           listarNovelasTxt(arNovelas);
           writeln('Archivo exportado a ListaNovelas.txt.');
           readln;
         end;
      7: writeln('Saliendo del programa.');
    else
      writeln('Opción no válida, intente nuevamente.');
      readln;
    end;
  until opcion = 7;
end.


