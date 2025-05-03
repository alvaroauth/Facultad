package Practica3.Ejercicio2;

import Practica3.Ejercicio1.GeneralTree;
import java.util.*;

public class RecorridosAG {
	
	public static List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> ab, int n){
		List<Integer> l = new LinkedList<>();
		if (ab != null && !ab.isEmpty()) {
			_numerosImparesMayoresQuePreOrden(ab, n, l);
		}
		return l;
	}
	
	private static void _numerosImparesMayoresQuePreOrden(GeneralTree<Integer> ab, int n, List<Integer> l){
		
		if ((ab.getData() % 2 == 1)&&(ab.getData() > n)) {
			l.add(ab.getData());
		}
		
		if (ab.hasChildren()){
			List<GeneralTree<Integer>> hijos = ab.getChildren();
			for( GeneralTree<Integer> h : hijos)
				_numerosImparesMayoresQuePreOrden(h, n, l);
		}
	}
	
	
	
	public static List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> ab, int n){
		List<Integer> l = new LinkedList<>();
		if (ab != null && !ab.isEmpty()) {
			_numerosImparesMayoresQueInOrden(ab, n, l);
		}
		return l;
	}
	
	private static void _numerosImparesMayoresQueInOrden(GeneralTree<Integer> ab, int n, List<Integer> l){
		Iterator<GeneralTree<Integer>> it = ab.getChildren().iterator();
		
		if (it.hasNext())
			_numerosImparesMayoresQueInOrden(it.next(),n,l);
		
		if ((ab.getData() % 2 == 1)&&(ab.getData() > n))
			l.add(ab.getData());
		
		while(it.hasNext())
			_numerosImparesMayoresQueInOrden(it.next(),n,l);
	}
	
	
	
	public static List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> ab, int n){
		List<Integer> l = new LinkedList<>();
		if (ab != null && !ab.isEmpty()) {
			_numerosImparesMayoresQuePostOrden(ab, n, l);
		}
		return l;
	}
	
	private static void _numerosImparesMayoresQuePostOrden(GeneralTree<Integer> ab, int n, List<Integer> l){
		
		if (ab.hasChildren()){
			List<GeneralTree<Integer>> hijos = ab.getChildren();
			for( GeneralTree<Integer> h : hijos)
				_numerosImparesMayoresQuePostOrden(h, n, l);
		}
		
		if ((ab.getData() % 2 == 1)&&(ab.getData() > n)) {
			l.add(ab.getData());
		}
	}
	
	
	
	public static List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> ab, int n){
		List<Integer> l = new LinkedList<>();
		if (ab != null && !ab.isEmpty()) {
			_numerosImparesMayoresQuePorNiveles(ab, n, l);
		}
		return l;
	}
	
	private static void _numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> ab, int n, List<Integer> l){
		Queue<GeneralTree<Integer>> cola = new LinkedList<>();
		cola.offer(ab);
		GeneralTree<Integer> nodo;
		int cantNodos;
		
		while (!cola.isEmpty()) {
			cantNodos = cola.size();
			for(int i = 0 ; i < cantNodos ; i++) {
				nodo = cola.remove();
				
				if ((nodo.getData() % 2 == 1)&&(nodo.getData() > n))
					l.add(nodo.getData());
				
				for (GeneralTree<Integer> h : nodo.getChildren())
					cola.add(h);
			}
		}
	}
}
