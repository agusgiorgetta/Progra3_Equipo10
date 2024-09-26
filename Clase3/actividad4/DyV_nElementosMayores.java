package actividad4;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
/*	CONSIGNA
	Encontrar los "n" elementos más grandes en una lista utilizando la
	técnica de Divide y Vencerás
	Realizar el análisis de recurrencia mediante método inductivo.
*/
public class DyV_nElementosMayores {
	
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		
        int[] lista = {12, 3, 5, 19, 20, 11, 25, 6, 30, 23};
        System.out.print("Ingrese la cant de elementos más grandes a encontrar: ");
        int n = leer.nextInt();
        
        int[] resultado = encontrarNMayores(lista, n);
        System.out.println("Los " + n + " elementos más grandes son: " + Arrays.toString(resultado));
        
        leer.close();
    }

    private static int[] encontrarNMayores(int[] lista, int n) {
        return encontrarNMayores(lista, 0, lista.length, n);
    }

    public static int[] encontrarNMayores(int[] lista, int inicio, int fin, int n) {
        // Caso base: Si el rango ya tiene n o menos elementos, se devuelve el array ordenado
    	if (fin - inicio <= n) {
            int[] sublista = Arrays.copyOfRange(lista, inicio, fin); //O(n)
            Arrays.sort(sublista); //O(n log n)
            return sublista;
        }	//O(n log n)

        // División del problema
        int mitad = (inicio + fin) / 2;	//O(1)

        // Resolución recursiva
        int[] mayoresIzq = encontrarNMayores(lista, inicio, mitad, n);	//O(n/2)
        int[] mayoresDer = encontrarNMayores(lista, mitad, fin, n);		//O(n/2)

        // Combina los resultados de las dos mitades
        return combinarSoluciones(mayoresIzq, mayoresDer, n);
    }

    // Combina las dos listas de los elementos más grandes y selecciona los n mayores
    public static int[] combinarSoluciones(int[] izquierda, int[] derecha, int n) {
        // Cola de prioridad para obtener los más grandes
        PriorityQueue<Integer> cola = new PriorityQueue<>();

        // Añadimos los elementos
        for (int num : izquierda) {
        	cola.add(num);
            if (cola.size() > n) {
            	cola.poll(); // Elimina el + pequeño si el tamaño > n
            }
        }
        for (int num : derecha) {
        	cola.offer(num);
            if (cola.size() > n) {
            	cola.poll();
            }
        }

        // Juntamos en un array
        int[] resultado = new int[n];
        for (int i = 0; i < n; i++) {
            resultado[i] = cola.poll();
        }
        return resultado;
    }
}
