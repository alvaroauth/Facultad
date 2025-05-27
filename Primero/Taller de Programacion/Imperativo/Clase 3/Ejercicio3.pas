{
Implementar un programa que contenga: 
	a. Un módulo que lea información de los finales rendidos por los alumnos de la Facultad de Informática y los almacene en una estructura de datos.
La información que se lee es legajo, código de materia, fecha y nota. La lectura de los alumnos finaliza con legajo 0. La estructura generada debe ser eficiente para la búsqueda por número de legajo y para cada
alumno deben guardarse los finales que rindió en una lista.
	b. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con legajo impar. 
	c. Un módulo que reciba la estructura generada en a. e informe, para cada alumno, su legajo y su cantidad de finales aprobados (nota mayor o igual a 4). 
	d. Un módulo que reciba la estructura generada en a. y un valor real. Este módulo debe retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado. 
}

program untitled;
const
	corte = 3;
	dias = 31;
	nota = 10;
type
	ranfecha = 1..dias;
	rannota = 1..nota;
	
	finales = record
		codigo:integer;
		fecha:ranfecha;
		nota:rannota;
	end;
	
	lista = ^nodoL;
	
	nodoL = record
		dato:finales;
		sig:lista;
	end;
	
	alumnos = record
		legajo:integer;
		f:lista;
	end;
	
	arbol = ^nodoA;
	
	nodoA = record
		dato:alumnos;
		hi:arbol;
		hd:arbol;
	end;

	
procedure randomm (var leg:integer; var f:finales);
begin
	leg     :=     random(11);
	f.codigo:=     random(11);
	f.nota  := 1 + random(10);
	f.fecha := 1 + random(31);
end;
	
Procedure agregarAdelante (var l:lista ; f:finales);
var
	nue:lista;
begin
	new(nue);
	nue^.dato:=f;
	nue^.sig:=l;
	l:=nue;
end;

procedure agregarArbol (var a:arbol; leg:integer ;x:finales);
begin
	if (a = nil) then
	begin
		new(a);
		a^.dato.f := nil;
		a^.hi := nil;
		a^.hd := nil;
		a^.dato.legajo := leg;
		agregarAdelante(a^.dato.f, x);
	end
	else
	begin
		if (leg < a^.dato.legajo) then
		BEGIN
			agregarArbol(a^.hi,leg,x);
		END
		else if (leg > a^.dato.legajo) then
		BEGIN
			agregarArbol(a^.hd,leg,x);
		END
		else
		BEGIN
			agregarAdelante(a^.dato.f, x);
		END;
	end;
end;
procedure cargarArbol (var a:arbol);
var
	f:finales;
	leg:integer;
begin
	randomize();
	randomm (leg, f);
	while (leg <> corte) do	
	begin
		agregarArbol(a,leg,f);
		randomm(leg, f);
	end;
end;


procedure legajoImpar (a:arbol ; var cont:integer);
var
	aux:integer;
begin
	if (a<>nil) then
	begin
		legajoImpar(a^.hi, cont);
		aux := a^.dato.legajo mod 2;
		if (aux<>0) then cont := cont + 1;
		legajoImpar(a^.hd, cont);
	end;
end;


function contarEnLista(l:lista):integer;
begin
	if(l<>nil)then
	begin
		if(l^.dato.nota >= 4)then contarEnLista:= 1 + contarEnLista(l^.sig)
		else contarEnLista:= contarEnLista(l^.sig);
	end
	else contarEnLista:= 0;
end;


procedure imprimirLista (l:lista);
begin
	if (l <> nil) then
	begin
	writeln ('   Materia: ', l^.dato.codigo,'   Fecha: ',l^.dato.codigo,'   Nota: ', l^.dato.nota);
	imprimirLista (l^.sig);
	end;
end;
procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then
	begin
		imprimirArbol(a^.hi);
		writeln ('----> Legajo: ' , a^.dato.legajo);
		Writeln ('Lista de finales: ');
		imprimirLista (a^.dato.f);
		imprimirArbol(a^.hd);
	end;
end;
procedure imprimirNotas (a:arbol);
begin
	if (a <> nil) then
	begin
		imprimirNotas(a^.hi);
		writeln('---> Legajo : ', a^.dato.legajo,'    Finales aprobados: ', contarEnLista(a^.dato.f));
		imprimirNotas(a^.hd);
	end;
end;


function promedios (l:lista):real;
var
	cont,acum:integer;
begin
	acum := 0;
	cont := 0;
	while (l <> nil) do
	begin
		acum := acum + 1;
		cont := cont + l^.dato.nota;
		l := l^.sig;
	end;
	promedios := (cont / acum);
end;
procedure notaMayor (a:arbol; pro:real);
begin
	if (a <> nil) then
	begin
		notaMayor(a^.hi,pro);
		if ( promedios(a^.dato.f) > pro) then writeln ('»»»» Legajo: ', a^.dato.legajo,'   Promedio: ', promedios(a^.dato.f):0:2);
		notaMayor(a^.hd,pro);
	end;
end;


VAR
	a:arbol;
	cont:integer;
	promedio:real;
BEGIN
	a := nil;
	cont := 0;
	cargarArbol(a);
	imprimirArbol(a);
	legajoImpar (a, cont);
	writeln('------------------------');
	writeln (cont);
	writeln('------------------------');
	imprimirNotas(a);
	writeln('------------------------');
	writeln('Ingrese el promedio a ser superado');
	readln(promedio);
	notaMayor(a,promedio);
END.

