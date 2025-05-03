program untitled;
uses crt;

const
	valoralto = 'ZZZ';

type
	regMaestro = record
		destino: string;
		fecha: string;
		hora: string;
		asientosDis: integer;
	end;

	regDetalle = record
		destino: string;
		fecha: string;
		hora: string;
		cantidad: integer;
	end;

	maestro = file of regMaestro;
	detalle = file of regDetalle;

procedure leerM(var mae: maestro; var rm: regMaestro);
begin
	if not eof(mae) then
		read(mae, rm)
	else
		rm.destino := valoralto;
end;

procedure leerD(var det: detalle; var rd: regDetalle);
begin
	if not eof(det) then
		read(det, rd)
	else
		rd.destino := valoralto;
end;

procedure LeerMaestro(var r: regMaestro);
begin
	writeln('Ingrese destino: ');
	readln(r.destino);
	if r.destino <> valoralto then
	begin
		writeln('Ingrese fecha: ');
		readln(r.fecha);
		writeln('Ingrese hora: ');
		readln(r.hora);
		writeln('Ingrese asientos disponibles: ');
		readln(r.asientosDis);
	end;
end;

procedure LeerDetalle(var r: regDetalle);
begin
	writeln('Ingrese destino: ');
	readln(r.destino);
	if r.destino <> valoralto then
	begin
		writeln('Ingrese fecha: ');
		readln(r.fecha);
		writeln('Ingrese hora: ');
		readln(r.hora);
		writeln('Ingrese asientos comprados: ');
		readln(r.cantidad);
	end;
end;

procedure CargarArchivoMaestro(var archivo: maestro);
var
	reg: regMaestro;
begin
	rewrite(archivo);
	LeerMaestro(reg);
	while reg.destino <> valoralto do
	begin
		write(archivo, reg);
		LeerMaestro(reg);
	end;
	Close(archivo);
end;

procedure CargarArchivoDetalle(var archivo: detalle);
var
	reg: regDetalle;
begin
	rewrite(archivo);
	LeerDetalle(reg);
	while reg.destino <> valoralto do
	begin
		write(archivo, reg);
		LeerDetalle(reg);
	end;
	Close(archivo);
end;

procedure ImprimirMaestro(var archivo: maestro);
var
	reg: regMaestro;
begin
	Reset(archivo);
	writeln('+----------------------------------------------------------------+');
	writeln('|                       ARCHIVO MAESTRO                        |');
	writeln('+----------------------------------------------------------------+');
	leerM(archivo, reg);
	if reg.destino = valoralto then
	begin
		writeln('|              << No hay registros para mostrar >>             |');
		writeln('+----------------------------------------------------------------+');
	end
	else
	begin
		while reg.destino <> valoralto do
		begin
			writeln('| Destino             : ', reg.destino:29, ' |');
			writeln('| Fecha               : ', reg.fecha:29, ' |');
			writeln('| Hora                : ', reg.hora:29, ' |');
			writeln('| Asientos Disponibles: ', reg.asientosDis:29, ' |');
			writeln('+----------------------------------------------------------------+');
			leerM(archivo, reg);
		end;
	end;
	Close(archivo);
end;

procedure ImprimirDetalle(var archivo: detalle);
var
	reg: regDetalle;
begin
	Reset(archivo);
	writeln('+----------------------------------------------------------------+');
	writeln('|                       ARCHIVO DETALLE                        |');
	writeln('+----------------------------------------------------------------+');
	leerD(archivo, reg);
	if reg.destino = valoralto then
	begin
		writeln('|              << No hay registros para mostrar >>             |');
		writeln('+----------------------------------------------------------------+');
	end
	else
	begin
		while reg.destino <> valoralto do
		begin
			writeln('| Destino             : ', reg.destino:29, ' |');
			writeln('| Fecha               : ', reg.fecha:29, ' |');
			writeln('| Hora                : ', reg.hora:29, ' |');
			writeln('| Cantidad Comprados  : ', reg.cantidad:29, ' |');
			writeln('+----------------------------------------------------------------+');
			leerD(archivo, reg);
		end;
	end;
	Close(archivo);
end;

procedure CargarMaestrosPrueba(var archivo: maestro);
var
	reg: regMaestro;
begin
	rewrite(archivo);
	reg.destino := 'Asuncion';
	reg.fecha := '01/02/2025';
	reg.hora := '10:00';
	reg.asientosDis := 100;
	write(archivo, reg);
	reg.destino := 'Buenos Aires';
	reg.fecha := '02/02/2025';
	reg.hora := '14:00';
	reg.asientosDis := 120;
	write(archivo, reg);
	reg.destino := 'Cordoba';
	reg.fecha := '03/02/2025';
	reg.hora := '18:00';
	reg.asientosDis := 150;
	write(archivo, reg);
	Close(archivo);
end;

procedure CargarDetallesPrueba1(var archivo: detalle);
var
	reg: regDetalle;
begin
	rewrite(archivo);
	reg.destino := 'Asuncion';
	reg.fecha := '01/02/2025';
	reg.hora := '10:00';
	reg.cantidad := 30;
	write(archivo, reg);
	reg.destino := 'Buenos Aires';
	reg.fecha := '02/02/2025';
	reg.hora := '14:00';
	reg.cantidad := 40;
	write(archivo, reg);
	reg.destino := 'Cordoba';
	reg.fecha := '03/02/2025';
	reg.hora := '18:00';
	reg.cantidad := 20;
	write(archivo, reg);
	Close(archivo);
end;

procedure CargarDetallesPrueba2(var archivo: detalle);
var
	reg: regDetalle;
begin
	rewrite(archivo);
	reg.destino := 'Buenos Aires';
	reg.fecha := '02/02/2025';
	reg.hora := '14:00';
	reg.cantidad := 15;
	write(archivo, reg);
	reg.destino := 'Cordoba';
	reg.fecha := '03/02/2025';
	reg.hora := '18:00';
	reg.cantidad := 25;
	write(archivo, reg);
	reg.destino := 'Rosario';
	reg.fecha := '04/02/2025';
	reg.hora := '20:00';
	reg.cantidad := 10;
	write(archivo, reg);
	Close(archivo);
end;

procedure SubMenuPruebas(var mae: maestro; var det1, det2: detalle);
var
	subOp: integer;
begin
	repeat
		writeln('------------------ MENU DE PRUEBAS ------------------');
		writeln('1. Crear Maestro de Prueba');
		writeln('2. Crear Detalle 1 de Prueba');
		writeln('3. Crear Detalle 2 de Prueba');
		writeln('4. Crear Todos de Prueba');
		writeln('5. Volver al Menu Principal');
		writeln('------------------------------------------------------');
		write('Ingrese opcion (1-5): ');
		readln(subOp);
		case subOp of
			1: CargarMaestrosPrueba(mae);
			2: CargarDetallesPrueba1(det1);
			3: CargarDetallesPrueba2(det2);
			4: begin
					CargarMaestrosPrueba(mae);
					CargarDetallesPrueba1(det1);
					CargarDetallesPrueba2(det2);
			   end;
			5: writeln('Volviendo al menu principal...');
		else
			writeln('Opcion no valida. Intente nuevamente.');
		end;
		writeln('Presione Enter para continuar...');
		readln;
	until subOp = 5;
end;

{ Ejemplo de procedimientos para cargar datos de prueba (hard-coded) }


procedure minimo(var det1, det2: detalle; var rd1, rd2, min: regDetalle);
begin
	if (rd1.destino < rd2.destino) then
	begin
		min := rd1;
		leerD(det1, rd1);
	end
	else
	begin
		min := rd2;
		leerD(det2, rd2);
	end;
end;


procedure ActualizarMaestro(var mae: maestro; var det1, det2: detalle);
var
	rm, aux: regMaestro;
	rd1, rd2, min: regDetalle;
begin
	Reset(mae);
	Reset(det1);
	Reset(det2);
	leerD(det1, rd1);
	leerD(det2, rd2);
	minimo(det1, det2, rd1, rd2, min);
	while (min.destino <> valoralto) do
	begin
		aux.destino := min.destino;
		while (min.destino = aux.destino) do
		begin
			aux.fecha := min.fecha;
			while (min.destino = aux.destino) and (min.fecha = aux.fecha) do
			begin
				aux.hora := min.hora;
				aux.asientosDis := 0;
				while (min.destino = aux.destino) and (min.fecha = aux.fecha) and (min.hora = aux.hora) do
				begin
					aux.asientosDis := aux.asientosDis + min.cantidad;
					minimo(det1, det2, rd1, rd2, min);
				end;
				
				leerM(mae, rm);
				while (rm.destino <> min.destino) and (rm.fecha <> min.fecha) and (rm.hora <> min.hora) do
				begin
					leerM(mae, rm);
					writeln(rm.destino,'   ',min.destino);
					readln;
				end;
					
				rm.asientosDis := rm.asientosDis - aux.asientosDis;
				seek(mae, filepos(mae)-1);
				write(mae, aux);
			end;
		end;
	end;
	Close(mae);
	Close(det1);
	Close(det2);
end;



var
	opcion: integer;
	mae: maestro;
	det1, det2: detalle;
begin
	assign(mae, 'maestro.dat');
	assign(det1, 'detalle1.dat');
	assign(det2, 'detalle2.dat');

	repeat
		writeln('------------------ MENU DE OPCIONES ------------------');
		writeln('0. Finalizar');
		writeln('1. Cargar Archivo Maestro (Manual)');
		writeln('2. Cargar Archivo Detalle 1 (Manual)');
		writeln('3. Cargar Archivo Detalle 2 (Manual)');
		writeln('4. Imprimir Archivo Maestro');
		writeln('5. Imprimir Archivos Detalle');
		writeln('6. Pruebas');
		writeln('7. Acrualizar Maestro');
		writeln('------------------------------------------------------');
		write('Ingrese opcion (1-7): ');
		readln(opcion);
		case opcion of
			1: CargarArchivoMaestro(mae);
			2: CargarArchivoDetalle(det1);
			3: CargarArchivoDetalle(det2);
			4: ImprimirMaestro(mae);
			5: begin
					ImprimirDetalle(det1);
					ImprimirDetalle(det2);
			   end;
			6: SubMenuPruebas(mae, det1, det2);
			7: actualizarMaestro(mae,det1,det2);
		else
			writeln('Opcion no valida. Intente nuevamente.');
		end;
		writeln('Presione Enter para continuar...');
		readln;
	until opcion = 0;
end.

