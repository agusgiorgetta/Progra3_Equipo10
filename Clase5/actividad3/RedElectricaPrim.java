package actividad3;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/*	CONSIGNA
	Una empresa de energía necesita conectar varias estaciones eléctricas en una
	región para asegurar que toda la zona esté alimentada de manera eficiente. Las
	estaciones están ubicadas en diferentes ciudades y los costos de instalación de
	las líneas eléctricas entre ellas varían según la distancia y el terreno.
	Tareas:
	Representar el grafo utilizando una lista de adyacencia.
	Aplicar el algoritmo de Prim para determinar el Árbol de Recubrimiento Mínimo.
	Mostrar el conjunto de conexiones resultante y calcular el costo total.	
*/
public class RedElectricaPrim {
	
	private static final int INF = Integer.MAX_VALUE;

    public static void primMST(int numVertices, List<List<int[]>> graph) {
        int[] key = new int[numVertices];  // Array to store the minimum weight edge to include in MST
        int[] parent = new int[numVertices];  // Array to store the resultant MST
        boolean[] inMST = new boolean[numVertices];  // Array to track vertices included in MST

        Arrays.fill(key, INF);  // Initialize key values as infinite
        key[0] = 0;  // Start from the first vertex
        parent[0] = -1;  // First node is always the root of the MST

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minKey(numVertices, key, inMST);  // Pick the minimum key vertex not yet included in MST
            inMST[u] = true;  // Include u in MST

            // Update key and parent index of the adjacent vertices of the picked vertex
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Update the key only if v is not in MST and weight of (u, v) is smaller than current key of v
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                }
            }
        }

        printMST(parent, numVertices, graph);
    }

    private static int minKey(int numVertices, int[] key, boolean[] inMST) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printMST(int[] parent, int numVertices, List<List<int[]>> graph) {
        System.out.println("Conexiones del Árbol de Recubrimiento Mínimo: ");
        int costoTotal = 0;
        for (int i = 1; i < numVertices; i++) {
            for (int[] neighbor : graph.get(i)) {
                if (neighbor[0] == parent[i]) {
                    System.out.println("Estación " + parent[i] + " - Estación " + i + " (Costo: " + neighbor[1] + ")");
                    costoTotal += neighbor[1];
                }
            }
        }
        System.out.println("El costo total del MST: " + costoTotal);
    }
    
    
    public static void main(String[] args) {
    	 int numVertices = 6;
         List<List<int[]>> graph = new ArrayList<>();

         for (int i = 0; i < numVertices; i++) {
             graph.add(new ArrayList<>());
         }

         //agregamos las conexiones entre estaciones y sus costos
         graph.get(0).add(new int[]{1, 4});	//A-B
         graph.get(1).add(new int[]{0, 4});	//B-A
         graph.get(0).add(new int[]{2, 4});	//A-C
         graph.get(2).add(new int[]{0, 4});	//C-A
         graph.get(1).add(new int[]{2, 2});	//B-C
         graph.get(2).add(new int[]{1, 2});	//C-B
         graph.get(1).add(new int[]{3, 6});	//B-D
         graph.get(3).add(new int[]{1, 6}); //D-B
         graph.get(2).add(new int[]{3, 8});	//C-D
         graph.get(3).add(new int[]{2, 8}); //D-C
         graph.get(2).add(new int[]{4, 9}); //C-E
         graph.get(4).add(new int[]{2, 9}); //E-C
         graph.get(3).add(new int[]{5, 7}); //D-F
         graph.get(5).add(new int[]{3, 7}); //F-D
         graph.get(4).add(new int[]{5, 5}); //E-F
         graph.get(5).add(new int[]{4, 5}); //F-E

        primMST(numVertices, graph);
    }
}
