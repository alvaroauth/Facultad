program punto1;
const 
	valoralto = 9999;

type
	prestamo = record
		sucursal: integer;
		dni: integer;
		num: integer;
		fecha: integer;
		monto: real;
	end;
	
	archivo = file of prestamo;
	
procedure leer(var a: archivo; var p:prestamo);
begin
	if (not eof(a)) then read(a, p)
	else p.sucursal := valoralto;
end;

procedure CrearArchivo(var a:archivo);
var
	r: prestamo;
begin
    rewrite(a);
  
	r.sucursal := 1; r.dni := 10001; r.num := 1; r.fecha := 101; r.monto := 500.00; write(a, r);
    r.sucursal := 1; r.dni := 10001; r.num := 2; r.fecha := 101; r.monto := 700.00; write(a, r);
    r.sucursal := 1; r.dni := 10002; r.num := 3; r.fecha := 101; r.monto := 600.00; write(a, r);
    r.sucursal := 1; r.dni := 10002; r.num := 4; r.fecha := 138; r.monto := 800.00; write(a, r);
    r.sucursal := 1; r.dni := 10003; r.num := 5; r.fecha := 143; r.monto := 650.00; write(a, r);
    
    r.sucursal := 2; r.dni := 20001; r.num := 6; r.fecha := 101; r.monto := 550.00; write(a, r);
    r.sucursal := 2; r.dni := 20001; r.num := 7; r.fecha := 114; r.monto := 750.00; write(a, r);
    r.sucursal := 2; r.dni := 20002; r.num := 8; r.fecha := 114; r.monto := 800.00; write(a, r);
    r.sucursal := 2; r.dni := 20002; r.num := 9; r.fecha := 137; r.monto := 900.00; write(a, r);
    r.sucursal := 2; r.dni := 20003; r.num := 10; r.fecha := 137; r.monto := 850.00; write(a, r);
    
    r.sucursal := 3; r.dni := 29001; r.num := 11; r.fecha := 101; r.monto := 650.00; write(a, r);
    r.sucursal := 3; r.dni := 29001; r.num := 12; r.fecha := 115; r.monto := 700.00; write(a, r);
    r.sucursal := 3; r.dni := 29002; r.num := 13; r.fecha := 115; r.monto := 750.00; write(a, r);
    r.sucursal := 3; r.dni := 29002; r.num := 14; r.fecha := 115; r.monto := 800.00; write(a, r);
    r.sucursal := 3; r.dni := 29003; r.num := 15; r.fecha := 115; r.monto := 850.00; write(a, r);
  

    close(a);
end;


procedure crearTxt (var a:archivo);
var
	p, actual: prestamo;
	cantFecha, cantEmpleado, cantSucursal, cantEmpresa: integer;
	montoFecha, montoEmpleado, montoSucursal, montoEmpresa: real;
	
	txt: text;
begin
	assign(txt, 'informe.txt');
	rewrite(txt);
	reset(a);
	cantEmpresa := 0;
	montoEmpresa := 0;
	writeln(txt, 'Empresa');
	
	leer(a, p);
	while( p.sucursal <> valoralto) do
	begin
		actual.sucursal := p.sucursal;
		montoSucursal := 0;
		cantSucursal := 0;
		writeln(txt, '	Sucursal: ',actual.sucursal);
		while (p.sucursal = actual.sucursal) do
		begin
			actual.dni := p.dni;
			cantEmpleado := 0;
			montoEmpleado:= 0;
			writeln(txt, '		Empleado: ',actual.dni);
			while ((p.sucursal = actual.sucursal) and (p.dni = actual.dni)) do
			begin
				actual.fecha := p.fecha;
				cantFecha := 0;
				montoFecha := 0;
				while ((p.sucursal = actual.sucursal) and (p.dni = actual.dni) and (p.fecha = actual.fecha)) do
				begin
					cantFecha := cantFecha+1;
					montoFecha := montoFecha + p.monto;
					leer(a, p);
				end;
				writeln(txt, '			Anio: ',actual.fecha,'	Monto: ',montoFecha:0:2,'	Cantidad: ',cantFecha);
				montoEmpleado := montoEmpleado + montoFecha;
				cantEmpleado := cantEmpleado + cantFecha;
			end;
			montoSucursal := montoSucursal + montoEmpleado;
			cantSucursal := cantSucursal + cantEmpleado;
			writeln(txt, '		Totales		Cantidad de Prestamos: ',cantEmpleado,'	Monto de los Prestamos: ',montoEmpleado:0:2);
			writeln(txt, '');
		end;
		montoEmpresa := montoEmpresa + montoSucursal;
		cantEmpresa := cantEmpresa + cantSucursal;
		writeln(txt, '	Totales		Cantidad de Prestamos: ',cantSucursal,'	Monto de los Prestamos: ',montoSucursal:0:2);
		writeln(txt, '');
	end;
	
	writeln(txt, '---------------------------------------------------------------------------------------------------------------------------');
	writeln(txt, 'Cantidad de Prestamos de la empresa: ',cantEmpresa);
	writeln(txt, 'Monto total de los prestamos de la empresa: ',montoEmpresa:0:2);
	writeln(txt, '---------------------------------------------------------------------------------------------------------------------------');
	close(txt);
	close(a);
end;
		
				
var
	a:archivo;
	
BEGIN
	assign(a, 'prestamos.dat');
	CrearArchivo(a);
	crearTxt(a);
END.

