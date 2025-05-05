package Practica3.Ejercicio4;

import java.util.*;
import Practica3.Ejercicio1.*;

public class AnalizadorArbol {
	public static double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		Queue<GeneralTree<AreaEmpresa>> cola = new LinkedList<>();
		int suma, cantNodos;
		double prom = -1;
		GeneralTree<AreaEmpresa> nodo;
		
		cola.add(arbol);
		while (!cola.isEmpty()) {
			
			cantNodos = cola.size();
			suma = 0;
			for (int i = 0; i < cantNodos ; i++) {
				
				nodo = cola.remove();
				suma += nodo.getData().getTardanza();
				
				for (GeneralTree<AreaEmpresa> hijo : nodo.getChildren()) {
					cola.add(hijo);
				}
			}
			
			prom = Math.max((suma / cantNodos), prom);
		}
		return prom;
	}
}
