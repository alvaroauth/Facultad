package ParcialesArboles.NuevoTree;

import Practica2.Ejercicio1.BinaryTree;

public class prueba {
	public static void main(String[] args) {
		BinaryTree<Integer> root = new BinaryTree<>(1);

		// Nodo 2 y 3 son hijos de 1
		BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
		BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
		root.addLeftChild(nodo2);
		root.addRightChild(nodo3);

		// Hijo izquierdo de 2 → 4
		BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
		nodo2.addLeftChild(nodo4);

		// Hijos de 3 → 5 (izq), 6 (der)
		BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
		nodo3.addLeftChild(nodo5);
		nodo3.addRightChild(nodo6);

		// Hijo izquierdo de 5 → 7
		BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
		nodo5.addLeftChild(nodo7);
		
		ParcialArboles pa = new ParcialArboles(root);
		
		root.entreNiveles(0, 5);
		
		pa.nuevoTree().entreNiveles(0, 5);
	}
}
