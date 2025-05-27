
package Practica_1;

import PaqueteLectura.GeneradorAleatorio;

public class Ejercicio2 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int df = 15;
        double cont = 0;
        double [] altura = new double[df];
        int i;
        for(i= 0 ; i<df ; i++){
            //System.out.println("Ingrese la altura del jugador "+(i+1));
            altura[i] = GeneradorAleatorio.generarDouble(2)+1.5;
            cont += altura[i];
            System.out.println("La altura del jugador "+(i+1)+" es de: "+altura[i]);
        }
        double prom = cont/df;
        System.out.println("La altura promedio es de: "+prom);
        for(i= 0 ; i<df ; i++)
            if(altura[i]>prom)
                System.out.println("El jugador "+(i+1)+" supera la altura promedio");
    }
}
          
            
    

