
package Parciales.Parcial10;

public class Tradicional extends Banco {
    private String direccion;
    private String localidad;
    private int cantDolares;

    public Tradicional(String direccion, String localidad, String nombre, int cantEmpleados, int n) {
        super(nombre, cantEmpleados, n);
        this.setCantDolares(0);
        this.setDireccion(direccion);
        this.setLocalidad(localidad);
    }

    public String getDireccion() {
        return direccion;
    }

    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    private void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCantDolares() {
        return cantDolares;
    }

    private void setCantDolares(int cantDolares) {
        this.cantDolares = cantDolares;
    }
    @Override
    public String concatenar(){
        String aux;
        aux = "   Localidad: "+this.getLocalidad()+"\n";
        aux+= "   Direccion: "+this.getDireccion()+"\n";
        aux+= "   Cantidad de cuentas en dolares: "+this.getCantDolares()+"\n";
        return aux;
    }
    @Override
    public boolean agregarCuentaFinal(Cuenta c){
        if (this.getDimL()< this.getMaxCuentas() && this.getCantDolares() < 100){
            agregarCuenta(c);
            if (c.getMoneda().equals("Dolares"))
                this.cantDolares++;
            return true;
        }
        else
            return false;
    }
    @Override
    public boolean puedeRecibirTarjeta(String cbu){
         Cuenta aux = this.obtenerCuenta(cbu);
         return (aux.getMoneda().equals("Pesos") && aux.getMonto() > 70000)||(aux.getMoneda().equals("Dolares") && aux.getMonto() > 500);
    }
}
