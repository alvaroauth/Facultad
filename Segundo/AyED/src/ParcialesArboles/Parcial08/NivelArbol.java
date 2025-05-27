package ParcialesArboles.Parcial08;

import Practica2.Ejercicio1.BinaryTree;
import Practica1.Ejercicio8.Queue;

public class NivelArbol {
	private BinaryTree<Integer> ab;

	public NivelArbol(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public BinaryTree<Integer> minEnNivelAB(int n){
		BinaryTree<Integer> min = new BinaryTree<>(Integer.MAX_VALUE);
		
		if (ab != null && !ab.isEmpty()) {
			Queue<BinaryTree<Integer>> cola = new Queue<>();
			int nivel = 0;
			
			cola.enqueue(ab);
			cola.enqueue(null);
			
			while (!cola.isEmpty()) {
				BinaryTree<Integer> aux = cola.dequeue();
				if (aux != null) {
					if ( n == nivel && aux.getData() < min.getData())
						min = aux;
					if (aux.hasLeftChild()) cola.enqueue(aux.getLeftChild());
					if (aux.hasRightChild()) cola.enqueue(aux.getRightChild());
				}
				else if (!cola.isEmpty()) {
					cola.enqueue(null);
					nivel++;
				}
			}
		}
		if (min.getData() != Integer.MAX_VALUE) return min;
		return new BinaryTree<>();
	}
}
