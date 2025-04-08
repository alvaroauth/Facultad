package Practica2.Ejercicio4;
//import java.util.*;
import Practica2.Ejercicio1.BinaryTree;


public class prueba {
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<>(10); // raíz

		ab.addLeftChild(new BinaryTree<>(5));
		ab.addRightChild(new BinaryTree<>(20));

		// Nivel 2 - hijos del nodo 5
		ab.getLeftChild().addLeftChild(new BinaryTree<>(3));
		ab.getLeftChild().addRightChild(new BinaryTree<>(7));

		// Nivel 2 - hijos del nodo 20
		ab.getRightChild().addLeftChild(new BinaryTree<>(15));
		ab.getRightChild().addRightChild(new BinaryTree<>(25));

		// Nivel 3 - hijos del nodo 3
		ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(2));
		ab.getLeftChild().getLeftChild().addRightChild(new BinaryTree<>(4));

		// Nivel 3 - hijos del nodo 7
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(6));
		ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(8));

		// Nivel 3 - hijos del nodo 15
		ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(13));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(17));

		// Nivel 3 - hijos del nodo 25
		ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<>(23));
		ab.getRightChild().getRightChild().addRightChild(new BinaryTree<>(27));
		
		RedBinariaLlena rb = new RedBinariaLlena(ab);
		System.out.println(rb.retardoReenvio());
		
		System.out.println("----------------------------------------");
	}
	
	
	/*
	                10
                 /      \
               5         20
             /   \      /   \
            3     7   15    25
           / \   / \  / \   / \
          2   4  6  8 13 17 23 27   creditos a chatgpt
	 */
}
