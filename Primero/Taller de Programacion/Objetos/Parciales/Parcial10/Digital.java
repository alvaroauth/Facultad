
package Parciales.Parcial10;

public class Digital extends Banco{
    private String url;
    
    public Digital(String nombre, int cantEmpleados, int n, String url){
        super(nombre, cantEmpleados, n);
        this.setUrl(url);
    }

    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String concatenar(){
        return "   URL: "+this.getUrl()+"\n";
    }
    @Override
    public boolean agregarCuentaFinal(Cuenta c){
        if (this.getDimL()< this.getMaxCuentas()){
            this.agregarCuenta(c);
            return true;
        }
        else 
            return false;
    }
    @Override
    public boolean puedeRecibirTarjeta(String cbu){
        Cuenta aux = this.obtenerCuenta(cbu);
        return aux.getMoneda().equals("Pesos") && aux.getMonto() > 100000;
    }
}