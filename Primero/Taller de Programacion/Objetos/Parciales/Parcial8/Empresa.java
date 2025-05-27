
package Parciales.Parcial8;


public class Empresa {
    private Director director;
    private Encargado [] encargados;
    private int max;

    public Empresa(Director director, int n) {
        this.director = director;
        this.max = n;
        this.encargados = new Encargado[n];
        for (int i=0;i<this.getMax();i++){
            encargados[i] = null;
        }
    }

    public Director getDirector() {
        return director;
    }

    public int getMax() {
        return max;
    }
    public void asignarEncargado(Encargado e,int n){
        this.encargados[n-1] = e;
    }
    public String toString(){
        String aux;
        aux = director.toString();
        for (int i=0;i<this.max;i++){
            if (encargados[i] != null){
                aux += "    ---> Encargado de la sucursal "+(i+1)+": "+encargados[i].toString()+"\n";
            }
        }
        return aux;
    }
    
    
    
}
