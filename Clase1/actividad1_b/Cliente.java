package actividad1_b;

public class Cliente {
	private int idCliente;
	private String nombre;

	public Cliente(int idCliente, String nombre) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
