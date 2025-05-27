package Practica2.Ejercicio9;

import Practica2.Ejercicio1.BinaryTree;

public abstract class ParcialArboles {
	
	public static BinaryTree<SumaDiferencia> sumAndDif(BinaryTree<Integer> a){
		BinaryTree<SumaDiferencia> abSD = new BinaryTree<SumaDiferencia>();
        if(!a.isEmpty()) {
            sumAndDifAux(a, abSD, 0, 0);
        }
        return abSD;
	}
	
	private static void sumAndDifAux(BinaryTree<Integer> a, BinaryTree<SumaDiferencia> abSD, int suma, int nodoPadre){
		abSD.setData(new SumaDiferencia(a.getData() + suma, a.getData() - nodoPadre));
		if (a.hasLeftChild()){
			abSD.addLeftChild(new BinaryTree<SumaDiferencia>());  //Me tira nullPointer sino
			sumAndDifAux(a.getLeftChild(), abSD.getLeftChild(), a.getData() + suma, a.getData());
		}
		if (a.hasRightChild()){
			abSD.addRightChild(new BinaryTree<SumaDiferencia>());  //Me tira nullPointer sino
			sumAndDifAux(a.getRightChild(), abSD.getRightChild(), a.getData() + suma, a.getData());
		}
	}
}
