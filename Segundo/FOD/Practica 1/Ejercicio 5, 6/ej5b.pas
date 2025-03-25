program p1ej5;
type
	op =1..9;
	str20 = string[20];
	celular = record
		codigo:integer;
		nombre:str20;
		desc:string;
		marca:str20;
		precio:real;
		stockMin:integer;
		stockAct:integer;
		end;
		
	celtexto = text;
	celbinario = file of celular;
procedure leer(var cb:celbinario ; var c:celular);
begin
	if(not eof(cb)) then
		read(cb, c)
	else
		c.codigo := -1;
end;

procedure BinATxt(var cb:celbinario;var ct:celtexto);
var
	c:celular;
	nombreArch:string;
begin
	writeln(' - - - INGRESE EL NOMBRE DEL ARCHIVO BINARIO - - -');
	readln(nombreArch);
	assign(cb,nombreArch);
	rewrite(cb);
	reset(ct);
	writeln('-----------------------------------');
	while(not eof(ct)) do
	begin
		readln(ct,c.codigo,c.precio,c.marca);
		readln(ct,c.stockMin,c.stockAct);
		readln(ct,c.nombre);
		write(cb, c);
	end;
	close(cb);
	close(ct);
	writeln ('Archivo exportado correctamente...');
end;
procedure TxtABin(var ct:celtexto;var cb:celbinario);
var
	c:celular;
begin
	rewrite(ct);
	reset(cb);
	while (not eof(cb)) do
	begin
		read(cb,c);
		writeln(ct,c.codigo,c.precio:0:2,c.marca);
		writeln(ct,c.stockMin,c.stockAct);
		writeln(ct,c.nombre);
	end;
	close(ct);
	close(cb);
end;
	
	

procedure AbrirBin(var cb:celbinario);
var
	nom:string;
begin
	writeln(' - Ingrese el nombre del archivo para abrir -');
	readln(nom);
	assign(cb,nom);
end;

procedure listarTodos(var cb:celbinario);
var
	c:celular;
begin
	reset(cb);
	while (not eof(cb)) do
	begin
		read(cb, c);
		writeln(' ---> Marca: ',c.marca,'   Nombre: ',c.nombre,'   Descricpion: ',c.desc,'   Codigo: ',c.codigo,'   Precio: ',c.precio:0:2,'   Stock: ',c.stockAct,'/',c.stockMin);
	end;
	close(cb);
end;

procedure listarStock(var cb:celbinario);
var
	c:celular;
begin
	reset(cb);
	while (not eof(cb)) do
	begin
		read(cb, c);
		if(c.stockMin > c.stockAct) then
			writeln(' ---> Marca: ',c.marca,'   Nombre: ',c.nombre,'   Descricpion: ',c.desc,'   Codigo: ',c.codigo,'   Precio: ',c.precio:0:2,'   Stock: ',c.stockAct,'/',c.stockMin);
	end;
	close(cb);
end;

procedure agregarCelular(var cb:celbinario);
procedure leerCel (var c:celular);
begin
	writeln('Ingrese el codigo de celular');
	readln(c.codigo);
	if (c.codigo <> -1) then
	begin
		writeln('Ingrese la marca');
		readln(c.marca);
		writeln('Ingrese el nombre');
		readln(c.nombre);
		writeln('Ingrese la descripcion');
		readln(c.desc);
		writeln('Ingrese el precio');
		readln(c.precio);
		writeln('Ingrese el stock minimo');
		readln(c.stockMin);
		writeln('Ingrese el stock disponible');
		readln(c.stockAct);
	end;
end;
var
	c:celular;
begin
	leerCel(c);
	reset(cb);
	seek(cb,fileSize(cb));
	write(cb, c);
	close(cb);
end;

procedure modificarStock (var cb:celbinario);
var
	c:celular;
	cod:integer;
begin
	writeln(' - Ingrese el codigo del celular a actualizar -');
	readln(cod);
	reset(cb);
	leer(cb, c);
	while(c.codigo <> -1)and(c.codigo <> cod) do
		leer(cb, c);
	if (c.codigo = -1) then
		writeln('El codigo de celular no se encuentra en la base de datos')
	else
	begin
		writeln('El codigo de celular se encontro, ingrese el nuevo stock actual');
		readln(c.stockAct);
		write(cb, c);
	end;
	close(cb);
end;
		
procedure cargarSinStock (var cb:celbinario);
var
	c:celular;
	sstxt:text;
begin
	assign(sstxt,'SinStock.txt');
	rewrite(sstxt);
	reset(cb);
	while (not eof(cb)) do
	begin
		read(cb, c);
		if (c.stockAct = 0) then
		begin
			writeln(sstxt,c.codigo,' ',c.precio:0:2,' ',c.marca);
			writeln(sstxt,c.stockMin,' ',c.stockAct);
			writeln(sstxt,c.nombre);	
		end;
	end;
	writeln('Archivo exportado con exito...');
	close(cb);
	close(sstxt);
end;
		
var
	celBin:celBinario;
	celtxt:celTexto;
	opcion:op;
	fin:boolean;
BEGIN
	fin := false;
	assign(celtxt,'celulares.txt');
	repeat
	writeln(' /////// INGRESE EL NUMERO CORRESPONDIENTE A LA ACCION \\\\\\\');
	writeln('1. Crear Archivo binario a partir de texto');
	writeln('2. Abrir Archivo binario');
	writeln('3. Modificar archivo de texto a partir de binario');
	writeln('4. Mostrar todos los elementos');
	writeln('5. Mostrar todos los elementos cuyo stock actual esta debajo del minimo');
	writeln('6. Agregar celular');
	writeln('7. Modificar stock');
	writeln('7. Crear texto de los productos sin stock');
	writeln('9.Finalizar');
	readln(opcion);
	
	case opcion of
	1: BinATxt(celbin,celtxt);
	2: AbrirBin(celbin);
	3: TxtABin(celtxt,celbin);
	4: listarTodos(celbin);
	5: listarStock(celbin);
	6: agregarCelular(celbin);
	7: modificarStock(celbin);
	8: cargarSinStock(celbin);
	9: fin := true;
	end;
	writeln('--------------------------------------------');
	until fin;
END.

