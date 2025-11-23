#!/bin/bash
select op in "Listar" "DondeEstoy" "QuienEsta"
do
case $op in
	"Listar")
		echo `ls`
		;;
	"DondeEstoy")
		echo `whoami`
		;;
	"QuienEsta")
		echo  `who`
		;;
	esac
done
