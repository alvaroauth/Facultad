
package Parciales.Parcial_Repetido2;

public class Ventas {
    private int dni;
    private double litros;
    private double monto;
    private String medioPago;

    public Ventas(int dni, double litros, double monto, String medioPago) {
        this.setDni(dni);
        this.setLitros(litros);
        this.setMonto(monto);
        this.setMedioPago(medioPago);
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    public double getLitros() {
        return litros;
    }

    private void setLitros(double litros) {
        this.litros = litros;
    }

    public double getMonto() {
        return monto;
    }

    private void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMedioPago() {
        return medioPago;
    }

    private void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }
    @Override
    public String toString(){
        return "   Dni: "+this.getDni()+"   Litros cargados: "+this.getLitros()+"   Monto abonado: "+this.getMonto()+"   Medio de Pago: "+this.getMedioPago();
    }
    
    
}
