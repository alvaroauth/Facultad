
package Parciales.Parcial2;


public class Alumno {
    private String nombre = "No asignado";
    private int edad =-1;
    private String instrumento = "No asignado";
    private double puntaje = -1;

    public Alumno(String nombre, int edad, String instrumento) {
        this.nombre = nombre;
        this.edad = edad;
        this.instrumento = instrumento;
        this.puntaje = puntaje;
    }
    public Alumno(){  
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    @Override
    public String toString() {
        return " Nombre: " +  this.getNombre() + " Instrumento: " + this.getInstrumento() + " Edad: " + this.getEdad() + " Puntaje: " + Math.round(this.getPuntaje()*100.0)/100.0 + " | ";
    } 
}
