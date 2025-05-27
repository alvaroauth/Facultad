
package Parciales.Parcial11;

public class Producto {
    private int codigo;
    private String descripcion;
    private double precio;
    private int cantidad;
    private double precioFinal;

    public Producto(int codigo, String descripcion, double precio, int cantidad) {
        this.setCodigo(codigo);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
        this.setCantidad(cantidad);
        this.precioFinal = (double) this.getPrecio()*this.getCantidad();
    }

    public int getCodigo() {
        return codigo;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    private void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    private void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }
    @Override
    public String toString(){
        return "     Codigo: "+this.getCodigo()+"   Descripcion: "+this.getDescripcion()+"   Precio/Unidad: "+this.getPrecio()+"   Cantidad de Prodcutos: "+this.getCantidad();
    }
    
    
}
