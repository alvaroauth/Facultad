{
Una clinica necesita un sistema para el procesamiento de las ateneciones realizadas a los pacientes en julio de 2024

	a) Implementar un modulo que lea informacion de las atenciones. De cada atencion se lee: matricula del medico, dni del paciente dia y diagnostico(entre A y F).
La lectura finaliza con el dni 0. El modulo debe retornar dos estructuras
		i. Una arbol binario de busqueda ordenado por matricula de medico. Para cada matricula debe almcaenarse la cantidad de atenciones realizadas
		ii. Un vector que almacene en cada posicion el tipo de genero y la lista de los dni de pacientes atenidos con ese diagnostico
	
	b) Implementar un modulo que reciba el arbol generado en a) ,una matricula y retonre la cantidad total de atenciones realizadas por los medicos con matricula superior a la matricula ingresada 
	
	c) Realizar un modulo recursivo que reciba al vector generado en a) y retorne el diagnostico con mayor cantidad de pacientes atendidos
	
}


program Clinica2024;
const
	corte = 0;
	dias=31;
type
	ranDias = 1..dias;
	
	atencion = record
		matricula:integer;
		dni:integer;
		dia:ranDias;
		diag:char;
		end;
		
	atencionV = record 
		matricula:integer;
		dni:integer;
		dia:ranDias;
		end;
	
	lista = ^nodoL;
	
	nodoL = record
		dato:atencionV;
		sig:lista;
		end;
		
	vDiag = array['A'..'F'] of lista;
	
	atencionA = record
		matricula:integer;
		cant:integer;
		end;
		
	arbol = ^nodoA;
	
	nodoA = record
		dato:atencionA;
		hi:arbol;
		hd:arbol;
		end;
		
procedure iniciarVector(var v:vDiag);
var
	i:char;
begin
	for i := 'A' to 'F' do
		v[i] := nil;
end;

procedure cargarRegistroV(var atv:atencionV ; a:atencion);
begin
	atv.dia:=a.dia;
	atv.matricula := a.matricula;
	atv.dni := a.dni;
end;

procedure agregarAdelante (var l:lista ; a:atencion);
var
	nue:lista;
	atv:atencionV;
begin
	new(nue);
	cargarRegistroV(atv,a);
	nue^.dato := atv;
	nue^.sig := l;
	l := nue;
end;

procedure aleatorio ( var a: atencion);
var
	v : array[1..6] of char = ('A','B','C','D','E','F');
begin
	a.dni := random (16);
	if (a.dni <> corte) then
	begin
		a.matricula := random (16);
		a.dia := 1+random(31);
		a.diag := v[random(6)+1];
	end;
end;


procedure agregarArbol (var a:arbol ; at:atencion);
begin
	if(a=nil) then
	begin
		new(a);
		a^.hi := nil;
		a^.hi := nil;
		a^.dato.matricula := at.matricula;
		a^.dato.cant := 1;
	end
	else
		if (a^.dato.matricula = at.matricula) then
			a^.dato.cant := a^.dato.cant + 1
		else
			if (a^.dato.matricula > at.matricula) then
				agregarArbol(a^.hi , at)
			else
				agregarArbol(a^.hd,at);
end;

procedure cargarEstructuras (var a:arbol ; var vd:vDiag);
var
	at:atencion;
begin
	aleatorio(at);
	while (at.dni <> 0) do
	begin
		agregarArbol(a,at);
		agregarAdelante(vd[at.diag], at);
		aleatorio(at);
	end;
end;

procedure imprimirLista(l:lista);
begin
	while (l<> nil) do
	begin
		writeln('           *Matricula: ',l^.dato.matricula,'           *Dni: ',l^.dato.dni,'           *Dia: ',l^.dato.dni);
		l :=  l^.sig;
	end;
end;

procedure imprimirVector (v:vDiag);
var
	i:char;
begin
	for i := 'A' to 'F' do
	begin
		writeln (' ------ Diagnostico: ',i,' ------ ');
		writeln();
		imprimirLista(v[i]);
		writeln();
	end;
end;

procedure imprimirArbol (a: arbol);
begin
	if(a<>nil) then
	begin
		imprimirArbol(a^.hi);
		writeln(' / / / Medico: ',a^.dato.matricula,'           / / / Cantidad de atenciones: ',a^.dato.cant);
		imprimirArbol(a^.hd);
	end;
end;

function cantMatricula (a:arbol ;mat:integer):integer;
begin
	if (a=nil) then cantMatricula := 0
	else
		if(a^.dato.matricula > mat) then
			cantMatricula := a^.dato.cant + cantMatricula(a^.hi ,mat) + cantMatricula(a^.hd , mat)
		else
			cantMatricula := cantMatricula(a^.hd, mat);
end;

function recorrerlista (l:lista ):integer;
var
	aux:integer;
begin
	aux:= 0;
	while (l <> nil) do
	begin
		aux := aux + 1;
		l := l^.sig;
	end;
	recorrerlista := aux;
end;


procedure maximoVector (v:vDiag ; var DimL:char; var max:integer; var maxD:char);
begin
	if (dimL <= 'F') then
	begin
		if (recorrerlista(v[dimL])> max) then
		begin
			max:= recorrerlista(v[DimL]);
			maxD:=dimL;
		end;
		dimL := succ(dimL);
		maximoVector(v, dimL, max,maxD);
	end;
end;
		
		
		



VAR
	a:arbol;
	vd:vDiag;
	mat,max:integer;
	DimL:char;
	maxD:char;
BEGIN
	randomize;
	a:= nil;
	max := -1;
	DimL:='A';
	iniciarVector(vd);
	cargarEstructuras(a,vd);
	imprimirVector(vd);
	writeln('----------------------');
	imprimirArbol(a);
	writeln('----------------------');
	writeln();
	writeln('Ingrese el numero a superar por las matriculas');
	readln(mat);
	writeln('La cantidad de diagnsoticos en ese rango es de: ',cantMatricula(a,mat));
	maximoVector(vd,dimL,max,maxD);
	writeln();
	writeln(maxD)
END.

