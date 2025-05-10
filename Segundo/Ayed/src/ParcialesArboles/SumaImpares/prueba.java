package ParcialesArboles.SumaImpares;

import Practica2.Ejercicio1.BinaryTree;

public class prueba {
	public static void main(String[] args) {
		BinaryTree<Integer> root = new BinaryTree<>(7);

		// Hijos de 7
		BinaryTree<Integer> nodo56 = new BinaryTree<>(56);
		BinaryTree<Integer> nodo25 = new BinaryTree<>(25);
		root.addLeftChild(nodo56);
		root.addRightChild(nodo25);

		// Hijos de 56
		BinaryTree<Integer> nodo38 = new BinaryTree<>(38);
		BinaryTree<Integer> nodo31 = new BinaryTree<>(31);
		nodo56.addLeftChild(nodo38);
		nodo56.addRightChild(nodo31);

		// Hijos de 38
		BinaryTree<Integer> nodo87 = new BinaryTree<>(87);
		BinaryTree<Integer> nodo77 = new BinaryTree<>(77);
		nodo38.addLeftChild(nodo87);
		nodo38.addRightChild(nodo77);

		// Hijo izquierdo de 77 → 16
		BinaryTree<Integer> nodo16 = new BinaryTree<>(16);
		nodo77.addLeftChild(nodo16);

		// Hijo derecho de 31 → 94
		BinaryTree<Integer> nodo94 = new BinaryTree<>(94);
		nodo31.addRightChild(nodo94);

		// Hijo izquierdo de 94 → 2
		BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
		nodo94.addLeftChild(nodo2);

		// Hijo izquierdo de 2 → 1
		BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
		nodo2.addLeftChild(nodo1);

		// Hijo izquierdo de 16 → 43
		BinaryTree<Integer> nodo43 = new BinaryTree<>(43);
		nodo16.addLeftChild(nodo43);

		// Hijos de 43 → 9 (izq) y 10 (der)
		BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
		BinaryTree<Integer> nodo10 = new BinaryTree<>(10);
		nodo43.addLeftChild(nodo9);
		nodo43.addRightChild(nodo10);

		// Hijos de 25 → 5 (izq) y 6 (der)
		BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
		nodo25.addLeftChild(nodo5);
		nodo25.addRightChild(nodo6);
		
		Parcial p = new Parcial(root);
		
		System.out.println(p.sumaImparesPosOrdenMayorA(30));
	}
}
