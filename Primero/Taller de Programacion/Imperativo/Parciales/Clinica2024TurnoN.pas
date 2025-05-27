{
Una clinica necesita implementar un sistema para el procesamiento de las atenciones realizadas a los pacientes durante el año 2023

	a) Implementar un modulo que lea la informacion de las atenciones y retorne un vector donde se almacenan las atenciones agrupadas por mes. 
Las atenciones de cada mes deben quedar almacenadas en un arbol binario de busqueda ordenado por DNI del paciente y solo deben almacenarse dni, mes y diagnostico. 
De cada atencion se lee matricula del medico, dni del paciente, mes y diagnostico (valor entre L y P). La lectura finaliza con la matricula 0
	
	b) c) Implementar un modulo recursivo que reciba el vector generado en a) y retorne el mes con mayor cantidad de atenciones
	
	c) Implementar un modulo que reciba el vector generado en a) y un DNI de paciente, y retorne si fue atendido o no, el paciente con el dni ingresado
	
}



program untitled;
Const
	corte = 0;
	meses = 12;
Type
	ranDiagnostico = 'L'..'P';
	ranMeses = 1..meses;
	
	atencion = record
		matricula:integer;
		dni:integer;
		mes:ranMeses;
		diag:ranDiagnostico;
		end;
		
	atencionA = record
		dni:integer;
		diag:ranDiagnostico;
		end;
		
	arbol=^nodo;
	
	nodo = record
		dato:atencionA;
		hi:arbol;
		hd:arbol;
		end;
		
	vMeses = array[ranMeses] of arbol;
	
procedure aleatorio ( var a:atencion);
var
	v : array[1..5] of char =('L','M','N','O','P');
begin
	a.matricula := random(16);
	if (a.matricula <> corte) then
	begin
		a.dni := random(21);
		a.mes := 1 +random(12);
		a.diag := v[random(6)+1];
	end;
end;

procedure iniciarVector ( var v:vMeses);
var
	i:ranMeses;
begin
	for i:= 1 to meses do
		v[i] := nil;
end;

procedure agregarArbol ( var a:arbol ; at:atencion );
begin
	if(a=nil) then
	begin
		new(a);
		a^.hi := nil;
		a^.hd := nil;
		a^.dato.dni := at.dni;
		a^.dato.diag := at.diag;
	end
	else
		if(a^.dato.dni > at.dni) then
			agregarArbol(a^.hi,at)
		else
			agregarArbol(a^.hd,at);
end;

procedure cargarVector( var v:vMeses);
var
	a:atencion;
begin
	aleatorio (a);
	while ( a.matricula <> corte ) do
	begin
		agregarArbol(v[a.mes],a);
		aleatorio(a);
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a<>nil) then
	begin
		imprimirArbol(a^.hi);
		writeln('                   ---> DNI: ',a^.dato.dni,'                   / / / Diagnostico: ',a^.dato.diag);
		imprimirArbol(a^.hd);
	end;
end;

function sumarArbol (a:arbol):integer;
begin
	if (a=nil) then sumarArbol := 0
	else
		sumarArbol := 1 + sumarArbol(a^.hi) + sumarArbol(a^.hd);
end;


procedure recorrerVector (v:vMeses ; var dimL,max:integer ; var  maxM:ranMeses);
begin
	
	if ( dimL >= 1) then
	begin
		if ( sumarArbol(v[dimL]) > max) then
		begin
			max := sumarArbol(v[dimL]);
			maxM := dimL;
		end;
		dimL := dimL-1;
		recorrerVector(v,dimL,max,maxM);
	end;
end;
			
procedure imprimirVector (v:vMeses);
var
	i:ranMeses;
begin
	for i := 1 to meses do
	begin
		writeln(' * MES: ',i,' *');
		writeln();
		imprimirArbol(v[i]);
	end;
end;
		
procedure encontrarArbol( a:arbol ; d:integer; var ok:boolean);
begin
	if( a <> nil ) then
	begin
		if (a^.dato.dni = d) then
			ok:=true
		else
			if (a^.dato.dni > d ) then
				encontrarArbol(a^.hi,d,ok)
			else 
				encontrarArbol(a^.hi,d,ok);
	end;
end;

function encontrarVector (v:vMeses ; d:integer):boolean;
var
	i:ranMeses;
	ok:boolean;
begin
	ok:=false;
	for i := 1 to meses do
	begin
		if (ok = false) then
			encontrarArbol (v[i], d, ok);
	end;
	encontrarVector := ok;
end;




VAR
	vm:vMeses;
	max, d,dimL:integer;
	maxM :ranMeses;
BEGIN
	randomize;
	max := -1;
	dimL := meses;
	iniciarVector(vm);
	cargarVector(vm);	
	imprimirVector(vm);
	recorrerVector(vm,dimL,max,maxM);
	writeln();
	writeln(maxM);
	writeln('Ingrese un dni a buscar ');
	writeln();
	Readln(d);
	if (encontrarVector (vm,d)) then
		writeln('El elemento esta en la base de datos')
	else
		writeln('El elemento NO esta en la base de datos');
END.

