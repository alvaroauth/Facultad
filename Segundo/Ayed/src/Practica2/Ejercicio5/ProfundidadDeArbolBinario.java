package Practica2.Ejercicio5;

import Practica2.Ejercicio1.BinaryTree;
import java.util.*;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> ab;

	public ProfundidadDeArbolBinario(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public int sumaElementosProfundidad(int p) {
		return (!ab.isEmpty() || p > 0) ? sumaElementosAux(ab, p) : 0;
	}
	
	private int sumaElementosAux(BinaryTree<Integer> a, int p) {
		Queue<BinaryTree<Integer>> cola = new LinkedList<>();
		cola.offer(a);
		int na = 0;
		int suma = 0;
		boolean ok = true;
		while (!cola.isEmpty() && ok) {
			int cant = cola.size();
			if (na == p) {
				for (int i=0;i<cant;i++){
					BinaryTree<Integer> aux = cola.remove();
					suma += aux.getData();
					if(aux.hasLeftChild()) cola.offer(aux.getLeftChild());
					if(aux.hasRightChild()) cola.offer(aux.getRightChild());
				}
				ok = false;
			}
			else {
				for (int i=0;i<cant;i++){
					BinaryTree<Integer> aux = cola.remove();
					if(aux.hasLeftChild()) cola.offer(aux.getLeftChild());
					if(aux.hasRightChild()) cola.offer(aux.getRightChild());
				}
			}
			na++;
		}
		return suma;
	}
}
