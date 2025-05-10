package ParcialesArboles.CaminoSumaMinima;

import java.util.*;

import Practica3.Ejercicio1.GeneralTree;

public class caminoMinimo {
	private GeneralTree<Integer> a;

	public caminoMinimo(GeneralTree<Integer> a) {
		super();
		this.a = a;
	}
	
	public List<Integer> caminoSumaMinimaRec() {
		List<Integer> resul = new LinkedList<>();
		
		if (a != null && !a.isEmpty()) {
			_caminoSumaMinimaRec(a, resul, new LinkedList<>(), 0, Integer.MAX_VALUE);
		}
		
		return resul;
	}
	
	private int _caminoSumaMinimaRec(GeneralTree<Integer> a, List<Integer> resul, List<Integer> aux, int suma, int min) {
		aux.add(a.getData());
		suma += a.getData();
		if (a.isLeaf() && suma < min) {
			resul.clear();
			resul.addAll(aux);
			min = suma;
		}
		
		else {
			for (GeneralTree<Integer> hijo : a.getChildren())
				 min = _caminoSumaMinimaRec(hijo, resul, aux, suma, min);
		}
		aux.remove(aux.size()-1);
		return min;
	}
}
