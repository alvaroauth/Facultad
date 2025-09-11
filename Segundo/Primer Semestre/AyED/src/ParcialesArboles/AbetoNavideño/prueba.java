package ParcialesArboles.AbetoNavideño;

import java.util.LinkedList;
import java.util.List;

import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
		
		
		
		//No me anduvo :(
		
		
		
		
		List<GeneralTree<Integer>> subArb1 = new LinkedList<GeneralTree<Integer>>();
        subArb1.add(new GeneralTree<Integer>(2));
        subArb1.add(new GeneralTree<Integer>(3));
        subArb1.add(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1, subArb1);
        
        List<GeneralTree<Integer>> subArb2A = new LinkedList<GeneralTree<Integer>>();
        subArb2A.add(new GeneralTree<Integer>(5));
        subArb2A.add(new GeneralTree<Integer>(6));
        subArb2A.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> subA2 = new GeneralTree<Integer>(2, subArb2A);
        List<GeneralTree<Integer>> subArb2B = new LinkedList<GeneralTree<Integer>>();
        subArb2B.add(subA2);
        subArb2B.add(new GeneralTree<Integer>(3));
        subArb2B.add(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subArb2B);
        
        List<GeneralTree<Integer>> subArb3A = new LinkedList<GeneralTree<Integer>>();
        subArb3A.add(new GeneralTree<Integer>(6));
        subArb3A.add(new GeneralTree<Integer>(7));
        subArb3A.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> subA3 = new GeneralTree<Integer>(3, subArb3A);
        List<GeneralTree<Integer>> subArb3B = new LinkedList<GeneralTree<Integer>>();
        subArb3B.add(new GeneralTree<Integer>(2));
        subArb3B.add(subA3);
        subArb3B.add(new GeneralTree<Integer>(4));
        subArb3B.add(new GeneralTree<Integer>(5));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subArb3B);
        
        ParcialArboles nav1 = new ParcialArboles(a1);
        ParcialArboles nav2 = new ParcialArboles(a2);
        ParcialArboles nav3 = new ParcialArboles(a3);
        
        System.out.println("Es abeto navidenio A1? " + nav1.esAbetoNavideño());
        System.out.println("Es abeto navidenio A2? " + nav2.esAbetoNavideño());
        System.out.println("Es abeto navidenio A3? " + nav3.esAbetoNavideño());
	}
}
