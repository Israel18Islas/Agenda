package agenda;



import java.io.Serializable;

public class Persona implements Serializable{

	private String nombre;
	private int edad;
	private Genero Genero;
	private String domicilio;
	private String telefono;
	private String correo;
	
	public Persona(String nombre, int edad, Genero genero, String domicilio, String telefono, String correo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		Genero = genero;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	public Persona(String nombre, int edad, Genero genero) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		Genero = genero;
	}
	
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Genero getGenero() {
		return Genero;
	}
	public void setGenero(Genero genero) {
		Genero = genero;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", Genero=" + Genero + ", domicilio=" + domicilio + ", telefono=" + telefono + ", correo=" + correo + "]";
	}
	
}
