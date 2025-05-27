{
3.- Implementar un programa que invoque a los siguientes módulos. 
a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 300 y menores a 1550 (incluidos ambos).
b. Un módulo que reciba el vector generado en a) y lo retorne ordenado. (Utilizar lo realizado en la práctica anterior) 
c. Un módulo que realice una búsqueda dicotómica en el vector, utilizando el siguiente encabezado: Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
Nota: El parámetro “pos” debe retornar la posición del dato o-1 si el dato no se encuentra en el vector.
}


program untitled;
const
	a=300;
	b=1550;
	dimF = 20;
type
	ranv = 1..dimF;
	vector = array [ranv] of integer;

procedure cargarVector (var v:vector; var pos:integer);
var
	num, rango:integer;
begin
	rango := b-a+1;
	num := a+ random(rango);
	if pos <= DimF then 
	begin
		v[pos] := num;
		pos:=pos +1;
		cargarVector(v, pos);
	end;
end;

procedure imprimirVector (v:vector);
var
	i:Integer;
begin
	for i := 1 to dimF do writeln(v[i]);
end;

Procedure seleccion ( var v: vector);
var
	i, j, pos: ranv;
	item : integer;			
begin
	for i:=1 to dimF do 
	begin
		pos := i;
		for j := i to DimF do
			if v[j] < v[pos] then
				pos:=j;
		item := v[pos];   
		v[pos]:= v[i];   
		v[i]:= item;
	end;
end;


VAR	 
	pos:integer;
	vec:vector;
BEGIN
	pos:=1;
	cargarVector (vec, pos);
	imprimirVector(vec);
	writeln('----------------------------');
	seleccion(vec);
	imprimirVector(vec);
END.

