{
El hipermercado Carrefour necesita un sistema para obtener estadisticas sobre las compras realizadas por sus clientes

	a) Implementar un modulo que lea todas las compras de 2023, los almacene y retorne una estructura de datos eficiente para la busqueda por codigo de cliente donde 
para cada codigo de cliente se almacenen juntas todas sus compras. De cada compra se conoce: codigo de cliente, numero de factura, cantidad de productos y monto. 
La lectura finaliza con el codigo de cliente 0.
	
	b) Implementar un modulo que reciba la estructura generada en a), un codigo de cliente y retorne la cantidad de compras y el monto total gastado por dicho cliente durante el 2023
	
	c) Realizar un modulo que reciba la estructura generada en a) y dos numeros de factura x e y, y retorne todas las ventas cuyo numero de factura estan entre x e y (incluidos)
}


program carrefour;
const
	corte = 0;
type
	compra = record
		cliente:integer;
		factura:integer;
		cantp:integer;
		monto:real;
		end;
	
	cliente = record
		factura:integer;
		cantp:integer;
		monto:real;
		end;
	
	lista = ^nodoL;
	
	nodoL = record
		dato:cliente;
		sig:lista;
		end;
		
	registroC = record
		cliente:integer;
		l:lista;
		end;
		
	arbol = ^nodoA;
	
	nodoA = record
		dato:registroC;
		hi:arbol;
		hd:arbol;
		end;
		
procedure aleatorio( var cpa:compra);
begin
	cpa.cliente := random(11);
	if (cpa.cliente <> corte) then
	begin
		cpa.factura :=random(11);
		cpa.cantp :=random(11);
		cpa.monto :=random(11);
	end;
end;

procedure cargarRegistro ( var cli:cliente ; com:compra);
begin
	cli.factura := com.factura;
    cli.cantp   := com.cantp;
	cli.monto   := com.monto;
end;

procedure agregarAdelante (var l:lista ; com:compra);
var
	cli:cliente;
	nue:lista;
begin
	new(nue);
	cargarRegistro(cli,com);
	nue^.dato := cli;
	nue^.sig := l;
	l := nue;
end;

procedure agregarArbol(var a:arbol ; com:compra );
begin
	if (a=nil) then
	begin
		new(a);
		a^.hi := nil;
		a^.hd := nil;
		a^.dato.l := nil;
		a^.dato.cliente := com.cliente;
		agregarAdelante (a^.dato.l,com);
	end
	else
		if (a^.dato.cliente = com.cliente) then agregarAdelante (a^.dato.l,com)
		else
			if(a^.dato.cliente > com.cliente) then agregarArbol(a^.hi,com)
			else agregarArbol(a^.hd,com);
end;

procedure cargarArbol (var a:arbol);
var
	c:compra;
begin
	aleatorio(c);
	while(c.cliente <> corte) do
	begin
		agregarArbol(a,c);
		aleatorio(c);
	end;
end;

procedure imprimirLista (l:lista);
begin
	while (l <> nil) do
	begin
		writeln ('                * Nro de Factura: ',l^.dato.factura,'   * Cantidad de prodcutos: ',l^.dato.cantp, '   * Monto gastado: ',l^.dato.monto:0:2);
		l := l^.sig;
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then
	begin
		imprimirArbol (a^.hi);
		writeln(' * * * Codigo de cliente: ',a^.dato.cliente ,'  * * * ');
		imprimirLista(a^.dato.l);
		imprimirArbol (a^.hd);
	end;
end;

procedure sumarLista (l:lista ; var produ:integer ; var monto: real);
begin
	while (l <> nil) do
	begin
		produ := produ + 1;
		monto := monto + l^.dato.monto;
		l := l^.sig;
	end;
end;


procedure buscarCliente(a:arbol ; cli:integer ; var produ:integer ; var monto: real);
begin
	if (a <> nil) then 
		if (a^.dato.cliente = cli) then sumarLista (a^.dato.l,produ,monto)
		else
			if (a^.dato.cliente > cli) then buscarCliente(a^.hi,cli,produ,monto)
			else buscarCliente(a^.hd,cli,produ,monto);
end;

procedure recorrerLista ( l:lista ; inf,sup:Integer; var l2:lista);
var
	aux:compra;
begin
	while (l <> nil) do
	begin
		if ((l^.dato.factura >= inf)and(l^.dato.factura <= sup)) then
		begin
			aux.factura := l^.dato.factura;
			aux.cantp	:= l^.dato.cantp;
            aux.monto   := l^.dato.monto;            
			agregaradelante(l2, aux);
		end;
		l := l^.sig;
	end;
end;

procedure recorrerArbol(a:arbol ; inf,sup:integer; var l2:lista);
begin
	if (a <> nil) then
	begin
		recorrerArbol(a^.hi,inf,sup,l2);
		recorrerLista(a^.dato.l,inf,sup,l2);
		recorrerArbol(a^.hd,inf,sup,l2);
	end;
end;


VAR	 
	a:arbol;
	produ,cli,inf,sup:integer;
	monto:real;
	lis:lista;
BEGIN
	randomize;
	a := nil;
	lis := nil;
	monto:= 0;
	cant:= 0;
	cargarArbol(a);
	imprimirArbol(a);
	writeln('------------------------');
	writeln('Ingrese el cliente a buscar');
	readln(cli);
	buscarCliente(a,cli,produ,monto);
	if (monto <> 0) and (produ <> 0) then
	begin
		writeln (' - Cliente: ', cli ,' -');
		writeln ('Compras totales : ', produ, '        Monto total gastado: ', monto:0:2);
	end
	else writeln('El cliente no se encuentra en la lista');
	writeln('------------------------');
	writeln('Ingrese el codigo minimo de factura a buscar');
	readln(inf);
	writeln('Ingrese el codigo maximo de factura a buscar');
	readln(sup);
	recorrerArbol(a,inf,sup,lis);
	writeln('Lista de las facturas en ese rango: ');
	imprimirLista(lis);
END.

