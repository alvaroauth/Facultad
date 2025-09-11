program p1e2;
type
	arch_integer = file of integer;
var
	arch_int:arch_integer;
	num:integer;
BEGIN
	assign(arch_int,'practica1ej1.dat');
	reset(arch_int);
	while(not EOF(arch_int)) do
	begin
		read(arch_int,num);
		writeln(num);
	end;
	Writeln('Finalizo la lectura de elementos');
	close(arch_int);
END.

