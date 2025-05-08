package ParcialesArboles.Parcial01;

import Practica3.Ejercicio1.GeneralTree;
import java.util.*;

public class ParcialArboles {
	private GeneralTree<Integer> ArbolGeneral;

	public ParcialArboles(GeneralTree<Integer> arbolGeneral) {
		super();
		ArbolGeneral = arbolGeneral;
	}
	
	public ParcialArboles() {}
	
	public List<Integer> camino(int num){
		List<Integer> camino = new LinkedList<>();
		if ( ArbolGeneral != null && !ArbolGeneral.isEmpty()) {
			_camino(num, ArbolGeneral, camino);
		}
		return camino;
	}
	
	private boolean _camino(int num, GeneralTree<Integer> a, List<Integer> camino) {
		boolean encontre = false;
		camino.add(a.getData());
		if (a.isLeaf())
			return true;
		
		if (a.getChildren().size() >= num) {
			
			Iterator<GeneralTree<Integer>> it = a.getChildren().iterator();
			
			while (it.hasNext() && !encontre)
				encontre = _camino(num, it.next(), camino);
			
		}
		else if (!encontre)
			camino.remove(camino.size()-1);
		return encontre;

	}
	
}
