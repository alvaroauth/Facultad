package Practica1.Ejercicio3;
public class Profesor extends Persona {
	private String catedra;
	private String facultad;
	
	public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
		super(nombre, apellido, email);
		this.setCatedra(catedra);
		this.setFacultad(facultad);
	}

	public String getCatedra() {
		return catedra;
	}

	private void setCatedra(String catedra) {
		this.catedra = catedra;
	}

	public String getFacultad() {
		return facultad;
	}

	private void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	@Override
	public String tusDatos() {
		String aux = super.tusDatos();
		aux += " --> Facultad: "+this.getFacultad()+"\n";
		aux += " --> Catedra: "+this.getCatedra()+"\n";
		return aux;
	}
}
