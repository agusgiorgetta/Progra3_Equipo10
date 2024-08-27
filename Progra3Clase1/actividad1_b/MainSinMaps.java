package actividad1_b;

import java.util.ArrayList;

public class MainSinMaps {
	/*Un sistema de facturación, recibe una lista de comprobantes facturas
	electrónicas, con id de factura, id de cliente, e importe y una lista de clientes,
	con id cliente, y nombre de cliente, realizar un código de java, que genere
	otra lista, con id cliente, suma importes de las facturas.
	*/
	
	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		
		//carga de datos a las listas
		Cliente c1 = new Cliente(1000, "Pedro");
		Cliente c2 = new Cliente(1001, "Juan");
		Cliente c3 = new Cliente(1002, "Roberto");
		Cliente c4 = new Cliente(1003, "Carlos");
		
		Factura f1 = new Factura(1, 1000, 1500);
		Factura f2 = new Factura(2, 1002, 3500);
		Factura f3 = new Factura(3, 1003, 2600);
		Factura f4 = new Factura(1, 1000, 5000);
		
		//añadimos a las listas
		sistema.getClientes().add(c1);
		sistema.getClientes().add(c2);
		sistema.getClientes().add(c3);
		sistema.getClientes().add(c4);
		
		sistema.getFacturas().add(f1);
		sistema.getFacturas().add(f2);
		sistema.getFacturas().add(f3);
		sistema.getFacturas().add(f4);
		
		//
		ArrayList<ResultadoSinMaps> resultado = new ArrayList<ResultadoSinMaps>();
		for (Factura f : sistema.getFacturas()) {
			boolean encontrado = false;

		    for (ResultadoSinMaps r : resultado) {
		        if (r.getIdCliente() == f.getIdCliente()) {
		            r.setImporte(r.getImporte() + f.getImporte());
		            encontrado = true;
		        }
		    }

		    // Si el cliente no fue encontrado, lo agregamos a la lista resultado
		    if (!encontrado) {
		        resultado.add(new ResultadoSinMaps(f.getIdCliente(), f.getImporte()));
		    }
		}
		
		
		//imprimimos valores
		for (ResultadoSinMaps r : resultado) {
			System.out.println("Cliente ID: " + r.getIdCliente() + " - " + r.getImporte());
		}
		
	}

}
