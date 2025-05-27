
package Parciales.Parcial10;

public abstract class Banco {
    private String nombre;
    private int cantEmpleados;
    private Cuenta [] cuentas;
    private int maxCuentas;
    private int dimL = 0;

    public Banco(String nombre, int cantEmpleados, int n) {
        this.setNombre(nombre);
        this.setCantEmpleados(cantEmpleados);
        this.setMaxCuentas(n);
        this.cuentas = new Cuenta[n];
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    private void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }

    public int getMaxCuentas() {
        return maxCuentas;
    }

    private void setMaxCuentas(int maxCuentas) {
        this.maxCuentas = maxCuentas;
    }

    public int getDimL() {
        return dimL;
    }
    public void agregarCuenta (Cuenta c){
        this.cuentas[this.getDimL()] = c;
        this.dimL++;
    }
    public Cuenta obtenerCuenta(String cbu){
        Cuenta aux = null;
        int i=0;
        boolean encontre = false;
        while (i<this.getDimL() && !encontre){
            if (i<this.getDimL() && this.cuentas[i].getCbu().equals(cbu)){
                encontre = true;
                aux = this.cuentas[i];
            }
            if (i<this.getDimL())
                i++;
        }
        return aux;   
    }
    public void depositarDinero (String cbu, double m){
        int i=-1;
        boolean encontre = false;
        while (i<this.getDimL() && !encontre){
            i++;
            if (this.cuentas[i].getCbu().equals(cbu)){
                encontre = true;
            }
        }
        if (encontre)
            cuentas[i].agregarDinero(m);
    }

    
    @Override
    public String toString(){
        String aux =" - BANCO "+this.getNombre().toUpperCase()+" -"+"\n";
        aux += "   Cantidad de empleados: "+this.getCantEmpleados()+"\n";
        aux += this.concatenar()+"\n";
        aux+= " -Cuentas"+"\n";
        for (int i=0;i<this.getDimL();i++)
            aux+= this.cuentas[i].toString()+"\n";
        return aux;
    }
    public abstract String concatenar();
    public abstract boolean agregarCuentaFinal(Cuenta c);
    public abstract boolean puedeRecibirTarjeta(String cbu);
    
    
    
    
}
