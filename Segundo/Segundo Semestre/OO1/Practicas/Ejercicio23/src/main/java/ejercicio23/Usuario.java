package ejercicio23;

public abstract class Usuario {

    private String nombre;
    private String descripcion;
    private double saldo;

    public Usuario(String n, String d){
        this.nombre = n;
        this.descripcion = d;
        this.saldo = 0;
    }

    public void cargarSaldo(double monto){
        this.saldo += monto;
    }

    public void cobrarViaje(Viaje v){
        double montoACObrar = (v.getValorTotal() / v.getCantPasajeros()) - this.calcularDescuento(v);
        this.saldo -= montoACObrar;
    }

    public double getSaldo(){
        return this.saldo;
    }

    protected abstract double calcularDescuento(Viaje v);
}
