package ParcialesArboles.Parcial01;

import Practica2.Ejercicio1.BinaryTree;

public class Parcial1 {
	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<>(2);

		// Subárbol izquierdo
		BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
		BinaryTree<Integer> nodo23 = new BinaryTree<>(23);
		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
		BinaryTree<Integer> nodoMenos3 = new BinaryTree<>(-3);
		BinaryTree<Integer> nodo55 = new BinaryTree<>(55);
		BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
		BinaryTree<Integer> nodo16 = new BinaryTree<>(16);

		raiz.addLeftChild(nodo7);
		nodo7.addLeftChild(nodo23);
		nodo7.addRightChild(nodo6);

		nodo23.addLeftChild(nodoMenos3);
		nodo6.addRightChild(nodo55);

		nodo55.addLeftChild(nodo9);
		nodo55.addRightChild(nodo16);

		// Subárbol derecho
		BinaryTree<Integer> nodoMenos5 = new BinaryTree<>(-5);
		BinaryTree<Integer> nodo19 = new BinaryTree<>(19);
		BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
		BinaryTree<Integer> nodo18 = new BinaryTree<>(18);
		BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
		BinaryTree<Integer> nodo24 = new BinaryTree<>(24);

		raiz.addRightChild(nodoMenos5);
		nodoMenos5.addLeftChild(nodo19);
		nodoMenos5.addRightChild(nodo4);

		nodo4.addLeftChild(nodo18);
		nodo18.addLeftChild(nodo8);
		nodo18.addRightChild(nodo24);
		
		ParcialArboles pa = new ParcialArboles(raiz);
		
		System.out.println(pa.isTwoTree(2));
		System.out.println();
		System.out.println(pa.isTwoTree(7));
		System.out.println();
		System.out.println(pa.isTwoTree(-3));
		System.out.println();
		System.out.println(pa.isTwoTree(4));
		System.out.println();
		System.out.println(pa.isTwoTree(55));
		System.out.println();
	}
}
