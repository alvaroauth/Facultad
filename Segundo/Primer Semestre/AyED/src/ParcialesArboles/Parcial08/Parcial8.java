package ParcialesArboles.Parcial08;

import Practica2.Ejercicio1.BinaryTree;

public class Parcial8 {
	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<>(2);

		BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
		BinaryTree<Integer> nodo5_izq = new BinaryTree<>(5);
		raiz.addLeftChild(nodo7);
		raiz.addRightChild(nodo5_izq);

		BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
		nodo7.addLeftChild(nodo2);

		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
		nodo7.addRightChild(nodo6);

		BinaryTree<Integer> nodo5_abajo = new BinaryTree<>(5);
		BinaryTree<Integer> nodo11 = new BinaryTree<>(11);
		nodo6.addLeftChild(nodo5_abajo);
		nodo6.addRightChild(nodo11);

		BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
		nodo5_izq.addRightChild(nodo9);

		BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
		nodo9.addRightChild(nodo4);
		
		NivelArbol na = new NivelArbol(raiz);
		
		System.out.println(na.minEnNivelAB(0).getData());
	}
}
