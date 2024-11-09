package actividad2;

/*	CONSIGNA
	Realizar un sistema de selección de viajes, para llegar a un destino realizando
	escalas, con el menor precio posible, cada destino es un nodo
*/
public class SeleccionViajes {
	
	public static void main(String[] args) {
		
		UCS ucs = new UCS();

        ucs.addEdge("Argentina", "Uruguay", 5);
        ucs.addEdge("Uruguay", "España", 2);
        ucs.addEdge("España", "Estados Unidos", 2);
        ucs.addEdge("Estados Unidos", "Argentina", 4);
        ucs.addEdge("Basil", "España", 9);
        ucs.addEdge("Canada", "Estados Unidos", 3);
        ucs.addEdge("Canada", "Basil", 7);
        ucs.addEdge("Argentina", "Canada", 7);

        //objetivos
        String origen = "Argentina";
        String destino = "Canada";
        int costoTotal = ucs.uniformCostSearch(origen, destino);
        
        //respuesta
        if (costoTotal != -1 ) {
        	System.out.println("El costo desde " +origen+ " hasta " +destino+ " es: " + costoTotal);
        } else {
        	System.out.println("No se encontró un camino desde " +origen+ " hasta " +destino);
        }
	}
}
