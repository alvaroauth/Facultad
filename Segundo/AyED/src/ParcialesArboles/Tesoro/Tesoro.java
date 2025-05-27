package ParcialesArboles.Tesoro;

import java.util.*;

import Practica3.Ejercicio1.GeneralTree;

public class Tesoro {
	public static GeneralTree<String> tesoro(GeneralTree<String> a){
		GeneralTree<String> tes = new GeneralTree<String>();
		
		if (a != null && !a.isEmpty()){
			_tesoro(a, tes, new LinkedList<>(), Integer.MAX_VALUE);
		}
		
		return tes;
	}
	
	
	private static int _tesoro(GeneralTree<String> a, GeneralTree<String> tes, List<String> lis, int min) {
		lis.add(a.getData());
		
		if (a.getData().equals("Tesoro") && lis.size() < min) {
			min = lis.size();
			tes = a;
			tes.getData();
			System.out.println("hola");
		}
		
		else if (!a.getData().equals("Bloqueo")) {
			for (GeneralTree<String> h : a.getChildren()) {
				min = _tesoro(h, tes, lis, min);
			}
		}
		
		lis.removeLast();
		return min;
	}
	
	public static void main(String[] args) {
		GeneralTree<String> t1Tesoro = new GeneralTree<>("Tesoro");
		GeneralTree<String> tunelT1 = new GeneralTree<>("Tunel T1", List.of(t1Tesoro));
		GeneralTree<String> camaraA1 = new GeneralTree<>("Camara A1", List.of(tunelT1));
		GeneralTree<String> camaraA2 = new GeneralTree<>("Camara A2");
		GeneralTree<String> camaraA = new GeneralTree<>("Camara A", List.of(camaraA1, camaraA2));

		GeneralTree<String> tesoroBloqueo = new GeneralTree<>("Tesoro");
		GeneralTree<String> bloqueo = new GeneralTree<>("Bloqueo", List.of(tesoroBloqueo));

		GeneralTree<String> camaraB1 = new GeneralTree<>("Camara B1");
		GeneralTree<String> camaraB = new GeneralTree<>("Camara B", List.of(camaraB1));
		GeneralTree<String> tesoroX = new GeneralTree<>("Tesoro");
		GeneralTree<String> pasajeX = new GeneralTree<>("Pasaje X", List.of(camaraB, tesoroX));

		GeneralTree<String> entrada = new GeneralTree<>("Entrada", List.of(camaraA, bloqueo, pasajeX));
		
		System.out.println(Tesoro.tesoro(entrada).getData());
	}
}
