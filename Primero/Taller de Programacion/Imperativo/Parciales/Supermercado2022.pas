{
Se lee informacion de las compras realizadas por los clientes de un supermercado en el año 2022.
De cada compra se lee el codigo de cliente, numero de mes y monto gastado. La lectura finaliza cuando se lee un cliente con codigo 0
	
	a) Realizar un modulo que lea la informacion de las compras y retorne una estructura de datos eficiente para la busqueda
por codigo de cliente. Para cada cliente debe quedar acumulado el monto total gastado para cada mes del año 2022

	b) Realizar un modulo que reciba la estructura generada en a) y un cliente, y retorne 
el mes con mayor gasto de dicho cliente 
	
	c) Realizar un modulo que reciba la estructura generada en a) y un numero de mes, y 
retorne la cantidad de clientes que no gastaron nada en dicho mes
}


program Supermercado2022;
const
	corte = 0;
	qmeses = 12;
	
type
	ranMeses = -1..12;
	
	compra = record
		codigo:integer;
		mes:ranMeses;
		monto:real;
		end;
		
	vecMeses = array [ranMeses] of real;
		
	cliente = record
		codigo:integer;
		meses:vecMeses;
		end;
		
	arbol = ^nodo;
	
	nodo = record
		dato:cliente;
		hi:arbol;
		hd:arbol;
		end;

		
procedure iniciarVector (var v:vecMeses);
var
	i:integer;
begin
	for i := 1 to qMeses do v[i] := 0;
end;

procedure aleatorio (var c:Compra);
begin
	c.codigo := random(11);
	if (c.codigo <> corte) then 
	begin
		c.mes := random(12) + 1;
		c.monto := random(3901)+100;
	end;
end;

procedure agregarArbol (var a:arbol ; cp:Compra);
var
	aux:ranMeses;
begin
	if (a=nil) then
	begin
		new (a);
		a^.hi := nil;
		a^.hd := nil;
		a^.dato.codigo := cp.codigo;
		iniciarVector(a^.dato.meses);
		aux := cp.mes;
		a^.dato.meses[aux] := a^.dato.meses[aux] + cp.monto;
	end
	else
		if (a^.dato.codigo = cp.codigo) then a^.dato.meses[cp.mes] := a^.dato.meses[cp.mes] + cp.monto
		else
			if (a^.dato.codigo > cp.codigo) then agregarArbol(a^.hi,cp)
			else agregarArbol(a^.hd,cp);
end;

procedure cargarArbol (var a:arbol);
var
	cp:compra;
begin
	aleatorio(cp);
	while (cp.codigo <> corte) do
	begin
		agregarArbol(a,cp);
		aleatorio(cp)
	end;
end;

procedure imprimirCliente(c: cliente);
var
    i: integer;
begin
    write('CODIGO=', c.codigo,' MONTO=');
    for i:= 1 to 12 do
        write(i,  '-->   ', c.meses[i]:0:2,'  ');
    writeln();
end;
procedure imprimirArbol(a: arbol);
begin
    if(a<>nil) then
        begin
            imprimirArbol(a^.hi);
            imprimirCliente(a^.dato);
            writeln();
            imprimirArbol(a^.hd);
        end;
end;

procedure maximo (v:vecMeses ; var maxM:integer);
var 
	i:integer;
	max:real;
begin
	max := -1;
	for i := 1 to qMeses do
	begin
		if (v[i] > max) then
		begin
			max := v[i];
			maxM := i;
		end;
	end;
end;

procedure calcularMax(a: arbol; num1: integer; var maxMes: integer);
begin
    if(a<>nil) then
        begin
            if(a^.dato.codigo = num1) then
                maximo(a^.dato.meses, maxMes)
            else
                if(num1 < a^.dato.codigo) then
                    calcularMax(a^.hi, num1, maxMes)
                else
                    calcularMax(a^.hd, num1, maxMes);
        end;
end;
{function noGasto (a:arbol ; mes:ranMeses): integer;
begin
	if (a = nil) then noGasto := 0
	else
		if (a^.dato.meses[mes] = 0) then
			noGasto := 1 + noGasto(a^.hi,mes) + noGasto(a^.hi,mes)
		else
			nogasto := noGasto(a^.hi,mes) + noGasto(a^.hi,mes);
end;
}

procedure noGastoMes ( a:arbol ; var cont:Integer ; mes:ranMeses);
begin
	if (a<> nil) then
	begin
		if (a^.dato.meses[mes] = 0) then cont := cont + 1;
		nogastomes (a^.hi,cont,mes);
		nogastomes (a^.hd,cont,mes);
	end;
end;

VAR
	a:arbol;
	cod,cant,max:integer;
BEGIN
	a:= nil;
	randomize;
	{cant := 0;}
	max:=-1;
	cargarArbol(a);
	imprimirArbol (a);
	writeln('------------------------');
	Writeln('Ingrese el codigo a buscar');
	readln (cod);
	calcularMax (a,cod,max);
	if (max <> -1) then writeln (' ---->  Codigo: ',cod,'   - Mes en el que mas se gasto: ',max)
	else writeln('El cliente no esta');
	{writeln('------------------------');
	Writeln('Ingrese el mes a buscar');
	readln(mesNN);
	noGastoMes(a,cant,mesNN);
	writeln('La cantidad de clientes que no gastaron en ese mes es de ',cant);}
END.

