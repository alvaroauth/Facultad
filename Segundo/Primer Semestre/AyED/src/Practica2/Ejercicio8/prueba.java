package Practica2.Ejercicio8;
import Practica2.Ejercicio1.BinaryTree;


public class prueba {
	public static void main(String[] args) {
		BinaryTree<Integer> ab1 = new BinaryTree<>(20);
		ab1.addLeftChild(new BinaryTree<>(15));
		ab1.addRightChild(new BinaryTree<>(22));
		ab1.getLeftChild().addLeftChild(new BinaryTree<>(8));
		ab1.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(4));
		ab1.getLeftChild().addRightChild(new BinaryTree<>(18));
		ab1.getRightChild().addLeftChild(new BinaryTree<>(21));
		
		BinaryTree<Integer> ab2 = new BinaryTree<>(20);
		ab2.addLeftChild(new BinaryTree<>(15));
		ab2.addRightChild(new BinaryTree<>(22));
		ab2.getLeftChild().addLeftChild(new BinaryTree<>(8));
		ab2.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(4));
		ab2.getLeftChild().addRightChild(new BinaryTree<>(18));
		ab2.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(19));
		ab2.getRightChild().addLeftChild(new BinaryTree<>(21));
		ab2.getRightChild().addRightChild(new BinaryTree<>(27));
		ab2.getRightChild().getRightChild().addLeftChild(new BinaryTree<>(25));
		ab2.getRightChild().getRightChild().addRightChild(new BinaryTree<>(30));
		
		System.out.println("----------------------------------------");
		System.out.println(ParcialArboles.esPrefijo(ab1, ab2));
		System.out.println("----------------------------------------");

	}
	
	
	/*
	 * 	ab2:		20
	 * 			  /    \
	 * 		    15      22
	 * 	       /  \    /  \
	 * 		  8   18  21   27
	 * 		 /      \     /  \
	 * 		4  		 19	 25   30 
	 * 
	 * 
	 * 
	 * 	ab1:		20
	 * 			  /    \
	 * 		    15      22
	 * 	       /  \    /  
	 * 		  8   18  21   
	 * 		 /           
	 * 		4  		 	 
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
