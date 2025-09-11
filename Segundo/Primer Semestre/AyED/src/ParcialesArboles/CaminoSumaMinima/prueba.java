package ParcialesArboles.CaminoSumaMinima;

import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(10); // Nivel 0

		GeneralTree<Integer> hijo1 = new GeneralTree<>(20); // Nivel 1
		GeneralTree<Integer> hijo2 = new GeneralTree<>(30);
		GeneralTree<Integer> hijo3 = new GeneralTree<>(40);

		raiz.addChild(hijo1);
		raiz.addChild(hijo2);
		raiz.addChild(hijo3);

		GeneralTree<Integer> nieto1 = new GeneralTree<>(100); // Nivel 2
		GeneralTree<Integer> nieto2 = new GeneralTree<>(110);
		GeneralTree<Integer> nieto3 = new GeneralTree<>(120);

		GeneralTree<Integer> nieto4 = new GeneralTree<>(130);
		GeneralTree<Integer> nieto5 = new GeneralTree<>(140);

		hijo1.addChild(nieto1);
		hijo1.addChild(nieto2);

		hijo2.addChild(nieto3);

		hijo3.addChild(nieto4);
		hijo3.addChild(nieto5);
		
		caminoMinimo cm = new caminoMinimo(raiz);
		
		System.out.println(cm.caminoSumaMinimaRec());
		
		nieto1.addChild(new GeneralTree<>(1000));
		
		System.out.println(cm.caminoSumaMinimaRec());
	}
	
	/*
        10
       / | \
     20 30 40
    / \   \  / \
 100 110 120 130 140

	 */
}
