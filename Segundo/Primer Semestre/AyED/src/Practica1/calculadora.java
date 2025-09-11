package Practica1;

public class calculadora {
	public static void imprimirFor (int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	public static void imprimirWhile (int a, int b) {
		int i = a;
		while (i <= b) {
			System.out.println(i++);
		}
	}
	public static void imprimirRec (int a, int b) {
		System.out.println(a);
		if (a<b) {
			imprimirRec(a+1,b);
		}
	}
}
