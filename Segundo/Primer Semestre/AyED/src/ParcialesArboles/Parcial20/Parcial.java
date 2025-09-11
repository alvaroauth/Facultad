package ParcialesArboles.Parcial20;

import java.util.LinkedList;
import java.util.List;

import Practica3.Ejercicio1.GeneralTree;

public class Parcial {
	private GeneralTree<Integer> ab;

	public Parcial(GeneralTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public List<Integer> resolver(){
		List<Integer> lista = new LinkedList<>();
		if (ab != null && !ab.isEmpty())
			_resolver(ab, lista);
		return lista;
	}
	
	private void _resolver(GeneralTree<Integer> a, List<Integer> lista) {
		if (a.isLeaf() && a.getData() % 2 == 0) {
			lista.add(a.getData());
		}
		else {
			for (GeneralTree<Integer> hijo : a.getChildren())
				_resolver(hijo, lista);
		}	
	}
}
