program ej7;
type
	str20 = string[20];
	novela = record
		cod:integer;
		nom:str20;
		genero:str20;
		precio:real;
		end;
		
	NovTexto = text;
	
procedure leer(var n:novela);
begin
	writeln('--> Ingrese un codigo de novela <--');
	readln(n.cod);
	if (n.cod <> -1) then
	begin
		writeln('Ingrese el nombre de la novela');
		readln(n.nom);
		writeln('Ingrese el genero de la novela');
		readln(n.genero);
		writeln('Ingrese el precio de la novela');
		readln(n.precio);
	end;
end;
	
VAR
	novtxt : novtexto;
	n:novela;
BEGIN
	assign(novtxt, 'novelas.txt');
	rewrite(novtxt);
	leer(n);
	while(n.cod <> -1) do
	begin
		writeln(novtxt,n.cod,n.precio,n.genero);
		writeln(novtxt,n.nom);
		leer(n);
	end;
	writeln('Finalizo la carga de archivos');
	close(novtxt);
END.
