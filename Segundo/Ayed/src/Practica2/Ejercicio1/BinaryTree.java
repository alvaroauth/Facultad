package Practica2.Ejercicio1;
import java.util.*;

//Ejercicio 1

public class BinaryTree <T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	public BinaryTree() {
    }

    public BinaryTree(T data) {
        this.data = data;
    }
    
    public T getData() {
    	return this.data;
    }
    
    public void setData(T data) {
    	this.data = data;
    }
    
    public BinaryTree<T> getLeftChild(){
    	return this.leftChild;
    }
    
    public BinaryTree<T> getRightChild(){
    	return this.rightChild;
    }
    
    public void addLeftChild(BinaryTree<T> child){
    	this.leftChild = child;
    }
    
    public void addRightChild(BinaryTree<T> child){
    	this.rightChild = child;
    }
    
    public void removeLeftChild(){
    	this.leftChild = null;
    }
    
    public void removeRightChild(){
    	this.rightChild = null;
    }
    
    public boolean hasLeftChild() {
    	return (this.leftChild != null);
    }
    
    public boolean hasRightChild() {
    	return (this.rightChild != null);
    }
    
    public boolean isLeaf() {
    	return (!this.hasLeftChild() && !this.hasRightChild());
    }
    
    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }
    
    @Override
    public String toString() {
        return this.getData().toString();
    }
    
    //Ejercicio 2
    
    public int contarHojas() {
    	int contador = 0;
        if (this.isEmpty()) return 0;
        else if (this.isLeaf()) return 1;
        else {
        	if (this.hasLeftChild()) 
            contador += this.getLeftChild().contarHojas();
        	if (this.hasRightChild()) 
            contador += this.getRightChild().contarHojas();
        	return contador;
        } 
    }
    
    public BinaryTree<T> espejado(){
    	BinaryTree<T> esp = new BinaryTree<T>();
    	if (this.hasLeftChild())
    		esp.addRightChild(this.getLeftChild().espejado());
    	if (this.hasRightChild())
    		esp.addLeftChild(this.getRightChild().espejado());
    	return esp;
    }
    
    public void imprimirInOrden() {
    	if(!this.isEmpty()) {
    		if (this.hasLeftChild())
    			this.getLeftChild().imprimirInOrden();
    		System.out.println(this.getData().toString());
    		if (this.hasRightChild())
    			this.getRightChild().imprimirInOrden();
    	}
    }
    
    public void entreNiveles(int n, int m) {
 		if (this.isEmpty()|| n<0 || n>m) {
 			return ;
 		}
 		Queue <BinaryTree<T>> cola =  new LinkedList<BinaryTree<T>>();  //la cola
 		cola.offer(this); 
 		int nivelActual=0;    
 		boolean ok = true;
 		
 		while (!cola.isEmpty() && nivelActual<=m) { 
 			int cantNodos = cola.size();
 			
 			 { 
 				
 			for (int i=0;i<cantNodos;i++) {  
 				BinaryTree <T> elem = cola.remove();
 				if (nivelActual>=n && nivelActual<=m)
 					System.out.print("|" + elem.getData().toString()+"|");
 				if (elem.hasLeftChild())cola.offer(elem.getLeftChild());
 				if (elem.hasRightChild())cola.offer(elem.getRightChild());
 			}
 			if (nivelActual>=n && nivelActual<=m)
 				System.out.println();
 			}
 		nivelActual++;
 		}
 	}
}
