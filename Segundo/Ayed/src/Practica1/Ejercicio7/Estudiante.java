package Practica1.Ejercicio7;
public class Estudiante {
	private String comision;
	private String direccion;
	private String nombre;
	private String apellido;
	private String email;
	
	public Estudiante(String nombre, String apellido, String email, String comision, String direccion) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setComision(comision);
		this.setDireccion(direccion);
	}
	
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	private void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
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
	
	public void actualizarEmail(String e) {
		this.setEmail(e);
	}
	
	@Override
	public String toString() {
		String aux = " ---> "+this.getNombre()+" "+this.getApellido()+" <--- "+"\n";
		aux += " --> Email: "+this.getEmail()+"\n";
		aux += " --> Comision: "+this.getComision()+"\n";
		aux += " --> Direccion: "+this.getDireccion()+"\n";
		return aux;
	}
}

