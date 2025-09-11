package ParcialesArboles.CaminoPar;

import Practica2.Ejercicio1.BinaryTree;

public class prueba {
	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<>(7);

		// Subárbol izquierdo de 7
		BinaryTree<Integer> nodo56 = new BinaryTree<>(56);
		raiz.addLeftChild(nodo56);

		BinaryTree<Integer> nodo38 = new BinaryTree<>(38);
		nodo56.addLeftChild(nodo38);

		BinaryTree<Integer> nodo87 = new BinaryTree<>(87);
		nodo38.addLeftChild(nodo87);

		BinaryTree<Integer> nodo77 = new BinaryTree<>(77);
		nodo38.addRightChild(nodo77);

		BinaryTree<Integer> nodo16 = new BinaryTree<>(16);
		nodo77.addLeftChild(nodo16);

		BinaryTree<Integer> nodo43 = new BinaryTree<>(43);
		nodo16.addLeftChild(nodo43);

		BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
		BinaryTree<Integer> nodo10 = new BinaryTree<>(10);
		nodo43.addLeftChild(nodo9);
		nodo43.addRightChild(nodo10);

		// Subárbol derecho de 56
		BinaryTree<Integer> nodo31 = new BinaryTree<>(31);
		nodo56.addRightChild(nodo31);

		BinaryTree<Integer> nodo94 = new BinaryTree<>(94);
		nodo31.addRightChild(nodo94);

		BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
		nodo94.addLeftChild(nodo2);

		BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
		nodo2.addRightChild(nodo1);

		// Subárbol derecho de 7
		BinaryTree<Integer> nodo25 = new BinaryTree<>(25);
		raiz.addRightChild(nodo25);

		BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
		nodo25.addLeftChild(nodo5);

		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
		nodo25.addRightChild(nodo6);
		
		caminoPar cp = new caminoPar(raiz);
		
		System.out.println(cp.resolver(2));
	}
}
