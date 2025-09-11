package ParcialesArboles.Parcial19;

import Practica3.Ejercicio1.GeneralTree;

public class Parcial19 {
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(-2);

		// Hijos de -2
		GeneralTree<Integer> nodoMenos7 = new GeneralTree<>(-7);
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
		raiz.addChild(nodoMenos7);
		raiz.addChild(nodo5);
		raiz.addChild(nodo4);

		// Hijos de -7
		nodoMenos7.addChild(new GeneralTree<>(2));
		nodoMenos7.addChild(new GeneralTree<>(6));

		// Hijo de 5
		nodo5.addChild(new GeneralTree<>(-3));

		// Hijos de 4
		nodo4.addChild(new GeneralTree<>(11));
		nodo4.addChild(new GeneralTree<>(-9));
		nodo4.addChild(new GeneralTree<>(10));
		
		System.out.println(Parcial.resolver(5, 10, raiz));
		System.out.println(Parcial.resolver(20, 100, raiz));
		System.out.println(Parcial.resolver(-9, 20, raiz));
	}
}
