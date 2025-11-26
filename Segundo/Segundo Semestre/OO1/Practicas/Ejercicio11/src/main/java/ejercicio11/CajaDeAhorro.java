package ejercicio11;

public class CajaDeAhorro extends Cuenta{

    @Override
    protected boolean puedeExtraer(double monto){
        return super.getSaldo() >= monto * 1.02;
    }

    @Override
    public void depositar(double monto){
        super.depositar(monto* 0.98);
    }

    @Override
    public boolean extraer(double monto){
        if (this.puedeExtraer(monto)){
            extraerSinControlar(monto*1.02);
            return true;
        }
        return false;
    }

    @Override
    public boolean transferirACuenta(double monto, Cuenta cuentaDestino){
        if (extraer(monto)){
            cuentaDestino.depositar(monto);
            return true;
        }
        return false;
    }
}
