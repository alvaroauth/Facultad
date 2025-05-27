Program dos;
Type
	vectorE = array [1..50] of integer;
Procedure cargarVector (var v:vectorE; var dimL2:integer ; a, b:integer);
var
	rango: integer;
	num:integer;
	dimF:integer;
begin
	DimF:=50;
	randomize();
	rango:= b - a + 1;
	num := a + random(rango);
	While (dimL2 <= dimF) and (num <> 0) do
	begin
		v[dimL2] := num;
		num := a + random(rango);
		dimL2:= dimL2 + 1;
	end;
end;

Procedure imprimirVector(v:vectorE;dimL:integer);
var
	i:integer;
begin
	for i := 1 to dimL do
		writeln (v[i]);
end;

Procedure imprimirVectorAlReves(v:vectorE;dimL:integer);
var
	i:integer;
begin
	for i := dimL downto 1 do
		writeln (v[i]);
end;

var
	vector: vectorE;
	dimL, a, b:integer;
begin
	dimL:=1;
	writeln('Ingrese el valor minimo');
	Readln(a);
	writeln('Ingrese el valor maximo');
	Readln(b);
	cargarVector(vector, dimL, a, b);
	imprimirVector(vector, dimL);
end.
