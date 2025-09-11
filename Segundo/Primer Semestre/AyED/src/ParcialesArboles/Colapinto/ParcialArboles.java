package ParcialesArboles.Colapinto;

import java.util.*;
import Practica3.Ejercicio1.GeneralTree;

public class ParcialArboles {
	
	public static List<Vueltas> mejorEstrategia(GeneralTree<Vueltas> a){
		List<Vueltas> mejor = new LinkedList<>();
		
		if (a != null && !a.isEmpty()) {
			_mejorEstrategia(a, new LinkedList<>(), mejor);
		}
		
		return mejor;
	}
	
	private static void _mejorEstrategia(GeneralTree<Vueltas> a, List<Vueltas> lista, List<Vueltas> mejor) {
		lista.add(a.getData());
		double min = Integer.MAX_VALUE;
		
		if (a.isLeaf() && calcularTiempo(lista) < min) {
			min = Math.min(min, calcularTiempo(lista));
			System.out.println(min);
			mejor.clear();
			mejor.addAll(lista);
			mejor.remove(0);
		}
		else {
			for (GeneralTree<Vueltas> hijo: a.getChildren()) {
				_mejorEstrategia(hijo, lista, mejor);
			}
			
		}
		lista.remove(lista.size()-1);
	}
	
	private static double calcularTiempo (List<Vueltas> lis) {
		double aux = 0;
		for (int i = 1 ; i < lis.size() ; i++) {
			
			switch (lis.get(i).getNeumatico()){
			case "Soft": 	
				aux += lis.get(i).getVueltas() * 0;
				break;
			
			case "Med": 	
				aux += lis.get(i).getVueltas() * 0.5;
				break;
				
			case "Hard": 	
				aux += lis.get(i).getVueltas() * 0.7;
				break;
			}
			
			aux += 10;
		}
		return aux - 10 ;
	}
	
}
