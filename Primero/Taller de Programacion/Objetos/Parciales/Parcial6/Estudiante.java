
package Parciales.Parcial6;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int dni;

    public Estudiante(String nombre, String apellido, int dni) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + '}';
    }
    
}
