
package Parciales.Parcial11;

public class Compra {
    private int numero;
    private Fecha fecha;
    private Producto [] productos;
    private int dimL;
    private int max;
    
    public Compra (int num, Fecha f, int n){
        this.setNumero(num);
        this.setFecha(f);
        this.setMax(n);
        this.dimL = 0;
        this.productos = new Producto [n];
//        for (int i=0;i<this.getMax();i++){
//            this.productos[i] = null;
//        }
        
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    private void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    private void setMax(int max) {
        this.max = max;
    }

    public int getNumero() {
        return numero;
    }

    public int getDimL() {
        return dimL;
    }
    public Fecha getFecha(){
        return this.fecha;
    }
    public int getMax() {
        return max;
    }
    public void agregarProducto(Producto p){
        this.productos[this.dimL++] = p;
    }
    private String imprimirCompras(){
        String aux="";
        for (int i=0;i<this.getDimL();i++){
            aux += this.productos[i].toString()+"\n";
        }
        return aux;
    }
    public double getPrecioFinal(){
        double aux =0;
        for (int i=0;i<this.getDimL();i++){
            aux += this.productos[i].getPrecioFinal();
        }
        return aux;
    }
    public boolean abonable(){
        return this.getPrecioFinal() > 100000;   
    }
    @Override
    public String toString(){
        String aux="";
        aux += " - COMPRA N° "+this.getNumero()+" -"+"\n";
        aux+= " ---> Fecha: "+this.getFecha().toString()+"\n";
        aux+= " ---> Lista de compras: "+"\n";
        aux += this.imprimirCompras()+"\n"+"\n";
        aux+= " - - - PRECIO TOTAL: $"+this.getPrecioFinal()+" - - - "+"\n"+"\n";
        aux+= " Apto para abonar en cuotas: "+this.abonable()+"\n";
        return aux;
    
    }
    
    
}
