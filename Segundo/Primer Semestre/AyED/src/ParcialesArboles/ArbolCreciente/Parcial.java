package ParcialesArboles.ArbolCreciente;

import Practica1.Ejercicio8.Queue;
import Practica3.Ejercicio1.GeneralTree;

public class Parcial {
	public static boolean esArbolCreciente(GeneralTree<Integer> a) {
		if (a == null || a.isEmpty()) return false;
		
		boolean cumple = true;
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		
		int nodosEnNivel = 0, nivel = 0;
		cola.enqueue(a);
		cola.enqueue(null);
		
		while (!cola.isEmpty() && cumple) {
			
			GeneralTree<Integer> nodo = cola.dequeue();
			if (nodo != null) {
				nodosEnNivel++;
				//System.out.println("nodo: "+nodo.getData());
				for (GeneralTree<Integer> h : nodo.getChildren())
					cola.enqueue(h);
			}
			else if (!cola.isEmpty()) {
				cola.enqueue(null);
				//System.out.println(nodosEnNivel+" "+(nivel+1));
				cumple = nodosEnNivel == nivel+1;
				nivel++;
				nodosEnNivel = 0;
			}
		}
		System.out.println(nodosEnNivel+" "+(nivel+1));
		if (nodosEnNivel == nivel+1)
			return cumple;
		else
			return false;
	
	
	}
}
