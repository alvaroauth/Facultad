{
Un comercio necesita el procesamiento de las compras realizadas por sus clientes durante el mes de julio de 2022. De cada compra se conoce el codigo de cliente, dia, cantidad de productos y monto pagado

	a) Implementar un modulo que lea compras, genere y retorne una estructura adecuada para la busqueda por codigo de cliente, donde cada codigo de cliente se almacenan juntas todas sus compras 
(dia, cantidad de produtos y monto) que realizo. La lectura finaliza con cantidad de productos 0
	
	b) Implementar un modulo que reciba la estructura generada en a) y un codigo de cliente y retorne todas las compras de dicho cliente
	
	c) Realizar un modulo recursivo que reciba la estructura que retorna b) y retorne el monto de la compra con mayor cantidad de productos 
}


program Comercio;
const
	corte = 0;
	dias = 31;
type
	ranDias = 1..dias;
	
	compra = record
		cliente:integer;
		dia:ranDias;
		cantp:integer;
		monto:real;
		end;
		
	cliente = record
		dia:ranDias;
		cantp:integer;
		monto:real;
		end;
		
	lista = ^nodoL;
	
	nodoL = record
		dato:cliente;
		sig:lista;
		end;
	
	recordC = record
		cliente:integer;
		l:lista;
		end;
	
	arbol = ^nodoA;
	
	nodoA = record
		dato:recordC;
		hi:arbol;
		hd:arbol;
		end;
		
		
procedure aleatorio ( var c:compra);
begin
	c.cantp := random(11);
	if (c.cantp <> corte) then 
	begin
		c.dia := 1+random(31);
		c.cliente := random(16);
		c.monto := random(101);
	end;
end;

procedure cargarRegistro(var cli:cliente ; com:Compra);
begin
	cli.monto := com.monto;
	cli.cantp := com.cantp;
	cli.dia := com.dia;
end;

procedure agregarAdelante( var l:lista ; c:compra);
var
	nue:lista;
	cli:cliente;
begin
	new(nue);
	cargarRegistro(cli,c);
	nue^.dato := cli;
	nue^.sig := l;
	l:= nue;
end;

procedure agregarArbol ( var a:arbol ; c:compra);
begin
	if ( a=nil ) then
	begin
		new(a);
		a^.hi := nil;
		a^.hd := nil;
		a^.dato.l := nil;
		a^.dato.cliente := c.cliente;
		agregarAdelante(a^.dato.l,c);
	end
	else
		if (a^.dato.cliente = c.cliente) then agregarAdelante (a^.dato.l,c)
		else
			if (a^.dato.cliente > c.cliente) then agregarArbol(a^.hi,c)
			else agregarArbol(a^.hd,c);
end;

procedure cargarArbol(var a:arbol);
var
	c:compra;
begin
	aleatorio(c);
	while (c.cantp <> corte) do
	begin
		agregarArbol(a, c);
		writeln('  ---> Cliente: ', c.cliente ,'  ---> Dia: ', c.dia, '  ---> Cantidad: ', c.cantp, '  ---> Monto: ', c.monto:0:2);
		aleatorio(c);
	end;
end;

procedure imprimirLista (l:Lista);
begin
	while (l <> nil) do
	begin
		writeln('                    ---> Dia: ', l^.dato.dia, '  ---> Cantidad: ', l^.dato.cantp, '  ---> Monto: ', l^.dato.monto:0:2);
		l := l^.sig;
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if ( a<>nil ) then
	begin
		imprimirArbol(a^.hi);
		writeln (' * * *  Codigo de cliente: ',a^.dato.cliente,'  * * *');
		imprimirLista(a^.dato.l);
		writeln();
		imprimirArbol(a^.hd);
	end;
end;

procedure buscarCliente(a:arbol ; cod:integer ; var l:lista);
begin
	if (a<> nil) then
		if (a^.dato.cliente = cod ) then l := a^.dato.l
		else
			if (a^.dato.cliente > cod ) then
				buscarCliente(a^.hi,cod,l)
			else
				buscarCliente(a^.hd,cod,l);
end;

function MayorCantidad ( l:lista ):real;
var
	aux:real;
	max:integer;
begin
	max := -1;
	while (l<> nil) do
	begin
		if (l^.dato.cantp > max) then
		begin
			max := l^.dato.cantp;
			aux := l^.dato.monto;
		end;
		l := l^.sig;
	end;
	mayorCantidad := aux;
end;



VAR
 a:arbol;
 l:lista;
 cliB:integer;
BEGIN
	randomize;
	a:= nil;
	l := nil;
	cargarArbol (a);
	writeln('---------------------------------------');
	imprimirArbol(a);
	writeln('---------------------------------------');
	writeln();
	writeln('Ingrese el numero de cliente a buscar');
	readln(cliB);
	buscarCliente(a,cliB,l);
	if (l<> nil) then
	begin
		writeln('La lista de compras del cliente es la siguiente: ');
		writeln();
		imprimirLista(l);
		writeln();
		writeln(' + + Su monto el dia que mas productos compro fue de: ',mayorCantidad(l):0:2);
	end
	else
		writeln('El cliente no se encuentra en la lista');
	
END.

