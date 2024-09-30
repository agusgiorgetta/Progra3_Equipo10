package actividad2;

/*	CONSIGNA
	El objetivo es seleccionar algunos objetos de manera que maximicen el valor total,
	sin superar la capacidad de la mochila, que es de 10. Se pide realizar una prueba de escritorio
	para fuerza bruta y para programación dinámica, indicando el resultado.	
*/
public class MaxValorFByPD {	//FB=fuerza bruta	PD=progra dinamica
	
	//FUERZA BRUTA
	static class Resultado {	//almacena los resultados de la fuerza bruta
	    int rendimientoMaximo;
	    int costoTotal;

	    public Resultado(int rendimientoMaximo, int costoTotal) {
	        this.rendimientoMaximo = rendimientoMaximo;
	        this.costoTotal = costoTotal;
	    }
	}
	
	static Resultado seleccionConFuerzaBruta(double[] costos, double[] rendimientos, int presupuesto) {
	    int n = costos.length;
	    int mejorRendimiento = 0;
	    int mejorCosto = 0;

	    // Probamos 2^n combinaciones
	    for (int i = 0; i < (1 << n); i++) {  // "1 << n" es 2^n
	        int costoTotal = 0;
	        int rendimientoTotal = 0;

	        // Recorremos cada bit de la combinación actual
	        for (int j = 0; j < n; j++) {
	            if ((i & (1 << j)) != 0) { 
	                costoTotal += costos[j];
	                rendimientoTotal += rendimientos[j];
	            }
	        }

	        // Verificamos que el costo total no exceda el presupuesto y si el rendimiento es mejor
	        if (costoTotal <= presupuesto && rendimientoTotal > mejorRendimiento) {
	            mejorRendimiento = rendimientoTotal;
	            mejorCosto = costoTotal;
	        }
	    }

	    return new Resultado(mejorRendimiento, mejorCosto);
	}

	//PROGRAMACION DINAMICA
	public static int seleccionConPrograDin(double[] costos, double[] rendimientos, int presupuesto) {
	    int n = costos.length;
	    int[][] dp = new int[n + 1][presupuesto + 1];

	    for (int i = 1; i <= n; i++) {
	        for (int j = 0; j <= presupuesto; j++) {
	            if (costos[i - 1] <= j) {
	                dp[i][j] = (int) Math.max(dp[i - 1][j], dp[i - 1][(int) (j - costos[i - 1])] + rendimientos[i - 1]);
	            } else {
	                dp[i][j] = dp[i - 1][j];
	            }
	        }
	    }

	    return dp[n][presupuesto];
	}

	public static void main(String[] args) {
		
		double[] costos = {2, 5, 6, 7};		//costos o pesos
		double[] valores = {4, 2, 1, 6};	//valores o rendimientos
		
	    int capacidadMochila = 10;
	    
	    //Resultados
	    System.out.println("Dada una mochila con capacidad " + capacidadMochila + " y los objetos:");
	    for (int i = 0; i < costos.length; i++) {
	    	System.out.println("Objeto " + (i+1) + " -> " + "Valor: " + valores[i] + " Peso: " + costos[i]);
	    }
	    Resultado valorMaxFuerzaBruta = seleccionConFuerzaBruta(costos, valores, capacidadMochila);
	    System.out.println("Resultado de maximización utilizando fuerza bruta: " + valorMaxFuerzaBruta.rendimientoMaximo);

	    int valorMaxPrograDin = seleccionConPrograDin(costos, valores, capacidadMochila);
	    System.out.println("Resultado de maximización utilizando programación dinámica: " + valorMaxPrograDin);
	}
}
