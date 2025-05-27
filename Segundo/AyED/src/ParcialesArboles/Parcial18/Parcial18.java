package ParcialesArboles.Parcial18;

import Practica3.Ejercicio1.GeneralTree;

public class Parcial18 {
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(-2);

		// Nivel 1
		GeneralTree<Integer> nodoMenos7 = new GeneralTree<>(-7);
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
		raiz.addChild(nodoMenos7);
		raiz.addChild(nodo5);
		raiz.addChild(nodo4);

		// Nivel 2
		GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
		GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
		nodoMenos7.addChild(nodo2);
		nodoMenos7.addChild(nodo6);

		GeneralTree<Integer> nodoMenos3 = new GeneralTree<>(-3);
		nodo5.addChild(nodoMenos3);

		GeneralTree<Integer> nodo11 = new GeneralTree<>(11);
		GeneralTree<Integer> nodoMenos9 = new GeneralTree<>(-9);
		GeneralTree<Integer> nodo10 = new GeneralTree<>(10);
		nodo4.addChild(nodo11);
		nodo4.addChild(nodoMenos9);
		nodo4.addChild(nodo10);
		
		Parcial p = new Parcial(raiz);
		
		System.out.println(p.resolver(-10));
	}
}
