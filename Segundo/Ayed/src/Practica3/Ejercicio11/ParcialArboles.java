package Practica3.Ejercicio11;

import Practica3.Ejercicio1.GeneralTree;
import Practica1.Ejercicio8.Queue;

public class ParcialArboles {
	
	public static boolean resolver(GeneralTree<Integer> a) {
		if (a == null || a.isEmpty()) 
			return false;
		
		boolean cumple = true;
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		int nodosEnNivel = 0, nivel = 0;
		
		cola.enqueue(a);
		cola.enqueue(null);
			
		while (!cola.isEmpty() && cumple) {
			GeneralTree<Integer> nodo = cola.dequeue();
			if (nodo != null) {
				nodosEnNivel++;
				for (GeneralTree<Integer> hijo : nodo.getChildren())
					cola.enqueue(hijo);
			}
			else if (!cola.isEmpty()) {
				nivel++;
				
				if (nivel != nodosEnNivel)
					cumple = false;
				
				nodosEnNivel = 0;
				cola.enqueue(null);
			}
		}
		return cumple;
	}
}
