Program Ejercicio3;
const
	corte=120;
	a=100;
	b=150;
type
	lista=^nodo;
	nodo=record
		dato: integer;
		sig: lista;
		end;

Procedure agregarAdelante (var l:lista ; val:integer);
var
	nue:lista;
begin
	new(nue);
	nue^.dato:=val;
	nue^.sig:=l;
	l:=nue;
end;

Procedure cargarLista (var l:lista);
var
	num, rango:integer;
begin
randomize();
rango:= b - a + 1;
num:= a + random(rango);
while num<>corte do begin
	agregarNodo (l,num);
	num:= a + random(rango);
	end;
end;

Procedure imprimirLista (l:lista);
begin
	while l <> nil do begin
		writeln (l^.dato);
		l:=l^.sig;
	end;
end;
function BusquedaDesordenada (l:lista ; num:integer):boolean;
var
	ok:boolean;
begin
	ok:=false;
	while (l <> nil) and (ok=false) do
	begin
		if (l^.dato=num) then ok := true
		else l:=l^.sig;
	end;
	busquedadesordenada:=ok;
end;
var
	lis:lista;
	num:integer;
begin
	lis:=nil;
	cargarLista(lis);
	imprimirLista(lis);
	writeln ('Ingrese el numero a buscar');
	readln(num);
	if (Busquedadesordenada(lis,num)) then writeln('El numero se encuentra en la lista')
	else writeln('El numero NO se encuentra en la lista');
end.
 
	



