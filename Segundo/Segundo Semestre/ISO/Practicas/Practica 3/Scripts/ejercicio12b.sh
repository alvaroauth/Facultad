#!/bin/bash
if [ $# -eq 2 ]; then
	echo "Los numeros pasados por parametro son: $*"
	echo "$1 + $2 = $(($1 + $2))"
	echo "$1 - $2 = $(($1 - $2))"
	echo "$1 x $2 = $(($1 * $2))"
	echo "$1 / $2 = $(($1 / $2))"
	exit 0
	fi
exit 1
