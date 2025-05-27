
package Parciales.Parcial11;
import PaqueteLectura.GeneradorAleatorio;
public class PARCIAL11 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Fecha f = new Fecha (GeneradorAleatorio.generarInt(31)+1,GeneradorAleatorio.generarInt(12)+1,GeneradorAleatorio.generarInt(25)+2000);
        
        Compra com = new Compra(12345, f, 10);
        
        Fecha ff = new Fecha (GeneradorAleatorio.generarInt(31)+1,GeneradorAleatorio.generarInt(12)+1,GeneradorAleatorio.generarInt(25)+2000);
        
        CompraMayorista comMay = new CompraMayorista(67890, ff, 10, "20-46013844-6", "Alvaro");
        
        Producto pro1 = new Producto(123, "Jabon para manos", 1850.00, 3);
        Producto pro2 = new Producto(234, "Lavandina", 4000.00, 2);
        Producto pro3 = new Producto(345, "Caramelos", 50.00, 20);
        Producto pro4 = new Producto(456, "yogurt", 1000.00, 100);
        Producto pro5 = new Producto(567, "Papel higenico", 950.00, 100);
        Producto pro6 = new Producto(678, "Aceite de girasol", 1750.00, 5);
        Producto pro7 = new Producto(789, "Shampoo", 2250.00, 50);
        
        com.agregarProducto(pro1);
        com.agregarProducto(pro2);
        com.agregarProducto(pro3);
        com.agregarProducto(pro4);
        
        comMay.agregarProducto(pro5);
        comMay.agregarProducto(pro6);
        comMay.agregarProducto(pro7);
        
        System.out.println(com.toString());
        
        System.out.println(comMay);
    }
}
