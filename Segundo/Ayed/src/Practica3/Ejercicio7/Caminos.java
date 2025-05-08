package Practica3.Ejercicio7;

import Practica3.Ejercicio1.GeneralTree;
import java.util.*;

public class Caminos {
	
	private GeneralTree<Integer> ab;

	public Caminos(GeneralTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public Caminos() {}
	
	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> camino = new LinkedList<>();
		List<Integer> maximo = new LinkedList<>();
		if (ab != null && !ab.isEmpty())
			_caminoAHojaMasLejana(this.ab, camino, maximo);
		
		return maximo;
	}
	
	private void _caminoAHojaMasLejana(GeneralTree<Integer> a, List<Integer> c, List<Integer> max) {
		c.add(a.getData());
		if (a.isLeaf() && c.size() > max.size()) {
			max.removeAll(max);
			max.addAll(c);
		}
		else{
			for (GeneralTree<Integer> hijo : a.getChildren())
				_caminoAHojaMasLejana(hijo, c, max);
		}
		c.remove(c.size()-1);
	}
	
}
