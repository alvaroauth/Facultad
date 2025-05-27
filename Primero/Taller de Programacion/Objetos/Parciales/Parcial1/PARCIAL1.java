
package Parciales.Parcial1;
import PaqueteLectura.*;

public class PARCIAL1 {
    public static void main(String[] args) {
        AlumnoDeGrado alu1;
        AlumnoDoctorado alu2;
        Materias mat;
        
        alu1 = new AlumnoDeGrado("Diplomatura en Esports", 777,"Estanislao Andres", 37);
        alu2 = new AlumnoDoctorado("Tecnico Analista en casos de violencia Pediatricas", "Universidad del este", 657,"Matias Julian Guaymas", 20);
        
        int i;
        for(i=0;i<alu1.getCantMax();i++){
            mat = new Materias(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarDouble(10), GeneradorAleatorio.generarInt(24));
            if(i==5){
                mat.setNombre("Tesis");
            }
            alu1.agregarMateria(mat);
        }
        
        for(i=0;i<alu2.getCantMax();i++){
            mat = new Materias(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarDouble(10), GeneradorAleatorio.generarInt(24));
            alu2.agregarMateria(mat);
        }
         
        System.out.println(alu1.toString());
        System.out.println(alu2.toString());

    }
    
}

