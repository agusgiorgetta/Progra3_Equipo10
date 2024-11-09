package actividad3;

public class Almacen {
	
	private int id;
	private String nombre;
	
	public Almacen(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "Almacen [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
