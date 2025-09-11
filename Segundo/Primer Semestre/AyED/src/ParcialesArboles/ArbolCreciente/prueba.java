package ParcialesArboles.ArbolCreciente;

import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(2);

		// Hijos de 2
		GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		raiz.addChild(nodo7);
		raiz.addChild(nodo5);

		// Hijos de 7
		GeneralTree<Integer> nodo2b = new GeneralTree<>(2);
		GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
		nodo7.addChild(nodo2b);
		nodo7.addChild(nodo6);

		// Hijos de 5
		GeneralTree<Integer> nodo9 = new GeneralTree<>(9);
		nodo5.addChild(nodo9);

		// Hijos de 6
		GeneralTree<Integer> nodo5b = new GeneralTree<>(5);
		GeneralTree<Integer> nodo11 = new GeneralTree<>(11);
		nodo6.addChild(nodo5b);
		nodo6.addChild(nodo11);

		// Hijos de 9
		GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
		nodo9.addChild(nodo4);
		
		raiz.imprimirPorNiveles();
		System.out.println(Parcial.esArbolCreciente(raiz));
		
	}
}
