package Practica1.Ejercicio8;

import java.util.List;
import java.util.ArrayList;

public class Queue <T> extends Sequence {
    protected List<T> data;
    
    public Queue() {
        this.data = new ArrayList<T>();
    }
    
    public void enqueue(T dato){
    	this.data.add(dato);
    }
    
    public T dequeue() {
    	T aux = this.data.get(0);
    	this.data.remove(0);
    	return aux;
    }
    
    public T head() {
    	return this.data.get(0);
    }
    
    @Override
    public boolean isEmpty() {
    	return this.data.size() == 0;
    }
    
    @Override
    public int size() {
    	return this.data.size();
    }
    
    @Override
    public String toString() {
    	String aux = "     -* -* -* COLA ENTERA *- *- *- \n";
    	for (T d: data){
    		aux += " ---> "+d.toString()+"  --\n";
    	}
    	aux += "-* -* -* -* -* -* --- *- *- *- *- *- *-";
    	return aux;
    }
}