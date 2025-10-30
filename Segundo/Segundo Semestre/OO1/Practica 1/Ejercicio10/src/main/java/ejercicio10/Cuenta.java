package ejercicio10;

public abstract class Cuenta {
    private double saldo = 0;

    public Cuenta(){}

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto){
        this.saldo += monto;
    }

    public boolean extraer(double monto){
        System.out.println(monto);
        if (this.puedeExtraer(monto)){
            this.extraerSinControlar(monto);
            return true;
        }
        return false;
    }

    public boolean transferirAOtraCuenta(double monto, Cuenta cuentaDestino){
        if (this.puedeExtraer(monto)){
            this.extraerSinControlar(monto);
            cuentaDestino.depositar(monto);
            return true;
        }
        return false;
    }

    protected abstract boolean puedeExtraer(double monto);

    protected void extraerSinControlar(double monto){
        this.saldo -= monto;
    }
}
