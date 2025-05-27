
package Parciales.Parcial_Repetido2;

public class PARCIAL_REPETIDO_2 {
    public static void main(String[] args) {
        Estacion est = new Estacion("La plata esq. Saenz",6);
        
        Surtidor surt1 = new Surtidor("Nafta", 1000, 3);
        Surtidor surt2 = new Surtidor("Gasoil", 1250, 2);
        Surtidor surt3 = new Surtidor("GNC", 500, 2);
        
        est.agregarSurtidor(surt1);
        est.agregarSurtidor(surt2);
        est.agregarSurtidor(surt3);
        
        est.agregarVenta(1, 46013844, 10.4, "Mercado Pago");
        est.agregarVenta(1, 27893456, 44.7, "Efectivo");
        est.agregarVenta(1, 34098765, 31.8, "Tarjeta");
        est.agregarVenta(2, 41567890, 20.0, "Efectivo");
        est.agregarVenta(2, 39765432, 15.5, "Mercado Pago");
        est.agregarVenta(3, 32678901, 12.8, "Trajeta");
        est.agregarVenta(3, 45321098, 28.8, "Tarjeta");
        
        System.out.println(est.toString());
        
        System.out.println(est.surtidorMasRecaudo());
                
    }
}
