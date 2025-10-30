package ejercicio10;

public class CuentaCorriente extends Cuenta {
    private double limiteDescubierto;

    public boolean puedeExtraer(double monto){
        return (this.getSaldo() + limiteDescubierto) >= monto;
    }
}
