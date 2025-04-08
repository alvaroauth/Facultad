package Practica2.Ejercicio7;
import Practica2.Ejercicio1.BinaryTree;


public class prueba {
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<>(2);

		ab.addLeftChild(new BinaryTree<>(7));
		ab.addRightChild(new BinaryTree<>(-5));
		ab.getLeftChild().addLeftChild(new BinaryTree<>(23));
		ab.getLeftChild().addRightChild(new BinaryTree<>(6));
		ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(-3));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(55));
		ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(11));
		ab.getRightChild().addLeftChild(new BinaryTree<>(19));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));
		ab.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(18));
		
		ab.entreNiveles(0,3);
		System.out.println("----------------------------------------");
	}
	
	
	
	/*
	 
	 
              2
            /   \
          7      -5
        /  \     /
      23    6   19
     /     / \     \
   -3    55  11     4
                     /
                   18
                   
                   
	 */
}