package ParcialesArboles.Parcial18;

import Practica3.Ejercicio1.GeneralTree;
import java.util.*;

public class Parcial {
	private GeneralTree<Integer> ab;

	public Parcial(GeneralTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public List<String> resolver(int num){
		List<String> lista = new LinkedList<>();
		if (ab != null && !ab.isEmpty()) {
			_resolver(ab, lista, 0, num);
		}
		return lista;
	}
	
	private void _resolver(GeneralTree<Integer> a, List<String> lista, int nivel, int num) {
		Iterator<GeneralTree<Integer>> it = a.getChildren().iterator();
		
		if (it.hasNext())
			_resolver(it.next(), lista, nivel+1, num);
		
		if (a.getData() > num) {
			lista.add(a.getData()+ " nivel "+nivel);
		}
		
		while(it.hasNext())
			_resolver(it.next(), lista, nivel+1, num);
	}
}
