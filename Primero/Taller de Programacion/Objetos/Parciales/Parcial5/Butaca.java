
package Parciales.Parcial5;

public class Butaca {
    private String desc;
    private double precio;
    private boolean ocupada;

    public Butaca(String desc, double precio, boolean ocupada) {
        this.desc = desc;
        this.precio = precio;
        this.ocupada = ocupada;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isOcupada() {
        return ocupada;
    }
    public void setOcupada(boolean ok){
        this.ocupada = ok;
    }
    @Override
    public String toString(){
        return "   ---> "+this.getDesc()+"   Precio:"+this.getPrecio()+"   ¿Esta ocupada?: "+this.isOcupada();
    }
}
