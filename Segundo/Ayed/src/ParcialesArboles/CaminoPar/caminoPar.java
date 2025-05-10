package ParcialesArboles.CaminoPar;

import java.util.*;

import Practica2.Ejercicio1.BinaryTree;

public class caminoPar {
	private BinaryTree<Integer> ab;

	public caminoPar(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public List<Integer> resolver (int min){
		List<Integer> resul = new LinkedList<>();
		
		if ( ab != null && !ab.isEmpty())
			_resolver(ab, resul, min, 0);
		
		return resul;
	}
	
	private boolean _resolver(BinaryTree<Integer> a,  List<Integer> aux, int min, int pares) {
		boolean ok = false;
		aux.add(a.getData());
		
		if (a.isLeaf() && pares >= min) {
			return true;
		}
		else {
			if (a.getData() % 2 == 0) pares++;
			if (a.hasLeftChild()) ok = _resolver(a.getLeftChild(), aux, min, pares);
			if (a.hasRightChild() && !ok) ok = _resolver(a.getRightChild(),  aux, min, pares);
		}
		if (!ok) aux.remove(aux.size()-1);
		return ok;
	}
}
