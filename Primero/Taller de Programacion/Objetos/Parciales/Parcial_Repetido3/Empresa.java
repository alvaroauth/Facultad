
package Parciales.Parcial_Repetido3;

public class Empresa {
    private String nombre;
    private String direccion;
    private Director director;
    private Encargado [] encargados;
    private int max;

    public Empresa(String nombre, String direccion, Director director, int n) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setDirector(director);
        this.setMax(n);
        this.encargados = new Encargado[n];
        for(int i=0;i<this.getMax();i++){
            this.encargados[i] = null;
        }
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Director getDirector() {
        return director;
    }

    private void setDirector(Director director) {
        this.director = director;
    }

    public int getMax() {
        return max;
    }

    private void setMax(int max) {
        this.max = max;
    }
    public void agregarEncargado(Encargado e, int n){
        n--;
        this.encargados[n] = e;
    }
    
    @Override
    public String toString(){
        String aux="";
        aux += " - * - EMPRESA "+this.getNombre().toUpperCase()+" - * -"+"\n";
        aux+= " - Direccion: "+this.getDireccion()+" -"+"\n";
        aux += this.getDirector().toString()+"\n";
        for ( int i = 0; i<this.getMax();i++){
            if (this.encargados[i] != null){
                aux += "     ---> Sucursal N° "+(i+1)+this.encargados[i].toString()+"\n";
            }
        }
        return aux;
    }
    
    
    
    
}
