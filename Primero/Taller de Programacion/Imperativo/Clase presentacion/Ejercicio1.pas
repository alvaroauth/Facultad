Program uno;
var
	num, a, b, f, rango: integer;
Begin
	randomize();
	Writeln('Ingrese el valor minimo');
	Readln(a);
	Writeln('Ingrese el valor maximo');
	Readln(b);
	Writeln('Ingrese el numero de corte');
	Readln(f);
	if ((f <= b)and(f >= a)) then
	begin
		Rango:= (b - a + 1)+ a;
		num:= random(rango); 
		While f <> num do 
		begin
			writeln('El numero aleatorio es ' , num);
			num:=random(rango)+ a; 
		end;
	end
	else
	begin
		writeln ('El numero no se encuentra dentro del rango');
	end;
End.
 
