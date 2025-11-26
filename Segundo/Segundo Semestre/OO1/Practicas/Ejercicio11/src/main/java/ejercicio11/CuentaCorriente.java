package ejercicio11;

public class CuentaCorriente extends Cuenta{

    private double limiteDescubierto;

    public CuentaCorriente(){
        super();
        this.limiteDescubierto = 0;
    }

    public double getLimiteDescubierto(){
        return this.limiteDescubierto;
    }

    public void setLimiteDescubierto(double ld){
        this.limiteDescubierto = ld;
    }

    @Override
    protected boolean puedeExtraer(double monto){
        return (super.getSaldo() + this.limiteDescubierto) >= monto;
    }
}