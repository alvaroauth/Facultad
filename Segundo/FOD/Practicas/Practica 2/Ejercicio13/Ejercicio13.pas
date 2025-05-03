program untitled;
const
	valoralto = 9999;

type
	regDetalle = record
		nro_usuario:integer;
		cuentaDestino: string;
		cuerpoMensaje: string;
		end;
		
	regMaestro = record
		nro_usuario: integer;
		nombreUsuario: string;
		nombre: string;
		apellido: string;
		cantMailEnviados: integer;
		end;
		
	maestro = file of regMaestro;
	detalle = file of regDetalle;
		
procedure leerM(var mae:maestro ; var rm: regMaestro);
begin
	if (not eof(mae)) then read(mae, rm)
	else rm.nro_usuario := valoralto;
end;

procedure leerD(var det:detalle ; var rd: regDetalle);
begin
	if (not eof(det)) then read(det, rd)
	else rd.nro_usuario := valoralto;
end;

procedure LeerDetalle(var reg: regDetalle);
begin
    writeln('Ingrese numero de usuario: ');
    readln(reg.nro_usuario);
    
    if reg.nro_usuario <> valoralto then
    begin
        writeln('Ingrese cuenta destino: ');
        readln(reg.cuentaDestino);
        
        writeln('Ingrese cuerpo del mensaje: ');
        readln(reg.cuerpoMensaje);
    end;
    writeln;
end;

procedure LeerMaestro(var reg: regMaestro);
begin
    writeln('Ingrese numero de usuario: ');
    readln(reg.nro_usuario);
    
    if (reg.nro_usuario <> valoralto) then
    begin
        writeln('Ingrese nombre de usuario: ');
        readln(reg.nombreUsuario);
        
        writeln('Ingrese nombre: ');
        readln(reg.nombre);
        
        writeln('Ingrese apellido: ');
        readln(reg.apellido);
        
        writeln('Ingrese cantidad de mails enviados: ');
        readln(reg.cantMailEnviados);
    end;
    writeln;
end;

procedure CargarArchivoMaestro(var archivo: maestro);
var
    reg: regMaestro;
begin
    rewrite(archivo);
    writeln('Cargando archivo maestro...');
    
    LeerMaestro(reg);
    
    while (reg.nro_usuario <> valoralto) do
    begin
        write(archivo, reg);
        LeerMaestro(reg);
    end;
    
    close(archivo);
end;

procedure CargarArchivoDetalle(var archivo: detalle);
var
    reg: regDetalle;
begin
    rewrite(archivo);
    writeln('Cargando archivo detalle...');
    
    LeerDetalle(reg);
    
    while (reg.nro_usuario <> valoralto) do
    begin
        write(archivo, reg);
        LeerDetalle(reg);
    end;
    
    close(archivo);
end;

procedure actualizarMaestro(var mae: maestro ; var det:detalle);
var
	rd : regDetalle;
	rm : regMaestro;
begin
	reset(mae);
	reset(det);
	leerD(det, rd);
	
	while (rd.nro_usuario <> valoralto) do
	begin
		leerM(mae, rm);
		while(rm.nro_usuario < rd.nro_usuario) do leerM(mae, rm);
		
		while (rm.nro_usuario = rd.nro_usuario) do
		begin
			rm.cantMailEnviados := rm.cantMailEnviados + 1;
			leerD(det, rd);
		end;
		
		seek(mae, filePos(mae) - 1);
		write(mae, rm);
		
	end;
	
	close(det);
	close(mae);
end;

procedure ImprimirArchivoMaestro(var archivo: maestro);
var
  reg: regMaestro;
begin
  reset(archivo);
  writeln('+--------------+------------------+------------------+----------------+------------------+');
  writeln('| Nro Usuario  | Nombre Usuario   | Nombre           | Apellido       | Mails Enviados   |');
  writeln('+--------------+------------------+------------------+----------------+------------------+');
  while not eof(archivo) do
  begin
    read(archivo, reg);
    writeln('| ', reg.nro_usuario:12, ' | ', reg.nombreUsuario:16, ' | ',
               reg.nombre:16, ' | ', reg.apellido:14, ' | ', 
               reg.cantMailEnviados:16, ' |');
  end;
  writeln('+--------------+------------------+------------------+----------------+------------------+');
  close(archivo);
end;

procedure ImprimirArchivoDetalle(var archivo: detalle);
var
  reg: regDetalle;
begin
  reset(archivo);
  writeln('+--------------+----------------------+---------------------------+');
  writeln('| Nro Usuario  | Cuenta Destino       | Cuerpo Mensaje            |');
  writeln('+--------------+----------------------+---------------------------+');
  while not eof(archivo) do
  begin
    read(archivo, reg);
    writeln('| ', reg.nro_usuario:12, ' | ', reg.cuentaDestino:20, ' | ',
               reg.cuerpoMensaje:25, ' |');
  end;
  writeln('+--------------+----------------------+---------------------------+');
  close(archivo);
end;

var
  opcion: integer;
  archMaestro: maestro;
  archDetalle: detalle;
begin
  Assign(archMaestro, 'maestro.dat');
  Assign(archDetalle, 'detalle.dat');

  repeat
    writeln('----------------------------------------');
    writeln('              MENU DE OPCIONES          ');
    writeln('----------------------------------------');
    writeln('1. Cargar Archivo Maestro');
    writeln('2. Cargar Archivo Detalle');
    writeln('3. Imprimir Archivo Maestro');
    writeln('4. Imprimir Archivo Detalle');
    writeln('5. Actualizar Archivo Maestro (con Archivo Detalle)');
    writeln('6. Salir');
    writeln('----------------------------------------');
    write('Ingrese la opcion deseada: ');
    readln(opcion);
    writeln;
    case opcion of
      1: CargarArchivoMaestro(archMaestro);
      2: CargarArchivoDetalle(archDetalle);
      3: ImprimirArchivoMaestro(archMaestro);
      4: ImprimirArchivoDetalle(archDetalle);
      5: ActualizarMaestro(archMaestro, archDetalle);
      6: writeln('Saliendo del programa...');
      else
         writeln('Opcion incorrecta. Intente nuevamente.');
    end;
    writeln;
  until opcion = 6;
end.


