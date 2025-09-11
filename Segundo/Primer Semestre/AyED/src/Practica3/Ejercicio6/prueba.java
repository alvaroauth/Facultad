package Practica3.Ejercicio6;

import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
		// Nodo raíz
        GeneralTree<Character> root = new GeneralTree<>('A');
        
        // Hijos de A: B, C, D y E
        GeneralTree<Character> nodeB = new GeneralTree<>('B');
        GeneralTree<Character> nodeC = new GeneralTree<>('C');
        GeneralTree<Character> nodeD = new GeneralTree<>('D');
        GeneralTree<Character> nodeE = new GeneralTree<>('E');
        
        root.addChild(nodeB);
        root.addChild(nodeC);
        root.addChild(nodeD);
        root.addChild(nodeE);
        
        // Bajo C: hijos F y G
        GeneralTree<Character> nodeF = new GeneralTree<>('F');
        GeneralTree<Character> nodeG = new GeneralTree<>('G');
        nodeC.addChild(nodeF);
        nodeC.addChild(nodeG);
        
        // Bajo F: hijo L
        GeneralTree<Character> nodeL = new GeneralTree<>('L');
        nodeF.addChild(nodeL);
        
        // Bajo D: cinco hijos: H, I, J, K y P
        GeneralTree<Character> nodeH = new GeneralTree<>('H');
        GeneralTree<Character> nodeI = new GeneralTree<>('I');
        GeneralTree<Character> nodeJ = new GeneralTree<>('J');
        GeneralTree<Character> nodeK = new GeneralTree<>('K');
        GeneralTree<Character> nodeP = new GeneralTree<>('P');
        nodeD.addChild(nodeH);
        nodeD.addChild(nodeI);
        nodeD.addChild(nodeJ);
        nodeD.addChild(nodeK);
        nodeD.addChild(nodeP);
        
        // Bajo J: hijos M y N
        GeneralTree<Character> nodeM = new GeneralTree<>('M');
        GeneralTree<Character> nodeN = new GeneralTree<>('N');
        nodeJ.addChild(nodeM);
        nodeJ.addChild(nodeN);


        
        RedDeAguaPotable rd = new RedDeAguaPotable(root);
        
        System.out.println("Caudal Minimo: "+rd.minimoCaudal(1000.0));
	}

}
