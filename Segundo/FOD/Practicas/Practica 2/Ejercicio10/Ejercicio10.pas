program untitled;
const
	valoralto = 9999;
	
type
	regMaestro = record
		codProvincia: integer;
		codLocalidad: integer;
		numMesa: integer;
		cantVotos: integer;
		end;
		
	maestro = file of regMaestro;
	
procedure leerM( var mae:maestro ; var rm: regMaestro);
begin
	if (not eof(mae)) then read(mae, rm)
	else rm.codProvincia := valoralto;
end;

procedure LeerRegistro(var r: regMaestro);
begin
  writeln('Ingrese codigo de provincia: ');
  readln(r.codProvincia);
  if r.codProvincia <> valoralto then
  begin
    writeln('Ingrese codigo de localidad: ');
    readln(r.codLocalidad);
    writeln('Ingrese numero de mesa: ');
    readln(r.numMesa);
    writeln('Ingrese cantidad de votos: ');
    readln(r.cantVotos);
  end;
end;

procedure cargarMaestro(var mae:maestro);
var
	reg: regMaestro;
begin
	rewrite(mae);

	LeerRegistro(reg);
	while reg.codProvincia <> valorAlto do
	begin
		write(mae, reg);
		LeerRegistro(reg);
	end;
	
	close(mae);
	writeln('Archivo maestro cargado correctamente.');
end;

procedure informarDatos(var mae:maestro);
var
	rm, rAux:regMaestro;
	totalLoc, totalProv, totalGeneral: integer;
begin
	reset(mae);
	totalGeneral := 0;
	leerM(mae, rm);
	
	while(rm.codProvincia <> valoralto) do
	begin
		rAux.codProvincia := rm.codProvincia;
		totalProv := 0;
		writeln(' 	===> PROVINCIA ',rAux.codProvincia,' <===');
		writeln;
		
		while( rm.codProvincia = rAux.codProvincia ) do
		begin
			rAux.codLocalidad := rm.codLocalidad ;
			totalLoc := 0;
			
			while ( rm.codProvincia = rAux.codProvincia ) and (rm.codLocalidad = rAux.codLocalidad) do
			begin
				totalLoc := totalLoc + rm.cantVotos;
				leerM(mae, rm);
			end;
			
			totalProv := totalProv + totalLoc;
			writeln(' 		---> Localidad ',rAux.codLocalidad,'   Votos: ',totalLoc);
			writeln;
		end;
		
		totalGeneral := totalGeneral + totalProv;
		writeln(' 	===> TOTAL DE LA PROVINCIA ',totalProv,' <===');
		writeln;
	end;
	
	writeln(' <<<<<<<< EL TOTAL GENERAL DE VOTOS ES DE ', totalGeneral,' >>>>>>>>');
	writeln;
	close(mae);
end;

var
	mae:maestro;
	opcion:integer;

BEGIN
	assign(mae,'maestro.dat');
	repeat
		writeln('===== MENU DE OPCIONES =====');
		writeln('1. Cargar archivo maestro');
		writeln('2. Informar datos');
		writeln('0. Salir');
		writeln('Ingrese una opcion: ');
		readln(opcion);

		case opcion of
		  1: cargarMaestro(mae);
		  2: informarDatos(mae);
		  0: writeln('Finalizando programa...');
		else
		  writeln('Opción no válida, intente de nuevo.');
		end;

  until opcion = 0;
end.

	
END.

