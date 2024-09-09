package actividad1_a;

import java.util.Random;

public class PuntoA {
	/*Realizar un programa en java, dado un array, calcular el máximo.
		¿ Cual es el orden de complejidad asintótica ?
	 */
	
	public static void mostrarArray(int[] array) {
		System.out.print("[ ");
		for (int i = 0; i < array.length; i++) {
			
			System.out.print(array[i] + " ");
		}
		System.out.print("]\n");
	}
	
	public static void main(String[] args) {
		
		int [] array = new int[10];
		//ingreso de datos al arreglo
		Random numAleatorio = new Random();
		for (int i = 0; i < 10; i++) {
			array[i] = numAleatorio.nextInt(25);
		}
		
		/*	si usamos numAleatorio.nextInt(25), se genera un num al azar entre 0 y 24. Si a la
		 * 	sentencia le agregamos numAleatorio.nextInt(25)+1, entonces el rango es de 1 a 25.
		 * 	Lo mismo si es +2, el valor inicial cambia y el rango es de 2 a 26.
		 */
		
		//calculamos el maximo
		int maximo = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maximo) {
				maximo = array[i];
			}
		}
		
		
		mostrarArray(array);
		System.out.println("El máximo del arreglo es: " + maximo);
	}
}
