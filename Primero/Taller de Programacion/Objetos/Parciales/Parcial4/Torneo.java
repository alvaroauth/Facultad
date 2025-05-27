
package Parciales.Parcial4;


public class Torneo {
    private String nombre;
    private Fecha [] fechas;
    private int max;
    private int dl;
    private int cantGoleadores;
    
    
    public Torneo (String nom, int n){
        this.fechas = new Fecha [n];
        n--;
        this.setMax(n);
        this.dl = 0;
        this.cantGoleadores = 0;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMax() {
        return max;
    }

    private void setMax(int max) {
        this.max = max;
    }

    public int getDl() {
        return dl;
    }

    public int getCantGoleadores() {
        return cantGoleadores;
    }
    
    
    public void agregarFecha(int m){
        this.fechas[this.getDl()] = new Fecha(m);
        this.dl++;
    }
    public void agregarGoleadorTorneo(Goleador g, int x){
        this.fechas[x-1].agregarGoleador(g);
        this.cantGoleadores++;
    }
    public Goleador menorGoleador (int x){
        return fechas[x-1].minGoleador();
    }
    public String toString(){
        String aux = "";
        for(int i=0; i<this.getDl();i++){
            aux += "FECHA #"+(i+1)+"   "+fechas[i].toString();
        }
        return aux;
    }
}
