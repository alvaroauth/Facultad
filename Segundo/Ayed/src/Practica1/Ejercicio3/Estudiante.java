package Practica1.Ejercicio3;

public class Estudiante extends Persona {
	private String comision;
	private String direccion;
	public Estudiante(String nombre, String apellido, String email, String comision, String direccion) {
		super(nombre, apellido, email);
		this.setComision(comision);
		this.setDireccion(direccion);
	}
	public String getComision() {
		return comision;
	}
	private void setComision(String comision) {
		this.comision = comision;
	}
	public String getDireccion() {
		return direccion;
	}
	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String tusDatos() {
		String aux = super.tusDatos();
		aux += " --> Comision: "+this.getComision()+"\n";
		aux += " --> Direccion: "+this.getDireccion()+"\n";
		return aux;
	}
}