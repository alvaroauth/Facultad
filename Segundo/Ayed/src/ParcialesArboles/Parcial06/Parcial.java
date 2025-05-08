package ParcialesArboles.Parcial06;

import Practica2.Ejercicio1.BinaryTree;

public class Parcial {
	
	private BinaryTree<Personaje> ab;

	public Parcial(BinaryTree<Personaje> ab) {
		super();
		this.ab = ab;
	}

	public Personaje recorridoPrincesa(){
		if (ab != null && !ab.isEmpty())
			return _recorridoPrincesa(ab);
		return null;
	}
	
	private Personaje _recorridoPrincesa(BinaryTree<Personaje> a) {
		if (a.getData().esPrincesa())
			return a.getData();
		else
		{
			Personaje aux = null;
			if (!a.getData().esDragon()) {
				if (a.hasLeftChild()) aux = _recorridoPrincesa(a.getLeftChild());
				if (a.hasRightChild() && aux == null) aux = _recorridoPrincesa(a.getRightChild());
			}
			return aux;
		}
	}
	
}
