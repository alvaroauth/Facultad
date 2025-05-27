
package Parciales.Parcial7;

public class Surtidor {
    private boolean estado;
    private Ventas [] ventas;
    private double totalm3;
    private int dimL;
    private int dimF;
    
    public Surtidor (int cantVentas){
        this.estado = true;
        this.dimF = cantVentas;
        this.ventas = new Ventas [cantVentas];
        this.dimL = 0;
        this.totalm3 = 0;
        for (int i=0;i<cantVentas;i++){
            this.ventas[i] = null;
        }
    }

    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getDimL() {
        return dimL;
    }
    public int getDimF() {
        return dimF;
    }
    public void setDimF(int dimF) {
        this.dimF = dimF;
    }
    public void agregarVenta(Ventas v){
        this.ventas[dimL++] = v;
        this.totalm3 += v.getM3();
    }

    public double getTotalm3() {
        return totalm3;
    }
    public Ventas mayorVenta(){
        Ventas aux = null;
        double max = -1;
        for (int i=0;i<this.getDimL();i++){
            if(this.ventas[i].getMonto()>max){
                max = this.ventas[i].getMonto();
                aux = this.ventas[i];
            }
        }
        return aux;
    }
    @Override
    public String toString(){
        String aux = "";
        for (int i = 0;i<dimL;i++){
            aux += "      ---> "+ventas[i].toString()+"\n";
        }
        return aux;
    }
}
