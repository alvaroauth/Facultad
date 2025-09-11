package Practica1.Ejercicio5;

public class Resultado {
	private int min, max;
	private double prom;
	
	public Resultado(int min, int max, double prom) {
		super();
		this.min = min;
		this.max = max;
		this.prom = prom;
	}
	public Resultado() {
		
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public double getProm() {
		return prom;
	}

	public void setProm(double prom) {
		this.prom = prom;
	}
	
	@Override
	public String toString() {
		return " ::: Maximo: "+this.getMax()+"     ::: Minimo: "+this.getMin()+"     ::: Promedio: "+this.getProm()+"\n";
	}
}
