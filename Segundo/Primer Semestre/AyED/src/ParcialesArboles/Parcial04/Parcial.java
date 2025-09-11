package ParcialesArboles.Parcial04;

import java.util.LinkedList;
import java.util.Queue;

import Practica3.Ejercicio1.GeneralTree;

public class Parcial {
	public static boolean esDeSeleccion(GeneralTree<Integer> a)  {
		if (a != null && !a.isEmpty())
			return _esDeSeleccion(a, a.getData());
		return false;
	}
	
	private static boolean _esDeSeleccion(GeneralTree<Integer> a, int padre) {
		Queue<GeneralTree<Integer>> cola = new LinkedList<>();
		boolean ok = true;
		cola.add(a);
		
		while (!cola.isEmpty()) {
			int cantNodos = cola.size();
			 for (int i = 0 ; i < cantNodos ; i++) {
				 GeneralTree<Integer> nodo = cola.remove();
				 int min = Integer.MAX_VALUE;
				 for (GeneralTree<Integer> h : nodo.getChildren()) {
					 min = Math.min(h.getData(), min);
					 cola.add(h);
				 }
				 if (!nodo.isLeaf() && nodo.getData() != min) ok = false;
				 
			 }
		}
		return ok;
	}
	
	
}
