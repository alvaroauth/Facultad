eoi equ 20h
imr equ 21h
int0 equ 24h
id equ 10
dato equ 40h
estado equ 41h

org 40
  dw rut_f10

org 1000h
  wait db 0
  msj db "Ingrese un numero del 1 al 9"
  fin db ?
  leido db ?

org 3000h
 conf_f10:    push ax
              mov al, 0FEh
              out imr, al
              mov al, id
              out int0, al
              pop ax
              ret

leer_digito:  push ax
              push bx
              mov bx, offset msj
              mov al, offset fin - offset msj
              int 7 
              mov bx, offset leido
              int 6
              pop bx
              pop ax
              ret

rut_f10:      push ax
              mov wait, 1
              mov al, 0ffh
              out imr, al
              in al, estado
              and al, 7fh
              out estado, al
              mov al, eoi
              out eoi, al
              pop ax
              iret

descender:    mov bx, sp
              add bx, 2
              mov dl, [bx]
poll:         in al, estado
              and al, 1
              jnz poll
              mov al, dl
              out dato, al
              dec dl
              cmp dl, '/'
              jnz poll
              ret

org 2000h
cli
call conf_f10
sti
loop: cmp wait, 1
      jnz loop
call leer_digito
mov al, leido
push ax
call descender
int 0 
end