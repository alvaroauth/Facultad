
package Practica_2;
import PaqueteLectura.Lector;

public class Ejercicio1 {
    public static void main(String[] args) {
        Persona uno = new Persona();
        int aux = Lector.leerInt();
        uno.setDNI(aux);
        uno.setEdad(Lector.leerInt());
        uno.setNombre(Lector.leerString());
        System.out.println(uno.toString());
    }
}
