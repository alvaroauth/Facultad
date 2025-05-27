
package Practica_4;

public class Ejercicio2 {
    public static void main(String[] args) {
        Jugador jug = new Jugador ("Adrianhino",25000,5,200,100);
        System.out.println(jug.toString());
        System.out.println(jug.calcularSueldoBase());
        System.out.println(jug.calcularEfectividad());
        System.out.println(jug.calcularSueldoACobrar());
        System.out.println("------------------------------");
        Entrenador ent = new Entrenador("Guardiola", 30000, 6, 3);
        System.out.println(ent.toString());
        System.out.println(ent.calcularSueldoBase());
        System.out.println(ent.calcularEfectividad());
        System.out.println(ent.calcularSueldoACobrar());
    }
    
}
