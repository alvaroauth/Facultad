package Practica2.Ejercicio6;

import Practica2.Ejercicio1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> ab;

	public Transformacion(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}
	
	public BinaryTree<Integer> suma(){
		BinaryTree<Integer> a = Transformacion.copiarArbol(this.ab);
		if (!a.isEmpty() )
			transformarArbol(a);
		return a;
	}
	
	public static <T> BinaryTree<T> copiarArbol(BinaryTree<T> original) {
        if (original == null) return null;

        BinaryTree<T> copia = new BinaryTree<>(original.getData());
        copia.addLeftChild(copiarArbol(original.getLeftChild()));
        copia.addRightChild(copiarArbol(original.getRightChild()));
        return copia;
    }
	
	private int transformarArbol (BinaryTree<Integer> a){
		int suma = 0;
		if (a.isLeaf()) {
			suma = a.getData();
			a.setData(0);
			return suma;
		}
		if (a.hasLeftChild())
			suma += transformarArbol(a.getLeftChild());
		if (a.hasRightChild())
			suma += transformarArbol(a.getRightChild());
		int aux = a.getData();
		a.setData(suma);
		return suma + aux;
	}
}
