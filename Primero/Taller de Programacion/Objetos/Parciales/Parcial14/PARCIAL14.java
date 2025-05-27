
package Parciales.Parcial14;

public class PARCIAL14 {
    public static void main(String[] args) {
        Parcial par = new Parcial(3,5);
        
        Alumno alu1 = new Alumno("Carlos", 4433214);
        Alumno alu2 = new Alumno("Valentina", 27893456);
        Alumno alu3 = new Alumno("Tomás", 34098765);
        Alumno alu4 = new Alumno("Sofía", 41567890);
        Alumno alu5 = new Alumno("Facundo", 39765432);
        Alumno alu6 = new Alumno("Julieta", 32678901);
        Alumno alu7 = new Alumno("Agustín", 45321098);
        
        par.agregarAlumno(alu1, 1);
        par.agregarAlumno(alu2, 1);
        par.agregarAlumno(alu3, 1);
        par.agregarAlumno(alu4, 2);
        par.agregarAlumno(alu5, 2);
        par.agregarAlumno(alu6, 3);
        par.agregarAlumno(alu7, 3);
        
        System.out.println(par.toString());
        
        par.agregarTemas();
        
        System.out.println(par.toString());
        
        System.out.println(par.alumnosTema(2));
    }
}
