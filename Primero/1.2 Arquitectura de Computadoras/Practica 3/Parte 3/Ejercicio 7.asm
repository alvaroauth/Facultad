eoi equ 20h
imr equ 21h
int0 equ 24h
id equ 10
int1 equ 25h
id2 equ 11

cont equ 10h
comp equ 11h

pa equ 30h
pb equ 31h
ca equ 32h
cb equ 33h

org 40 
  dw parar

org 44
  dw contador

org 3000h
  conf_pio: push ax
            mov al, 1
            out ca, al
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
          mov al, 20h
          out eoi, al
          pop ax
          iret
          
  bsy:   push ax
  seguir:in al, pa
         and al, 1
         cmp al, 1
         jz seguir
         pop ax
         ret
  strobe:push ax
         in al, pa
         and al, 11111101b
         out pa, al
         in al, pa
         or al, 10b
         out pa, al
         pop ax
         ret
         
  contador: push ax
            call bsy
            mov al, [bx]
            out pb, al
            call strobe
            mov al, 0
            out cont, al
            inc bx
            dec termino
            mov al, 20h
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
