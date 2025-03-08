eoi equ 20h
imr equ 21h
int0 equ 24h
id equ 10

org 40
  dw contar

org 3000h
contar: inc dl
  mov al, 20h
  out eoi, al
  iret

org 2000h
  mov dl, 0
  cli
  mov al, id
  out int0, al
  mov al, 0feh
  out imr, al
  sti

loop: jmp loop
  int 0
end
