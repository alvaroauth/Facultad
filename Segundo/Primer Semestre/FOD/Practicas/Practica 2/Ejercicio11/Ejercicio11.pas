program untitled;
const
	valoralto = 9999;
	dimF = 15;
	
type
	ranVector = 1..dimF;
	
	empleado = record
		departamento: integer;
		division: integer;
		numEmpleado: integer;
		categoria: ranVector;
		horasExtra: real;
		end;
		
	vector = array[ranVector] of real;
	
	maestro = file of empleado;
		
procedure cargarHorasVector(var v: vector);
var
	arch: text;
	num: real;
	categoria:ranVector;
begin
	assign(arch, 'horasVector.txt');
	reset(arch);
	while( not eof(arch)) do
	begin
		read(arch,categoria,num);
		v[categoria] := num;
	end;
	close(arch);
end;
	

procedure LeerEmpleado(var e: empleado);
begin
  writeln('Ingrese codigo de departamento: ');
  readln(e.departamento);
  
  if e.departamento <> valoralto then
  begin
    writeln('Ingrese codigo de division: ');
    readln(e.division);
    writeln('Ingrese numero de empleado: ');
    readln(e.numEmpleado);
    writeln('Ingrese categoria: ');
    readln(e.categoria);
    writeln('Ingrese cantidad de horas extra: ');
    readln(e.horasExtra);
  end;
end;


procedure cargarMaestro(var mae: maestro);
var
  emp: empleado;
begin
	rewrite(mae);

	writeln('Ingrese los datos de los empleados (para finalizar, ingrese ', valoralto, ' en departamento):');
	LeerEmpleado(emp);

	while emp.departamento <> valoralto do
	begin
		write(mae, emp);
		LeerEmpleado(emp);
	end;

	close(mae);
	writeln('Archivo maestro cargado correctamente.');
end;

procedure leerM(var mae:maestro; var e:empleado);
begin	
	if (not eof(mae)) then read(mae, e)
	else e.departamento := valoralto;
end;
	
procedure informarDatos(var mae:maestro);
var
	v:vector;
	e, actual:empleado;
	montoDiv, montoDpto, totalEmp, totalDiv, totalDpto: real;
begin
	reset(mae);
	leerM(mae, e);
	cargarHorasVector(v);
	
	while (e.departamento <> valoralto) do
	begin	
		totalDpto := 0;
		montoDpto := 0;
		actual.departamento := e.departamento;
		writeln(' ::::::> DEPARTAMENTO ',actual.departamento,' <::::::');
		while (e.departamento = actual.departamento) do
		begin
			totalDiv := 0;
			montoDiv := 0;
			actual.division := e.division;
			writeln(' 	====> DVISION ',actual.division,' <====');
			writeln;
			while (e.departamento = actual.departamento) and (e.division = actual.division) do
			begin
				totalEmp := 0;
				actual.numEmpleado := e.numEmpleado;
				actual.categoria := e.categoria;
				while (e.departamento = actual.departamento) and (e.division = actual.division) and (e.numEmpleado = actual.numEmpleado) do
				begin
					totalEmp := totalEmp + e.horasExtra;
					leerM(mae, e);
				end;
				totalDiv := totalDiv + totalEmp;
				montoDiv := montoDiv + (totalDiv * v[actual.categoria]);
				writeln(' 		---> Empleado: ',actual.numEmpleado,'   Horas: ',totalEmp:0:2,'   Importe a Cobrar: $',montoDiv:0:2);
				writeln;
			end;
			totalDpto := totalDpto + totalDiv;
			montoDpto := montoDpto + montoDiv;
			writeln(' 	====> Total de Horas ',totalDiv:0:2,'   Monto total: $',montoDiv:0:2,' <====');
			writeln;
		end;
		writeln(' ::::::> Total de Horas ',totalDpto:0:2,'   Monto total: $',montoDpto:0:2,' <::::::');
		writeln;
	end;
	close(mae);
end;

var
	mae:maestro;
	opcion:integer;
	
BEGIN
assign(mae, 'empleados.dat');

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
END.

