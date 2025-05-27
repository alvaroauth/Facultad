{
Una empresa de gastronomia procesar las entregas realizadas por sus clientes durante el año 2022

	a) Implementar un modulo que lea compras de comida. De cada compra se lee codigo de comida, codigo de cliente y categoria de la entrega (full, super, Media, Basica, Normal). 
La lectura finaliza con codigo de cliente 0. Se deben retornar dos estructuras de datos
	
			i.un arbol binario de busqueda ordenado por codigo de comida. Para cada codigo de comida debe quedar almacenado la cantidad de entregas realizadas a ese codigo entre todos los clientes
			
			ii. Un vector que almacene en cada posicion el nombre de la categoria y la cantidad de entregas realizadas para esa categoria
		
	b) Implementar un modulo que reciba el arbol generado en a) y un codigo de comida. El modulo debe retornar la cantidad de entregas realizada por el codigo de comida ingresado
	
	c) Implementar un modulo que reciba el vector generado en a), lo ordene  por cantidad de entregas de menor a mayor y retorne la categoria con amyor cantidad de entregas
}


program EntregasComida;
const
	dimF = 5;
	corte = 0;
type
	ranEntrega = 1..dimF;
	
	compra = record
		comida:integer;
		cliente:integer;
		categoria:string;
		end;
		
	recordA = record
		comida:integer;
		entregas:integer;
		end;
		
	arbol = ^nodo;
	
	nodo = record
		dato:recordA;
		hi:arbol;
		hd:arbol;
		end;
		
	recordV = record
		categoria:string;
		entregas:integer;
		end;
	
	vCate = array [ranEntrega] of recordV;


procedure iniciarVector(var v:vCate);
var
	aux:array[ranEntrega] of string = ('Full', 'Super', 'Media', 'Basica', 'Normal');
	i:ranEntrega;
begin
	for i:= 1 to dimF do
	begin
		v[i].categoria := aux[i];
		v[i].entregas := 0;
	end;
end;
		
procedure aleatorio ( var c:Compra);
var
	aux:array[ranEntrega] of string = ('Full', 'Super', 'Media', 'Basica', 'Normal');
	i:ranEntrega;
begin		
	c.cliente := random(16);
	if (c.cliente <> corte) then 
	begin
		c.comida := random(16);
		i := random(5) + 1;
		c.categoria := aux[i];
	end;
end;

procedure agregarArbol ( var a:arbol  ; c:compra );
begin
	if (a=nil) then
	begin
		new(a);
		a^.hi := nil;
		a^.hd := nil;
		a^.dato.comida := c.comida;
		a^.dato.entregas := 1;
	end
	else
		if(a^.dato.comida = c.comida) then
			a^.dato.entregas := a^.dato.entregas + 1
		else
			if(a^.dato.comida > c.comida) then
				agregarArbol(a^.hi,c)
			else
				agregarArbol(a^.hd,c);
end;

procedure agregarVector(var v:vCate; s:String);
var
	i:integer;
	ok:boolean;
begin
	i:=1;
	ok:=false;
	while (i <= dimF) and ( ok = false) do
	begin
		if (v[i].categoria = s) then
		begin
			v[i].entregas := v[i].entregas + 1;
			ok:=true;
		end;
		i:=i+1;
	end;
end;
		
		
procedure cargarEstructuras (var a:arbol ; var v:vCate);	
var
	c:compra;
begin
	aleatorio(c);
	while (c.cliente <> corte) do
	begin
		agregarArbol(a,c);
		agregarVector(v,c.categoria);
		aleatorio(c);
	end;
end;
	
procedure imprimirArbol (a:arbol);
begin
	if(a<>nil) then
	begin
		imprimirArbol(a^.hi);
		writeln('             [ Codigo de comida: ',a^.dato.comida,' ]             [ Cantidad de entregas: ',a^.dato.entregas,' ]');
		writeln('------------------------------------------------------------------');
		writeln();
		imprimirArbol(a^.hd);        
	end;
end;
		
procedure imprimirVector( v:vCate);
var
	i:integer;
begin
	for i := 1 to dimF do
	begin
		writeln('             [ Categoria de comida: ',v[i].categoria,' ]             [ Cantidad de entregas: ',v[i].entregas,' ]');
		writeln('------------------------------------------------------------------');
		writeln();
	end;
end;
	
function incisoB ( a:arbol ; c:integer ):integer;	
begin
	if (a=nil) then incisoB := -1
	else
		if( a^.dato.comida = c) then
			incisoB := a^.dato.entregas
		else
			if(a^.dato.comida > c) then
				incisoB := incisoB(a^.hi , c)
			else
				incisoB := incisoB(a^.hi , c);
end;
		
procedure ordenarSeleccion (var v:vCate);
var
	item:recordV;
	i,j,pos:ranEntrega;
begin
	for i := 1 to dimF-1 do
	begin
		pos := i;
		for j := i to dimF do if (v[j].entregas < v[pos].entregas) then pos := j;
		item := v[pos];
		v[pos] := v[i];
		v[i] := item;
	end;
end;
VAR
	a:arbol;
	vc:vCate;	
	c:integer;
BEGIN
	randomize;
	a:=nil;
	iniciarVector(vc);
	cargarEstructuras(a,vc);
	imprimirArbol(a);
	imprimirVector(vc);
	writeln('----------------------------------');
	writeln('Ingrese el codigo de comida para retornar su cantidad de compras');
	readln(c);
	if (incisoB(a,c) <> -1) then writeln(' La cantidad de compras realizadas por el cliente: ',c,' fue de: ',incisoB(a,c))
	else writeln('El cliente nunca realizo una compra');
	ordenarSeleccion(vc);
	writeln('----------------------------------');
	writeln (' * * *La mayor cantidad de entregas fue de ',vc[dimF].categoria,' * * *');
END.

