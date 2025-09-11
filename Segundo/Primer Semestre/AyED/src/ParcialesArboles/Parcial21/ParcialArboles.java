package ParcialesArboles.Parcial21;

import java.util.*;

import Practica3.Ejercicio1.GeneralTree;
import Practica1.Ejercicio8.Queue;

public class ParcialArboles {
	private GeneralTree<Integer> a;

	public ParcialArboles(GeneralTree<Integer> a) {
		super();
		this.a = a;
	}
	
	public List<Integer> nivel(int num){
		List<Integer> resul = new LinkedList<>();
		boolean ok = true;
		if (a != null && !a.isEmpty()) {
			Queue<GeneralTree<Integer>> cola = new Queue<>();
			
			int nodosEnNivel = 0;
			
			cola.enqueue(a);
			cola.enqueue(null);
			while (!cola.isEmpty() && ok) {
				
				GeneralTree<Integer> nodo = cola.dequeue();
				if (nodo != null) {
					List<GeneralTree<Integer>> lisHijos= nodo.getChildren();
					nodosEnNivel++;
					
					if (lisHijos.size() >= num)
						resul.add(nodo.getData());
					
					for(GeneralTree<Integer> hijo: lisHijos)
						cola.enqueue(hijo);
				}
				else if (!cola.isEmpty()){
					cola.enqueue(null);
					if (resul.size() != nodosEnNivel) {
						nodosEnNivel = 0;
						resul.clear();
					}
					else ok = false;
				}
			}
		}
		return resul;
	}
}
