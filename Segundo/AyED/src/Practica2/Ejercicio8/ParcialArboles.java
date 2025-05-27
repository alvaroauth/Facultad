package Practica2.Ejercicio8;

import Practica2.Ejercicio1.BinaryTree;

public abstract class ParcialArboles {
	public static boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
		if(a1.isEmpty() || a2.isEmpty()) 
            return a1.isEmpty() && a2.isEmpty(); //El primer if verifica si al menos uno de los arboles esta vacio, si es asi, pregunta si ambos arboles estan vacios, si es asi tienen la misma estructura, en caso contrario, no es prefijo
        return esPrefijoAux(a1, a2);
	}
	
	private static boolean esPrefijoAux(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
		boolean ok = true;
		
		if (!(a1.getData().equals(a2.getData())))
			ok = false;
		
		if ((a1.hasLeftChild() && a2.hasLeftChild()) && ok)
			ok = esPrefijoAux(a1.getLeftChild(), a2.getLeftChild());
		else if ((a1.hasLeftChild() && !a2.hasLeftChild()) && ok) ok = false;
		
		if ((a1.hasRightChild() && a2.hasRightChild()) && ok)
			ok = esPrefijoAux(a1.getRightChild(), a2.getRightChild());
		else if ((a1.hasRightChild() && !a2.hasRightChild()) && ok) ok = false;
		
		return ok;
	}
	
	
}
