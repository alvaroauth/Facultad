package ParcialesArboles.Parcial07;

import java.util.*;
import Practica3.Ejercicio1.GeneralTree;

public class Parcial {
	
	public static List<List<Character>> caminosPares(GeneralTree<Character> a){
		List<List<Character>> l2 = new LinkedList<>();
		
		if (a != null && !a.isEmpty()) {
			List<Character> l = new LinkedList<>();
			_caminosPares(a, l2, l, 0);
		}
		return l2;
	}
	
	private static void _caminosPares(GeneralTree<Character> a, List<List<Character>> l2, List<Character> l, int cant) {
		cant++;
		l.add(a.getData());
		
		if (a.isLeaf() && cant % 2 == 0)
			l2.add(new LinkedList(l));
		else 
		{
			for (GeneralTree<Character> hijo : a.getChildren())
				_caminosPares(hijo, l2, l, cant);
		}
		
		l.remove(l.size()-1);
	}
}
