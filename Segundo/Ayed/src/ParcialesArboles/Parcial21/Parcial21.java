package ParcialesArboles.Parcial21;

import Practica3.Ejercicio1.GeneralTree;

public class Parcial21 {
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(10);

		// Nivel 1
		GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
		GeneralTree<Integer> nodoMenos5 = new GeneralTree<>(-5);
		raiz.addChild(nodo8);
		raiz.addChild(nodoMenos5);

		// Nivel 2
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		GeneralTree<Integer> nodo22 = new GeneralTree<>(22);
		nodo8.addChild(nodo5);
		nodo8.addChild(nodo22);

		GeneralTree<Integer> nodo19 = new GeneralTree<>(19);
		nodoMenos5.addChild(nodo19);

		// Nivel 3
		GeneralTree<Integer> nodoMenos6 = new GeneralTree<>(-6);
		GeneralTree<Integer> nodo2_1 = new GeneralTree<>(2);
		GeneralTree<Integer> nodo8_1 = new GeneralTree<>(8);
		nodo5.addChild(nodoMenos6);
		nodo5.addChild(nodo2_1);
		nodo5.addChild(nodo8_1);

		GeneralTree<Integer> nodo28 = new GeneralTree<>(28);
		GeneralTree<Integer> nodo55 = new GeneralTree<>(55);
		GeneralTree<Integer> nodo18 = new GeneralTree<>(18);
		nodo22.addChild(nodo28);
		nodo22.addChild(nodo55);
		nodo22.addChild(nodo18);

		GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
		GeneralTree<Integer> nodo2_2 = new GeneralTree<>(2);
		GeneralTree<Integer> nodo8_2 = new GeneralTree<>(8);
		nodo19.addChild(nodo4);
		nodo19.addChild(nodo2_2);
		nodo19.addChild(nodo8_2);
		
		ParcialArboles p = new ParcialArboles(raiz);
		
		System.out.println(p.nivel(2));
		
	}
}
