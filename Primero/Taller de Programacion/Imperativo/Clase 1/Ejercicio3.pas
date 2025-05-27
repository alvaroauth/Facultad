{
  Netflix ha publicado la lista de películas que estarán disponibles durante el mes de diciembre de 2022. 
De cada película se conoce: código de película, código de género (1: acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y puntaje promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el código de la película -1.
b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje obtenido entre todas las críticas, a partir de la estructura generada en a).. 
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos métodos vistos en la teoría.  
d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje, del vector obtenido en el punto c). 
}
program Netflix;
const
	qgenero = 8;
type
	ranGen = 1..qgenero;
	pelicula = record 
		codigo:integer;
		puntaje:real;
		end;
	
	lista=^nodo;
	nodo = record
		dato:pelicula;
		sig:lista;
		end;
	
	punteros = record
		pri:lista;
		ult:lista;
		end;
	
	vectorL = array [ranGen] of punteros;
	vectorP = array [ranGen] of pelicula;
	
procedure leer(var p:pelicula; var gen:ranGen);
begin
	writeln('Ingrese el codigo de pelicula'); Readln(p.codigo);
	if (p.codigo <> -1) then
	begin
		writeln('Ingrese el genero'); Readln(gen);
		writeln('Ingrese el puntaje'); Readln(p.puntaje);
	end;
end;

Procedure seleccion ( var v: vectorp);
var
	i, j, pos: ranGen;
	item : real;			
begin
	for i:=1 to qgenero do 
	begin
		pos := i;
		for j := i+1 to qgenero do
			if v[j].puntaje < v[pos].puntaje then
				pos:=j;
		item := v[pos].puntaje;   
		v[pos].puntaje := v[i].puntaje;   
		v[i].puntaje := item;
	end;
end;

procedure agregarAtras (var l, ult: lista; p: pelicula);
var
	nue: lista;
begin
	new (nue);
	nue^.dato:= p;
	nue^.sig:= nil;
	if (l<> nil) then
		ult^.sig:= nue
	else
		l:= nue;
	ult:= nue;
end;

procedure iniciarVector (var v:vectorL);
var
	i:ranGen;
begin
	for i := 1 to qgenero do
	begin
		v[i].pri := nil;
		v[i].ult := nil;
	end;
end;


procedure cargarVector (var v:vectorL);
var
	p:pelicula;
	gen:ranGen;
begin
	leer(p,gen);
	while (p.codigo <> -1) do
	begin
		agregarAtras(v[gen].pri,v[gen].ult, p);
		leer(p,gen);
	end;
end;

procedure imprimirVector (v:vectorL);
var
	i:ranGen;
	cont:integer;
begin	
	for i := 1 to qgenero do
	begin
		if (v[i].pri <> nil) then 
		begin
			cont := 0;
			while (v[i].pri <> nil) do
			begin
				cont := cont + 1;
				writeln ('El elemento numero ' , cont , ' del genero ' , i , ' tiene como codigo ' , v[i].pri^.dato.codigo );
				v[i].pri := v[i].pri^.sig;
			end;
		writeln('----------------------------');
		writeln ('El genero ' , i , ' tiene ' , cont , ' peliculas');
		writeln('----------------------------');
		end
		else
		begin
			writeln('----------------------------');
			writeln ('El genero ' , i , ' no tiene peliculas');
			writeln('----------------------------');
		end;
	end;
end;

procedure maximosVector (vL:vectorL; var vp:vectorP);
var
	i:ranGen;
	max:real;
	maxcod:integer;
	entro:boolean;
begin
	for i:= 1 to qgenero do
	begin
		max:=-1;
		entro:=false;
		while (vl[i].pri <> nil) do
		begin
			entro:=true;
			if vl[i].pri^.dato.puntaje > max then
			begin
				max := vl[i].pri^.dato.puntaje;
				maxcod := vl[i].pri^.dato.codigo;
			end;
			vl[i].pri := vl[i].pri^.sig;
		end;
		if (entro) then
		begin
			vp[i].puntaje := max;
			vp[i].codigo := maxcod;
		end;
	end;
end;

procedure iniciarVector2 (var v:vectorP);	
var
	i:ranGen;
begin
	for i := 1 to qgenero do
	begin
		v[i].codigo := 0;
	end;
end;

procedure imprimirVector(var v:vectorP);	
var
	i:ranGen;
begin
	for i := 1 to qgenero do
	begin
		writeln('El genero de codigo ' , i , ' tiene como pelicula mas exitosa a la de codigo ' , v[i].codigo);
	end;
end;
			
VAR
	vpel:vectorL;
	vgen:vectorP;
BEGIN
	iniciarVector2(vgen);
	iniciarVector(vpel);
	cargarVector(vpel);
	imprimirVector(vpel);
	maximosVector(vpel, vgen);
	imprimirVector(vgen);
	writeln('----------------------------');
	seleccion(vgen);
	imprimirVector(vgen);
END.

