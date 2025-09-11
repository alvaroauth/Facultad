program untitled;

uses SysUtils;

const
	valoralto = 9999;
	DimF = 3;
type
	ranVector = 1..DimF;
	
	regMaestro = record
		codProvincia: integer;
		nomProvincia: string;
		habitantes: integer;
		YerbaConsumida: real;
		end;
	
	regDetalle = record
		codProvincia: integer;
		YerbaConsumida: real;
		end;
		
	detalle = file of regDetalle;
	maestro = file of regMaestro;
		
	vDetalles = array [ranVector] of detalle;
	
	vInfoDetalles = array [ranVector] of regDetalle;
	
procedure leer(var d:detalle ; var rd:regDetalle);
begin
	if(not eof(d)) then read(d, rd)
	else rd.codProvincia := valoralto;
end;

procedure leerM(var m:maestro ; var rm:regMaestro);
begin
	if(not eof(m)) then read(m, rm)
	else rm.codProvincia := valoralto;
end;

procedure LeerMaestro(var maestro: regMaestro);
begin
    writeln('Ingrese codigo de provincia: ');
    readln(maestro.codProvincia);
    if (maestro.codProvincia <> valoralto) then
    begin
        writeln('Ingrese nombre de provincia: ');
        readln(maestro.nomProvincia);
        writeln('Ingrese cantidad de habitantes: ');
        readln(maestro.habitantes);
        writeln('Ingrese consumo de yerba (kg): ');
        readln(maestro.YerbaConsumida);
    end;
end;

procedure LeerDetalle(var detalle: regDetalle);
begin
    writeln('Ingrese codigo de provincia: ');
    readln(detalle.codProvincia);
    if (detalle.codProvincia <> valoralto) then
    begin
        writeln('Ingrese cantidad de yerba consumida (kg): ');
        readln(detalle.YerbaConsumida);
    end;
end;

procedure cargarDetalles(var vD: vDetalles);
var
    i: ranVector;
    rd: regDetalle;
begin
    for i := 1 to DimF do
    begin
        rewrite(vD[i]);
        leerDetalle(rd);
        
        while (rd.codProvincia <> valoralto) do
        begin
            write(vD[i], rd);
            leerDetalle(rd);
        end;
        close(vD[i]); 
    end;
end;

procedure cargarMaestro(var m: maestro);
var
    rm: regMaestro;
begin
	rewrite(m);
    LeerMaestro(rm);

    while (rm.codProvincia <> valoralto) do
    begin
        write(m, rm);
        LeerMaestro(rm);
    end;

    close(m);
end;

procedure minimo (var vD:vDetalles ; var vInfo:vInfoDetalles ; var min:regDetalle);
var
	i, pos:ranVector;
begin
	min.codProvincia := valoralto;
	for i := 1 to DimF do
	begin
		if (min.codProvincia > vInfo[i].codProvincia) then
		begin
			min := vInfo[i];
			pos := i;
		end;
	end;
	if (min.codProvincia <> valoralto) then
		leer(vD[pos], vInfo[pos]);
end;

procedure imprimirDetalles (var vD: vDetalles);
var
    i: ranVector;
    rd: regDetalle;
begin
    for i := 1 to DimF do
    begin
        reset(vD[i]);
        leer(vD[i], rd);

        writeln('Detalles de archivo ', i, ':');
        while (rd.codProvincia <> valoralto) do
        begin
            writeln('Código de provincia: ', rd.codProvincia);
            writeln('Yerba consumida: ', rd.YerbaConsumida:0:2);
            leer(vD[i], rd);
        end;

        close(vD[i]);
        writeln;
    end;
end;

procedure imprimirMaestro(var vM: maestro);
var
    rm: regMaestro;
begin
    reset(vM);
    leerM(vM, rm);

    writeln('Registros del archivo maestro:');
    while (rm.codProvincia <> valoralto) do
    begin
        writeln('Código de provincia: ', rm.codProvincia);
        writeln('Nombre de provincia: ', rm.nomProvincia);
        writeln('Habitantes: ', rm.habitantes);
        writeln('Yerba consumida: ', rm.YerbaConsumida:0:2);
        writeln('-------------------------------------------------------');
        leerM(vM, rm);
    end;
    
    close(vM);
end;

function promedio(suma:real;cant:integer):real;
begin
	promedio := suma / cant;
end;

procedure actualizarMaestro (var mae:maestro; var vD:vDetalles);
var
	vInfo: vInfoDetalles;
	min: regDetalle;
	rm: regMaestro;
	i:ranVector;
begin

	for i := 1 to dimF do
	begin
		reset(vD[i]);
		leer(vD[i], vInfo[i]);
	end;
	reset(mae);
	minimo(vD, vInfo, min);
	read(mae, rm);
	
	while(min.codProvincia <> valoralto) do
	begin
	
		while(rm.codProvincia < min.codProvincia) do read(mae, rm);
			
		while (rm.codProvincia = min.codProvincia) do
		begin
			rm.YerbaConsumida := rm.YerbaConsumida + min.YerbaConsumida;
			minimo(vD, vInfo, min);
		end;
		
		seek(mae,filepos(mae)-1);
		write(mae, rm);
	end;
	
	close(mae);
	for i := 1 to DimF do
		close(vD[i]);
end;

procedure asignar(var mae:maestro; var vD:vDetalles);
var
	i:ranVector;
begin
	for i:=1 to dimF do
		assign(vD[i],'det'+IntToStr(i)+'.dat');
	assign(mae,'mae.dat');
end;

procedure informar (var mae:maestro);
var
	rm:regMaestro;
begin
	reset(mae);
	
	leerM(mae, rm);
	while(rm.codProvincia <> valoralto) do
	begin
	
		writeln(' =-=-=-= Provincia: ',rm.nomProvincia,' =-=-=-=');
		if (rm.YerbaConsumida > 10000) then
			writeln(' * La cantidad de yerba consumida historicamente supera los 10000kg *');
		writeln('El promedio de yerba consumida por habitante es de: ',promedio(rm.YerbaConsumida,rm.habitantes):0:2);
		writeln;
		leerM(mae, rm);
	end;
	close(mae);
end;

VAR
	vD:vDetalles;
	mae:maestro;
	opcion: integer;
BEGIN
	asignar(mae, vD);
	repeat
        writeln('MENU DE OPCIONES');
        writeln('1. Cargar archivo maestro');
        writeln('2. Cargar archivos de detalle');
        writeln('3. Imprimir archivo maestro');
        writeln('4. Imprimir archivos de detalle');
        writeln('5. Actualizar un registro del maestro');
        writeln('6. Informar datos de cada provincia');
        writeln('0. Terminar programa');
        writeln;
        write('Ingrese una opcion: ');
        readln(opcion);

        case opcion of
            1: cargarMaestro(mae);
            2: cargarDetalles(vD);
            3: imprimirMaestro(mae);
            4: imprimirDetalles(vD);
            5: actualizarMaestro(mae,vD);
            6: informar(mae);
            0: writeln('Programa finalizado.');
        else
            writeln('Opción inválida, intente de nuevo.');
        end;

        writeln('Presione ENTER para continuar...');
        readln;
    until opcion = 0;
END.

