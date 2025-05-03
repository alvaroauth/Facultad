package Practica3.Ejercicio1;

import java.util.*;

public class GeneralTree<T>{
    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();;
    
    public GeneralTree(){}
    
    public GeneralTree(T data){
        this.data = data;
    }
    
    public GeneralTree(T data, List<GeneralTree<T>> children){
        this.data = data;
        this.children = children;
    }
    
    public T getData(){
        return this.data;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public List<GeneralTree<T>> getChildren(){
        return this.children;
    }
    
    public void setChildren(List<GeneralTree<T>> children){
        this.children = children;
    }
    
    public void addChild(GeneralTree<T> nodo){
        this.getChildren().add(nodo);
    }
    
    public boolean isLeaf(){
        return !this.hasChildren();
    }
    
    public boolean hasChildren(){
        return !this.getChildren().isEmpty();
    }
    
    public boolean isEmpty(){
        return (!(this.getData() == null) && !this.hasChildren());
    }
    
    public void removeChildren(GeneralTree<T> child){
        if (this.hasChildren())
            this.getChildren().remove(child);
    }
    
    public int altura() {
    	if (this.isEmpty()) return 0;
    	else return alturaAux();
    }
    
    private int alturaAux() {
    	if (this.isLeaf()) return 0;
    	else {
    		int altMax = -1;
    		List<GeneralTree<T>> lista = this.getChildren();
    		for(GeneralTree<T> hijo : lista)
    			altMax = Math.max(altMax,hijo.alturaAux());
    		return altMax + 1;
    	}
    }
    
    public int nivel (T dato) {
    	if (this.isEmpty()) return -1;
    	else return nivelAux(dato);
    }
    
    private int nivelAux(T dato) {
    	Queue<GeneralTree<T>> cola = new LinkedList<GeneralTree<T>>();
    	int nivel = 0, cantNodos;
    	GeneralTree<T> nodo;
    	
    	cola.add(this);
    	
    	while(!cola.isEmpty()) {
    		cantNodos = cola.size();
    		
    		for (int i = 0 ; i < cantNodos ; i++) {
    			nodo = cola.remove();
    			
    			if (nodo.getData().equals(dato))
    				return nivel;
    
    			for (GeneralTree<T> hijo : nodo.getChildren())
    				cola.add(hijo);
    		}
    		nivel++;
    	}
    	return -1;
    }
    
    public int ancho () {
    	if (this.isEmpty()) return -1;
    	else return anchoAux();
    }
    
    private int anchoAux() {
    	Queue<GeneralTree<T>> cola = new LinkedList<GeneralTree<T>>();
    	int cantNodos;
    	GeneralTree<T> nodo;
    	int max = -1;
    	cola.add(this);
    	
    	while(!cola.isEmpty()) {
    		cantNodos = cola.size();
    		max = Math.max(cantNodos, max);
    		
    		for (int i = 0 ; i < cantNodos ; i++) {
    			nodo = cola.remove();
    		
    			for (GeneralTree<T> hijo : nodo.getChildren())
    				cola.add(hijo);
    		}
    	}
    	return max;
    }
    
}