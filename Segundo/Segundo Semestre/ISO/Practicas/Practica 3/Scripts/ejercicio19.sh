#!/bin/bash
while true 
do
	select archivo in * "Salir";
	do
		if [[ "$archivo" = "Salir" ]];
		then
			echo "Saliendo weon perkin"
			exit 0
		else
			echo "Ejecutando $archivo..."
			echo "Si el script necesita parametros, escribilos"
			read parametros
			./"$archivo" $parametros
		fi
	done
done
