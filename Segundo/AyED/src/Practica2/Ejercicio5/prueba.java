package Practica2.Ejercicio5;
import Practica2.Ejercicio1.BinaryTree;


public class prueba {
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<>(20);
		ab.addLeftChild(new BinaryTree<>(15));
		ab.addRightChild(new BinaryTree<>(22));
		ab.getLeftChild().addLeftChild(new BinaryTree<>(8));
		ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(4));
		ab.getLeftChild().addRightChild(new BinaryTree<>(18));
		ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(19));
		ab.getRightChild().addLeftChild(new BinaryTree<>(21));
		ab.getRightChild().addRightChild(new BinaryTree<>(27));
		ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<>(25));
		ab.getRightChild().getRightChild().addRightChild(new BinaryTree<>(30));
		
		ab.entreNiveles(0,3);
		System.out.println("----------------------------------------");
		ProfundidadDeArbolBinario pab = new ProfundidadDeArbolBinario(ab);
		System.out.println(pab.sumaElementosProfundidad(-1));
	}
	
	
	
	/*
	 * 				20
	 * 			  /    \
	 * 		    15      22
	 * 	       /  \    /  \
	 * 		  8   18  21   27
	 * 		 /      \     /  \
	 * 		4  		 19	 25   30 
	 */
}
