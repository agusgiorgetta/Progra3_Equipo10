package actividad1;

public class Cliente {
	
	private int id;
	private String nombre;
	private int scoring;
	
	public Cliente(int id, String nombre, int scoring) {
		this.id = id;
		this.nombre = nombre;
		this.scoring = scoring;
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

	public int getScoring() {
		return scoring;
	}

	public void setScoring(int scoring) {
		this.scoring = scoring;
	}

	@Override
	public String toString() {
		return "Cliente [ id= " + id + ", nombre= " + nombre + ", scoring= " + scoring + " ]";
	}
	
}
