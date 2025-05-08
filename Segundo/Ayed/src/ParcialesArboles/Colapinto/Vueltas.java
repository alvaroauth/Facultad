package ParcialesArboles.Colapinto;

public class Vueltas {
	private int vueltas;
	private String neumatico;
	
	public Vueltas(int vueltas, String neumatico) {
		super();
		this.setVueltas(vueltas);
		this.setNeumatico(neumatico);
	}

	public int getVueltas() {
		return vueltas;
	}

	private void setVueltas(int vueltas) {
		this.vueltas = vueltas;
	}

	public String getNeumatico() {
		return neumatico;
	}

	private void setNeumatico(String neumatico) {
		this.neumatico = neumatico;
	}

	@Override
	public String toString() {
		return "vueltas=" + vueltas + ", neumatico=" + neumatico + "]";
	}
}
