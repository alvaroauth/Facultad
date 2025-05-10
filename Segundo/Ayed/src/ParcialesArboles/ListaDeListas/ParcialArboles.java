package ParcialesArboles.ListaDeListas;

import java.util.*;

import Practica3.Ejercicio1.GeneralTree;

public class ParcialArboles {
	private GeneralTree<Integer> a;

	public ParcialArboles(GeneralTree<Integer> a) {
		super();
		this.a = a;
	}
	
	public List<List<Integer>> todosLosCaminosConValoresEntre(int min, int max){
		List<List<Integer>> resul = new LinkedList<>();
		
		if (a != null && !a.isEmpty() && a.getData() >= min && a.getData() <= max)
			_todosLosCaminosConValoresEntre(a, resul, new LinkedList<>(), min, max);
		
		return resul;
	}
	
	private void _todosLosCaminosConValoresEntre(GeneralTree<Integer> a, List<List<Integer>> resul, List<Integer> act, int min, int max) {
		act.add(a.getData());
		
		if (a.isLeaf()) {
			resul.add(new LinkedList<>(act));
		}
		else{
			for (GeneralTree<Integer> hijo : a.getChildren())
				if (hijo.getData() >= min && hijo.getData() <= max) 
					_todosLosCaminosConValoresEntre(hijo, resul, act, min, max);
		}
		
		act.remove(act.size()-1);
	}
}
