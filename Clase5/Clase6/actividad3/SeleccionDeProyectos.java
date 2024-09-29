package actividad3;

import java.util.Arrays;
import java.util.Comparator;
/*	CONSIGNA
	Eres el gerente de una empresa que debe decidir en qué proyectos invertir. Cada
	proyecto tiene un costo asociado y un beneficio esperado. Tienes un presupuesto
	limitado y necesitas elegir qué combinación de proyectos maximiza el beneficio
	total sin exceder el presupuesto. Se proporcionaran los datos
*/
public class SeleccionDeProyectos {
	
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
		double[] costos = {10, 15, 20, 25};
		double[] beneficiosEsperados = {100, 200, 150, 300};
		int presupuesto = 40;
		
		//relacionamos el costo y beneficio a un proyecto
		Item[] proyectos = new Item[costos.length];
		for (int i = 0; i < costos.length; i++) {
			proyectos[i] = new Item(costos[i], beneficiosEsperados[i]);
		}
		
		//Resultados
		System.out.println("SELECCION DE PROYECTOS");		
		System.out.println("El beneficio máximo que se puede obtener con el presupuesto disponible de " + presupuesto + " es: ");
		//fb
		Resultado resultado = seleccionConFuerzaBruta(proyectos, presupuesto);
		System.out.println("-> Analizando con fuerza bruta: " + resultado.rendimientoMaximo
									+ "\t(Costo total: " + resultado.costoTotal +")");
		//greedy
		System.out.println("-> Analizando con greedy: " + seleccionConGreedy(proyectos, presupuesto));
		//pd
		System.out.println("-> Analizando con programacion dinámica: " + seleccionConPrograDin(costos, beneficiosEsperados, presupuesto));
	}
	
}
