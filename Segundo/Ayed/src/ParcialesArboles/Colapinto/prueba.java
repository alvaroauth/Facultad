package ParcialesArboles.Colapinto;

import ParcialesArboles.Parcial04.Parcial;
import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
		// Nodo raíz (sin datos, como se ve en la imagen)
		GeneralTree<Vueltas> raiz = new GeneralTree<>(new Vueltas(0, "Soft"));

		// Nivel 1
		GeneralTree<Vueltas> nodo10Soft = new GeneralTree<>(new Vueltas(10, "Soft"));
		GeneralTree<Vueltas> nodo20Hard = new GeneralTree<>(new Vueltas(20, "Hard"));
		GeneralTree<Vueltas> nodo35Hard = new GeneralTree<>(new Vueltas(35, "Hard"));
		raiz.addChild(nodo10Soft);
		raiz.addChild(nodo20Hard);
		raiz.addChild(nodo35Hard);

		// Nivel 2
		GeneralTree<Vueltas> nodo10Soft_2 = new GeneralTree<>(new Vueltas(10, "Soft"));
		nodo10Soft.addChild(nodo10Soft_2);

		GeneralTree<Vueltas> nodo30Hard = new GeneralTree<>(new Vueltas(30, "Hard"));
		nodo20Hard.addChild(nodo30Hard);

		GeneralTree<Vueltas> nodo15Med = new GeneralTree<>(new Vueltas(15, "Med"));
		nodo20Hard.addChild(nodo15Med);

		GeneralTree<Vueltas> nodo15Soft = new GeneralTree<>(new Vueltas(15, "Soft"));
		nodo35Hard.addChild(nodo15Soft);

		// Nivel 3
		GeneralTree<Vueltas> nodo30Hard_2 = new GeneralTree<>(new Vueltas(30, "Hard"));
		nodo10Soft_2.addChild(nodo30Hard_2);

		GeneralTree<Vueltas> nodo15Med_2 = new GeneralTree<>(new Vueltas(15, "Med"));
		nodo15Med.addChild(nodo15Med_2);
		
		System.out.println(ParcialArboles.mejorEstrategia(raiz));
	}
}
