
package Parciales.Parcial3;

public class Producto {
    private int codigo;
    private double precio;
    private String descripcion;

    public Producto(int codigo, double precio, String descripcion) {
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    public Producto(){
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString(){
        return "                    ---> Producto: "+this.getCodigo()+"   Precio: "+this.getPrecio()+"   Descripcion: "+this.getDescripcion()+"\n";
    }
}
