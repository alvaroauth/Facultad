.data
	control: .word 0x10000
	data: .word 0x10008
	str: .asciiz " El resultado es: "
	valor: .word 7
.code
	daddi $sp,$0,0x400
	ld $s0,control($0)
	ld $s1,data($0)
	ld $a1,valor($0)
	daddi $t0,$0,8
	sd $t0,0($s0)
	ld $a0,0($s1)
	slt $t0, $a1, $a0
	bnez $t0, mayor
menor: jal esMenor
	   j imprimir
mayor: jal esMayor
imprimir: dadd $a2,$s1,$0
		  dadd $a3,$s0,$0
		  dadd $a0,$v0,$0
		  jal impString	
		  jal impNum
		  halt 
		  

esMayor: dsub $v0,$a0,$a1
		 dmul $v0,$v0,$a0
		 jr $ra

esMenor: dsub $v0,$a1,$a0
		 ddiv $v0,$v0,$a0
		 jr $ra

impString: daddi $sp,$sp,-16
		   sd $t1, 8($sp)
		   sd $t0, 0($sp)

		   daddi $t1,$0,str
		   sd $t1, 0($a2)
		   daddi $t0,$0,4
		   sd $t0,0($a3)

		   ld $t1,-8($sp)
		   ld $t0, 0($sp)
		   daddi $sp,$sp,16
		   jr $ra

impNum: daddi $sp,$sp,-8
		sd $t0, 0($sp)

		sd $a0, 0($a2)
		daddi $t0,$t0,2
		sd $t0, 0($a3)

		sd $t0, 0($sp)
		daddi $sp,$sp,8
		jr $ra