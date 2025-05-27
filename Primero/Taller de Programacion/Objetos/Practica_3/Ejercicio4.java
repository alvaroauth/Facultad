
package Practica_3;

import PaqueteLectura.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        
        GeneradorAleatorio.iniciar();;
        System.out.println("Ingrese la cantidad de habitaciones del hotel");
        int n = Lector.leerInt();
        Hotel hot = new Hotel(n);
        Cliente cli;
        int numHab = 1;
        for (int i=0;i<10;i++){
            cli = new Cliente(GeneradorAleatorio.generarString(5),GeneradorAleatorio.generarInt(99999999),GeneradorAleatorio.generarInt(100));
            hot.agregarCliente(cli, numHab);
            numHab += 2;
        }
        System.out.println(hot.toString());
        hot.aumentarHabitaciones(2000);
        System.out.println(hot.toString());
    }
    
}
