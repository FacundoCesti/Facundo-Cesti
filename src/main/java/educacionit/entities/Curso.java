package educacionit.entities;

public class Curso {
	
	private int id;
	private String nombre;
	private int tecnologia;
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(int id, String nombre, int tecnologia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tecnologia = tecnologia;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", tecnologia=" + tecnologia + "]";
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

	public int getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(int tecnologia) {
		this.tecnologia = tecnologia;
	}

}
