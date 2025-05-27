/*
Demo que crea objetos Libro invocando a los constructores definidos. 
 */
package Practica_3;

public class Ejercicio2 {

    public static void main(String[] args) {
        Autor aut = new Autor("Jhon Orton" , "El mas pelotudo" , "Buenos aires");
        Autor aut2 = new Autor("Jeff Bezos" , "El mas capito" , "Bajo Flores");
        Libro libro1= new  Libro( "Java: A Beginner's Guide",   
                                 "Mcgraw-Hill", 2014,   
                                 aut, "978-0071809252", 21.72);
        Libro libro2= new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                               aut2, "978-1512108347");
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        System.out.println("Precio del libro2: " +libro2.getPrecio());
        System.out.println("Año edición del libro2: " +libro2.getAñoEdicion());
        Libro libro3= new Libro(); 
    }
    
}
