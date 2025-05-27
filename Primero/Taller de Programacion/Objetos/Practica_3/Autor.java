
package Practica_3;


public class Autor {
    private String nombre= "";
    private String biografia= "";
    private String origen= "";
    
    public Autor(String nom, String bio, String ori){
        this.nombre = nom;
        this.biografia = bio;
        this.origen = ori;
    }
    public Autor(){
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    @Override
    public String toString(){
        String aux = ("Autor: "+this.getNombre()+"   Biografia: "+this.getBiografia()+"   Origen: "+this.getOrigen());
        return aux;
    }
    
}
