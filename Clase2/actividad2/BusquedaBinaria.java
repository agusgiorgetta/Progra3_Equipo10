package actividad2;

/*	CONSIGNA
 	Utilizar la implementación de la búsqueda binaria que está en el repo de la
	materia, para buscar un elemento en un array ordenado. (VER MAIN)
 */

public class BusquedaBinaria {
	
	// Método para realizar la búsqueda binaria
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            // Verificar si el objetivo está en el medio
            if (arreglo[medio] == objetivo) {
                return medio; // Retorna el índice del objetivo
            }

            // Si el objetivo es mayor, ignorar la mitad izquierda
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            } 
            // Si el objetivo es menor, ignorar la mitad derecha
            else {
                derecha = medio - 1;
            }
        }
        // Si no se encuentra el objetivo, retorna -1
        return -1;
    }
    
    
    //Método de mensajes de salida por consola según resultado de la búsqueda
    private static void output(int valorBuscado, int resultadoBusqueda) {
    	if (resultadoBusqueda == -1) {
    		System.out.println("El valor "+valorBuscado+" no ha sido encontrado.");
    	} else {
    		System.out.println("El valor "+valorBuscado+" se encontró en la posición: "+resultadoBusqueda);
    	}
    }	// O(1) -> constante, solo imprime un mensaje
    
    public static void main(String[] args) {
		
    	//creamos un arreglo para probar la búsqueda
    	int array [] = {1,2,3,4,5,6,7,8,9,10};
    	
    	int valorBuscado = 7;	//caso positivo
    	int valorBuscado2 = 11;	//caso negativo
    	
    	output(valorBuscado,busquedaBinaria(array, valorBuscado));
    	output(valorBuscado2,busquedaBinaria(array, valorBuscado2));

	}	// O(log n) -> en las llamadas a la busqueda
    	// Total = O(log n) -> porque domina sobre O(1)

}
