#!/bin/bash
if [ $# -eq 3 ]; then
	case $1 in
	"+")
		echo "$2 + $3 = $(($2 + $3))"
		;;
	"-")
		echo "$2 - $3 = $(($2 - $3))"
		;;
	\*)
		echo "$2 * $3 = $(($2 * $3))"
		;;
	"%")
		echo "$2 % $3 = $(($2 % $3))"
		;;
	*)
		exit 2
		;;
	esac
	exit 0
	fi
exit 1
