package actividad1_b;

public class ResultadoSinMaps {
	//clase creada como ayuda para guardar los elementos sin hashmap
	
	private int idCliente;
	private double importe;
	
	public ResultadoSinMaps(int idCliente, double importe) {
		super();
		this.idCliente = idCliente;
		this.importe = importe;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
}
