program untitled;
const
	valoralto = 9999;
type
	ranMes = 1..12;
	ranDia = 1..31;
	
	regMaestro = record
		anio: integer;
		mes: ranMes;
		dia: ranDia;
		idUsuario: integer;
		tiempo: real;
		end;
		
	maestro = file of regMaestro;
	
procedure leerM(var mae:maestro ; var rm:regMaestro);
begin
	if (not eof(mae)) then read(mae, rm)
	else rm.anio := valoralto;
end;

procedure LeerRegistro(var r: regMaestro);
begin
  writeln('Ingrese anio: ');
  readln(r.anio);
  
  if r.anio <> valoralto then
  begin
    writeln('Ingrese mes: ');
    readln(r.mes);
    writeln('Ingrese dia: ');
    readln(r.dia);
    writeln('Ingrese ID de usuario: ');
    readln(r.idUsuario);
    writeln('Ingrese tiempo registrado: ');
    readln(r.tiempo);
  end;
end;

procedure cargarMaestro(var mae: maestro);
var
  r: regMaestro;
begin
  rewrite(mae);

  writeln('Ingrese los datos del archivo maestro (para finalizar, ingrese ', valoralto, ' en anio):');
  LeerRegistro(r);

  while r.anio <> valoralto do
  begin
    write(mae, r);
    LeerRegistro(r);
  end;

  close(mae);
  writeln('Archivo maestro cargado correctamente.');
  writeln;
end;

procedure informarAnio(var mae:maestro);
var
	anioLeido: integer;
	rm, actual: regMaestro;
	totalAnio, totalMes, totalDia, totalUsuario: real;
begin
	writeln(' = = = Ingrese un Anio para buscar = = =');
	readln(anioLeido);
	reset(mae);
	leerM(mae, rm);
	writeln;
	while (rm.anio < anioLeido) do leerM(mae, rm);
	
	if (rm.anio = anioLeido) then
	begin
		totalAnio := 0;
		writeln(' <v><v><v><v><v><v> ANIO',anioLeido,' <v><v><v><v><v><v>');
		writeln;
		while (rm.anio = anioLeido) do
		begin
			totalMes := 0;
			actual.mes := rm.mes;
			writeln(' 	:=:=:=:=:> Mes ',actual.mes,' <:=:=:=:=:');
			writeln;
			while (rm.anio = anioLeido) and (actual.mes = rm.mes) do
			begin
				totalDia := 0;
				actual.dia := rm.dia;
				writeln(' 		====> Dia ',actual.dia,' <====');
				writeln;
				while (rm.anio = anioLeido) and (actual.mes = rm.mes) and (actual.dia = rm.dia) do
				begin
					totalUsuario := 0;
					actual.idUsuario := rm.idUsuario;
					while (rm.anio = anioLeido) and (actual.mes = rm.mes) and (actual.dia = rm.dia) and (actual.idUsuario = rm.idUsuario) do
					begin
						totalUsuario := totalUsuario + rm.tiempo;
						leerM(mae, rm);
					end;
					writeln (' 			---> Usuario: ',actual.idUsuario,'   Tiempo total de acceso: ',totalUsuario:0:1);
					writeln;
					totalDia := totalDia + totalUsuario;
				end;
				writeln(' 		====> Total del dia: ',totalDia:0:2,' <====');
				writeln;
				totalMes := totalMes + totalDia;
			end;
			writeln(' 	:=:=:=:=:> Total del Mes: ',totalMes:0:2,' <:=:=:=:=:');
			writeln;
			totalAnio := totalAnio + totalMes;
		end;
		writeln(' <v><v><v><v><v><v> TOTAL DEL ANIO: ',totalAnio:0:2,' <v><v><v><v><v><v>');
		writeln;
	end
	else
		writeln(' x X x   No se encontro el anio :(   x X x');
	writeln;
	close(mae);
end;
	
var
  mae: maestro;
  opcion: integer;

BEGIN
  assign(mae, 'maestro.dat');
  
  repeat
    writeln('===== MENU DE OPCIONES =====');
    writeln('1. Cargar archivo maestro');
    writeln('2. Informar datos por anio');
    writeln('0. Salir');
    writeln('Ingrese una opcion: ');
    readln(opcion);

    case opcion of
      1: cargarMaestro(mae);
      2: informarAnio(mae);
      0: writeln('Finalizando programa...');
    else
      writeln('Opcion no valida, intente de nuevo.');
    end;

  until opcion = 0;
end.


