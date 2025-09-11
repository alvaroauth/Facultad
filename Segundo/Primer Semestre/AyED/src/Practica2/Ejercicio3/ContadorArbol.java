package Practica2.Ejercicio3;

import java.util.*;
import Practica2.Ejercicio1.BinaryTree;

public class ContadorArbol {
	
	BinaryTree<Integer> ab = new BinaryTree<>();
	
	public ContadorArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}

	public LinkedList<Integer> numerosParesIO(){
		LinkedList<Integer> l = new LinkedList<>();
		if (!ab.isEmpty())
			numerosParesAuxIO(ab, l);
		return l;
	}
	
	private LinkedList<Integer> numerosParesAuxIO(BinaryTree<Integer> a, LinkedList<Integer> l){
		if (a.hasLeftChild())
			numerosParesAuxIO(a.getLeftChild(), l);
		if (a.getData() % 2 == 0)
			l.add(a.getData());
		if (a.hasRightChild())
			numerosParesAuxIO(a.getRightChild(), l);
		return l;
	}
	
	public LinkedList<Integer> numerosParesPO(){
		LinkedList<Integer> l = new LinkedList<>();
		if (!ab.isEmpty())
			numerosParesAuxPO(ab, l);
		return l;
	}
	
	private LinkedList<Integer> numerosParesAuxPO(BinaryTree<Integer> a, LinkedList<Integer> l){
		if (a.hasLeftChild())
			numerosParesAuxIO(a.getLeftChild(), l);
		if (a.hasRightChild())
			numerosParesAuxIO(a.getRightChild(), l);
		if (a.getData() % 2 == 0)
			l.add(a.getData());
		return l;
	}
}
