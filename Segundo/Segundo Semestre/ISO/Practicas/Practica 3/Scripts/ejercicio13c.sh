#!/bin/bash
if [ $# -eq 1 ]; then
	if [ -e $1 ]; then
		if [ -d $1 ]; then
			echo "El directorio existe"
		else
			echo "El archivo existe"
		fi
	else
		echo "No existe el archivo o directorio"
	fi
	exit 0
fi
exit 1
