eoi equ 20h
imr equ 21h
int1 equ 25h
id equ 11
cont equ 10h
comp equ 11h

org 44
  dw impre

org 1000h
  msj db "Escriba 5 caracteres"
  fin db ?
  termino db 5
  cad db ?

org 3000h
leer: mov bx, offset cad
      mov cl, 5
lazo: int 6
      inc bx
      dec cl
      cmp cl, 0
      jnz lazo
      ret

inicio: push ax
        push bx
        mov bx, offset msj
        mov al, offset fin - offset msj
        int 7
        pop bx
        pop ax
        ret

conf_timer: push ax
            mov al, 11111101b
            out imr, al
            mov al, id
            out int1, al
            mov al, 1
            out comp, al
            pop ax
            ret
            
impre:  mov al, 1
        int 7
        inc bx
        dec termino
        cmp termino, 0
        jnz fin2
        mov al, 0FFh
        out imr, al
fin2:   push ax
        mov al, 0
        out cont ,al
        mov al, 20h
        out eoi, al
        pop ax
        iret

        

org 2000h
call inicio
call leer
cli
call conf_timer
sti
mov bx, offset cad
mov al, 0
out cont, al
loop: cmp termino, 0
      jnz loop
int 0
end