#!/bin/bash
pila=()
agregarElemento(){
	read -p "Ingresa el valor a agregar: " valor
	if [[ -z "$valor" ]];
	then
		echo "No ingresaste nada weon"
	else
		pila+=("$valor")
	fi
}
sacarElemento(){
	if [[ "${#pila[@]}" -eq 0 ]];
	then
		echo "La pila esta vacia weon"
		return 1
	fi
	local pos=$(( ${#pila[@]} - 1 ))
	local ult="${pila[$pos]}"
	unset "pila[$pos]"
	echo "Elemento popeado: $ult"
	return 0
}
while true;
do
	select op in "Push" "Pop" "Salir"
	do
		case "$op" in
		"Push")
			agregarElemento
			;;
		"Pop")
			sacarElemento
			;;
		"Salir")
			exit 0
			;;
		*)
			echo "Opcion invalida"
		esac
	done
done
