package ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {

    private String nombre;
    private List<Email> emails;

    public Carpeta(String n){
        this.nombre = n;
        this.emails = new ArrayList<>();
    }

    public int calcularTamanio(){
        return (this.nombre.length() + emails.stream().mapToInt(e -> e.calcularTamanio()).sum());
    }

    public void mover(Email e, Carpeta c){
        this.eliminarEmail(e);
        c.agregarEmail(e);
    }

    public Email buscarTexto(String text){
        return emails.stream().filter(e -> e.contieneTexto(text) != null).findFirst().orElse(null);
    }

    public void agregarEmail(Email e){
        emails.add(e);
    }

    public boolean eliminarEmail(Email e){
        return emails.remove(e);
    }

    public boolean contieneEmail(Email e){
        return this.emails.contains(e);
    }

    public String getNombre() {
        return nombre;
    }
}
