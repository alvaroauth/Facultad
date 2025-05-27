
package Parciales.Parcial_Repetido1;

public class Butaca {
    private String descriptor;
    private double precio;
    private boolean estado;
    
    public Butaca(int f,int m){
        this.setEstado(false);
        this.setDescriptor(f,m);
        this.setPrecio(f);
    }

    public String getDescriptor() {
        return descriptor;
    }

    private void setDescriptor(int f,int m) {
        this.descriptor = "Butaca "+(f+1)+","+(m+1);
    }

    public double getPrecio() {
        return precio;
    }

    private void setPrecio(int f) {
        this.precio = 800+100*(f+1);
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Descriptor: " + descriptor + "   Precio: " + precio + "   Estado:" + estado;
    }
    
    
}
