program untitled;
const 
	valoralto = 9999;
	
type
	prenda = record
		cod_prenda: integer;
		descripcion: string;
		colores: string;
		tipo_prenda: string;
		stock: integer;
		precio_unitario: real;
	end;
	
	archivo = file of prenda;
	
	archBajas = file of integer;

procedure leer( var a: archivo; var p:prenda);
begin
	if (not eof(a)) then read(a, p)
	else p.cod_prenda := valoralto;
end;

procedure leerBajas( var a: archBajas; var cod: integer);
begin
	if (not eof(a)) then read(a, cod)
	else cod := valoralto;
end;

procedure leerPrenda (var p: prenda);
begin
	write('Ingrese el codigo de prenda(-1 para terminar): ');
	readln(p.cod_prenda);
	if (p.cod_prenda <> -1) then 
	begin
		write('Ingrese la descripcion: ');
		readln(p.descripcion);
		write('Ingrese los colores: ');
		readln(p.colores);
		write('Ingrese el tipo de prenda: ');
		readln(p.tipo_prenda);
		write('Ingrese el stock: ');
		readln(p.stock);
		write('Ingrese el precio por unidad: ');
		readln(p.precio_unitario);
	end;
end;

procedure ejemplo( var archivo: archivo);
var
	p:prenda;
begin

	rewrite(archivo);

	{ Cabecera }
	p.cod_prenda := 0;
	p.descripcion := '';
	p.colores := '';
	p.tipo_prenda := '';
	p.stock := 0;
	p.precio_unitario := 0;
	write(archivo, p);
	
    { Registro 1 }
    p.cod_prenda := 1;
    p.descripcion := 'Remera deportiva';
    p.colores := 'Rojo/Blanco';
    p.tipo_prenda := 'Deportiva';
    p.stock := 10;
    p.precio_unitario := 1500.50;
    write(archivo, p);
   
    { Registro 2 }
    p.cod_prenda := 2;
    p.descripcion := 'Camisa casual';
    p.colores := 'Azul';
    p.tipo_prenda := 'Casual';
    p.stock := 8;
    p.precio_unitario := 2000.75;
    write(archivo, p);
   
    { Registro 3 }
    p.cod_prenda := 3;
    p.descripcion := 'Pantalón vaquero';
    p.colores := 'Azul';
    p.tipo_prenda := 'Casual';
    p.stock := 15;
    p.precio_unitario := 3500.00;
    write(archivo, p);
   
    { Registro 4 }
    p.cod_prenda := 4;
    p.descripcion := 'Vestido elegante';
    p.colores := 'Negro';
    p.tipo_prenda := 'Elegante';
    p.stock := 5;
    p.precio_unitario := 5000.00;
    write(archivo, p);
   
    { Registro 5 }
    p.cod_prenda := 5;
    p.descripcion := 'Short deportivo';
    p.colores := 'Gris';
    p.tipo_prenda := 'Deportivo';
    p.stock := 20;
    p.precio_unitario := 1000.95;
    write(archivo, p);
   
    { Se cierra el archivo }
    writeln;
    writeln ('Se creo el archivo de ejemplo correctamente...');
    writeln;
    close(archivo);
end;

procedure cargarArchivo(var a: archivo);
var
	p: prenda;
begin
	rewrite(a);
	
	p.cod_prenda := 0;
	p.descripcion := '';
	p.colores := '';
	p.tipo_prenda := '';
	p.stock := 0;
	p.precio_unitario := 0;
	write (a, p);
	
	leerPrenda(p);
	while (p.cod_prenda <> -1) do
	begin
		write(a, p);
		leerPrenda(p);
	end;
	
	close(a);
end;

procedure imprimirArchivo( var a: archivo );
var
	p: prenda;
begin
	reset(a);
	if (not eof(a)) then
	begin
		seek(a, 1);
		leer(a, p);
		while (p.cod_prenda <> valoralto) do
		begin
			if (p.stock > 0) then
			begin
				writeln ('   ---> Codigo: ',p.cod_prenda,' <---');
				writeln ('   Descripcion: ',p.descripcion);
				writeln ('       Colores: ',p.colores);
				writeln ('Tipo de prenda: ',p.tipo_prenda);
				writeln ('         Stock: ',p.stock);
				writeln ('   ---> Precio: ',p.precio_unitario:0:2,' <---');
			end
			else
				writeln('   -x->  Espacio libre para un regsitro  <-x-');
			writeln;
			leer(a, p);
		end;
	end;
	close(a);
end;

procedure cargarArchivoBajas(var b: archBajas);
var
	cod: integer;
begin
	rewrite(b);
	write ('Ingrese un codigo para eliminar (-1 para terminar): ');
	readln(cod);
	while(cod <> -1) do
	begin
		write(b, cod);
		write ('Ingrese un codigo para eliminar (-1 para terminar): ');
		readln(cod);
	end;
end;


procedure bajaPrenda (var a:archivo; var bajas: archBajas);
var
	p, cabecera: prenda;
	cod: integer;
begin
	reset(a);
	reset(bajas);
	
	leer(a, cabecera);
	leerBajas(bajas, cod);
	
	while (cod <> valoralto) do
	begin
		leer(a, p);
		while(p.cod_prenda <> valoralto) and (p.cod_prenda <> cod) do
			leer(a, p);
	
		if (p.cod_prenda = cod) then
		begin	
			seek(a, filePos(a)-1);
			write(a, cabecera);
			cabecera.stock := (filePos(a)-1)*-1;
			seek(a, 0);
			write(a, cabecera);
			writeln('Se elimino la prenda con codigo: ',cod);
		end
		else
			writeln('No se encontro la prenda con codigo: ',cod);
			
		leerBajas(bajas, cod);
	end;
	writeln('Se termino de procesar el archivo...');
	
	writeln;
	close(a);
	close(bajas);
end;

procedure altaPrenda(var a: archivo);
var
	p, cabecera: prenda;
begin
	reset(a);
	leerPrenda(p);
	
	leer(a, cabecera);
	if (cabecera.stock = 0) then
	begin
		seek(a, fileSize(a));
		write(a, p);
	end
	else
	begin
		seek(a, cabecera.stock*-1);
		read(a, cabecera);
		seek(a, filePos(a)-1);
		write(a, p);
		seek(a, 0);
		write(a, cabecera);
	end;
	
	writeln('La prenda se dio de alta correctamente...');
	writeln;
	close(a);
end;

procedure imprimirBajas(var b: archBajas);
var
	num: integer;
begin
	reset(b);
	
	leerBajas(b, num);
	while (num <> valoralto) do
	begin
		writeln(' -x-> Codigo: ',num);
		leerBajas(b, num);
	end;
	writeln;
	
	close(b);
end;
	
VAR
	arch: archivo;
	bajas: archBajas;
	op: integer;
	fin: boolean;
	
BEGIN
	assign(arch, 'archivoPrendas.dat');
	assign(bajas, 'codigosBaja.dat');
	fin := false; 
	
	repeat
		writeln('   =-=-=-=-=-=-= - MENU PRINCPIAL - =-=-=-=-=-=-=');
		writeln('0. Terminar Programa.');
		writeln('1. Cargar Arhcivo de Prendas Manualmente.');
		writeln('2. Cargar Arhcivo de Prendas de Ejemplo.');
		writeln('3. Cargar Arhcivo de Bajas.');
		writeln('4. Agregar una Prenda.');
		writeln('5. Eliminar Prendas.');
		writeln('6. Imprimir archivo de prendas.');
		writeln('7. Imprimir archivo de bajas.');
		writeln;
		write('   Seleccione una opcion: ');
		readln(op);
		
		case op of 
			0: fin := true;
			1: cargarArchivo( arch );
			2: ejemplo( arch );
			3: cargarArchivoBajas( bajas );
			4: altaPrenda( arch );
			5: bajaPrenda ( arch, bajas );
			6: imprimirArchivo ( arch );
			7: imprimirBajas ( bajas );
		else
			writeln(' Ingrese un opcion valida...');
		end;
		writeln;
		
	until (fin);
END.





