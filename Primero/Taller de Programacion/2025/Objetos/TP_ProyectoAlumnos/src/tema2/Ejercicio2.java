package tema2;
import PaqueteLectura.*;
public class Ejercicio2 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int dni, edad, diml = 0, max=15;
        String nombre;
        Persona[] vp = new Persona[max];
        edad = GeneradorAleatorio.generarInt(101);
        while (diml < max && edad != 0){
            dni = GeneradorAleatorio.generarInt(15000);
            System.out.println("Ingrese un nombre");
            nombre = Lector.leerString();
            vp[diml++] = new Persona(nombre,dni,edad);

            edad = GeneradorAleatorio.generarInt(101);

        }
        int cont = 0;
        int min = Integer.MAX_VALUE;
        Persona menor = null;
        for (int i = 0; i < diml; i++){
            System.out.println("Nombre: "+vp[i].getNombre()+"   DNI: "+vp[i].getDNI()+"   Edad: "+vp[i].getEdad());
            if (vp[i].getEdad() > 65) cont++;
            if (vp[i].getEdad() < min){ menor = vp[i]; min = vp[i].getEdad();}
        }
        if (menor != null) System.out.println("Nombre: "+menor.getNombre()+"   DNI: "+menor.getDNI()+"   Edad: "+menor.getEdad());
    }
}
