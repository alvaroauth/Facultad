package ParcialesArboles.Parcial01;

import java.util.Arrays;

import Practica3.Ejercicio1.GeneralTree;

/*

Ejercicio 1 (5 puntos). Defina una clase ParcialArboles con: 
	(i) una única variable de instancia de tipo ArbolGeneral de enteros, y 
	(ii) un método público con la siguiente firma: public ListaGenerica<Integer> camino (int num). 
El método debe devolver un camino desde la raíz hasta una hoja donde cada nodo (no hoja) tenga al menos la cantidad num de hijos. 
Debe retornar el primer camino que encuentre que cumple la condición. En caso de no encontrar ninguno retornar la lista vacía. 
Por ejemplo, con un árbol como se muestra en la siguiente imagen.

Si num = 2 debe retornar: 10-8-22-28
Si num = 3 retorna lista vacía

Tenga en cuenta que:
1. No puede agregar más variables de instancia ni de clase a la clase ParcialArboles.
2. Debe respetar la firma del método indicado.
3. Puede definir todos los métodos y variables locales que considere necesarios.
4. Todo método que no esté definido en la sinopsis de clases debe ser implementado.
5. Debe recorrer la estructura sólo 1 vez para resolverlo.
6. Si durante el recorrido detecta el no cumplimiento de la condición debe cortar la ejecución.

 */
public class Parcial1 {
	public static void main(String[] args) {
		
		GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
		GeneralTree<Integer> nodo28 = new GeneralTree<>(28);
		GeneralTree<Integer> nodo55 = new GeneralTree<>(55);
		GeneralTree<Integer> nodo18 = new GeneralTree<>(18);
		GeneralTree<Integer> nodo9 = new GeneralTree<>(9);
		GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
		
		// Subárboles
		GeneralTree<Integer> nodo5_izq = new GeneralTree<>(5, Arrays.asList(nodo6));
		GeneralTree<Integer> nodo22 = new GeneralTree<>(22, Arrays.asList(nodo28, nodo55, nodo18));
		GeneralTree<Integer> nodo8 = new GeneralTree<>(8, Arrays.asList(nodo5_izq, nodo22));
		
		GeneralTree<Integer> nodo19 = new GeneralTree<>(19, Arrays.asList(nodo4));
		GeneralTree<Integer> nodo42 = new GeneralTree<>(42);
		
		GeneralTree<Integer> nodoMenos5 = new GeneralTree<>(-5,Arrays.asList(nodo19, nodo9)); // Este es hijo directo de 10 y no tiene hijos
		
		// Raíz
		GeneralTree<Integer> nodo10 = new GeneralTree<>(10, Arrays.asList(nodo8, nodo42, nodoMenos5));
		
		ParcialArboles pa1 = new ParcialArboles(nodo10);
		ParcialArboles pa2 = new ParcialArboles(nodo6);
		
		System.out.println(pa1.camino(2).toString());
		
		
		System.out.println(pa2.camino(2).toString());
	}
     

}
