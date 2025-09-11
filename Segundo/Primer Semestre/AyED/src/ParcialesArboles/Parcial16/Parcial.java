package ParcialesArboles.Parcial16;

import Practica3.Ejercicio1.GeneralTree;
import java.util.*;

public class Parcial {
	public int resolver(GeneralTree<Integer> a) {
		if (a != null && !a.isEmpty()) {
			return _resolver(a);
		}
		return -1;
	}
	
	private int _resolver(GeneralTree<Integer> a) {
		Queue<GeneralTree<Integer>> cola = new LinkedList<>();
		GeneralTree<Integer> nodo;
		int producto = 1, cantNodos;
		cola.add(a);
		
		while (!cola.isEmpty()) {
			producto = 1;
			cantNodos = cola.size();
			for (int i = 0 ; i < cantNodos ; i++) {
				nodo = cola.remove();
				producto = producto * nodo.getData();
				
				List<GeneralTree<Integer>> hijos = nodo.getChildren();
				
				for(GeneralTree<Integer> hijo : hijos)
					cola.add(hijo);
			}
		}
		return producto;
	}
}
