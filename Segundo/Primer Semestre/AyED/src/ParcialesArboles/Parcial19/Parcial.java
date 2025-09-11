package ParcialesArboles.Parcial19;

import java.util.*;

import Practica3.Ejercicio1.GeneralTree;

public class Parcial {
	public static List<String> resolver(int menor, int mayor,GeneralTree<Integer> a){
		List<String> resul = new LinkedList<>();
		
		if (a != null  && !a.isEmpty()) {
			_resolver(a, resul, menor, mayor, 0);
		}
		return resul;
	}
	
	private static void _resolver(GeneralTree<Integer> a, List<String> lista, int menor, int mayor, int niv) {
		for (GeneralTree<Integer> hijo : a.getChildren())
			_resolver(hijo, lista, menor, mayor, niv+1);
		
		Integer aux = a.getData();
		if (aux >= menor && aux <= mayor)
			lista.add("("+aux+ " nivel: " + niv+")");
	}
}
