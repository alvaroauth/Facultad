package ParcialesArboles.Parcial06;

import Practica2.Ejercicio1.BinaryTree;

/*

Las operaciones esDragon(): boolean y esPrincesa(): boolean permiten averiguar si un personaje es un dragón o una princesa respectivamente.
Suponemos que ningún personaje es un dragón y princesa a la vez, y que un personaje puede no ser ninguna de las dos cosas.

Dado un árbol binario de personajes, se denominan nodos accesibles a aquellos nodos tales que a lo largo de la raíz hasta la hoja NO se encuentra ningún dragón.

Debe implementar un método:
	princesaAccesible(): Personaje
en la clase árbol binario que encuentre una princesa accesible.

 */
public class Parcial6 {
	public static void main(String[] args) {
		BinaryTree<Personaje> raiz = new BinaryTree<>(new Personaje("Otro", "X"));

        BinaryTree<Personaje> dragon = new BinaryTree<>(new Personaje("Dragon", "Draco"));
        BinaryTree<Personaje> princesaNoAccesible = new BinaryTree<>(new Personaje("Princesa", "Luna"));
        dragon.addLeftChild(princesaNoAccesible);
        raiz.addLeftChild(dragon);

        BinaryTree<Personaje> z = new BinaryTree<>(new Personaje("Otro", "Z"));
        BinaryTree<Personaje> w = new BinaryTree<>(new Personaje("Otro", "W"));
        BinaryTree<Personaje> princesaAccesible = new BinaryTree<>(new Personaje("Princesa", "Estela"));

        w.addLeftChild(princesaAccesible);
        z.addRightChild(w);
        raiz.addRightChild(z);
        
        Parcial p = new Parcial(raiz);
        
        System.out.println(p.recorridoPrincesa());
	}
}
