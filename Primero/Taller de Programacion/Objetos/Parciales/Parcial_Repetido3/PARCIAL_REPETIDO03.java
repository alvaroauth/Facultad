
package Parciales.Parcial_Repetido3;

public class PARCIAL_REPETIDO03 {
    public static void main(String[] args) {
        Director dir = new Director (5000000, "Alvaro",46013844,2020,350000);
        Encargado enc1 = new Encargado(10, "Jorge",46013844,1989,100000);
        Encargado enc2 = new Encargado(15, "Angelina",46101764,2005,250000);
        Encargado enc3 = new Encargado(5, "Victor",22928791,2010,220000);
        
        Empresa emp = new Empresa ( "Copetro", " 152 n1051",dir, 3);
        
        emp.agregarEncargado(enc1, 1);
        emp.agregarEncargado(enc2, 2);
        emp.agregarEncargado(enc3, 3);
        
        System.out.println(emp.toString());
    }
}
