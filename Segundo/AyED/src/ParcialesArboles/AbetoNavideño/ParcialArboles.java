package ParcialesArboles.AbetoNavideño;

import Practica3.Ejercicio1.GeneralTree;

public class ParcialArboles {
	private GeneralTree<Integer> a;

	public ParcialArboles(GeneralTree<Integer> ab) {
		super();
		this.a = ab;
	}
	
	public boolean esAbetoNavideño() {
		if (a != null && !a.isEmpty())
			return _esAbetoNavideño(a);
		return false;
	}
	
	private boolean _esAbetoNavideño(GeneralTree<Integer> a) {
		boolean ok = true;
		if (a.isLeaf()) {
			return false;
		}
		else if (a.hasChildren()){
			GeneralTree<Integer> primerHijo = a.getChildren().get(0);
			if (primerHijo.getChildren().isEmpty()) {
				for (int i = 1 ; i < a.getChildren().size()-2 ; i++) {
					ok = _esAbetoNavideño(a.getChildren().get(i));
				}
			}
			GeneralTree<Integer> ultimoHijo = a.getChildren().get(a.getChildren().size()-1);
			if (!ultimoHijo.isLeaf())
				ok = false;
		}
		return ok;
	}
}
