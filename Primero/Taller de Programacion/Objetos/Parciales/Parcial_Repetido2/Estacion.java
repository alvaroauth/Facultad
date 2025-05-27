
package Parciales.Parcial_Repetido2;

public class Estacion {
    private Surtidor [] surtidores;
    private String direccion;
    private int max;
    private int dimL;
    
    public Estacion (String direccion, int cantS){
        this.setDireccion(direccion);
        this.setMax(cantS);
        this.setDimL(0);
        this.surtidores = new Surtidor [cantS];
        for (int i=0;i<this.getMax();i++)
            this.surtidores[i]= null;
    }

    public String getDireccion() {
        return direccion;
    }

    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMax() {
        return max;
    }

    private void setMax(int max) {
        this.max = max;
    }

    public int getDimL() {
        return dimL;
    }

    private void setDimL(int dimL) {
        this.dimL = dimL;
    }
    
    public void agregarSurtidor(Surtidor s){
        if (this.getDimL() != this.getMax())
            this.surtidores[this.dimL++] = s;
    }
    public void agregarVenta(int n, int dni, double l, String pag){
        double monTotal = (this.surtidores[n-1].getPrecio()*l);
        Ventas aux = new Ventas(dni, l, monTotal, pag);
        this.surtidores[n-1].agregarCompra(aux);
    }
    public int surtidorMasRecaudo(){
        double maxMonto = -1;
        int aux=0;
        for (int i=0;i<this.getDimL();i++){
            if(this.surtidores[i].getMonto() > maxMonto){
                aux = i;
                maxMonto = this.surtidores[i].getMonto();
            }
        }
        return aux+1;
    }
    
    @Override
    public String toString (){
        String aux="";
        for (int i=0;i<this.getDimL();i++){
            aux+= " - - - SURTIDOR "+(i+1)+" - - - \n";
            aux+= this.surtidores[i].toString()+"\n";
        }
        return aux;
    }
    
    
}
