package ParcialesArboles.Parcial07;

import java.util.List;

import Practica3.Ejercicio1.GeneralTree;

/*

Dado un árbol general, encontrar todos los caminos desde la raíz a una hoja, tales que la cantidad de nodos en el camino sea un número par. 
  Escribir el siguiente método dentro de la clase Parcial:
  
	public ?? caminosPares(ArbolGeneral<Character> arbol)
	
        A
      / | \
     B  C  D
    /   | \
   E    F  G
       / \
      H   I
      
Caminos con cantidad de nodos pares:

 - A C F H

 - A C F I

 - A D

Caminos con cantidad de nodos impares:

 - A B E

 - A C G

 */
public class Parcial7 {
	public static void main(String[] args) {
		GeneralTree<Character> arbol = new GeneralTree<>('A');

		// Nivel 1
		GeneralTree<Character> nodoB = new GeneralTree<>('B');
		GeneralTree<Character> nodoC = new GeneralTree<>('C');
		GeneralTree<Character> nodoD = new GeneralTree<>('D');
		arbol.addChild(nodoB);
		arbol.addChild(nodoC);
		arbol.addChild(nodoD);

		// Nivel 2
		GeneralTree<Character> nodoE = new GeneralTree<>('E');
		GeneralTree<Character> nodoF = new GeneralTree<>('F');
		GeneralTree<Character> nodoG = new GeneralTree<>('G');
		nodoB.addChild(nodoE);
		nodoC.addChild(nodoF);
		nodoC.addChild(nodoG);

		// Nivel 3
		GeneralTree<Character> nodoH = new GeneralTree<>('H');
		GeneralTree<Character> nodoI = new GeneralTree<>('I');
		nodoF.addChild(nodoH);
		nodoF.addChild(nodoI);
		
		for (List<Character> l : Parcial.caminosPares(arbol)) {
			System.out.println(l);
			System.out.println();
		}
			
	}
}
