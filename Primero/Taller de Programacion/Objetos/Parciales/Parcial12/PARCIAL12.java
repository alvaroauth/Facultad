
package Parciales.Parcial12;

public class PARCIAL12 {
    public static void main(String[] args) {
        Presencial pre = new Presencial("10B",2024,3);
        Virtual vir = new Virtual("www.googlemeet.com.ar", 2023, 4);
        
        Alumno alu1 = new Alumno(46013844, "Alvaro");
        Alumno alu2 = new Alumno(45678901, "Santiago");
        Alumno alu3 = new Alumno(24567890, "Lucía");
        Alumno alu4 = new Alumno(31234567, "Mateo");
        Alumno alu5 = new Alumno(38901234, "Martina");
        Alumno alu6 = new Alumno(33567890, "Joaquín");
        Alumno alu7 = new Alumno(29876543, "Camila");
        
        pre.agregarAlumno(alu1);
        pre.agregarAlumno(alu2);
        pre.agregarAlumno(alu3);
        vir.agregarAlumno(alu4);
        vir.agregarAlumno(alu5);
        vir.agregarAlumno(alu6);
        vir.agregarAlumno(alu7);
        
        pre.aumAsistencia(46013844);
        pre.aumAsistencia(46013844);
        pre.aumAsistencia(46013844);
        
        pre.aumAsistencia(24567890);
        pre.aumAsistencia(24567890);
        pre.aumAsistencia(24567890);
        
        vir.aumAsistencia(33567890);
        vir.aumAutoevaluacion(33567890);
        vir.aumAutoevaluacion(33567890);
        vir.aumAutoevaluacion(33567890);
        
        System.out.println(pre.toString());
        System.out.println("--------------------------------");
        System.out.println(vir.toString());
    }
}
