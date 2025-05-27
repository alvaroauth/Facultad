
package Parciales.Parcial8;

public class PARCIAL8 {
    public static void main(String[] args) {
        
        Director dir = new Director("Alvaro",46013844,1900,123457.99,300000.00);
        Empresa emp = new Empresa(dir, 4);
        
        Encargado enc1 = new Encargado("Milei", 998877,2010, 40000, 10);
        Encargado enc2 = new Encargado("Cristina", 997755,1989, 50000, 10);
        Encargado enc3 = new Encargado("Macri", 996633,2020, 60000, 10);
        Encargado enc4 = new Encargado("Massa", 995511,2000, 70000, 10);
        
        emp.asignarEncargado(enc4, 4);
        emp.asignarEncargado(enc3, 3);
        emp.asignarEncargado(enc2, 2);
        emp.asignarEncargado(enc1, 1);
        
        System.out.println(emp.toString());
    }
}
