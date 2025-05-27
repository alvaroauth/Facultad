package ParcialesArboles.Caudal;

import java.util.List;

import Practica3.Ejercicio1.GeneralTree;

public class Parcial {
	private GeneralTree<Character> a;

	public Parcial(GeneralTree<Character> a) {
		super();
		this.a = a;
	}
	
	public double minCaudal(double caudal) {
		if (a != null && !a.isEmpty())
			return _minCaudal(a, caudal);
		return -1;
	}
	
	private double _minCaudal(GeneralTree<Character> a, double caudal) {
		double min = Integer.MAX_VALUE;
		
		if (a.isLeaf())
			return caudal;
		
		List<GeneralTree<Character>> hijos = a.getChildren();
		
		caudal = caudal/hijos.size();
		for(GeneralTree<Character> h : hijos) 
			min = Math.min(min, _minCaudal(h, caudal));
		
		return min;
	}
}
