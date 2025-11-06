package ejercicio10;

public class CajaDeAhorro extends Cuenta {

    public boolean puedeExtraer(double monto){
        return this.getSaldo() >= monto+(monto*0.02);
    }

    @Override
    protected void extraerSinControlar(double monto){
        super.extraerSinControlar(monto);
    }

    @Override
    public void depositar(double monto){
        super.depositar(monto-(monto*0.02));
    }
}
