package Practica_2;
import PaqueteLectura.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        //Constantes
        int DF = 20;
        //Variables
        Partido [] match = new Partido [DF];
        int i,dimL = 0;
        String vis;
        //PP
        GeneradorAleatorio.iniciar();
        vis = GeneradorAleatorio.generarString(3);
        
        while ((dimL<DF)&&!(vis.equals("ZZZ"))){
            match[dimL++] = new Partido(Lector.leerString(), vis , GeneradorAleatorio.generarInt(5), GeneradorAleatorio.generarInt(5));
            //vis = GeneradorAleatorio.generarString(3);
            vis = Lector.leerString();
        }
        int Riv = 0;
        int Boc = 0;
        for(i = 0;dimL>i; i++){
            System.out.println("L: "+match[i].getLocal()+"  "+match[i].getGolesLocal()+" - "+match[i].getGolesVisitante()+"  "+match[i].getVisitante()+" :V" );
            
            if(match[i].getGanador().equals("River")){
                Riv++;
            }
            if (match[i].getLocal().equals("Boca")){
                Boc += match[i].getGolesLocal();
            }
        }  
        System.out.println("River Gano un total de: "+Riv);
        System.out.println("Boca hizo un total de "+Boc+" goles como local");
    } 
}