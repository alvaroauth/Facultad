
package Parciales.Parcial_Repetido1;

public class PARCIAL_REPETIDO_1 {
    public static void main(String[] args) {
        Funcion fun = new Funcion("La bohemiere","180/08/2004","20:30",5,6);
        
        fun.ocuparButaca( 1, 1);
        fun.ocuparButaca( 1, 2);
        fun.ocuparButaca( 2, 2);
        fun.ocuparButaca( 4, 2);
        fun.ocuparButaca( 4, 4);
        fun.ocuparButaca( 5, 3);
        fun.ocuparButaca( 5, 6);
        
        System.out.println(fun.toString());
        
        //fun.desocuparButacas(4);
        
        
        System.out.println(fun.stringButaca(2));
        
        
    }
}
