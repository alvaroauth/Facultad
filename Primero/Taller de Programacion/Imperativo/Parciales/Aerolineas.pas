{
Aerolineas Argentinas necesita procesar los pasajes vendidos durante 2023. De cada pasaje se conoce el codigo de vuelo, codigo de cliente, codigo de ciudad destino y monto del pasaje

	a) Implmentar un modulo que lea pasajes, genere y retorne una estructura adecuada para la busqueda por codigo de ciudad de destino, donde para cada 
codigo de ciudad destino se almacenan juntos todos los pasajes (codigo de vuelo, codigo de cliente y monto del pasaje. La lectura finaliza con monto de pasaje 0.

	b) Implementar un modulo que reciba la estructura generada en a) y un codigo de ciudad destino y retorne todos los pasajes hacia esa ciudad destino
	
	c) Realizar un modulo que reciba la estructura generada en a) y retorne el codigo de ciudad de destino con mayor cantidad de pasajes vendidos 
}


program Aerolineas;
const
	corte = 0;

type
	pasaje = record
		vuelo:integer;
		cliente:integer;
		destino:integer;
		monto:real;
		end;
		
	Destinos = record
		vuelo:integer;
		cliente:integer;
		monto:real;
		end;
		
	lista = ^nodoL;
	
	nodoL = record
		dato:destinos;
		sig:lista;
		end;
		
	registroA = record
		destino:integer;
		l:lista;
		end;
		
	arbol = ^nodoA;
	
	nodoA = record
		dato:registroA;
		hi:arbol;
		hd:arbol;
		end;
		
procedure aleatorio (var p:pasaje);
begin
	p.monto := random(30);
	if (p.monto <> corte) then
	begin
		p.destino  :=random(5);
		p.cliente  :=random(50);
		p.vuelo  :=random(51);
	end;
end;

Procedure cargarRegistro (var d:destinos ; p:pasaje);
begin
	d.monto := p.monto;
	d.vuelo :=p.vuelo;
	d.cliente := p.cliente;
end;

procedure agregarAdelante (var l:lista ; p:pasaje);
var
	nue:lista;
	d:destinos;
begin
	new(nue);
	cargarRegistro (d, p);
	nue^.dato := d;
	nue^.sig := l;
	l := nue;
end;

procedure agregarArbol (var a:arbol ; p:pasaje);
begin
	if (a=nil) then
	begin
		new(a);
		a^.hi := nil;
		a^.hd := nil;
		a^.dato.l := nil;
		a^.dato.destino := p.destino;
		agregarAdelante (a^.dato.l, p);
	end
	else
		if (a^.dato.destino = p.destino) then agregarAdelante(a^.dato.l ,p)
		else
			if(a^.dato.destino > p.destino) then agregarArbol(a^.hi,p)
			else agregarArbol(a^.hd,p);
end;

procedure cargarArbol (var a:arbol);
var
	p:pasaje;
begin
	aleatorio (p);
	while (p.monto <> corte) do
	begin
		agregarArbol(a,p);
		aleatorio(p);
	end;
end;

procedure imprimirLista (l:lista);
begin
	while (l <> nil) do
	begin
		writeln (' --> Codigo de vuelo: ', l^.dato.vuelo,'    --> Codigo de cliente: ',l^.dato.cliente,'    --> Monto del pasaje: ',l^.dato.monto:0:2);
		l := l^.sig;
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then
	begin
		imprimirArbol(a^.hi);
		writeln(' * CODIGO DE VUELO : ',a^.dato.destino,' * ');
		imprimirLista(a^.dato.l);
		imprimirArbol(a^.hd);
	end;
end;

procedure imprimirDestino (a:arbol ; cod:integer);
begin
	if (a <> nil) then
	begin
		if (a^.dato.destino = cod) then 
		begin
			writeln(' * CODIGO DE VUELO : ',a^.dato.destino,' * ');
			imprimirLista(a^.dato.l);
		end
		else
			if (a^.dato.destino > cod) then imprimirDestino (a^.hi,cod)
			else imprimirDestino (a^.hd,cod);
	end;
end;

function recorrerPasajes (l:lista ):integer;
var
	cont :integer;
begin
	cont := 0;
	while (l <> nil) do
	begin
		cont := cont + 1;
		l := l^.sig;
	end;
	recorrerPasajes := cont;
end;

procedure mayorPasajes (a:arbol ; var max, maxcod:integer);
begin
	if (a <> nil) then
	begin
		mayorPasajes (a^.hi, max, maxcod);
		if (recorrerPasajes(a^.dato.l) > max) then
		begin
			max := (recorrerPasajes(a^.dato.l));
			maxcod := a^.dato.destino;
		end;
		mayorPasajes (a^.hd, max, maxcod);
	end;
end;
	
		

VAR
	a:arbol;
	cod,maxcod,max:integer;
BEGIN
	randomize;
	a := nil;
	max := -1;
	cargarArbol(a);
	imprimirArbol(a);
	writeln('---------------------------------');
	readln (cod);
	imprimirDestino(a,cod);
	writeln('---------------------------------');
	mayorPasajes (a,max,maxcod);
	writeln(' + + + El codigo de destino con mas pasajes fue: ',maxcod);
END.

