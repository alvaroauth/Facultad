package Practica3.Ejercicio6;

import Practica3.Ejercicio1.GeneralTree;

public class RedDeAguaPotable {
	
	private GeneralTree<Character> ab;

	public RedDeAguaPotable(GeneralTree<Character> ab) {
		super();
		this.ab = ab;
	}
	
	public RedDeAguaPotable() {}
	
	public double minimoCaudal(double caudal) {
		if (ab != null && !ab.isEmpty())
			return _minimoCaudal(ab, caudal);
		return -1;
	}
	private double _minimoCaudal(GeneralTree<Character> a, double caudal) {
		if (a.isLeaf())
			return caudal;
		
		double caudalAux = caudal / a.getChildren().size();
		double min = Double.MAX_VALUE;
		
		for (GeneralTree<Character> hijo : a.getChildren()) 
			min = Math.min(min, _minimoCaudal(hijo, caudalAux));
		
		return min;
	}
	
}
