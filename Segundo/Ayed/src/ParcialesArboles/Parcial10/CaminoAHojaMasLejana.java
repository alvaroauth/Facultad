package ParcialesArboles.Parcial10;

import java.util.*;
import Practica3.Ejercicio1.GeneralTree;

public class CaminoAHojaMasLejana {
	
	
	public static List<Integer> caminoMasLargo(GeneralTree<Integer> ab) {
        List<Integer> lisMax = new LinkedList<Integer>();
        if(!ab.isEmpty()) {
            _caminoMasLargo(ab, lisMax, new LinkedList<Integer>());
        }
        return lisMax;
    }
	
	private static void _caminoMasLargo(GeneralTree<Integer> ab, List<Integer> max, List<Integer> lista) {
		lista.add(ab.getData());
		if (ab.isLeaf() && (lista.size() > max.size())) {
			max.removeAll(max);
			max.addAll(lista);
		}
		else
			for (GeneralTree<Integer> hijo : ab.getChildren()) {
				_caminoMasLargo(hijo, max, lista);
		lista.remove(lista.size()-1);
		}
	}
	
}
