package Practica3.Ejercicio2;

import Practica3.Ejercicio1.GeneralTree;
import java.util.*;

public class prueba {

	public static void main(String[] args) {
		GeneralTree<Integer> root = new GeneralTree<>(1);
        GeneralTree<Integer> child1 = new GeneralTree<>(2);
        GeneralTree<Integer> child2 = new GeneralTree<>(3);
        GeneralTree<Integer> child3 = new GeneralTree<>(4);
        GeneralTree<Integer> grandchild1 = new GeneralTree<>(5);
        GeneralTree<Integer> grandchild2 = new GeneralTree<>(6);
        GeneralTree<Integer> grandchild3 = new GeneralTree<>(7);

        child1.addChild(grandchild1);
        child1.addChild(grandchild2);
        child2.addChild(grandchild3);

        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);
        
        List<Integer> lpre = RecorridosAG.numerosImparesMayoresQuePreOrden(root, 0);
        List<Integer> lin = RecorridosAG.numerosImparesMayoresQueInOrden(root, 0);
        List<Integer> lpost = RecorridosAG.numerosImparesMayoresQuePostOrden(root, 0);
        List<Integer> lniv = RecorridosAG.numerosImparesMayoresQuePorNiveles(root, 0);
        
        System.out.println(lpre.toString());
        System.out.println();
        System.out.println(lin.toString());
        System.out.println();
        System.out.println(lpost.toString());
        System.out.println();
        System.out.println(lniv.toString());
    }
	
	//	    1
    //    / | \
    //   2  3  4
    //  / \  \
    // 5   6  7 
	
}
