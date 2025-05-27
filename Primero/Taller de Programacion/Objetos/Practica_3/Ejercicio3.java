
package Practica_3;
import PaqueteLectura.GeneradorAleatorio;

public class Ejercicio3 {
    public static void main(String[] args) {
        Estanteria est1 = new Estanteria();
        Autor aux = new Autor();
        int i;
        GeneradorAleatorio.iniciar();
        for(i=0;i<15;i++){
            Autor unAutor = new Autor(GeneradorAleatorio.generarString(8), GeneradorAleatorio.generarString(10), GeneradorAleatorio.generarString(5));
            Libro libro = new Libro(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarString(4),GeneradorAleatorio.generarInt(4), unAutor ,GeneradorAleatorio.generarString(4),GeneradorAleatorio.generarDouble(6));
            if(i == 11){
                libro.setTitulo("Mujercitas");
            }
            est1.agregarLibro(libro);
        }
        
        System.out.println(est1.devolverLibro("Mujercitas").getPrimerAutor().getNombre());
    }
}
