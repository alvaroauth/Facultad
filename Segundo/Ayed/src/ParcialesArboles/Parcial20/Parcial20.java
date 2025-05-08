package ParcialesArboles.Parcial20;

import Practica3.Ejercicio1.GeneralTree;

/*

Implemente en la clase Parcial que tiene como variable de instancia un ArbolGeneral<Integer>, el método:

ListaEnlazadaGenerica<Integer> resolver()

Que retorna una lista con los elementos de la frontera del árbol con valor par.

Se define como frontera de un árbol general, a las hojas del árbol recorridas de izquierda a derecha.

*/

public class Parcial20 {
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(12);

		// Nivel 1
		GeneralTree<Integer> nodo17 = new GeneralTree<>(17);
		GeneralTree<Integer> nodo9 = new GeneralTree<>(9);
		GeneralTree<Integer> nodo15 = new GeneralTree<>(15);
		raiz.addChild(nodo17);
		raiz.addChild(nodo9);
		raiz.addChild(nodo15);

		// Nivel 2
		GeneralTree<Integer> nodo10 = new GeneralTree<>(10);
		GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
		nodo17.addChild(nodo10);
		nodo17.addChild(nodo6);

		GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
		nodo9.addChild(nodo8);

		GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
		nodo15.addChild(nodo4);

		// Nivel 3
		GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
		GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
		GeneralTree<Integer> nodo13 = new GeneralTree<>(13);
		nodo10.addChild(nodo3);
		nodo10.addChild(nodo2);
		nodo10.addChild(nodo13);

		GeneralTree<Integer> nodo1 = new GeneralTree<>(1);
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		nodo8.addChild(nodo1);
		nodo8.addChild(nodo5);
		
		Parcial p = new Parcial(raiz);
		System.out.println(p.resolver());
	}
}
