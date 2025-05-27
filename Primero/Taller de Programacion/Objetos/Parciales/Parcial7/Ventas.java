
package Parciales.Parcial7;

public class Ventas {
    private int dni;
    private double m3;
    private double monto;
    private String medioPago;

    public Ventas(int dni, double m3, double monto, String medioPago) {
        this.dni = dni;
        this.m3 = m3;
        this.monto = monto;
        this.medioPago = medioPago;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getM3() {
        return m3;
    }

    public void setM3(double m3) {
        this.m3 = m3;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    @Override
    public String toString() {
        return "   ---> Venta (" + "dni=" + dni + ",  m3=" + m3 + ",  monto=" + monto + ",  medioPago=" + medioPago + ')';
    }
    
    
}
