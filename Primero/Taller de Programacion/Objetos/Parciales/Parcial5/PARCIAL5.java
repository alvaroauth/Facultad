
package Parciales.Parcial5;

import PaqueteLectura.*;

public class PARCIAL5 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Funcion fun = new Funcion("La boeheme","18/12/2022","20:40",10,20);
        
        int i,j;
        for(i=0;i<10;i++){
            for(j=0;j<20;j+=2){
                fun.ocuparButaca(i+1, j+1);
            }
        }
        System.out.println(fun.ocuparButaca(1, 2));
        System.out.println("----------------");
        System.out.println(fun.toString());
        System.out.println("----------------");
        fun.desocuparButacas(1);
        System.out.println(fun.toString());
        System.out.println("----------------");
        System.out.println(fun.repButacas(3));
    }
    
}
