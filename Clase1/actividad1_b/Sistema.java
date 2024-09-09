package actividad1_b;

import java.util.ArrayList;

public class Sistema {
	
	private ArrayList<Factura> facturas;
	private ArrayList<Cliente> clientes;
	
	public Sistema() {
		facturas = new ArrayList<Factura>();
		clientes = new ArrayList<Cliente>();
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
}
