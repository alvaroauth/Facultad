package ParcialesArboles.Parcial03;

import java.util.LinkedList;
import java.util.List;

import Practica2.Ejercicio1.BinaryTree;

public class ProcesadorDeArbol {
	private BinaryTree<Integer> ab;
	
	
	
	public ProcesadorDeArbol(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}

	public ClaseAux procesar() {
		int cant = 0;
		List<BinaryTree<Integer>> lista = new LinkedList<>();
		if (ab != null && !ab.isEmpty()) cant  = _procesar(ab, lista);
		return new ClaseAux(lista, cant);
	}
	
	private int _procesar(BinaryTree<Integer> a, List<BinaryTree<Integer>> lista) {
		int dato = a.getData();
		int cant = 0;
		if (dato % 2 == 0) {
			cant++;
			if (a.hasLeftChild() && ab.hasRightChild())
				lista.add(a);
		}
		if (a.hasLeftChild()) cant += _procesar(a.getLeftChild(), lista);
		if (a.hasRightChild()) cant += _procesar(a.getRightChild(), lista);
		return cant;
	}
}
