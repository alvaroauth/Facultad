package Parciales.Parcial12;

public class Alumno {
    private int dni;
    private String nombre;
    private int asistencias;
    private int autoevaluaciones;

    public Alumno(int dni, String nombre) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.asistencias = 0;
        this.autoevaluaciones = 0;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public int getAutoevaluaciones() {
        return autoevaluaciones;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void aumAsistencias() {
        this.asistencias++;
    }

    public void aumAutoevaluaciones() {
        this.autoevaluaciones++;
    }
    
    @Override
    public String toString(){
        return "     Nombre: "+this.getNombre()+"   DNI: "+this.getDni()+"   Asistencias: "+this.getAsistencias()+"   Autoevaluaciones aprobadas: "+this.getAutoevaluaciones();
    }
    
    
    
}
