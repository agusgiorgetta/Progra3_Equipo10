package actividad3;

import java.util.ArrayList;

/*	CONSIGNA
	dado que la consigna es igual que la act 1 se plantea una solucion con 
	arraylist en lugar de con arreglos
*/
public class ScoringClienteArrayList {
	public static void main(String[] args) {
        //creamos una lista de clientes
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente(0, "Juan Gomez", 800));
		clientes.add(new Cliente(1, "Rober Perez", 1300));
		clientes.add(new Cliente(2, "Ana Lopez", 1000));
		clientes.add(new Cliente(3, "Julio Tess", 500));
		
    	Cliente scoringMaximo = maxScoring(clientes);
        System.out.println("El máximo scoring es del " + scoringMaximo);
    }
    
 //algoritmo divide y veceras   
    private static Cliente maxScoring(ArrayList<Cliente> clientes) {
        return maxScoring(clientes, 0, clientes.size());
    }
    
    private static Cliente maxScoring(ArrayList<Cliente> clientes, int inicio, int fin) {
        //caso base (si solo hay 1 cliente)
    	if(inicio == fin - 1) 
        	return clientes.get(inicio);	//O(1), devolver cliente es constante
    	
    	//division del problema
    	int mitad = (fin + inicio)/2;	//O(1), calcular el medio es constante
    	
    	//resolucion recursiva
    	Cliente izq = maxScoring(clientes, inicio, mitad);
    	Cliente der = maxScoring(clientes, mitad, fin);
        		//se divide el problema en dos de tamaño n/2 --> 2 * O(n/2)
    	
    	//combinacion de soluciones
    	if(izq.getScoring() > der.getScoring()) {
    		return izq;
    	} else {
    		return der;
    	}					//la comparacion de soluciones es O(1)
    }
    
    //Complejidad total: 2*O(n/2) + O(1) = O(n) --> costo lineal
}
