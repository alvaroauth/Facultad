package ParcialesArboles.PrincesaOtraVez;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Practica3.Ejercicio1.GeneralTree;

public class EncontrarPrincesa {
	public GeneralTree<Personaje> a;

	public EncontrarPrincesa(GeneralTree<Personaje> a) {
		super();
		this.a = a;
	}
	
	public List<Personaje> encPrincesa(){
		List<Personaje> resul = new LinkedList<>();
		
		if (a != null && !a.isEmpty() && !a.getData().esDragon())
			_encPrincesa(a, resul);
		
		return resul;
	}
	
	private boolean _encPrincesa (GeneralTree<Personaje> a, List<Personaje> resul) {
		boolean enc = false;
		
		resul.add(a.getData());
		
		if (a.getData().esPrincesa())
			return true;
		
		else {
			Iterator<GeneralTree<Personaje>> it = a.getChildren().iterator();
			
			while (it.hasNext() && !enc) {
				GeneralTree<Personaje> hijo = it.next();
				if (!hijo.getData().esDragon())
					enc = _encPrincesa(hijo, resul);
					
			}
		}
		if (!enc) resul.remove(resul.size()-1);
		return enc;
		
	}
}
