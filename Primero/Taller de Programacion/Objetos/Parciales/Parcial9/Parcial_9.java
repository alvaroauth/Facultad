
package Parciales.Parcial9;

public class Parcial_9 {
    public static void main(String[] args) {
        
        Estacionamiento est = new Estacionamiento("Berisso",1999.99,3,5);
        
        Vehiculo ve1 = new Vehiculo("AXF217", 3.5, "Peugeot", "405");
        Vehiculo ve2= new Vehiculo("DOF531", 2, "Peugeot", "406");
        Vehiculo ve3 = new Vehiculo("DNW065", 4.5, "Ford", "Escort");
        Vehiculo ve4 = new Vehiculo("JDT789", 2.5, "Renault", "Clio");
        Vehiculo ve5 = new Vehiculo("IOY299", 1, "Peugeot", "207 Compact");
        Vehiculo ve6 = new Vehiculo("AB235GE", 1.5, "Fiat", "600");
        Vehiculo ve7 = new Vehiculo("DTN776", 3, "Peugeot", "405 Style");
        
        est.agregarVehiculo(ve1, 1, 1);
        est.agregarVehiculo(ve2, 1, 2);
        est.agregarVehiculo(ve3, 1, 5);
        est.agregarVehiculo(ve4, 2, 2);
        est.agregarVehiculo(ve5, 1, 4);
        est.agregarVehiculo(ve6, 2, 3);
        est.agregarVehiculo(ve7, 3, 1);
        
        System.out.println(est.toString());
        System.out.println("El sector que mas recaudo es el "+est.masRecaudo());
        System.out.println("");
        System.out.println(est.eliminarModelo("Ford", 3));
        
        System.out.println(est.toString());
    }
}
