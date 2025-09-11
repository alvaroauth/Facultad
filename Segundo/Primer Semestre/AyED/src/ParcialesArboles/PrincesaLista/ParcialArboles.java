package ParcialesArboles.PrincesaLista;

import java.util.*;

import Practica3.Ejercicio1.GeneralTree;

public class ParcialArboles {
	private GeneralTree<Personaje> a;

	public ParcialArboles(GeneralTree<Personaje> a) {
		super();
		this.a = a;
	}
	
	public List<Personaje> caminoAPrincesa(){
		List<Personaje> camino = new LinkedList<>();
		
		if (a != null && !a.isEmpty()) {
			_caminoAPrincesa(a, camino);
		}
		
		return camino;
	}
	
	private boolean _caminoAPrincesa(GeneralTree<Personaje> a, List<Personaje> camino) {
		boolean ok = false;
		camino.add(a.getData());
		if (a.getData().esPrincesa()) {
			return true;
		}
		else if (!a.getData().esDragon()) {
			Iterator<GeneralTree<Personaje>> it = a.getChildren().iterator();
			while (it.hasNext() && !ok) {
				ok = _caminoAPrincesa(it.next(), camino);
			}
		}
		if (!ok)
			camino.remove(camino.size()-1);
		return ok;
	}
}
