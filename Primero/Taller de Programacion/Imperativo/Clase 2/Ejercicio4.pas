{
4.- Realizar un programa que lea números y que utilice un módulo recursivo que escriba el
equivalente en binario de un número decimal. El programa termina cuando el usuario ingresa
el número 0 (cero). 
}


program untitled;

{procedure binario(var bin:integer ; num:integer);
begin
	if num <> 0 then
	begin
		num := num div 2;
		binario(bin,num);
		if ((num mod 2) = 1) then bin := bin + 1 ;
		if (num <> 0) then bin := bin*10;
	end;
end;
}

procedure binario2 (num:integer);
begin
	if num > 0 then
	begin
		binario2(num div 2);
		num := num mod 2;
		write(num);
	end;
end;
VAR	
	num: integer;
BEGIN
	readln(num);
	Binario2(num);
END.

