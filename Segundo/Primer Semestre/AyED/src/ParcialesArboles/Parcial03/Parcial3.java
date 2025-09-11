package ParcialesArboles.Parcial03;

/*
	Escribir una clase llamada ProcesadorDeArbol.

	La clase ProcesadorDeArbol contiene UNA ÚNICA variable de instancia de tipo ArbolBinario de valores numéricos (no puede agregar más variables a esta clase).

	La clase ProcesadorDeArbol contiene UN MÉTODO PÚBLICO llamado procesar, que usa la variable definida en el punto anterior, recorre el árbol de manera recursiva, usando un recorrido preorder y devuelve 2 valores:

	una LISTA con todos aquellos ÁRBOLES que cumplen con la siguiente condición:
	tienen 2 hijos y el valor del dato es par.

	la cantidad de valores pares en el árbol.
 */

import Practica2.Ejercicio1.BinaryTree;

public class Parcial3 {
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(10);
		ab.addLeftChild(new BinaryTree<Integer>(6));
		ab.addRightChild(new BinaryTree<Integer>(2));
		
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(9));
		
		ab.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(20));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(11));
		ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(5));
		
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(8));
		ab.getRightChild().addRightChild(new BinaryTree<Integer>(3));
		
		ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(2));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		
		ab.entreNiveles(0, 10);
		
		ProcesadorDeArbol p = new ProcesadorDeArbol(ab);
        ClaseAux parc = p.procesar();
        
        System.out.println("");
        
        System.out.println(parc.getLista());
        System.out.println(parc.getCant());
	}
	
}
