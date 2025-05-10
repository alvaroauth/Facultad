package ParcialesArboles.PrincesaLista;

import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
		GeneralTree<Personaje> raiz = new GeneralTree<>(new Personaje("Otro", "X"));

		// Subárbol izquierdo: Dragon con hija Princesa Luna
		GeneralTree<Personaje> dragon = new GeneralTree<>(new Personaje("Dragon", "Draco"));
		GeneralTree<Personaje> dragon2 = new GeneralTree<>(new Personaje("Dragon", "Draco2"));
		GeneralTree<Personaje> princesaLuna = new GeneralTree<>(new Personaje("Princesa", "Luna"));
		dragon.addChild(princesaLuna);

		// Subárbol derecho: Otro(Z) con hijo Otro(W) con hija Princesa Estela
		GeneralTree<Personaje> z = new GeneralTree<>(new Personaje("Otro", "Z"));
		GeneralTree<Personaje> w = new GeneralTree<>(new Personaje("Otro", "W"));
		GeneralTree<Personaje> princesaEstela = new GeneralTree<>(new Personaje("Princesa", "Estela"));
		w.addChild(princesaEstela);
		z.addChild(w);
		z.addChild(dragon2);

		// Armamos el árbol principal
		raiz.addChild(dragon);
		raiz.addChild(z);
        
        ParcialArboles p = new ParcialArboles(raiz);
        
        System.out.println(p.caminoAPrincesa());
	}
}
