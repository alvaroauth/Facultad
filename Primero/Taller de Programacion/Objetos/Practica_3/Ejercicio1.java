
package Practica_3;

import PaqueteLectura.Lector;

public class Ejercicio1 {
    public static void main(String[] args) {
        double l1,l2,l3;
        String Col, Lin;
        System.out.println("Ingrese el lado 1 del triangulo");
        l1 = Lector.leerDouble();
        System.out.println("Ingrese el lado 2 del triangulo");
        l2 = Lector.leerDouble();
        System.out.println("Ingrese el lado 3 del triangulo");
        l3 = Lector.leerDouble();
        System.out.println("Ingrese el color de relleno");
        Col = Lector.leerString();
        System.out.println("Ingrese el color de linea");
        Lin  = Lector.leerString();
        Triangulo tri = new Triangulo(l1,l2,l3,Col,Lin);
        System.out.println("----------------------");
        System.out.println(tri.toString());
    }
}
