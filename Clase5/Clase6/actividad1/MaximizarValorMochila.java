package actividad1;

/*	CONSIGNA
	Dada una mochila con una capacidad máxima de peso P, y dispones de n objetos.
	Cada objeto tiene un peso w y un valor v.
	El objetivo es seleccionar algunos objetos de manera que maximicen el valor
	total, sin superar la capacidad de la mochila, que es de 6
	Se pide realizar una prueba de escritorio para fuerza bruta y para programación
	dinámica, indicando el resultado.		
*/

public class MaximizarValorMochila {
	
	static class Item {
	    double value, weight;

	    Item(double value, double weight) {
	        this.value = value;
	        this.weight = weight;
	    }
	}

	// Clase que almacena el resultado de la mejor combinación
	static class Resultado {
	    int rendimientoMaximo;
	    int costoTotal;

	    public Resultado(int rendimientoMaximo, int costoTotal) {
	        this.rendimientoMaximo = rendimientoMaximo;
	        this.costoTotal = costoTotal;
	    }
	}

	// FUERZA BRUTA - (mejor combinación)
	static Resultado seleccionConFuerzaBruta(Item[] objetos, int presupuesto) {
	    int n = objetos.length;
	    int mejorRendimiento = 0;
	    int mejorCosto = 0;

	    // Probamos 2^n combinaciones
	    for (int i = 0; i < (1 << n); i++) {  // "1 << n" es 2^n
	        int costoTotal = 0;
	        int rendimientoTotal = 0;

	        // Recorremos cada bit de la combinación actual
	        for (int j = 0; j < n; j++) {
	            if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
	                costoTotal += objetos[j].weight;
	                rendimientoTotal += objetos[j].value;
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
		
	    Item[] items = {
	        new Item(4, 3), // Objeto 1: (valor, peso)
	        new Item(5, 4), // Objeto 2: (valor, peso)
	        new Item(3, 2), // Objeto 3: (valor, peso)
	    };

	    int capacidadMochila = 6;
	    
	    
	    //desglosamos items en dos arreglos
	    double[] costos = new double[items.length];			// Costos o pesos
	    double[] rendimientos = new double[items.length]; 	// Rendimientos o valor
	    
	    for (int i = 0; i < items.length; i++) {
	    	costos[i] = items[i].weight;
	    	rendimientos[i] = items[i].value;
	    }
	    
	    //Resultados
	    System.out.println("Dada una mochila con capacidad " + capacidadMochila + " y los objetos:");
	    for (int i = 0; i < items.length; i++) {
	    	System.out.println("Objeto " + (i+1) + " -> " + "Valor: " + items[i].value + " Peso: " + items[i].weight);
	    }
	    Resultado valorMaxFuerzaBruta = seleccionConFuerzaBruta(items, capacidadMochila);
	    System.out.println("Resultado de maximización utilizando fuerza bruta: " + valorMaxFuerzaBruta.rendimientoMaximo);

	    int valorMaxPrograDin = seleccionConPrograDin(costos, rendimientos, capacidadMochila);
	    System.out.println("Resultado de maximización utilizando programación dinámica: " + valorMaxPrograDin);
	}

}
