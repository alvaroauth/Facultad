
package Parciales.Parcial2;
import PaqueteLectura.*;
public class PARCIAL2 {
    public static void main(String[] args) {
        Concurso con;
        GeneradorAleatorio.iniciar();
        
        con = new Concurso(20);
        
        Alumno concu1 = new Alumno("Francisco", GeneradorAleatorio.generarInt(20)+15, "Flauta");
        Alumno concu2 = new Alumno("Matias", GeneradorAleatorio.generarInt(20)+15, "Bateria");
        Alumno concu3 = new Alumno("Jose", GeneradorAleatorio.generarInt(20)+15, "Guitarra");
        Alumno concu4 = new Alumno("Rodrigo", GeneradorAleatorio.generarInt(20)+15, "Bajo");
        Alumno concu5 = new Alumno("Justina", GeneradorAleatorio.generarInt(20)+15, "Xilofon");
        
        con.agregarAlumno(concu1, (GeneradorAleatorio.generarInt(5)+1));
        con.agregarAlumno(concu2, (GeneradorAleatorio.generarInt(5)+1));
        con.agregarAlumno(concu3, (GeneradorAleatorio.generarInt(5)+1));
        con.agregarAlumno(concu4, (GeneradorAleatorio.generarInt(5)+1));
        con.agregarAlumno(concu5, (GeneradorAleatorio.generarInt(5)+1));
        
        System.out.println(con.toString());
        
        con.agregarPuntaje( "Francisco",GeneradorAleatorio.generarDouble(10));
        con.agregarPuntaje( "Matias",GeneradorAleatorio.generarDouble(10));
        con.agregarPuntaje( "Jose",GeneradorAleatorio.generarDouble(10));
        con.agregarPuntaje( "Rodrigo",GeneradorAleatorio.generarDouble(10));
        con.agregarPuntaje( "Justina",GeneradorAleatorio.generarDouble(10));
        
        System.out.println(con.toString());
        
    }


    
}
