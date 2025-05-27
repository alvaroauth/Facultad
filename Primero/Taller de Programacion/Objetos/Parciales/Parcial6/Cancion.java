
package Parciales.Parcial6;

public class Cancion {
    private String nombre;
    private String compositor;
    private int identificador;
    private Estudiante estudiante;
    private double puntaje;

    public Cancion(String nombre,String compositor, int identificador) {
        this.nombre = nombre;
        this.compositor = compositor;
        this.identificador = identificador;
        this.puntaje = 0;
        this.estudiante = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public void  evaluarEstudiante(Estudiante e, double p){
        if (this.getPuntaje()<p){
            this.estudiante = e;
            this.puntaje = p;
        }
    }

    @Override
    public String toString() {
        return "Cancion{" + "nombre=" + nombre + ", compositor=" + compositor + ", identificador=" + identificador + ", estudiante=" + estudiante + ", puntaje=" + puntaje + '}';
    }
    
            
    
    
    
}
