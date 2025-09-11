package Practica1.Ejercicio5;

public class Calculadora {
	static Resultado res;
	public Calculadora() {
	}
	
	public static Resultado metodo1 (int [] nums) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int suma = 0;
		for( int i=0; i<nums.length; i++) {
			
			if(nums[i] > max)
                max = nums[i];
            if(nums[i] < min)
                min = nums[i];
            suma += nums[i];
		}
		double prom = suma / nums.length;
		return new Resultado(min,max,prom);
	}
	
	public static void metodo2(int[] nums, Resultado r) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int suma = 0;
		for( int i=0; i<nums.length; i++) {
			
			if(nums[i] > max)
                max = nums[i];
            if(nums[i] < min)
                min = nums[i];
            suma += nums[i];
		}
		double prom = suma / nums.length;
		
		r.setMax(max);
		r.setMin(min);
		r.setProm(prom);
	}
	
	public static void metodo3(int[] nums) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int suma = 0;
		for( int i=0; i<nums.length; i++) {
			
			if(nums[i] > max)
                max = nums[i];
            if(nums[i] < min)
                min = nums[i];
            suma += nums[i];
		}
		double prom = suma / nums.length;
		setResultado(min, max, prom);
	}
	
	private static void setResultado(int min, int max, double prom) {
		res = new Resultado(min,max,prom);
	}
}
