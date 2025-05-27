package Practica_2;

import PaqueteLectura.Lector;

public class Ejercicio2 {
    public static void main(String[] args) {
        int dL = 0;
        Persona [] vector = new Persona [15];
        int dni;
        String nombre;
        int edad = Lector.leerInt();
        while (dL <= 14 && edad != 0){
            vector [dL].setEdad(edad);
            vector [dL].setDNI(Lector.leerInt());
            vector [dL].setNombre(Lector.leerString());
            edad = Lector.leerInt();
            dL++;
            }
        for (int i=0; i<=dL;i++){
            System.out.println(vector[i].toString());
        }
                        
        
    }
}
