package ParcialesArboles.SumaImpares;

import Practica2.Ejercicio1.BinaryTree;

public class Parcial {
	private BinaryTree<Integer> ab;

	public Parcial(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public int  sumaImparesPosOrdenMayorA (int num) {
		if (ab != null && !ab.isEmpty())
			return _sumaImparesPosOrdenMayorA(ab, num);
		return -1;
	}
	
	private int _sumaImparesPosOrdenMayorA(BinaryTree<Integer> a, int num) {
		int cant = 0;
		
		if (a.getData() % 2 != 0 && a.getData() > num) cant += a.getData();
		
		if (a.hasLeftChild()) cant += _sumaImparesPosOrdenMayorA(a.getLeftChild(), num);
		
		if (a.hasRightChild()) cant += _sumaImparesPosOrdenMayorA(a.getRightChild(), num);
		
		return cant;
	}
}
