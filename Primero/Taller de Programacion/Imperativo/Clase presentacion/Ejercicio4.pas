program cuatro;
const
	min=100;
	max=150;
	corte=120;
type
	lista=^nodo;
	nodo=record
		dato:integer;
		sig:lista;
		end;
procedure agregarOrdenado (var l: lista; num:integer);
var
	ant, nue, act: lista;
begin
	new (nue);
	nue^.dato:= num;
	act:= l;
	ant:= l;
	while (act <> nil) and (act^.dato < num) do begin
		ant:= act;
		act:= act^.sig;
	end;
	if (ant = act) then
		l:= nue
	else
		ant^.sig:= nue;
	nue^.sig:= act;
end;
procedure cargarLista (var l:lista);
var
	num, rango:integer;
begin
	randomize;
	rango:= max - min + 1;
	num:= min + random(rango);
	while num <> corte do 
	begin
		insertar_ordenado(l,num);
		num:= min + random(rango);
	end;
end;
Procedure imprimirLista (l:lista);
begin
	while l <> nil do begin
		writeln (l^.dato);
		l:=l^.sig;
	end;
end;
function BusquedaOrdenada (l:lista ; num:integer):boolean;
var
	ok:boolean;
begin
	ok:=false;
	while (l <> nil) and (l^.dato < num) do begin
		l:=l^.sig;
	end;
	if (l <> nil) and (l^.dato=num) then ok:=true;
	busquedaordenada:=ok;
end;
var
	l:lista;
	num:integer;
begin
	l:=nil;
	cargarLista(l);
	imprimirLista(l);
	writeln ('Ingrese el numero a buscar');
	readln(num);
	if (BusquedaOrdenada(l,num)) then writeln('El numero se encuentra en la lista')
	else writeln('El numero NO se encuentra en la lista');
end.

			
