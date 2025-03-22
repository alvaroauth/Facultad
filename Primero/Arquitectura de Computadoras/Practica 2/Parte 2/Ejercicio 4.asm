pa equ 30h
pb equ 31h
ca equ 32h
cb equ 33h

org 3000h
ini_pio: push ax
         mov al, 0FDh
         out ca, al
         mov al, 0
         out cb, al
         pop ax
         ret

bsy: push ax
     in al, pa
     and al, 1
     jnz bsy
     pop ax
     ret

strb: push ax
      in al, pa
      and al, 0FDh
      out pa, al
      in al, pa
      or al, 02h
      out pa, al
      pop ax
      ret

imprimir: mov al, char
          out pb, al
          ret

org 1000h
  char db ?
org 2000h
  call ini_pio
  mov bx, offset char
  int 6
  call bsy
  call imprimir
  call strb
  int 0
end