program ej7b;
type
	opc = 1..6;
	str20 = string[20];
	novela = record
		cod:integer;
		nom:str20;
		genero:str20;
		precio:real;
		end;
		
	NovTexto = text;
	NovBinario = file of novela;

procedure leer(var nb:novbinario ; var n:novela);
begin
	if(not eof(nb)) then
		read(nb,n)
	else
		n.cod := -1;
end;
procedure crearBinario(var nt:novtexto ; var nb:novBinario);
var
	n:novela;
	nom:str20;
begin
	writeln(' :::: Ingrese el nombre del archivo ::::');
	readln(nom);
	assign(nb, nom);
	rewrite(nb);
	reset(nt);
	while(not eof(nt)) do
	begin
		readln(nt,n.cod,n.precio,n.genero);
		readln(nt,n.nom);
		write(nb,n);
	end;
	writeln('Archivo creado con exito...');
	close(nt);
	close(nb);
end;

procedure actualizarTexto(var nt:novtexto ; var nb:novbinario);
var
	n:novela;
begin
	reset(nb);
	rewrite(nt);
	while(not eof(nb)) do
	begin
		read(nb,n);
		writeln(nt,n.cod,n.precio,n.genero);
		writeln(nt,n.nom);
	end;
	close(nt);
	close(nb);
end;

procedure abrirBinario(var nb:novbinario);
var
	nom:str20;
begin
	writeln('>> Ingrese el nombre del archivo binario <<');
	readln(nom);
	assign(nb,nom);
end;

procedure agregarNovela(var nb:novbinario);
procedure leer(var n:novela);
begin
	writeln('--> Ingrese un codigo de novela <--');
	readln(n.cod);
	if (n.cod <> -1) then
	begin
		writeln('Ingrese el nombre de la novela');
		readln(n.nom);
		writeln('Ingrese el genero de la novela');
		readln(n.genero);
		writeln('Ingrese el precio de la novela');
		readln(n.precio);
	end;
end;
var
	n:novela;
begin
	reset(nb);
	leer(n);
	seek(nb,fileSize(nb));
	write(nb, n);
	writeln('Novela agregada con exito...');
	close(nb);
end;

procedure modificarNovela(var nb:novbinario);
type
	opAux = 1..4;
var
	n:novela;
	cod:integer;
	op: opAux;
begin
	reset(nb);
	writeln(' -> Ingrese el codigo de la novela a modificar <-');
	readln(cod);
	leer(nb,n);
	while(n.cod <> -1)and(n.cod <> cod) do
		leer(nb,n);
	if (n.cod <> -1) then
	begin
		writeln('El archivo se encontro, ingrese que campo desea modificar');
		writeln('1. Codigo de Novela');
		writeln('2. Nombre');
		writeln('3. Genero');
		writeln('4. Precio');
		readln(op);
		writeln('----------------------------------------');
		case op of 
			1: readln(n.cod);
			2: readln(n.nom);
			3: readln(n.genero);
			4: readln(n.precio);
		end;
		seek(nb,filePos(nb)-1);
		write(nb, n);
		writeln(' -El campo se modifico correctamente-');
	end
	else
		writeln('El codigo no se encontro');
	close(nb);
end;
		

var
	novbin:novbinario;
	novtxt:novtexto;
	fin:boolean;
	opcion:opc;
begin
	fin := false;
	assign(novtxt,'novelas.txt');
	repeat
		writeln(' ---> INGRESE EL NUMERO QUE CORRESPONDA A LA ACCION <---');
		writeln('1. Crear archivo binario a partir de texto');
		writeln('2. Abrir archivo binario');
		writeln('3. Actualizar archivo de texto mediante el binario');
		writeln('4. Agregar novela');
		writeln('5. Modificar novela');
		writeln('6.Finalizar');
		readln(opcion);
		case opcion of
			1: crearBinario(novtxt,novbin);
			2: abrirBinario(novbin);
			3: actualizarTexto(novtxt,novbin);
			4: agregarNovela(novbin);
			5: modificarNovela(novbin);
			6: fin :=true;
		end;
	until fin;
	writeln('----------------------------------------------');
end.
	
