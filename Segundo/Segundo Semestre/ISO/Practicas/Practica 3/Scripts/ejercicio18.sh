#!/bin/bash
if [ $# -ne 1 ]; then
	echo "Tenes que pasar un parametro"
	exit 1
else
	intervalo=10
	usuario=$1
	while true
	do
		salida=$(w $usuario 2>/dev/null)
		if [[ "$salida" =~ "$usuario" ]]; then
			echo "EL usuario $usuario se conecto"
			exit 0
		fi
		sleep $intervalo
	done
fi
