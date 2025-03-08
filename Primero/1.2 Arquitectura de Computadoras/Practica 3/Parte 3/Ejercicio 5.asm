eoi equ 20h
imr equ 21h
int1 equ 25h
id equ 11
pb equ 31h
cb equ 33h
cont equ 10h
comp equ 11h

org 44
  dw est_luces

org 1000h
  luces db ?
  termino db ?

org 3000h
conf: mov al, 0
      out cb, al
      mov al, 0FFh
      out imr, al
      mov al, id
      out int1, al
      mov al, 12
      out comp, al
      ret
      
luces12: push ax
         push bx
         mov bx, sp
         add bx, 6
         mov bx, [bx]
         mov ax, [bx]
         and al, 80h
         cmp al, 0h
         jz fin2
         mov al, 0
         out cont, al
         mov al, 0FDh
         out imr, al
         mov al, 0ffh
         out pb, al
         jmp fin
fin2:    mov termino, 1
fin:     pop bx
         pop ax
         ret

est_luces:mov al, 0
          out pb, al
          mov al, 0ffh
          out imr, al
          mov termino, 1
          mov al, eoi
          out eoi, al
          iret
         

org 2000h
cli
call conf
sti
in al, pb
mov luces, al
mov ax, offset luces
push ax
call luces12
loop: cmp termino, 1
      jnz loop
int 0
end