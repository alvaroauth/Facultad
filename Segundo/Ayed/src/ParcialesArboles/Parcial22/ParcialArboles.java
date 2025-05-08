package ParcialesArboles.Parcial22;

import java.util.*;

import Practica3.Ejercicio1.GeneralTree;

public class ParcialArboles {
	private GeneralTree<Integer> a;

	public ParcialArboles(GeneralTree<Integer> a) {
		super();
		this.a = a;
	}
	
	public List<Integer> camino (int num){
		List<Integer> resul = new LinkedList<>();
		if (a != null && !a.isEmpty())
			_camino(a, resul, num);
		return resul;
	}
	
	private boolean _camino(GeneralTree<Integer> a, List<Integer> resul, int num) {
		boolean ok = false;
		resul.add(a.getData());
		
		if (a.isLeaf()) {
			return true;
		}
		int tamaño = a.getChildren().size();
		
		if (tamaño >= num) {
			Iterator<GeneralTree<Integer>> it = a.getChildren().iterator();
			
			while (it.hasNext() && !ok)
				ok = _camino(it.next(), resul, num);
		}
		
		if (!ok) resul.remove(resul.size()-1);
		return ok;
	}
	
}
