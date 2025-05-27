
package Parciales.Parcial4;

import PaqueteLectura.*;

public class PARCIAL4 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Torneo tor = new Torneo("LPF 2024", 5);
        Goleador gol = new Goleador ("Sebastian Almendra","River Plate", 150);
        Goleador gol2 = new Goleador ("Amadeo Carrizo","River Plate", 200);
        Goleador gol3 = new Goleador ("Juan Roman Riquelme","Boca", 1);
        Goleador gol4 = new Goleador ("Marcelo Gallardo","River Plate", 100);
        Goleador gol5 = new Goleador ("Franco Mastantuono","River Plate", 15);
        Goleador gol6 = new Goleador ("Lionel Messi","Barcelona", 1000);
        
        tor.agregarFecha(3);
        tor.agregarFecha(5);
        tor.agregarFecha(2);
        
        tor.agregarGoleadorTorneo(gol, 2);
        tor.agregarGoleadorTorneo(gol6, 2);
        tor.agregarGoleadorTorneo(gol3, 2);
        tor.agregarGoleadorTorneo(gol2, 3);
        tor.agregarGoleadorTorneo(gol4, 3);
        tor.agregarGoleadorTorneo(gol5, 1);
        
        System.out.println(tor.toString());
        System.out.println(tor.menorGoleador(1).toString());
        System.out.println(tor.getCantGoleadores());
    }        
}
