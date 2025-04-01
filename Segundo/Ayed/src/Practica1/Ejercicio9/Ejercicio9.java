package Practica1.Ejercicio9;

import java.util.Stack;
import java.util.Scanner;

public class Ejercicio9 {
	
	private static Character AperturaACierre(Character c) {
		int aux = (int)c;
		if (aux == 40) aux++;
		else aux += 2;
		Character cierre = (char)aux;
		return cierre;
	}
	private static boolean esBalanceado(String s) {
		Stack<Character> pila = new Stack<>();
		boolean ok = true;
		
		if ((s.length()%2 != 0 )||(s.length() > 0)&&(s.charAt(0) == ')')||(s.charAt(0) == ']')||(s.charAt(0) == '}')) ok = false;
		else {
			int i = 0;
			Character act, ape;
			while (i<s.length() && ok) {
				act = s.charAt(i);
				if ((act == '(')||(act == '[')||(act == '{')) pila.push(act);
				else if (!pila.isEmpty()) {
					ape = pila.pop();
					if (AperturaACierre(ape) != act ) ok = false;
				}
				i++;
			}
			if (!pila.isEmpty()) ok = false;
		}
		return ok;
	}
	public static void main(String[] args) {
		System.out.println("Ingrese una cadena de llaves, corchetes y parentesis");
		Scanner sc = new Scanner(System.in);
		String cadena = sc.nextLine();
		if (esBalanceado(cadena)) System.out.println("La cadena es balanceada");
		else System.out.println("La cadena no es balanceada");
	}
}
