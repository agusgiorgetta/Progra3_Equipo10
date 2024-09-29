package actividad4;

import java.util.Arrays;
import java.util.Comparator;
/*	CONSIGNA
	Eres un gestor financiero y tienes la tarea de seleccionar entre varios paquetes de
	inversión para maximizar las ganancias. Cada paquete tiene un costo inicial y una
	ganancia estimada. Sin embargo, tu presupuesto es limitado, por lo que debes elegir
	cuidadosamente qué paquetes comprar para maximizar las ganancias sin exceder el
	presupuesto.
*/
public class SeleccionPaquetesInversion {
	
	//almacena el objeto con su valor y peso - para fuerza bruta y greedy
	static class Item {
		
        double costo, rendimiento, relacion;

        Item (double costo, double rendimiento) {
            this.costo = costo;
            this.rendimiento = rendimiento;
            this.relacion = rendimiento / costo;
        }
	}//O(1)
	
	//FUERZA BRUTA
	static class Resultado {	//almacena los resultados de la fuerza bruta
	    int rendimientoMaximo;
	    int costoTotal;

	    public Resultado(int rendimientoMaximo, int costoTotal) {
	        this.rendimientoMaximo = rendimientoMaximo;
	        this.costoTotal = costoTotal;
	    }
	}//O(1)
	
	static Resultado seleccionConFuerzaBruta(Item[] objetos, int presupuesto) {
	    int n = objetos.length;
	    int mejorRendimiento = 0;
	    int mejorCosto = 0;

	    // Probamos 2^n combinaciones
	    for (int i = 0; i < (1 << n); i++) {  // "1 << n"=2^n y O(2^n)
	        int costoTotal = 0;
	        int rendimientoTotal = 0;

	        // Recorremos cada bit de la combinación actual
	        for (int j = 0; j < n; j++) {	//O(n)
	            if ((i & (1 << j)) != 0) { 
	                costoTotal += objetos[j].costo;
	                rendimientoTotal += objetos[j].rendimiento;
	            }
	        }

	        // Verificamos que el costo total no exceda el presupuesto y si el rendimiento es mejor
	        if (costoTotal <= presupuesto && rendimientoTotal > mejorRendimiento) {
	            mejorRendimiento = rendimientoTotal;
	            mejorCosto = costoTotal;
	        }
	    }

	    return new Resultado(mejorRendimiento, mejorCosto);
	}//O(2^n) + O(n) = O(2^n) = complejidad total
	
	//GREEDY
    static int seleccionConGreedy(Item[] objetos, int presupuesto) {
        // Ordenamos los jugadores por la relación rendimiento/costo de mayor a menor
        Arrays.sort(objetos, Comparator.comparingDouble(j -> -j.relacion)); //O(n log n)

        int rendimientoTotal = 0;
        int costoTotal = 0;

        // Seleccionar jugadores mientras el presupuesto lo permita
        for (Item objeto : objetos) { //O(n)
            if (costoTotal + objeto.costo <= presupuesto) {
                costoTotal += objeto.costo;
                rendimientoTotal += objeto.rendimiento;
            }
        }
        return rendimientoTotal;
    }//O(n log n) + O(n) = O(n log n) = complejidad total
    
	//PROGRAMACION DINAMICA
	public static int seleccionConPrograDin(double[] costos, double[] rendimientos, int presupuesto) {
	    int n = costos.length;
	    int[][] dp = new int[n + 1][presupuesto + 1]; //O(n*p)

	    for (int i = 1; i <= n; i++) {	//O(n)
	        for (int j = 0; j <= presupuesto; j++) { //O(p)
	            if (costos[i - 1] <= j) {
	                dp[i][j] = (int) Math.max(dp[i - 1][j], dp[i - 1][(int) (j - costos[i - 1])] + rendimientos[i - 1]);
	            } else {
	                dp[i][j] = dp[i - 1][j];
	            }
	        }
	    }

	    return dp[n][presupuesto];
	}//O(n*p) + O(n) + O(p) = O(n*p) = complejidad total
		
	public static void main(String[] args) {
		double[] costos = {12, 20, 15, 25};
		double[] gananciasEsperadas = {150, 200, 100, 300};
		int presupuesto = 35;
		
		//relacionamos el costo y beneficio a un paquete de inversion
		Item[] paquetesDeInversion = new Item[costos.length];
		for (int i = 0; i < costos.length; i++) {
			paquetesDeInversion[i] = new Item(costos[i], gananciasEsperadas[i]);
		}
		
		//Resultados
		System.out.println("SELECCION DE PAQUETES DE INVERSIÓN");
		System.out.println("La ganancia máxima que puede obtenerse con el presupuesto disponible de " + presupuesto + " es: ");
		//fb
		Resultado resultado = seleccionConFuerzaBruta(paquetesDeInversion, presupuesto);
		System.out.println("-> Analizando con fuerza bruta: " + resultado.rendimientoMaximo
									+ "\t(Costo total: " + resultado.costoTotal +")");
		//greedy
		System.out.println("-> Analizando con greedy: " + seleccionConGreedy(paquetesDeInversion, presupuesto));
		//pd
		System.out.println("-> Analizando con programacion dinámica: " + seleccionConPrograDin(costos, gananciasEsperadas, presupuesto));
	
	}
}
