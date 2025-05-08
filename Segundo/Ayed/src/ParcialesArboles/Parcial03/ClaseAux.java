package ParcialesArboles.Parcial03;

import java.util.List;

import Practica2.Ejercicio1.BinaryTree;

public class ClaseAux {
	private List<BinaryTree<Integer>> lista;
	private int cant;
	
	public ClaseAux(List<BinaryTree<Integer>> lista, int cant) {
		super();
		this.setLista(lista);
		this.setCant(cant);
	}

	public List<BinaryTree<Integer>> getLista() {
		return lista;
	}

	private void setLista(List<BinaryTree<Integer>> lista) {
		this.lista = lista;
	}

	public int getCant() {
		return cant;
	}

	private void setCant(int cant) {
		this.cant = cant;
	}
	
	
	
	
	
}
