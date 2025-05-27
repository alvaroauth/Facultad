
package Parciales.Parcial15;

public class PARCIAL15 {
    public static void main(String[] args) {
        Sala sal = new Sala(4);
        
        PC pc1 = new PC(1200);
        PC pc2 = new PC(12);
        PC pc3 = new PC(600);
        PC pc4 = new PC(700);
        
        sal.agregarPC(1, pc1);
        sal.agregarPC(2, pc2);
        sal.agregarPC(3, pc3);
        sal.agregarPC(4, pc4);
        
        sal.encenderPc();
        sal.encenderPc();
        
        System.out.println(sal.toString());
    }
}
