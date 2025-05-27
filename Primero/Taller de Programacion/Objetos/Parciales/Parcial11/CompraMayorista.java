
package Parciales.Parcial11;

public class CompraMayorista extends Compra {
    private ConsumidorFinal consuF;
    
    public CompraMayorista (int num, Fecha f, int n,String c, String nom){
        super(num, f, n);
        this.consuF = new ConsumidorFinal(c, nom);
    }

    public ConsumidorFinal getConsuF() {
        return consuF;
    }
    @Override
    public void agregarProducto(Producto p){
        if (p.getCantidad()>6){
            super.agregarProducto(p);
        }
    }
    @Override
    public double getPrecioFinal(){
        double aux = super.getPrecioFinal();
        return aux - (aux*0.21);
    }
    @Override
    public String toString(){
        String aux = "";
        aux += super.toString();
        aux += " - Consumidor final -"+"\n";
        aux += this.getConsuF().toString()+"\n";
        return aux;
    }
}
