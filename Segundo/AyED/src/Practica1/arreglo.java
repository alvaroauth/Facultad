package Practica1;

public class arreglo {
	public static int[] primos(int n) {
		int[] v = new int[n];
		int c = 0;
		for (int i = 0; i<n;i++){
			v[c++] = n*c;
		}
		return v;
	}
	public static void imprimir (int[] v) {
		for(int i=0;i<(v.length);i++) {
			System.out.println(v[i]);
		}
	}
}
