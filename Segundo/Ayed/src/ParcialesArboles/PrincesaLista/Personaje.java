package ParcialesArboles.PrincesaLista;

public class Personaje {
	
	private String tipo;
	private String nombre;
	
	public Personaje(String tipo, String nombre) {
		super();
		this.setTipo(tipo);
		this.setNombre(nombre);
	}
	
	public String getTipo() {
		return tipo;
	}
	
	private void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean esDragon() {
		return this.getTipo().equals("Dragon");
	}
	
	public boolean esPrincesa() {
		return this.getTipo().equals("Princesa");
	}

	@Override
	public String toString() {
		return "Tipo: " + tipo + ", Nombre: " + nombre+"   ";
	}
	
	
	
	
	
	
}
