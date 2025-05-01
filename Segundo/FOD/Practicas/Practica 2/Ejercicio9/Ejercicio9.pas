program untitled;
const
	valoralto = 9999;
type
	str20 = string[20];
	ranAnio = 1900..2025;
	ranMes = 1..12;
	
	
	rCliente = record
		cod: integer;
		nombre:str20;
		apellido:str20;
		end;
		
	regMaestro = record
		cliente: rCliente;
		anio: ranAnio;
		mes: ranMes;
		monto: real;
		end;
		
	maestro = file of regMaestro;
	
procedure leer(var mae:maestro ; var rm:regMaestro);
begin
	if (not eof(mae)) then read(mae, rm)
	else rm.cliente.cod := valoralto;
end;
	
procedure LeerMaestro(var maestro: regMaestro);
begin
    writeln('Ingrese código de cliente: ');
    readln(maestro.cliente.cod);
    if (maestro.cliente.cod <> valoralto) then
    begin
		writeln('Ingrese nombre del cliente: ');
		readln(maestro.cliente.nombre);
		
		writeln('Ingrese apellido del cliente: ');
		readln(maestro.cliente.apellido);
		
		writeln('Ingrese año: ');
		readln(maestro.anio);
		
		writeln('Ingrese mes: ');
		readln(maestro.mes);
		
		writeln('Ingrese monto: ');
		readln(maestro.monto);
	end;
end;

procedure imprimirDatos(var mae:maestro);
var
	rm:regMaestro;
	totalAnio, totalMes, totalCliente, totalEmp: real;
	mActual: ranMes;
	aActual: ranAnio;
	cActual:integer;
begin
	reset(mae);
	totalEmp := 0;
	leer(mae, rm);
	while (rm.cliente.cod <> valoralto) do
	begin
		totalCliente := 0;
		cActual := rm.cliente.cod;
		writeln(' :::::::::::::: CLIENTE ',cActual,' ::::::::::::::');
		while(cActual = rm.cliente.cod) do
		begin
			totalAnio := 0;
			aActual := rm.anio;
			writeln(' 	===== ANIO ',aActual,' =====');
			while(cActual = rm.cliente.cod) and (aActual = rm.anio) do
			begin
				totalMes := 0;
				mActual := rm.mes;
				while(cActual = rm.cliente.cod) and (aActual = rm.anio) and (mActual = rm.mes) do
				begin
					totalMes := totalMes + rm.monto;
					leer(mae,rm);
				end;
				writeln(' 		--- Mes: ',mActual,'	Monto: ',totalMes:0:2);
				totalAnio := totalAnio + totalMes;
				writeln;
			end;
			writeln;
			writeln(' 	===== El total del anio ',aActual,' es de ',totalAnio:0:2,' =====');
			totalCliente := totalCliente + totalAnio;
		end;
		writeln;
		writeln(' :::::::::::::: El total del cliente ',cActual,' es de ',totalCliente:0:2,' ::::::::::::::');
		totalEmp := totalEmp + totalCliente;
		writeln;
	end;
	writeln('=#=#=#=#=#=#=#=#=#=#=#=#=#=  TOTAL DE LA EMPRESA: ',totalEmp:0:2,'  =#=#=#=#=#=#=#=#=#=#=#=#=#=');
	close(mae);
end;
	
procedure cargarMaestro(var mae: maestro);
var
    rm: regMaestro;
begin
    rewrite(mae);
    LeerMaestro(rm);

    while (rm.cliente.cod <> valoralto) do
    begin
        write(mae, rm);
        LeerMaestro(rm);
    end;

    close(mae); 
end;
	

var
	mae:maestro;
	opcion:integer;
begin
	assign(mae, 'maestro.dat');
    repeat
        writeln('MENU DE OPCIONES');
        writeln('1. Cargar archivo maestro');
        writeln('2. Imprimir archivo maestro');
        writeln('0. Terminar programa');
        writeln;
        write('Ingrese una opcion: ');
        readln(opcion);

        case opcion of
            1: cargarMaestro(mae);
            2: imprimirDatos(mae);
            0: writeln('Programa finalizado.');
        else
            writeln('Opcion inválida, intente de nuevo.');
        end;

        writeln('Presione ENTER para continuar...');
        readln;
    until opcion = 0;
end.

Raul
