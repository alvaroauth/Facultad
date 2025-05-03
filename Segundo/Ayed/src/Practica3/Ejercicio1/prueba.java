package Practica3.Ejercicio1;

public class prueba {
	public static void main(String[] args) {
	    // Se instancia el siguiente ejemplo:
	    //
	    //         4
	    //      /  |   \
	    //     2  83    7
	    //       / | \    \
	    //     61  3 -9     5
		//    /
		//  123
		
	    GeneralTree<Integer> arbol  = new GeneralTree<Integer>(4);
	    GeneralTree<Integer> arbolB = new GeneralTree<Integer>(2);
	    GeneralTree<Integer> arbolC = new GeneralTree<Integer>(83);
	    GeneralTree<Integer> arbolD = new GeneralTree<Integer>(7);
	    GeneralTree<Integer> arbolE = new GeneralTree<Integer>(61);
	    GeneralTree<Integer> arbolF = new GeneralTree<Integer>(3);
	    GeneralTree<Integer> arbolG = new GeneralTree<Integer>(-9);
	    GeneralTree<Integer> arbolH = new GeneralTree<Integer>(5);
	    GeneralTree<Integer> arbolI = new GeneralTree<Integer>(123);

	    // Se agrega el 123
	    arbolE.addChild(arbolI);
	    // Se agregan los hijos al nodo 83
	    arbolC.addChild(arbolE);
	    arbolC.addChild(arbolF);
	    arbolC.addChild(arbolG);

	    // El 5 es hijo del 7, no del 83
	    arbolD.addChild(arbolH);

	    // Se agregan los hijos al nodo 4
	    arbol.addChild(arbolB);
	    arbol.addChild(arbolC);
	    arbol.addChild(arbolD);
	    
	    System.out.println("Ancho: "+arbol.ancho());
	    
	    System.out.println("Raiz: "+arbol.nivel(4));
	    
	    System.out.println("Nodo 83: "+arbol.nivel(83));
	    
	    System.out.println("Nodo 61: "+arbol.nivel(61));
	    
	    System.out.println("Nodo 123: "+arbol.nivel(123));
	    
	    System.out.println("Nodo 999 (no existe): "+arbol.nivel(999));
	}
}
