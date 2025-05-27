
package Practica_3;


public class Cliente {
    private int DNI= -1;
    private int edad= -1;
    private String nombre = "";
    
    public Cliente(){
    }
    
    public Cliente (String nom, int dni, int edad){
        this.nombre = nom;
        this.DNI = dni;
        this.edad = edad;
    }
    
    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

    @Override
    public String toString() {
        return "Cliente{" + "DNI=" + DNI + ", edad=" + edad + ", nombre=" + nombre + '}';
    }
}
