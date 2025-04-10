package Practica2.Ejercicio7;

import Practica2.Ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> ab;

	public ParcialArboles(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public void imprimirArbol() {
	   	if(!ab.isEmpty()) {
	   		if (ab.hasLeftChild())
	   			ab.getLeftChild().imprimirInOrden();
	   		System.out.println(ab.getData());
    		if (ab.hasRightChild())
    			ab.getRightChild().imprimirInOrden();
	    }
	}
	
	public boolean isLeftTree (int num){
		if (ab.isEmpty())
			return false;
		else {
			if (ab.hasLeftChild())
				return hijosIzquierdaDerecha(buscarNodo(ab, num));
			else 
				return false;
		}
	}
		
	
	private boolean hasOneChild(BinaryTree<Integer> a) {
		return ((a.hasLeftChild() && !a.hasRightChild())||(!a.hasLeftChild() && a.hasRightChild()));
	}
	
	private int cantHijosCumple(BinaryTree<Integer> a) {
		int cont = 0;
		if(a.hasLeftChild())
			cont += cantHijosCumple(a.getLeftChild());
		if (this.hasOneChild(a))
			cont++;
		if(a.hasRightChild())
			cont += cantHijosCumple(a.getRightChild());
		return cont;	
	}
	
	private boolean hijosIzquierdaDerecha(BinaryTree<Integer> a) {
		int i = 0, d = 0;
		if (a.hasLeftChild())
			i = this.cantHijosCumple(a.getLeftChild());
		if (a.hasRightChild())
			d = this.cantHijosCumple(a.getRightChild());
		return i>d;
	}
	
	
	private BinaryTree<Integer> buscarNodo(BinaryTree<Integer> aux, int n){
		BinaryTree<Integer> a = new BinaryTree<Integer>();
		if (aux.hasLeftChild())
			a = buscarNodo(aux.getLeftChild(), n);
		if (aux.getData() == n)
			return aux;
		if (aux.hasRightChild() && a.isEmpty())
			a = buscarNodo(aux.getRightChild(), n);
		return a;
	}
	
	
}
