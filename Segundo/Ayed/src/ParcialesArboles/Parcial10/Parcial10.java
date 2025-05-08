package ParcialesArboles.Parcial10;

import Practica3.Ejercicio1.GeneralTree;

public class Parcial10 {
	public static void main(String[] args) {
		GeneralTree<Integer> n2 = new GeneralTree<>(2);
		GeneralTree<Integer> n4 = new GeneralTree<>(4);
		GeneralTree<Integer> n6 = new GeneralTree<>(6);
		GeneralTree<Integer> n7 = new GeneralTree<>(7);
		GeneralTree<Integer> n1 = new GeneralTree<>(1);
		GeneralTree<Integer> n9 = new GeneralTree<>(9);
		GeneralTree<Integer> n10 = new GeneralTree<>(10);
		
		n7.addChild(n2);
		
		GeneralTree<Integer> n3 = new GeneralTree<>(3);
		n3.addChild(n4);
		n3.addChild(n7);
		n3.addChild(n6);
		
		GeneralTree<Integer> n5 = new GeneralTree<>(5);
		n5.addChild(n1);
		n5.addChild(n9);
		n5.addChild(n10);
		
		GeneralTree<Integer> root = new GeneralTree<>(8);
		root.addChild(n3);
		root.addChild(n5);	
		
		System.out.println(CaminoAHojaMasLejana.caminoMasLargo(root));
	}
}
