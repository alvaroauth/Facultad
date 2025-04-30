program p1e3;
const
	corte = 'fin';
type
	str10 = String[10];
	Empleado = record
		ape : str10;
		nom : str10;
		dni : str10;
		num : integer;
		edad : integer;
	end;
	ar_empleados = file of Empleado;
	
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
	arEmple:ar_empleados;
	e:empleado;		
	aux :string;
BEGIN
	writeln('- - - INGRESE EL NOMBRE DEL ARCHIVO - - -');
	readln(aux);
	assign (arEmple,aux);
	rewrite(arEmple);
	writeln('-----------------------------------------------------');
	leer(e);
	while(e.ape <> corte) do
	begin
		write(arEmple, e);
		leer(e);
	end;
	writeln('Finalizo la carga de elementos');
	close(arEmple);
END.

