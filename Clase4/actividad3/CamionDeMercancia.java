package actividad3;

import java.util.Arrays;
/*	CONSIGNA
	Una empresa distribuidora necesita cargar un camión con mercancía que se
	puede fraccionar. Indicar con una lista los elementos a subir al camión para
	maximizar el valor total, dado que el camión tiene una capacidad limitada.
*/
public class CamionDeMercancia {
	
	// Clase para representar un objeto con su valor y peso
    static class Item {
        double value, weight, ratio;

        Item(double value, double weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = value / weight;	//relacion valor-peso
        }
    }

    public static double maximizarCargaCamion(int W, Item[] items) { //fractionalKnapsack = MochilaFraccional
    	
        // Ordenar los objetos por la relación valor/peso en orden descendente
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double maxValue = 0.0; //aqui se guardará el maximo valor que se puede obtener

        for (Item item : items) {
            if (W == 0) break; // Si la mochila está llena, terminar

            if (item.weight <= W) {
                // Tomar el objeto completo
                maxValue += item.value;
                W -= item.weight;
            } else {
                // Tomar solo la fracción del objeto que cabe en la mochila
                maxValue += item.value * ((double) W / item.weight);
                W = 0;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Item[] mercancia = {	//valor-peso
            new Item(300, 30),	//azucar
            new Item(500, 25),	//cafe
            new Item(600, 50),	//harina
            new Item(350, 60),	//arroz
            new Item(420, 45)	//aceite de cocina
        };	//valor total:2170 - peso total:210	(caso feliz)

        int W = 120; // Capacidad del camión
        
        System.out.println("Dadas las mercancías: ");
        for (Item producto : mercancia) {
        	System.out.println("Valor: "+producto.value+ " Peso: "+producto.weight);
        }
        System.out.println("\nLa capacidad del camión es: " + W);
        System.out.println("Valor máximo obtenido = " + maximizarCargaCamion(W, mercancia));
    }
}
