package actividad2;
/*	CONSIGNA
	Dada una lista de números, encontrar los dos números mayores
	utilizando la técnica de Divide y Conquista.
	Realiza el análisis de recurrencia conceptual por el
	método inductivo para determinar la	complejidad.
*/
public class LosDosNumMayores_DyV {
	
	public static void main(String[] args) {
		//creamos la lista de numeros
        int[] numeros = { 3, 1, 4, 1, 5, 9, 2, 6, 5 };
        
        int[] mayores = encontrarMayores(numeros);
        System.out.println("Mayor 1: "+mayores[0]+ "\nMayor 2: "+mayores[1]);
    }

//algoritmo divide y veceras
    private static int[] encontrarMayores(int[] numeros) {
        return encontrarMayores(numeros,0,numeros.length);
    }
    
    private static int[] encontrarMayores(int[] numeros, int inicio, int fin) {
        // Caso base: si hay un solo número
        if (fin - inicio == 1) {
            return new int[] { numeros[inicio], 0};	
        }

        // División del problema
        int mitad = (fin + inicio) / 2;

        // Resolución recursiva
        int[] izq = encontrarMayores(numeros, inicio, mitad);	//O(n/2)
        int[] der = encontrarMayores(numeros, mitad, fin);		//O(n/2)

        // Combinación de soluciones
        return combinarSoluciones(izq, der);	//O(1)
        
    }//Complejidad total: 2*O(n/2) + O(1) = O(n)
    //dado que nuestro metodo de combinacion es O(n) el resultado sigue siendo O(n)

    private static int[] combinarSoluciones(int[] izq, int[] der) {
        int mayor1, mayor2;
        if (izq[0] > der[0]) {
            mayor1 = izq[0];
            mayor2 = Math.max(izq[1], der[0]);
        } else {
            mayor1 = der[0];
            mayor2 = Math.max(izq[0], der[1]);
        }
        int[] mayores = {mayor1, mayor2};
        return mayores; // O(1)
    }
}
