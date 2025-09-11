program p1e1;
const
	corte = 30000;
type
	arch_integer = file of integer;
	
function toString(num:integer):string;
begin
	toString:=(num+'Hola');
end;

var
	arch_int:arch_integer;
	num:integer;
begin
	assign(arch_int,'practica1ej1.dat');
	rewrite(arch_int);
	Writeln('Ingrese un numero');
	readln(num);
	writeln(toString(num));
	while (num <> corte) do
	begin
		write(arch_int,num);
		Writeln('Ingrese un numero');
		readln(num);
	end;
	Writeln('Finalizo la carga de elementos');
	close(arch_int);
end.
	
