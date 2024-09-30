package actividad1;

/*	CONSIGNA
	Realizar una prueba de escritorio para el algoritmo de Floyd-Warshall, el cual es
	un algoritmo clásico de programación dinámica que permite calcular las distancias
	más cortas entre todos los pares de nodos en un grafo ponderado. Nodos y aristas serán dados
*/
public class FloydWarshall {
	
	final static int INF = 99999;  //valor grande para representar el infinito
    
    public static void main(String[] args) {
        
    	FloydWarshall fw = new FloydWarshall();
        
        int graph[][] = { 
	    		{0, 2, INF, 5}, 	//1->2:2 y 1->4:5
	    	    {INF, 0, INF, 4}, 	//2->4:4
	    	    {INF, INF, 0, INF}, //3
	    	    {INF, INF, 2, 0} 	//4->3:2
                        };			//diagonal en 0 xq el vertice no tiene distancia de si mismo
        
        int V = graph.length;
        fw.floydWarshall(graph, V);
    }

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }
     // Actualizar la matriz de distancias
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
