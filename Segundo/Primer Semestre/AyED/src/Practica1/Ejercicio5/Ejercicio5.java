package Practica1.Ejercicio5;
/*

Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio
en un único método. Escriba tres métodos de clase, donde respectivamente:
a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").
b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de
tipo arreglo).
c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".

*/
public class Ejercicio5 {
	public static void main(String[] args) {
		int[] arreglo = {6,7,3,9,10,5,1};
		System.out.println("-*-*-*-*-*-*-*-*-* Metodo 1 *-*-*-*-*-*-*-*-*-");
		Resultado r1 = Calculadora.metodo1(arreglo);
		System.out.println(r1.toString());
		
		System.out.println("-*-*-*-*-*-*-*-*-* Metodo 2 *-*-*-*-*-*-*-*-*-");
		Resultado r2 = new Resultado();
		Calculadora.metodo2(arreglo, r2);
		System.out.println(r2.toString());
		
		System.out.println("-*-*-*-*-*-*-*-*-* Metodo 3 *-*-*-*-*-*-*-*-*-");
		Calculadora.metodo3(arreglo);
		System.out.println(Calculadora.res.toString());
	}
}
