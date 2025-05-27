
package Parciales.Parcial7;


public class Estacion {
    private String direccion;
    private double preciom3;
    private Surtidor [] surtidores;
    private int cantSurtidores = 6;
    
    public Estacion (String dir, double pre, int cantV){
        this.preciom3 = pre;
        this.direccion = dir;
        surtidores = new Surtidor [6];
        for (int i=0;i<6;i++){
            surtidores[i] = new Surtidor(cantV);
        }
        
    }

    public String getDireccion() {
        return direccion;
    }

    public double getPreciom3() {
        return preciom3;
    }

    public int getCantSurtidores() {
        return cantSurtidores;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPreciom3(double preciom3) {
        this.preciom3 = preciom3;
    }
    public void agregarVentaSurtidor(int sur, int dni, double m3, String pago){
        double aux = (double) m3*this.preciom3;
        
        Ventas auxV = new Ventas (dni,m3,aux,pago);
        
        this.surtidores[sur].agregarVenta(auxV);
    }
    public void fueraServicio(double min){
        for (int i=0;i<this.getCantSurtidores();i++){
            if (surtidores[i].isEstado() && surtidores[i].getTotalm3()<min){
                surtidores[i].setEstado(false);
            }
        }
    }
    public Ventas getMayorVenta(){
        Ventas aux= null;
        double max = -1;
        for (int i=0;i<this.getCantSurtidores();i++){
            if (this.surtidores[i].isEstado() && this.surtidores[i].mayorVenta().getMonto() > max){
                aux = this.surtidores[i].mayorVenta();
                max = this.surtidores[i].mayorVenta().getMonto();
            }
        }
        return aux;
    }
    @Override
    public String toString(){
        String aux = "";
        for (int i=0;i<this.getCantSurtidores();i++){
            aux += "Surtidor "+i+"   Estado: "+surtidores[i].isEstado()+" Total de m3: "+surtidores[i].getTotalm3()+"\n"+ surtidores[i].toString()+"\n";
        }
        
    return aux;
    }
    
}
