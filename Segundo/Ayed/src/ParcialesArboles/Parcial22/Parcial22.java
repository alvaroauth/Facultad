package ParcialesArboles.Parcial22;

import Practica3.Ejercicio1.GeneralTree;

/*

Defina una clase ParcialArboles con:
(i) una única variable de instancia de tipo ArbolGeneral<Integer>,
(ii) un método público con la siguiente firma:

java
Copiar
Editar
public ListaGenerica<Integer> camino(int num)
El método debe retornar un camino desde la raíz hasta una hoja donde cada nodo (no hoja) tenga la misma cantidad num de hijos. Debe retornar el primer camino que encuentre que cumpla la condición. En caso de no encontrar ninguno, retornar la lista vacía. Por ejemplo, con un árbol como se muestra en la siguiente imagen:

Si num = 2, debe retornar: 10 → 8 → 22 → 28

Si num = 3, retorna lista vacía

Tenga en cuenta que:

No puede agregar más variables de instancia ni de clase a la clase ParcialArboles.

Debe respetar la clase y la firma del método indicado.

Puede definir todos los métodos y variables locales que considere necesarios.

Todo método que no esté definido en la sinopsis de clases debe ser implementado.

Debe recorrer la estructura sólo 1 vez para resolverlo.

Si durante el recorrido detecta el no cumplimiento de la condición, debe cortar la ejecución.

 */
public class Parcial22 {
	public static void main(String[] args) {
		GeneralTree<Integer> arbol = new GeneralTree<Integer>(10);
        
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(5);
        subAb1.addChild(new GeneralTree<Integer>(-6));
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(22);
        subAb2.addChild(new GeneralTree<Integer>(28));
        subAb2.addChild(new GeneralTree<Integer>(55));
        subAb2.addChild(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(8);
        a1.addChild(subAb1);
        a1.addChild(subAb2);
        
        arbol.addChild(a1);
        arbol.addChild(new GeneralTree<Integer>(42));
        
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(19);
        subAb3.addChild(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(-5);
        a2.addChild(subAb3);
        a2.addChild(new GeneralTree<Integer>(-9));
        
        arbol.addChild(a2);
	        
	    ParcialArboles pa = new ParcialArboles(arbol);
	        
	    System.out.println(pa.camino(2));
	    
	    System.out.println(pa.camino(3));
	}
}
