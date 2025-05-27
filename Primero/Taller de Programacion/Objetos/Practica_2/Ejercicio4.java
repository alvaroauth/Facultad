package Practica_2;
import PaqueteLectura.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        Persona per [] [] = new Persona [5] [8];
        int [] aux = new int [5];
        int i= 0,j;
        
        for (int ix = 0;ix <5; ix++){
            aux[ix] = 0;
        }
        System.out.println("Ingrese el nombre - (Dia: 1 , Persona: 1");
        //String nom = Lector.leerString();
        String nom = GeneradorAleatorio.generarString(3);
        while(!(nom.equals("ZZZ"))&&(i < 5)){
            j = 0;
            
            while(!(nom.equals("ZZZ"))&&(j < 8)){
                System.out.println("Seleccione el dia para la entrevista");
                int diaent = GeneradorAleatorio.generarInt(5)+1;

                if (aux[diaent-1] < 8){
                    
                    aux[diaent-1]++;
                    System.out.println("Ingrese el dni");
                    //int dni = Lector.leerInt();
                    int dni = GeneradorAleatorio.generarInt(110);
                    System.out.println("Ingrese la edad");
                    //int edad = Lector.leerInt();
                    int edad = GeneradorAleatorio.generarInt(30);
                    per [diaent-1][aux[diaent-1]] = new Persona (nom,dni,edad);
                    System.out.println("Ingrese el nombre");
                    //nom = Lector.leerString();
                    nom = GeneradorAleatorio.generarString(3);
                }
                
                else    
                    System.out.println("El dia solicitado no esta disponible");
                j++;
            }
            i++;
        }
        for (i = 0; i < 5; i++){
            for (int k = 0; k < aux[i] ; k++){
                System.out.println("Dia " + i + " entrevista " + k + " es de la persona: " + per[i][k].getNombre());
            }
        }
    }
}