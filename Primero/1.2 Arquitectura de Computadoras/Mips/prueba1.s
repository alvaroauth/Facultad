.data	
	nro: .word 2
.code	
	daddi $t3,$0,0
	ld $t1,nro($0)
	daddi $t2,$0,2
loop: dadd $t3,$t3,$t1
	  daddi $t2,$t2,-1
	  bnez $t2,loop
	  halt