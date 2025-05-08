package ParcialesArboles.Parcial23;

import Practica2.Ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> ab;

	public ParcialArboles(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public BinaryTree<Integer> nuevoTree(){
		BinaryTree<Integer> nuevoAb = new BinaryTree<Integer>();
		if (ab != null && !ab.isEmpty()) {
			_nuevoTree(ab,nuevoAb, 0);
		}
		return nuevoAb;
	} 
	
	private void _nuevoTree(BinaryTree<Integer> a,BinaryTree<Integer> an, int padre) {
		int aux = a.getData();
		an.setData(aux+padre);
		
		if (a.hasLeftChild()) {
			an.addLeftChild(new BinaryTree<Integer>());
			_nuevoTree(a.getLeftChild(), an.getLeftChild(), aux);
		}
		
		if (a.hasRightChild()) {
			an.addRightChild(new BinaryTree<Integer>());
			_nuevoTree(a.getRightChild(), an.getRightChild(), 0);
		}
	}
}
