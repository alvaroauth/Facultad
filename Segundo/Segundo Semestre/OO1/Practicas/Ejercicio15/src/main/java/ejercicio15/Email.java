package ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Email {

    private String titulo;
    private String cuerpo;
    private List<Archivo> archivos;

    public Email(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.archivos = new ArrayList<>();
    }

    public int calcularTamanio(){
        return (titulo.length() + cuerpo.length() + archivos.stream().mapToInt(a -> a.tamanio()).sum());
    }

    public Email contieneTexto(String text){
        return (this.titulo.contains(text) || this.cuerpo.contains(text))? this : null;
    }

    public void adjuntarArchivo(Archivo a){
        this.archivos.add(a);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public List<Archivo> adjuntos() {
        return archivos;
    }
}
