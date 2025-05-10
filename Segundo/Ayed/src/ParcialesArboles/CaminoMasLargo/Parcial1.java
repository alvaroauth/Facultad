package ParcialesArboles.CaminoMasLargo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
		
		GeneralTree<Integer> n40 = new GeneralTree<>(40);
		GeneralTree<Integer> n50 = new GeneralTree<>(50);
		GeneralTree<Integer> n60 = new GeneralTree<>(60);
		List<GeneralTree<Integer>> hijos20 = new LinkedList<>();
		hijos20.add(n40);
		hijos20.add(n50);
		hijos20.add(n60);
		GeneralTree<Integer> n20 = new GeneralTree<>(20, hijos20);

		GeneralTree<Integer> n30 = new GeneralTree<>(30);
		List<GeneralTree<Integer>> hijosRaiz = new LinkedList<>();
		hijosRaiz.add(n20);
		hijosRaiz.add(n30);
		GeneralTree<Integer> raiz = new GeneralTree<>(10, hijosRaiz);
		
		n50.addChild(new GeneralTree<>(100));
		
		ParcialArboles pa = new ParcialArboles(raiz);
		
		System.out.println(pa.camino());
		
	}
     

}
