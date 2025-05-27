{4.- Una librería requiere el procesamiento de la información de sus productos. De cada producto se conoce el código del producto, código de rubro (del 1 al 8) y precio.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos: 
a. Lea los datos de los productos y los almacene ordenados por código de producto y agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza cuando se lee el precio 0. 
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro. 
c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. 
Considerar que puede haber más o menos de 30 productos del rubro 3. Si la cantidad de productos del rubro 3 es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto.  
d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno de los dos métodos vistos en la teoría.  
e. Muestre los precios del vector resultante del punto d). 
f. Calcule el promedio de los precios del vector resultante del punto d).}
program libreria;
const
	qrubro = 8;
	corte = 0;
	dimF = 30;
	rubroV = 3;
type
	ranrubro = 1..qrubro;
	producto = record
		codigo:integer;
		rubro: ranrubro;
		precio: real;
		end;
	lista = ^nodo;
	nodo = record 
		dato:producto;
		sig: lista;
		end;
	vrubro = array [ranrubro] of  lista;
	ranprodu = 1..dimF;
	vprodu = array [ranprodu] of producto;
	
procedure iniciarVector(var v:vrubro);
var
	i:integer;
begin
	for i := 1 to qrubro do
		v[i] := nil
end;

procedure leer (var p:producto);
begin
	writeln('ingrese el codigo del producto');
	readln(p.codigo);
	if p.codigo <> corte then 
	begin
		writeln('ingrese el codigo del rubro');
		readln(p.rubro);
		writeln('ingrese el precio');
        readln(p.precio);
	end;
end;

procedure agregarOrdenado (var l: lista; p:producto);
var
	ant, nue, act: lista;
begin
	new (nue);
	nue^.dato:= p;
	act:= l;
	ant:= l;
	while (act <> nil) and (act^.dato.codigo < p.codigo) do begin
		ant:= act;
		act:= act^.sig;
	end;
	if (ant = act) then
		l:= nue
	else
		ant^.sig:= nue;
	nue^.sig:= act;
end;

procedure cargarLista (var vl: vrubro);
var
	p:producto;
begin
	leer (p);
	while (p.codigo <> corte) do
	begin
		agregarOrdenado(vl[p.rubro],p);
		leer (p);
	end;
end;

procedure imprimirRubro (vl:vrubro);
var
	i:ranrubro;
	cont:integer;
begin
	for i := 1 to qrubro do
	begin
		if (vl[i] <> nil) then
		begin
			cont := 0;
			while (vl[i] <> nil) do
			begin
				cont := cont + 1;
				writeln('El producto numero ' , cont , ' del rubro de codigo ' , i , ' es el codigo ' , vl[i]^.dato.codigo);
				vl[i] := vl[i]^.sig;
			end;
			writeln('----------------------------');
			writeln('El codigo de rubro ' , i , ' tiene ' , cont , ' cantidad de productos');
			writeln('----------------------------');
		end
		else
		begin
			writeln ('El codigo de rubro ' , i , ' no tiene productos ingresados');
		end;
	end;
end;

Procedure cargarVprodu (vl:vrubro ; var dimL:integer; var vp:vprodu);
begin
	dimL := 1;
	while (vl[rubroV] <> nil) and (DimL<=DimF) do
	begin
		vp[DimL] := vl[rubroV]^.dato;
		DimL := DimL + 1;
		vl[rubroV] := vl[rubroV]^.sig;
	end;
end;

procedure imprimirVector (vp:vprodu; dimL:integer);
var 
	i:integer;
begin
	for i := 1 to dimL do
	begin
		writeln(vp[i].codigo);
	end;
end;

Procedure seleccion ( var v: vprodu; dimL: integer);

var i, j, pos: integer; item : real;	
		
begin
 for i:=1 to (dimL-1) do begin
          pos := i;
          for j := i+1 to dimL do
             if v[ j ].precio < v[ pos ].precio then pos:=j;
         item := v[ pos ].precio;   
         v[ pos ].precio := v[ i ].precio;   
         v[ i ].precio := item;
      end;
end;

function promedio (vp:vprodu; dimL: integer): real;
var
	i:integer;
	acum:real;
begin
	acum := 0;
	for i := 1 to dimL do
	begin
		acum := acum + vp[i].precio;
	end;
	promedio := (acum / dimL);
end;
{programa principal}
var
	vrub:vrubro;
	vpro:vprodu;
	dimL:integer;
begin
	DimL:=0;
	iniciarVector(vrub);
	cargarLista(vrub);
	imprimirRubro(vrub);
	cargarVprodu(vrub, dimL, vpro);
	seleccion(vpro, dimL);
	if dimL > 0 then 
	begin
		writeln(promedio(vpro,dimL));
		imprimirVector(vpro, dimL);
	end;
end.



