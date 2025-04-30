program ej1;
const 
	valorAlto = -1;
type
	opciones = 0..9;
	
	empleado = record
		codigo:integer;
		nombre:string;
		monto:real;
		end;
		
	detalle = file of empleado;

procedure leer(var det:detalle ; var e:empleado);
begin
	if (not eof(det)) then read(det, e)
	else e.codigo := valorAlto;
end;

procedure leerEmpleado(var e:empleado);
begin
	writeln('           ---- Ingrese un codigo de empleado ---');
	readln(e.codigo);
	if (e.codigo <> valorAlto) then
	begin
		writeln('           Ingrese el nombre del empleado');
		readln(e.nombre);
		writeln('           Ingrese el monto del empleado');
		readln(e.monto);	
	end;
	writeln('          -------------------------------');
end;

procedure crearDetalle(var det:detalle);
var 
	e:empleado;
begin
	rewrite(det);
	leerEmpleado(e);
	while(e.codigo <> valorAlto) do
	begin
		write(det,e);
		leerEmpleado(e);
	end;
	writeln('           ====> Archivo creado correctamente...');
	close(det);
end;

procedure cargarMaestro(var mae, det:detalle);
var
	e, act:empleado;
begin
	reset(det);
	rewrite(mae);
	leer(det, e);
	while(e.codigo <> valorAlto) do
	begin
		act := e;
		act.monto := 0;
		while (e.codigo <> valorAlto)and(e.codigo = act.codigo) do
		begin
			act.monto := act. monto + e.monto;
			leer(det, e);
		end;
		write(mae, act);
	end;
	close(det);
	close(mae);
end;

procedure imprimirDetalle(var det:detalle);
var
	e:empleado;
begin
	reset(det);
	leer(det, e);
	while(e.codigo <> valorAlto) do
	begin
		writeln('          <--->  Nombre: ',e.nombre,'   Codigo: ',e.codigo,'   Monto: ',e.monto:0:2,'  <--->');
		leer(det,e);
	end;
	writeln();
	close(det);
end;

var
	det,mae:detalle;
	op:opciones;
	fin:boolean;
BEGIN
	assign(det,'detalle.dat');
	assign(mae,'maestro.dat');
	fin := false;
	repeat
		Writeln('                   *-*-*-*-*-*-* INGRESE UNA OPCION *-*-*-*-*-*-*');
		Writeln('          |   0). Finalizar');
		Writeln('          |   1). Crear detalle');
		Writeln('          |   2). Crear Mestro');
		Writeln('          |   3). Imprimir detalle');
		Writeln('          |   4). Imprimir maestro');
		readln(op);
		case op of
			0: fin := true;
			1: crearDetalle(det);
			2: cargarMaestro(mae,det);
			3: imprimirDetalle(det);
			4: imprimirDetalle(mae);
		end;
	until fin;
END.

