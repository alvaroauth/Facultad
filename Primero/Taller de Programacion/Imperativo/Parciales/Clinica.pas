{
Una clinica necesita un sistema para el procesamiento de las atenciones realizadas a los pacientes.

	a.Implementar un modulo que lea informacion de las atenciones. De cada atencion se lee DNI del paciente, numero de mes y codigo de diagnostico (1 a 15). La lectura finaliza con el mes 0. 
El modulo debe retornar dos estructuras de datos:
  i) Una estructura de datos eficiente para la busqueda por DNI de paciente. Para cada DNI debe almcenarse la cantidad total de atenciones recibidas
  ii) Otra estructura con la cantidad de atenciones realizadas para cada diagnostico
  
	b. Implementar un modulo que reciba la estructura generada en a.i), dos numeros de DNI y un valor entero x. Este modulo debe retornar la cantidad de pacientes 
con mas de x atenciones cuyos DNI estan entre los dos numeros de DNI recibidos

	c. Implementar un modulo recursivo que reciba la estructura generada en a.ii), y retorne la cantidad de
diagnosticos para los cuales la cantidad de atenciones fue 0
}
	
Program clinica;
const
	mes = 12;
	qdiag = 15;
type
	ranMes = 0..mes;
	ranDiag = 1..qdiag;

	atencion = record
		dni:integer;
		mes:ranMes;
		diagnostico:ranDiag;
		end;
		
	cliente = record
		dni:integer;
		cant:integer;
		end;
		
	arbol = ^nodo;
	
	nodo = record
		dato:cliente;
		hd:arbol;
		hi:arbol;
		end;
		
	vecDiag = array[ranDiag] of integer;
	
Procedure iniciarVector (var v:vecDiag);
var
	i:integer;
begin
	for i:= 1 to qDiag do v[i] := 0;
end;

procedure aleatorio (var at:atencion);
begin
	at.mes := random(13);
	if (at.mes <> 0) then 
	begin
		at.dni := random(11) + 1000;
		at.diagnostico := random (15) + 1;
	end;
end;

procedure agregarArbol (var a: arbol; at:atencion);
begin
	if (a = nil) then
	begin
		new(a);
		a^.hi := nil;
		a^.hd := nil;
		a^.dato.dni := at.dni;
		a^.dato.cant := 1;
	end
	else
	begin
		if (a^.dato.dni > at.dni) then agregarArbol (a^.hi,at)
		else if (a^.dato.dni < at.dni) then agregarArbol (a^.hd,at)
		else a^.dato.cant := a^.dato.cant + 1;
	end;
end;

Procedure cargarEstructuras (var a:arbol ; var v:vecDiag);
var
	at:atencion;
begin
	aleatorio (at);
	while at.mes <> 0 do
	begin
		agregarArbol(a, at);
		v[at.diagnostico] := v[at.diagnostico] + 1;
		writeln('DNI=', at.dni, ' MES=', at.mes, ' CODE=', at.diagnostico);
		aleatorio(at);
	end;
end;

function ranAtenciones (a:arbol ; inf,sup,ate:integer):integer;
begin
	if (a=nil) then ranAtenciones := 0
	else if (a^.dato.dni > inf) then 
		if (a^.dato.dni < sup) then 
			if (a^.dato.cant > ate) then ranAtenciones := 1 + ranAtenciones(a^.hi,inf,sup,ate) + ranAtenciones(a^.hd,inf,sup,ate)
		else ranAtenciones := ranAtenciones(a^.hi,inf,sup,ate)
	else ranAtenciones := ranAtenciones(a^.hd,inf,sup,ate);
end;

procedure imprimirVector ( v:vecDiag);
var
	i:integer;
begin
	for i:= 1 to qDiag do
	begin
		if (v[i] <> 0) then writeln('Codigo:  ', i ,'    Cantidad: ',v[i])
		else writeln ('Codigo:  ', i ,'   X No posee ninguna atencion');
	end;
end;
		

var
	a:arbol;
	diag:vecDiag;
	min,max,ate:integer;
begin
	randomize;
	a:= nil;
	iniciarVector(diag);
	cargarEstructuras(a,diag);
	writeln('---------------');
	imprimirVector(diag);
	writeln('---------------');
	writeln('Ingrese el DNI minimo a tomar en cuenta');
	Readln (min);
	writeln('Ingrese el DNI maximo a tomar en cuenta');
	Readln (max);
	writeln('Ingrese la cantidad minima de atenciones a tomar en cuenta');
	Readln (ate);
	writeln('---------------');
	writeln ('-----> Cantidad de atenciones en ese rango:  ',ranAtenciones(a,min,max,ate));
end.
	
