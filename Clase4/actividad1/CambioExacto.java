package actividad1;

import java.util.ArrayList;
import java.util.Arrays;
/*	CONSIGNA
	Implementar una función que, siguiendo la técnica de diseño greedy, determine si
	es posible entregar un cambio exacto utilizando una lista de monedas disponible.
	Indicar la complejidad algorítmica
*/
public class CambioExacto {

	 public static boolean cambioExactoIs(int[] monedas, int monto) {
		 Arrays.sort(monedas);	//ordenamos de menor a mayor	--> este ordenamiento cuesta O(n log n)
		 ArrayList<Integer> resultado = new ArrayList<>();	//guardaremos el resultado aqui por si se quiere mejorar el cod
		 
		 for (int i = monedas.length - 1; i >= 0; i--) {//recorremos del mayor al menor -> O(n)
			 while (monto >= monedas[i]) {				//mientras la moneda sea menor
				 monto -= monedas[i];					//la restamos al monto -> O(m) si el monto es muy grande el while se puede ejecutar m veces
				 resultado.add(monedas[i]);				//añadimos al vuelto (que no es necesario en este ejercicio)
			 }
		 }//estos recorridos cuestan O(n*m)
		 
		 if (monto == 0) {	//si el vuelto dio justo --> true -> O(1)
			 return true;
		 } else {
			 return false;
		 }
	 }//Complejidad Total: O(n log n) + O(n*m) = depende del tamaño de m
	 					 //O(n log n) --> si m es pequeño (aunque tambien varia segun tamaño de n)
	 								  //O(n*m) --> si m es muy grande
	 
	 public static void main(String[] args) {
		 int[] monedas = {1, 5, 10, 25, 50};
		 int monto = 42;
		 boolean resultado = cambioExactoIs(monedas, monto);
		 System.out.println("Las monedas son: " + Arrays.toString(monedas));
		 System.out.println("¿Es posible dar el cambio exacto de " + monto + "? " + resultado);
	}
}
