{2.- Escribir un programa que:
 a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
 “random” en el rango 100-200. Finalizar con el número 100.
 b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el
 mismo orden que están almacenados.
 c. Implemente un módulo recursivo que reciba la lista generada en a) e imprima los valores de
 la lista en orden inverso al que están almacenados.
 d. Implemente un módulo recursivo que reciba la lista generada en a) y devuelva el mínimo
 valor de la lista.
 e. Implemente un módulo recursivo que reciba la lista generada en a) y un valor y devuelva
 verdadero si dicho valor se encuentra en la lista o falso en caso contrario.}
 
 Program recursivo2;
 const
	corte = 15;
 
 type
	lista =^nodo;
	nodo = record
		dato:integer;
		sig:lista;
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

procedure cargarLista (var l:lista);
var
	num:integer;
begin
	num := 10+random(11);
	if num <> corte then
	begin 
		agregarAdelante(l,num);
		cargarLista(l);
	end;
end;
	
procedure imprimirLista (l:lista);
begin
	if (l <> nil) then
	begin
		writeln (l^.dato);
		imprimirLista (l^.sig);
	end;
end;

procedure imprimirAlReves (l:lista);
begin
	if (l <> nil) then
	begin
     	imprimirAlReves (l^.sig);
		writeln (l^.dato);
	end;
end;

procedure minimo (l:lista; var min:integer);
begin
	if (l<> nil) then
	begin
		if (l^.dato < min) then min := l^.dato;
		minimo (l^.sig,min);
	end;
end;

Function buscarElemento (l:lista;num:integer):Boolean;
begin
	if (l<>nil) then
	begin
		if l^.dato = num then
		begin
			buscarElemento:=true;
		end
		else
		begin
			buscarElemento:=buscarElemento(l^.sig,num);
		end
	end
	else
	begin
		buscarElemento := false
	end;
end;

 var
	l:lista;
	min, num:integer;
 begin
	randomize;
	l:=nil;
	min:=32767;
	cargarLista(L);
	imprimirLista(l);
	writeln ('-----------------------------------------------');
	imprimirAlReves(l);
	writeln ('-----------------------------------------------');
	minimo(l,min);
	writeln(min);
	writeln ('-----------------------------------------------');
	Readln (num);
	if (buscarElemento(l,num)) then writeln ('El elemento se encuentra en la lista')
	else writeln('El elemento NO se encuentra en la lista');
end.
