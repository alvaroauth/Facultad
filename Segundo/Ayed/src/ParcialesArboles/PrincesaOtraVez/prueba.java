package ParcialesArboles.PrincesaOtraVez;

import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
		GeneralTree<Personaje> coyote = new GeneralTree<>(new Personaje("Animal", "COYOTE"));

		// Hijos de COYOTE
		GeneralTree<Personaje> simba = new GeneralTree<>(new Personaje("Animal", "SIMBA"));
		GeneralTree<Personaje> mushu = new GeneralTree<>(new Personaje("Dragon", "MUSHU"));
		GeneralTree<Personaje> zazu = new GeneralTree<>(new Personaje("Animal", "ZAZÚ"));
		coyote.addChild(simba);
		coyote.addChild(mushu);
		coyote.addChild(zazu);

		// Hijos de SIMBA
		GeneralTree<Personaje> timon = new GeneralTree<>(new Personaje("Animal", "TIMON"));
		GeneralTree<Personaje> bella = new GeneralTree<>(new Personaje("Princesa", "BELLA"));
		mushu.addChild(timon);
		mushu.addChild(bella);

		// Hijos de MUSHU
		GeneralTree<Personaje> elliott = new GeneralTree<>(new Personaje("Dragon", "ELLIOTT"));
		mushu.addChild(elliott);

		// Hijos de ZAZÚ
		GeneralTree<Personaje> rafiki = new GeneralTree<>(new Personaje("Animal", "RAFIKI"));
		GeneralTree<Personaje> mulan = new GeneralTree<>(new Personaje("Princesa", "MULAN"));
		zazu.addChild(rafiki);
		zazu.addChild(mulan);

		// Hijos de MULAN
		GeneralTree<Personaje> frozen = new GeneralTree<>(new Personaje("Princesa", "FROZEN"));
		GeneralTree<Personaje> nala = new GeneralTree<>(new Personaje("Animal", "NALA"));
		mulan.addChild(frozen);
		mulan.addChild(nala);
		
		EncontrarPrincesa ep = new EncontrarPrincesa(coyote);
		
		System.out.println(ep.encPrincesa());
	}
}
