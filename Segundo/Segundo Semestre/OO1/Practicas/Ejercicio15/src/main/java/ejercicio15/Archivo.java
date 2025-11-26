package ejercicio15;

public class Archivo {

    private String nombre;

    public Archivo(String n){
        this.nombre = n;
    }

    public int tamanio(){
        return nombre.length();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
