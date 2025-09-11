package Practica2.Ejercicio4;

import Practica2.Ejercicio1.BinaryTree;

public class RedBinariaLlena {

	private BinaryTree<Integer> ab;
    
	
	
	public RedBinariaLlena(BinaryTree<Integer> red) {
		super();
		this.ab = red;
	}

	public int retardoReenvio() {
        return (ab != null && !ab.isEmpty()) ? retardoReenvio(ab) : 0;
    }

	private int retardoReenvio(BinaryTree<Integer> a) {
        if(a.isLeaf())
        	return a.getData();
        else {
        	int hi=0,hd=0;
        	if(a.hasLeftChild())
                hi = retardoReenvio(a.getLeftChild());
            if(a.hasRightChild())
                hd = retardoReenvio(a.getRightChild());
            return (((hi > hd) ? hi : hd)+ a.getData());
        }
        
    }
}
