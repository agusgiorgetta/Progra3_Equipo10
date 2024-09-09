package actividad1_b;

import java.util.HashMap;

public class MainConMaps {

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
		
		HashMap<Integer, Double> resultados = new HashMap<>();
		
	    for (Factura f : sistema.getFacturas()) {
	        int clienteId = f.getIdCliente();
	        double importe = f.getImporte();

	        // Verificar si el cliente ya existe en el HashMap
	        if (resultados.containsKey(clienteId)) {
	            // Si ya existe, sumar el importe al total actual
	            double tot = resultados.get(clienteId) + importe;
	            resultados.put(clienteId, tot);
	        } else {
	            // Si no existe, agregar el cliente con el importe de la factura
	            resultados.put(clienteId, importe);
	        }
	    }    
	        
	  
	    // imprimir el resultado
	    for (Integer id : resultados.keySet()) {
	    	System.out.println("Cliente ID: " + id + " - " + resultados.get(id));
	    } 
	    
	}
		
}
