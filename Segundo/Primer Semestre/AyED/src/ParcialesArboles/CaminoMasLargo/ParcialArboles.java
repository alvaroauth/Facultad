package ParcialesArboles.CaminoMasLargo;

import Practica3.Ejercicio1.GeneralTree;
import java.util.*;

public class ParcialArboles {
	private GeneralTree<Integer> ArbolGeneral;

	public ParcialArboles(GeneralTree<Integer> arbolGeneral) {
		super();
		ArbolGeneral = arbolGeneral;
	}
	
	public ParcialArboles() {}
	
	public List<Integer> camino(){
		List<Integer> camino = new LinkedList<>();
		if ( ArbolGeneral != null && !ArbolGeneral.isEmpty()) {
			_camino( ArbolGeneral, camino, new LinkedList<>());
		}
		return camino;
	}
	
	private void _camino( GeneralTree<Integer> a, List<Integer> camino, List<Integer> aux) {
		aux.add(a.getData());
		
		if (a.isLeaf() && camino.size() < aux.size()) {
			camino.clear();
			camino.addAll(aux);
		}
		else {
			for (GeneralTree<Integer> h : a.getChildren()) {
				_camino(h, camino, aux);
			}
		}
		aux.removeLast();
	}
	
}
