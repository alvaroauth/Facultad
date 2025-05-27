/*
3- Escriba un programa que defina una matriz de enteros de tamaño 5x5. Inicialice la matriz con números aleatorios entre 0 y 30. 
Luego realice las siguientes operaciones:Mostrar el contenido de la matriz en consola.--Calcular e informar la suma de los elementos de la fila 1
Generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. Luego, imprima el vector. 
Leer un valor entero e indicar si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna) en caso contrario imprima “No se encontró el elemento”.
*/
package Practica_1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ejercicio3 {
    
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int df = 3;
        int dc = 3;
        int [][] matriz = new int [df][dc];
        int i,j;
        int [] columnas = new int [dc];
        int cont=0;
        int num,col=-1,fil=-1;
        
        boolean esta = false;
        
        for (i=0;i<df;i++)
            for (j=0;j<dc;j++)
                matriz[j][i] = GeneradorAleatorio.generarInt(31);
        
        for (i=0;i<df;i++){
            cont += matriz[0][i];
            for (j=0;j<dc;j++){
                System.out.print(" ("+j+","+i+") "+matriz[i][j]+" | ");
                }
            System.out.println();
            }
        
        System.out.println();
        System.out.println(" - - - La suma de la fila 1 es de: "+cont);
        System.out.println();
        
        for (i=0 ; i<df ; i++){
            columnas[i] = 0;
            for (j=0 ; j<dc ; j++)
                columnas[i] += matriz[j][i];
            System.out.println("La suma de la columna "+i+" es de: "+columnas[i]);
        }
        System.out.println("Ingrese el numero a buscar en la matriz");
        num = Lector.leerInt();
        
        for(i=0 ; i<df ; i++)
            for(j=0 ; j<dc ; i++)
                    if (matriz [i][j] == num){
                        esta=true;
                        fil=i;
                        col=j;
                        }
        
        if (esta== true)
            System.out.println("El elemnto sd encuentra en la posicion ("+fil+","+col+")");
        else
            System.out.println("El elemento no se encuentra en la matriz");
    }   
}
