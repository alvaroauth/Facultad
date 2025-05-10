package ParcialesArboles.ComparadorArboles;

import java.util.Iterator;
import java.util.List;

import Practica3.Ejercicio1.GeneralTree;

public class ComapradorDeArbolesGenerales {
	//
	//
	//
	public static boolean esInferiorProfundo(GeneralTree<Integer> a1, GeneralTree<Integer> a2) {
		
		if (a1 != null && !a1.isEmpty()  && a2 != null && !a2.isEmpty() ) {
			return _esInferiorProfundo(a1, a2);
		}
		return false;
	}
	
	private static boolean _esInferiorProfundo(GeneralTree<Integer> a1, GeneralTree<Integer> a2) {
		boolean cumple = true;
		
		List<GeneralTree<Integer>> lisA1 = a1.getChildren();
		List<GeneralTree<Integer>> lisA2 = a2.getChildren();
		
		if (a1.getData() >= a2.getData()) return  false;
		if (a1.hasChildren() && a2.hasChildren()) {
			int sum1 = 0, sum2 = 0;
			for(GeneralTree<Integer> h1 : lisA1) 
				sum1 += h1.getData();
			for(GeneralTree<Integer> h2 : lisA2) 
				sum2 += h2.getData();
			if (sum1 > sum2) return false;
		}
		else if(!a1.isLeaf() && a2.isLeaf()) return false;
		
		Iterator<GeneralTree<Integer>> it1 = lisA1.iterator();
		Iterator<GeneralTree<Integer>> it2 = lisA2.iterator();
		while (cumple && it2.hasNext() && it1.hasNext()) {
			cumple = _esInferiorProfundo(it1.next(), it2.next());
		}
		
		return cumple;
	}
}
