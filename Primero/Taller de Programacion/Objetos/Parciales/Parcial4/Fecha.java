
package Parciales.Parcial4;

public class Fecha {
    private int maxGol;
    private Goleador [] goleador;
    private int dimL;

    public Fecha(int maxGol) {
        this.setMaxGol(maxGol);
        this.goleador = new Goleador[maxGol];
        this.dimL = 0;
    }
    
    
    public int getMaxGol() {
        return this.maxGol;
    }

    private void setMaxGol(int maxGol) {
        this.maxGol = maxGol;
    }

    public int getDimL() {
        return this.dimL;
    }
    public Goleador getGoleador(int i){
        return goleador[i];
    }
    public void agregarGoleador(Goleador g){
        this.goleador[this.getDimL()] = g;
        this.dimL++;
    }
    private String concatenar(){
        String aux = "";
        for ( int i=0;i<this.getDimL();i++){
            aux += goleador[i].toString();
        }
        return aux;
    }
    public Goleador minGoleador(){
        int min = 0,minAux=99999;
        for( int i=0;i<this.getDimL();i++){
            if(minAux > this.goleador[i].getGoles()){
                min = i;
                minAux = this.goleador[i].getGoles();
            }
        }
        return goleador[min];
    }
    @Override
    
    public String toString(){
        return concatenar();
    }
    
    
}
