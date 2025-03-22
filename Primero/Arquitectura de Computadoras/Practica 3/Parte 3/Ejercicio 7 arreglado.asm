eoi equ 20h
imr equ 21h
int0 equ 24h
id equ 10
int1 equ 25h
id2 equ 11

cont equ 10h
comp equ 11h

pb equ 31h
cb equ 33h

org 40 
  dw parar

org 44
  dw contador

org 3000h
  conf_pio: push ax
            mov al, 0
            out cb, al
            pop ax
            ret
  conf_pic: push ax
            mov al, 11111100b
            out imr, al
            mov al, id
            out int0, al
            mov al, id2
            out int1, al
            mov al, 5
            out comp, al
            mov al, 0
            out cont, al
            pop ax
            ret    
  parar:  push ax
          mov termino, 0
          mov al, 0ffh
          out imr, al
          mov al, 20h
          out eoi, al
          pop ax
          iret
         
  contador: push ax
            mov al, [bx]
            out pb, al
            mov al, 0
            out cont, al
            inc bx
            dec termino
            cmp termino, 0
            jnz terminar
            mov al, 0ffh
            out imr, al
  terminar:  mov al, 20h
            out eoi, al
            pop ax
            iret
            
            
       

org 1000h
  msj db "Hola!"
  fin db ?
  termino db ?

org 2000h
call conf_pio
cli
call conf_pic
sti
mov bx, offset msj
mov termino, offset fin - offset msj
loop: cmp termino, 0
      jnz loop
int 0  
end
