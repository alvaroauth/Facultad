
package Practica_4;


public class Ejercicio1 {
    public static void main(String[] args) {
        Triangulo tri = new Triangulo(1.25,1.25,2.66,"Amarillo","Negro");
        System.out.println(tri.toString());
        Circulo circ = new Circulo(3.55,"Azul","Amarillo");
        System.out.println(circ.toString());
        Cuadrado cuad = new Cuadrado(4.56, "Rojo", "Blanco");
        System.out.println(cuad.toString());
        Rectangulo rect = new Rectangulo(10, 17.2, "Amarillo", "Violeta");
        System.out.println(rect.toString());
        rect.despintar();
        System.out.println(rect.toString());
    }
}
