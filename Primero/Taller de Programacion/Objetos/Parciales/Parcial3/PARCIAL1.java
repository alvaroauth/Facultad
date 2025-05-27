
package Parciales.Parcial3;

import PaqueteLectura.*;

public class PARCIAL1 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Mayorista may = new Mayorista(12345,3,"20-46013844-6");
        Minorista min = new Minorista(54321, 4, true);
        
        Producto pro1 = new Producto (678,1250.99,"Javon ala");
        Producto pro2 = new Producto (678,2500.50,"Pizza");
        Producto pro3 = new Producto (678,3000.00,"Papel higenico");
        Producto pro4 = new Producto (678,5500.50,"Lays");
        Producto pro5 = new Producto (678,780.99,"Servilletas");
        Producto pro6 = new Producto (678,429.99,"Aquarius");
        Producto pro7 = new Producto (678,4799.99,"Capelettinis");
        
        may.agregarProducto(pro1);
        may.agregarProducto(pro2);
        may.agregarProducto(pro3);
        min.agregarProducto(pro4);
        min.agregarProducto(pro5);
        min.agregarProducto(pro6);
        min.agregarProducto(pro7);
        
        System.out.println(may.toString());
        System.out.println("-----------------------------");
        System.out.println(min.toString());
        
    }
}
