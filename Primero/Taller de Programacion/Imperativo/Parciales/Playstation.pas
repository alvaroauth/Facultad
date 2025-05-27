{
Playstation store requiere procesar las compras realizadas por sus clientes durante el año 2022

	a) Implementar un modulo que lea compras de videojuegos. De cada compra se lee codigo del videojuego, codigo de cliente, dia y mes. La lectura finaliza con el codigo de cliente 0
	Se deben retornar 2 estructuras:
		i. Una estructura eficiente para la busqueda por codigo de cliente 
		ii. Otra estructura que almacena la cantidad de compras realizadas en cada mes
		
	b) Implementar un modulo quer eciba la estructura generada en a) i, un codigo de cliente, retorne todas las compras que realizo dicho cliente
	
	c) Implementar un modulo que reciba la estructura generada en a) ii, y retorne la misma estructura ordenada por cantidad de mayor a menor
}


program untitled;
const
	dias = 31;
	meses = 12;
	anio = 2022;
type
	ranDias = 1..31;
	ranMeses = 1..12;
	
	compra = record
		juego:integer;
		cliente:integer;
		dia:ranDias;
		mes:ranMeses;
		end;
		
	cliente = record
		juego:integer;
		dia:ranDias;
		mes:Ranmeses;
		end;
		
	lista = ^nodoL;
	
	nodoL = record
		dato:cliente;
		sig:lista;
		end;

	recordA = record
		cliente:integer;
		l:Lista;
		end;
		
	arbol = ^nodoA;
	
	nodoA = record
		dato:recordA;
		hi:arbol;
		hd:arbol;
		end;
		
	vMeses = array [RanMeses] of integer;
	
procedure iniciarVector (var v:vMeses);
var
	i:RanMeses;
begin
	for i := 1 to meses do v[i] := 0;
end;

procedure aleatorio (var c:compra);
begin
	c.cliente := random(16);
	if (c.cliente <> 0) then
	begin
		c.juego := random(21);
		c.dia := 1+ random(31);
		c.mes := 1+ random(12);
	end;
end;

procedure cargarRegistro (var cli:cliente ; c:Compra);
begin
	cli.juego := c.juego;
	cli.dia := c.dia;
	cli.mes := c.mes;
end;

procedure agregarAdelante (var l:lista ; c:compra);
var
	nue:lista;
	cli:cliente;
begin
	new(nue);
	cargarRegistro(cli,c);
	nue^.dato := cli;
	nue^.sig := l;
	l := nue;
end;

procedure agregarArbol ( var a:arbol ; c:Compra);
begin
	if (a = nil) then 
	begin
		new(a);
		a^.hi:=nil;
		a^.hd:=nil;
		a^.dato.l := nil;
		a^.dato.cliente := c.cliente;
		agregarAdelante ( a^.dato.l,c);
	end
	else
		if (a^.dato.cliente = c.cliente) then
			agregarAdelante(a^.dato.l,c)
		else
			if ( a^.dato.cliente > c.cliente ) then
				agregarArbol ( a^.hi,c)
			else
				agregarArbol ( a^.hd,c);
end;

procedure cargarEstructuras ( var a:arbol ; var v:vMeses);
var
	c:compra;
begin
	aleatorio(c);
	while ( c.cliente <> 0) do
	begin
		agregarArbol(a,c);
		v[c.mes] := v[c.mes] + 1;
		aleatorio(c);
	end;
end;

procedure imprimirLista ( l:Lista);
begin
	while (l<> nil) do
	begin
		writeln('   ---> Codigo de juego: ',l^.dato.juego, '   ---> Fecha:  ',l^.dato.dia,' / ',l^.dato.mes,' / ', anio);
		l := l^.sig;
	end;
end;


procedure imprimirArbol( a:arbol);
begin
	if (a<>nil) then
	begin
		imprimirArbol(a^.hi);
		writeln (' * * * CODIGO DE CLIENTE: ',a^.dato.cliente,' * * *');
		imprimirLista(a^.dato.l);
		writeln();
		imprimirArbol(a^.hd);
	end;
end;

procedure retornarCliente (a:arbol ; cli:integer ; var l2:lista);
begin
	if (a <> nil) then
		if (a^.dato.cliente = cli) then
			l2 := a^.dato.l
		else
			if (a^.dato.cliente > cli) then
				retornarCliente(a^.hi,cli,l2)
			else
				retornarCliente(a^.hd,cli,l2);
end;

procedure imprimirVector(v:vMeses);
var
	i:ranMeses;
begin
	for i := 1 to meses do
	begin
		writeln ('       - - - Mes: ', i, ' - - - Cantidad de ventas: ',v[i]);
		writeln();
	end;
end;

procedure ordenarVector (var v:vMeses);
var
	i,j,pos:ranMeses;
	item:integer;
begin
	for i:=1 to (meses-1) do
	begin
		pos := i;
		for j := i+1 to meses do
			if (v[j] > v[pos]) then pos:=j;
		item := v[pos];   
		v [pos] := v[i];   
		v[i] := item;
	end;
end;

VAR
	a:arbol;
	vm: vMeses;
	cli:integer;
	l2:lista;
BEGIN
	randomize;
	a:= nil;
	l2:=nil;
	iniciarVector(vm);
	cargarEstructuras(a,vm);
	imprimirArbol(a);
	writeln('______________________________');
	writeln();
	imprimirVector(vm);
	writeln('______________________________');
	writeln();
	writeln('Ingrese el numero de cliente a buscar');
	readln(cli);
	retornarCliente(a,cli,l2);
	if (l2 <> nil) then
	begin
		writeln('La lista de compras del cliente: ',cli,' es: ');
		imprimirLista(l2);
	end
	else
		writeln('El cliente no se encuentra en la lista');
	writeln('______________________________');
	ordenarVector(vm);
	imprimirVector(vm);
END.

