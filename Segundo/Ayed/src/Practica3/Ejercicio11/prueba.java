package Practica3.Ejercicio11;

import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(2);

		// Subárbol izquierdo (hijos de 2)
		GeneralTree<Integer> nodo1 = new GeneralTree<>(1);
		GeneralTree<Integer> nodo25 = new GeneralTree<>(25);
		raiz.addChild(nodo1);
		raiz.addChild(nodo25);

		// Hijo de 25
		nodo25.addChild(new GeneralTree<>(13));

		// Hijos de 1
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
		nodo1.addChild(nodo5);
		nodo1.addChild(nodo4);

		// Hijo de 5
		GeneralTree<Integer> nodo18 = new GeneralTree<>(18);
		nodo5.addChild(nodo18);

		// Hijo de 18
		nodo18.addChild(new GeneralTree<>(83));

		// Hijos de 4
		nodo4.addChild(new GeneralTree<>(7));
		nodo4.addChild(new GeneralTree<>(11));

		GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
		nodo4.addChild(nodo3);

		// Hijos de 3
		nodo3.addChild(new GeneralTree<>(33));
		nodo3.addChild(new GeneralTree<>(12));
		nodo3.addChild(new GeneralTree<>(17));
		nodo3.addChild(new GeneralTree<>(9));
		
		System.out.println(ParcialArboles.resolver(raiz));
		
		// ------------------------------------------------------------------------------------- //
		
		GeneralTree<Integer> Fraiz = new GeneralTree<>(2);

		// Subárbol izquierdo (hijos de 2)
		GeneralTree<Integer> Fnodo1 = new GeneralTree<>(1);
		GeneralTree<Integer> Fnodo25 = new GeneralTree<>(25);
		Fraiz.addChild(Fnodo1);
		Fraiz.addChild(Fnodo25);

		// Hijo de 25
		Fnodo25.addChild(new GeneralTree<>(13));

		// Hijos de 1
		GeneralTree<Integer> Fnodo5 = new GeneralTree<>(5);
		GeneralTree<Integer> Fnodo4 = new GeneralTree<>(4);
		Fnodo1.addChild(Fnodo5);
		Fnodo1.addChild(Fnodo4);

		// Hijo de 5
		GeneralTree<Integer> Fnodo18 = new GeneralTree<>(18);
		Fnodo5.addChild(Fnodo18);

		// Hijo de 18
		Fnodo18.addChild(new GeneralTree<>(83));

		// Hijos de 4
		Fnodo4.addChild(new GeneralTree<>(7));

		GeneralTree<Integer> Fnodo3 = new GeneralTree<>(3);
		Fnodo4.addChild(Fnodo3);

		// Hijos de 3
		Fnodo3.addChild(new GeneralTree<>(33));
		Fnodo3.addChild(new GeneralTree<>(12));
		Fnodo3.addChild(new GeneralTree<>(17));
		Fnodo3.addChild(new GeneralTree<>(9));
		
		System.out.println(ParcialArboles.resolver(Fraiz));
	}
}
