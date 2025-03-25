program p1e3;
const
	corte = 'fin';
type
	op = 1..8;
	str10 = String[10];
	Empleado = record
		ape : str10;
		nom : str10;
		dni : str10;
		num : integer;
		edad : integer;
	end;
	ar_empleados = file of Empleado;
	
procedure leer(var e:empleado ; var arEmp: ar_empleados);
begin
	if not eof(arEmp) then
		read(arEmp,e)
	else
		e.num := -1;
end;


procedure imprimirApeNom(var arEmp:ar_empleados);
var
	apenom:str10;
	e:empleado;
	aux, opc:integer;
begin
	reset(arEmp);
	aux := 1;
	writeln('Ingrese el numero correspondiente a la accion');
	writeln('1. Buscar por Apellido');
	writeln('2. Buscar por Nombre');
	readln(opc);
	case opc of
		1:begin
			writeln('Ingrese el apellido');
			readln(apenom);
			writeln('---------------------------------------------------------');
			while(not EOF(arEmp)) do
			begin
				read(arEmp,e);
				if (e.ape = apenom) then
				begin
					writeln(aux,'. ', e.nom,' ',e.ape, ' - ',e.edad,' Anios - ','DNI: ',e.dni,' - Numero de empleado: ',e.num); 
					aux := aux + 1;
				end;		
			end;
		end;
		2: begin
			writeln('Ingrese el nombre');
			readln(apenom);
			writeln('---------------------------------------------------------');
			while(not EOF(arEmp)) do
			begin
				read(arEmp,e);
				if (e.nom = apenom) then
				begin
					writeln(aux,'. ', e.nom,' ',e.ape, ' - ',e.edad,' Anios - ','DNI: ',e.dni,' - Numero de empleado: ',e.num); 
					aux := aux + 1;
				end;
			end;
		end;
	end;
	writeln('Finalizo la lectura');
	close(arEmp);
end;

procedure imprimirJubilados(var arEmp:ar_empleados);
var
	e:empleado;
	cont:integer;
begin
	reset(arEmp);
	cont := 1;
	while(not EOF(arEmp)) do
	begin
		read(arEmp,e);
		if (e.edad > 70) then
		begin
			writeln(cont,'. ', e.nom,' ',e.ape, ' - ',e.edad,' Anios - ','DNI: ',e.dni,' - Numero de empleado: ',e.num); 
			cont := cont + 1;
		end;
	end;
	writeln(' - Finalizo la lectura -');
	close(arEmp);
end;

procedure imprimirTodos(var arEmp:ar_Empleados);
var
	e:empleado;
	cont:integer;
begin
	reset(arEmp);
	cont := 1;
	while(not EOF(arEmp)) do
	begin
		read(arEmp, e);
		writeln(cont,'. ', e.nom,' ',e.ape, ' - ',e.edad,' Anios - ','DNI: ',e.dni,' - Numero de empleado: ',e.num); 
		cont := cont + 1;
	end;
	writeln(' - Finalizo la lectura -');
	close(arEmp);
end;

procedure agregarEmpleado(var arEmp:ar_empleados);
	procedure leer (var e: empleado);
	begin
		writeln('Ingrese el Apellido');
		readln(e.ape);
		if (e.ape <> corte) then
		begin
			writeln('Ingrese el Nombre');
			readln(e.nom);
			writeln('Ingrese el DNI');
			readln(e.dni);
			writeln('Ingrese la Edad');
			readln(e.edad);
			writeln('Ingrese el Numero de empleado');
			readln(e.num);
		end;
	end;
var
	e:empleado;
begin
	leer(e);
	reset(arEmp);
	seek(arEmp,fileSize(arEmp));
	write(arEmp, e);
	writeln('Se agrego al empleado con exito');
	close(arEmp);
end;

procedure modificarEdad(var arEmp:ar_empleados);
var
	num:integer;
	e:empleado;
begin
	reset(arEmp);
	writeln('Ingrese el numero de empleado a modificar');
	readln(num);
	writeln('------------------------------');
	leer(e,arEmp);
	while(e.num <> -1) and (num <> e.num) do
		leer(e,arEmp);
	if (e.num <> -1) then
	begin
		writeln('Se encontro al empleado, ingrese la nueva edad');
		readln(e.edad);
		seek(arEmp,filePos(arEmp)-1);
		write(arEmp, e);
		writeln('La edad se modifico correctamente');
	end
	else
		writeln('No se encontro al empleado');
	close(arEmp);
end;
		
procedure exportarBinario (var arEmp:ar_empleados);
var
	cargaText:Text;
	e:empleado;
begin
	assign(cargaText, 'todos_empleados.txt');
	rewrite(cargaText);
	reset(arEmp);
	while(not eof(arEmp)) do
	begin
		read(arEmp,e);
		writeln(cargaText, e.nom,' ',e.ape, ' - ',e.edad,' Anios - ','DNI: ',e.dni,' - Numero de empleado: ',e.num); 
	end;
	writeln('Archivo exportado...');
	close(arEmp);
	close(cargaText);
end;

procedure exportarFaltaDNI (var arEmp:ar_empleados);
var
	cargaText:Text;
	e:empleado;
begin
	assign(cargaText, 'faltaDNIEmpleado.txt');
	rewrite(cargaText);
	reset(arEmp);
	while(not eof(arEmp)) do
	begin
		read(arEmp,e);
		if (e.dni = '00') then
			writeln(cargaText, e.nom,' ',e.ape, ' - ',e.edad,' Anios - ','DNI: ',e.dni,' - Numero de empleado: ',e.num); 
	end;
	writeln('Archivo exportado...');
	close(arEmp);
	close(cargaText);
end;
	

var
	arEmple:ar_empleados;
	num :op;
	nomArchivo:string;
	terminar:boolean;
BEGIN
	terminar:=false;
	writeln(' - - - INGRESE EL NOMBRE DEL ARCHIVO - - -');
	readln(nomArchivo);
	assign(arEmple, nomArchivo);
	repeat
	writeln('---------------------------------------------------------');
	writeln('Ingrese el numero correspondiente a la accion');
	writeln('1. Leer un empleado desde teclado y mostrarlo');
	writeln('2. Listar todos los empleados');
	writeln('3. Listar los empleados proximos a jubilarse (+70)');
	writeln('4. Agregar empleado al archivo');
	writeln('5. Modificar la edad de un empleado');
	writeln('6. Exportar a texto todos los empleados');
	writeln('7. Exportar a texto los empleados sin DNI');
	writeln('8. Finalizar');
	readln(num);
	writeln('---------------------------------------------------------');
	case num of
		1: imprimirApeNom(arEmple);
		2: imprimirTodos(arEmple);
		3: imprimirJubilados(arEmple);
		4: agregarEmpleado(arEmple);
		5: modificarEdad(arEmple);
		6: exportarBinario(arEmple);
		7: exportarFaltaDNI(arEmple);
		8: terminar := true;
	end;
	until terminar;
END.
