
package Parciales.Parcial10;

public class Cuenta {
    private String cbu;
    private String alias;
    private int dni;
    private String moneda;
    private double monto;

    public Cuenta(String cbu, String alias, int dni, String moneda) {
        this.setCbu(cbu);
        this.setAlias(alias);
        this.setDni(dni);
        this.setMoneda(moneda);
        this.setMonto(0);
    }

    public String getCbu() {
        return cbu;
    }

    private void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    private void setAlias(String alias) {
        this.alias = alias;
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    public String getMoneda() {
        return moneda;
    }

    private void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }

    private void setMonto(double monto) {
        this.monto = monto;
    }
    public void agregarDinero(double m){
        this.monto += m;
    }
    @Override
    public String toString(){
        return "   ---> DNI: "+this.getDni()+"   Alias: "+this.getAlias()+"   CBU: "+this.getCbu()+"   Moneda: "+this.getMoneda()+"   Monto: "+this.getMonto();
    }
    
    
}
