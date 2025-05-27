
package Parciales.Parcial14;

public class Alumno {
    private String nombre;
    private int dni;
    private int tema = -1;

    public Alumno(String nombre, int dni) {
        this.setNombre(nombre);
        this.setDni(dni);
        this.setTema(-1);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return " Nombre: " + this.nombre + "   DNI:" + this.dni + "   Tema: " + this.tema;
    }
    
    
}
