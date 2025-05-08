package ParcialesArboles.Parcial04;

import Practica3.Ejercicio1.GeneralTree;

/*

Implemente en la clase Parcial el método:

esDeSeleccion (ArbolGeneral<Integer> arbol): boolean que devuelve true si el árbol es de selección, false si no lo es.

Un árbol general es de selección si cada nodo tiene en su raíz el valor del menor de sus hijos.

 */
public class Parcial4 {
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(2);

		GeneralTree<Integer> nodo3 = new GeneralTree<>(2);
		GeneralTree<Integer> nodo4 = new GeneralTree<>(6);
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);

		nodo3.addChild(new GeneralTree<>(2)); // hoja
		nodo3.addChild(new GeneralTree<>(7)); // hoja

		nodo4.addChild(new GeneralTree<>(6)); // hoja
		nodo4.addChild(new GeneralTree<>(8)); // hoja

		nodo5.addChild(new GeneralTree<>(5)); // hoja

		raiz.addChild(nodo3); // hijo con valor 4
		raiz.addChild(nodo4); // hijo con valor 6
		raiz.addChild(nodo5); // hijo con valor 5
		
		System.out.println(Parcial.esDeSeleccion(raiz));
	}
}
