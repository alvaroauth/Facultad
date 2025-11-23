#!/bin/bash
if [ $# -ne 2 ]; then
	echo "Tenes que pasar un parametro"
	exit 1
elif [ ! -d $1 ]; then
	echo "El directorio especificado no existe"
	exit 2
else
	for archivo in `ls $1`;
	do
		mv ./$1/$archivo ./$1/${archivo}_$2
	done
	exit 0
fi
