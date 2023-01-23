package educacionit.entities;

public class Alumno {
	
	private int id;
	private String nombre;
	
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Alumno(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
