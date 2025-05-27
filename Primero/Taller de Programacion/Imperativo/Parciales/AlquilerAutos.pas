{
Una empresa de alquiler de autos desea procesar la informacion de sus alquileres. Implementar un programa que
 
	a) Implementar un modulo que lea informacion de los alquileres y retorne una estructura de datos eficiente para la busqueda por patente.
Para cada patente deben quedar almacenados juntos todos sus alquileres. 
De cada alquiler se lee dni del cliente, patente, mes y año. La lectura finaliza con la patente 0
	
	b) Implementar un modulo que reciba la estructura generada en a) y un dni. Este modulo debe retornar la cantidad de alquileres realizados por el dni D.
	
	c) Implementar un programa quer eciba la estructura generada en a), un año x y dos patentes. Este modulo debe retornar la 
cantidad de alquileres realizados por las patentes entre A y B (incluidas) durante el año x
}


program AlquilerAutos;
const
	qmes = 12;
	qanio1 = 2000;
	qanio2 = 2024;
	corte = 0;
type
	ranAnios = qanio1 .. qanio2;
	ranMeses = 1..qmes;
	
	alquiler = record
		dni:integer;
		patente:integer;
		mes:ranMeses;
		anio:ranAnios;
		end;
	
	patente = record
		dni:integer;
		mes:ranMeses;
		anio:ranAnios;
		end;
		
	lista = ^nodoL;
	
	nodoL = record
		dato:patente;
		sig:lista;
		end;
		
	recordA = record
		patente:integer;
		l:lista;
		end;
		
	arbol = ^nodoA;
	
	nodoA = record
		dato:recordA;
		hi:arbol;
		hd:arbol;
		end;
		
procedure aleatorio ( var a:alquiler);
begin
	a.patente := random(16);
	if (a.patente <> corte) then
	begin
		a.anio := (random(qanio2-qanio1 +1))+qanio1;
		a.mes := random(12) + 1;
		a.dni:=random(26);
	end;
end;

procedure cargarRegistro(var p:patente ; a:alquiler);
begin
	p.mes := a.mes;
	p.anio := a.anio;
	p.dni := a.dni;
end;

procedure agregarAdelante ( var l:lista ; a:alquiler);
var
	nue:lista;
	p:patente;
begin
	new(nue);
	cargarRegistro(p,a);
	nue^.dato := p;
	nue^.sig:= l;
	l := nue;
end;

procedure agregarArbol(var a:arbol ; al:alquiler);
begin
	if (a = nil) then
	begin
		new(a);
		a^.hi := nil;
		a^.hd := nil;
		a^.dato.l := nil;
		a^.dato.patente := al.patente;
		agregarAdelante(a^.dato.l , al);
	end
	else
		if( a^.dato.patente = al.patente) then 
			agregarAdelante(a^.dato.l , al)
		else
			if(a^.dato.patente > al.patente) then
				agregarArbol(a^.hi , al)
			else 
				agregarArbol(a^.hd , al);
end;

procedure cargarArbol(var a:arbol);
var
	al:alquiler;
begin
	aleatorio(al);
	while (al.patente <> corte ) do
	begin
		agregarArbol(a,al);
		aleatorio(al);
	end;
end;

procedure imprimirLista(l:lista);
begin
	if(l <> nil) then
	begin
		writeln ('    - - - > DNI del cliente: ', l^.dato.dni, '      -> Fecha: ',l^.dato.mes,' / ', l^.dato.anio);
		imprimirLista(l^.sig);
	end;
end;

procedure imprimirArbol ( a:arbol);
begin
	if (a<> nil) then
	begin
		imprimirArbol(a^.hi);
		writeln(' * - * PATENTE: ',a^.dato.patente, ' * - *');
		writeln();
		imprimirLista(a^.dato.l);
		writeln();
		imprimirArbol(a^.hd);
	end;
end;

function cantAlquileres ( l:Lista ; d:integer) : integer;
var
	aux:integer;
begin
	aux:=0;
	while (l <> nil) do 
	begin
		if (l^.dato.dni = d) then
			aux := aux + 1;
		l := l^.sig;
	end;
	cantAlquileres := aux;
end;

function cantAnioAux ( l:Lista ; an:RanAnios) : integer;
var
	aux:integer;
begin
	aux:=0;
	while (l <> nil) do 
	begin
		if (l^.dato.anio = an) then
			aux := aux + 1;
		l := l^.sig;
	end;
	cantAnioAux := aux;
end;


procedure recorrerArbol ( a:arbol ; d:integer ; var cant:integer);
begin
	if (a<> nil) then
	begin
		recorrerArbol(a^.hi , d , cant);
		cant := cant + cantAlquileres(a^.dato.l,d);
		recorrerArbol(a^.hd , d , cant);
	end;
end;

function cantAnio ( a:arbol ; inf,sup:integer ; an: ranAnios): Integer;
begin
	if (a = nil) then cantAnio := 0
	else
		if (a^.dato.patente >= inf) then
			if(a^.dato.patente <= sup) then
				cantAnio := cantAnioAux(a^.dato.l , an) + cantAnio(a^.hi,inf,sup,an)  + cantAnio(a^.hd,inf,sup,an)
			else
				cantAnio := cantAnio(a^.hi,inf,sup,an)
		else
			cantAnio := cantAnio(a^.hd,inf,sup,an);
end;
			

VAR
	a:arbol;
	d, cant,min,max :integer;
	anio:ranAnios;
BEGIN
	randomize;
	a:=nil;
	cant := 0;
	cargarArbol(a);
	imprimirArbol(a);
	writeln();
	writeln('Ingrese un numero de dni para buscar');
	writeln();
	Readln(d);
	recorrerArbol(a,d,cant);
	writeln();
	if (cant > 0) then writeln('El dni: ',d,' Realizo un total de: ',cant,' alquileres')
	else writeln('El numero de dni ingresado nunca realizo un alquiler');
	writeln();
	writeln('Ingrese el anio buscar');
	readln(anio);
	writeln('Ingrese el minimo de patente a buscar');
	readln(min);
	writeln('Ingrese el maximo de patente a buscar');
	readln(max);
	writeln('Rango de patenes: ',min, '  -  ',max,'        Anio: ',anio,'       Cantidad de alquileres: ',cantAnio(a,min,max,anio));
	
END.

