pa equ 30h
pb equ 31h
ca equ 32h
cb equ 33h

org 3000h
ini_pio: push ax
  mov al, 0FFh
  out ca, al
  pop ax
  ret

verif: push ax
  in al, pa
  cmp al, 10000001b
  pop ax
  ret
imprimir: push ax
  push bx
  mov bx, offset msj
  mov al, offset fin - offset msj
  int 7
  pop bx
  pop ax
  ret

org 1000h
  msj db "Activado"
  fin db ?

org 2000h
  call ini_pio

loop: call verif
      jnz loop
      call imprimir
      int 0
end
