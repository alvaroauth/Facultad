package ParcialesArboles.NuevoTree;

import Practica2.Ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> ab;

	public ParcialArboles(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public BinaryTree<Integer> nuevoTree(){
		
		if (ab != null && !ab.isEmpty())
			return _nuevoTree(ab, 0);
		return null;
	}
	
	private BinaryTree<Integer> _nuevoTree(BinaryTree<Integer> a, int padre){
		BinaryTree<Integer> nuevo = new BinaryTree<>(a.getData() + padre);

		if (a.hasLeftChild())
			nuevo.addLeftChild(_nuevoTree(a.getLeftChild(), a.getData()));
			
		if (a.hasRightChild()) 
			nuevo.addRightChild(_nuevoTree(a.getRightChild(), 0));
			
		
		return nuevo;
	}
}
