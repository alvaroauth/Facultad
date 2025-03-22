pa equ 30h
pb equ 31h
ca equ 32h
cb equ 33h

org 3000h
ini_pio: push ax
  mov al, 0FFh
  out ca, al
  mov al, 0
  out cb, al
  pop ax
  ret

verif: push ax
  in al, pa
  cmp al, 0
  pop ax
  ret

llave: push ax
  in al, pa
  or al, 0FEh
  cmp al, 0FFh
  jnz fin2
  call imprimir
fin2: pop ax
      ret
  

imprimir: push ax
  push bx
  mov bx, offset msj
  mov al, offset fin - offset msj
  int 7
  pop bx
  pop ax
  ret

invertir: push ax
  in al, pa
  not al
  out pb, al
  pop ax
  ret

org 1000h
  msj db "Arquitectura de Computadoras: ACTIVADA"
  fin db ?

org 2000h
  call ini_pio

loop: call llave
      call invertir
      call verif
      jnz loop
      
      int 0
end
