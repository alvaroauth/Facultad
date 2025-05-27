
package Parciales.Parcial_Repetido2;

public class Surtidor {
    private String combustible;
    private double precio;
    private Ventas [] ventas;
    private int max;
    private int dimL;
    private int monto;
    
    public Surtidor(String combustible, double precio, int v){
        this.setMax(v);
        this.setCombustible(combustible);
        this.setPrecio(precio);
        this.setDimL(0);
        this.setMonto(0);
        this.ventas = new Ventas[v];
        for (int i=0;i<this.getMax();i++){
            this.ventas[i] = null;
        }
    }

    public String getCombustible() {
        return combustible;
    }

    private void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public double getPrecio() {
        return precio;
    }

    private void setPrecio(double precio) {
        this.precio = precio;
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
    public void agregarCompra(Ventas v){
        this.ventas[this.dimL++] = v;
        this.monto += v.getMonto();
    }

    public int getMonto() {
        return monto;
    }

    private void setMonto(int monto) {
        this.monto = monto;
    }
    
    @Override
    public String toString(){
        String aux = "   ---> Combustible dispensado: "+this.getCombustible()+"   Precio/Litro: "+this.getPrecio()+"   Ventas:"+"\n";
        for (int i=0;i<this.getDimL();i++){
            aux +="      ---> "+ ventas[i].toString()+"\n";
        }
        return aux;
    }
    
    
}
