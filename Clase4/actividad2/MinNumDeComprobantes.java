package actividad2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*	CONSIGNA
	Un sistema de tesorería tiene a disposición una variedad de comprobantes que
	incluyen monedas, cheques, bonos y otros documentos financieros. Cada
	comprobante tiene un valor específico. El objetivo es realizar una compra de
	moneda extranjera minimizando el número de comprobantes utilizados.
	Indicar la complejidad algorítmica.
*/
public class MinNumDeComprobantes {
	
	public static ArrayList<String> minimizarComprobantes(HashMap<String, Integer> comprobantes, int monto) {
		Integer[] valores = comprobantes.values().toArray(new Integer[0]); //O(n) por la iteracion de claves para añadir al array
		Arrays.sort(valores);	//O(n log n)
		ArrayList<Integer> resultado = new ArrayList<>();
		ArrayList<String> resultadoClaves = new ArrayList<>();

		for (int i = valores.length - 1; i >= 0; i--) { //O(n)
			while (monto >= valores[i]) {				//mientras sea menor al monto
				monto -= valores[i];					//la restamos -> O(m)
				resultado.add(valores[i]);				//añadimos al vuelto
			
				for (String clave : comprobantes.keySet()) {
	                if (comprobantes.get(clave).equals(valores[i])) {
	                    resultadoClaves.add(clave); // Añadimos la clave correspondiente al comprobante
	                    break;
	                }//O(n)
	            }
			}
		}//estos recorridos cuestan O(n*m*n) = O(n^2*m)
				
		return resultadoClaves;
	 }//Complejidad Total: O(n) + O(n log n) + O(n^2*m) = O(n^2*m)
	 	
	
	public static void main(String[] args) {
		HashMap<String, Integer> comprobantes = new HashMap<String, Integer>();
		comprobantes.put("Moneda", 1);
		comprobantes.put("Cheque", 10);
		comprobantes.put("Bono", 25);
		int monto = 37;

		ArrayList<String> resultado = minimizarComprobantes(comprobantes, monto);
		
		System.out.println("Dados los comprobantes:");
		for(String clave : comprobantes.keySet()) {
			System.out.println(clave + " -> " + comprobantes.get(clave));
		}
		
		System.out.println("\nSe puede llegar al monto " + monto + " con: " + resultado);
		
	}
}
