package actividad4;

/*	CONSIGNA
	Dado un array desordenado, ordenarlo utilizando merge sort. Utilizar el código
	base que está en el repo de la materia.
*/

public class MergeSort {

	// Método principal que ordena el arreglo
    public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) {
            return; // Si el arreglo tiene 0 o 1 elementos, ya está ordenado
        }
        int medio = arreglo.length / 2;
        
        // Dividir el arreglo en dos mitades
        int[] izquierda = new int[medio];
        int[] derecha = new int[arreglo.length - medio];

        // Copiar los elementos a las mitades
        for (int i = 0; i < medio; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            derecha[i - medio] = arreglo[i];
        }

        // Llamadas recursivas para ordenar las mitades
        mergeSort(izquierda);
        mergeSort(derecha);

        // Mezclar las mitades ordenadas
        merge(arreglo, izquierda, derecha);
    }

    // Método para mezclar dos mitades ordenadas
    private static void merge(int[] arreglo, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos en orden
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }
        // Copiar los elementos restantes de la mitad izquierda
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }
        // Copiar los elementos restantes de la mitad derecha
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }
    
    public static void imprimirArray(int[] a) {
    	System.out.print("El arreglo es: { ");
    	for (int i = 0; i < a.length; i++) {
    		System.out.print(a[i]);
    		if (i < (a.length - 1)) {
    			System.out.print(", ");
    		}
    	}
    	System.out.println(" }");
    }
    
    public static void main(String[] args) {
		int[]array = {8,3,5,12,3,14,2,2,19,4};
		
		//mostramos la situacion inicial del arreglo
		imprimirArray(array);
		
		//lo ordenamos pasando los parametros a la funcion
		mergeSort(array);
		System.out.println("Ordenando arreglo, espere...");
		try {
			Thread.sleep(2000);
		}catch (InterruptedException ex){
			
		}
		
		//mostramos el resultado
		imprimirArray(array);
    
    }
    
}