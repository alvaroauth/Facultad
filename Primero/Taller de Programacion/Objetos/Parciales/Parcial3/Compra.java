
package Parciales.Parcial3;

public abstract class Compra {
    private int numero;
    private Producto [] vector;
    private int max;
    private double total;
    private int dimL;

    public Compra(int numero, int max) {
        setNumero(numero);
        setMax(max);
        this.vector = new Producto[this.getMax()];
        this.dimL = 0;
        this.total = 0;
    }
    private void agregarTotal(double p){
        this.total += p;
    }
    public void agregarProducto(Producto p){
        this.vector [this.dimL] = p;
        this.agregarTotal(p.getPrecio());
        this.dimL++;
    }

    public int getNumero() {
        return numero;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMax() {
        return max;
    }

    private void setMax(int max) {
        this.max = max;
    }

    public double getTotal() {
        return total;
    }

    public int getDimL() {
        return dimL;
    }
    private String concat(){
        String aux = "";
        for (int i = 0; i<this.getDimL();i++){
            aux += this.vector[i].toString();
        }
        return aux;
    }
    @Override
    public String toString (){
        return " Compra "+this.getClass()+": "+this.getNumero()+"   Lista de productos: "+"\n"+this.concat()+"   Precio total: "+this.getTotal();
    }
    
    
}
