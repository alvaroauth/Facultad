
package Parciales.Parcial7;

public class PARCIAL7 {
    public static void main(String[] args) {
        Estacion est = new Estacion("7 y 55, La palta",1249.99,10);
        
        est.agregarVentaSurtidor(3, 46013844, 15, "Debito");
        est.agregarVentaSurtidor(3, 46013678, 10, "Efectivo");
        est.agregarVentaSurtidor(0, 46013129, 9, "Mercado Pago");
        est.agregarVentaSurtidor(2, 46013098, 40, "Debito");
        est.agregarVentaSurtidor(5, 46013333, 30, "Efectivo");
        
        System.out.println(est.toString());
        
        est.fueraServicio(10);
        
        System.out.println(est.toString());
        
        System.out.println(est.getMayorVenta().toString());
    }
}
