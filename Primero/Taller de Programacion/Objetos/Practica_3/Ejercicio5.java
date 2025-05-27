
package Practica_3;

import PaqueteLectura.*;
public class Ejercicio5 {
    public static void main(String[] args) {
        Circulo circ = new Circulo();
        System.out.println("Ingrese el radio");
        circ.setRadio(Lector.leerDouble());
        System.out.println("Ingrese el color de relleno");
        circ.setRelleno(Lector.leerString());
        System.out.println("Ingrese el color de linea");
        circ.setLinea(Lector.leerString());
        System.out.println("-------------------");
        System.out.println(circ.toString());
    }
    
}
