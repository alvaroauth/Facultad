package ParcialesArboles.ListaDeListas;

import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(4);

		// Hijo 1 del 4 → 2
		GeneralTree<Integer> nodo2 = new GeneralTree<>(2);

		// Hijos de 2 → 6, 3, 9
		nodo2.addChild(new GeneralTree<>(6));
		nodo2.addChild(new GeneralTree<>(3));
		nodo2.addChild(new GeneralTree<>(9));

		// Hijo 2 del 4 → 5
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);

		// Hijo 3 del 4 → -5
		GeneralTree<Integer> nodoMenos5 = new GeneralTree<>(-5);

		// Hijo de -5 → 7
		nodoMenos5.addChild(new GeneralTree<>(7));

		// Agrego los hijos al 4
		raiz.addChild(nodo2);
		raiz.addChild(nodo5);
		raiz.addChild(nodoMenos5);
		
		ParcialArboles pa = new ParcialArboles(raiz);
		
		System.out.println(pa.todosLosCaminosConValoresEntre(1, 6));
	}
}
