package ParcialesArboles.Parcial01;

import Practica2.Ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> ab;

	public ParcialArboles(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public boolean isTwoTree(int num) {
		BinaryTree<Integer> arb = buscarNodo(ab, num);
        return (arb != null && !arb.isEmpty()) ? _isTwoTree(arb) : false;
	}
	
	private boolean _isTwoTree(BinaryTree<Integer> a) {
		int cantDer = -1;
		int cantIzq = -1;
		if (a.hasLeftChild()) cantIzq = cant2Hijos(a.getLeftChild());
		if (a.hasRightChild()) cantDer = cant2Hijos(a.getRightChild());
		return cantDer == cantIzq;
	}
	
	private int cant2Hijos (BinaryTree<Integer> a) {
		int cant = 0;
		if (a.hasLeftChild() && a.hasRightChild())
			cant++;
		if (a.hasLeftChild()) cant += cant2Hijos(a.getLeftChild());
		if (a.hasRightChild()) cant += cant2Hijos(a.getRightChild());
		return cant;
	}
	
	private BinaryTree<Integer> buscarNodo(BinaryTree<Integer> a, int num) {
		if (a.getData().equals(num))
			return a;
		BinaryTree<Integer> nodo = null;
		if (a.hasLeftChild()) nodo = buscarNodo(a.getLeftChild(), num);
		if (a.hasRightChild() && nodo == null) nodo = buscarNodo(a.getRightChild(), num);
		return nodo;
	}
}
