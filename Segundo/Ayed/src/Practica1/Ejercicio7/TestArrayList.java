package Practica1.Ejercicio7;
import java.util.*;

public class TestArrayList {

	public static void main(String[] args) {
		// ============== PUNTO A ==============
		List<Integer> L = new ArrayList<>();
		for(int i=0; i<args.length;i++) {
			L.add(Integer.parseInt(args[i]));
		}
		for(int i: L){
			System.out.println(i);
		}
		
		// ============== PUNTO B ==============
		List<Integer> L2 = new LinkedList<>();
		for(int i=0; i<args.length;i++) {
			L2.add(Integer.parseInt(args[i]));
		}
		for(int i: L2){
			System.out.println(i);
		}
		
		// ============== PUNTO C ==============
		for(int i = 0; i<L.size();i++){
			System.out.println(L.get(i));
		}
	}
}
