package actividad4;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/*	CONSIGNA
	Una empresa de logística tiene varios centros de distribución en diferentes
	ciudades de una región y necesita optimizar las rutas de entrega de sus
	camiones. Cada centro de distribución está conectado a otros centros mediante
	carreteras, y cada carretera tiene un tiempo de viaje asociado en minutos. La
	empresa desea minimizar el tiempo total de entrega desde su centro de
	distribución principal hasta todas las otras ciudades.
	Objetivo:
	Aplicar el algoritmo de Dijkstra para encontrar el tiempo mínimo de entrega desde
	el centro de distribución principal hasta los demás centros, considerando las
	diferentes rutas disponibles.	
*/
public class LogisticaConDijkstra {
	
	static class Edge {
        int target;
        int weight;
        
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int target, int weight) {
            adjList.get(source).add(new Edge(target, weight));
        }

        void dijkstra(int startVertex) {
            int[] distances = new int[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startVertex] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(e -> e.weight));
            pq.add(new Edge(startVertex, 0));

            boolean[] visited = new boolean[vertices];

            while (!pq.isEmpty()) {
                int u = pq.poll().target;

                if (visited[u]) continue;
                visited[u] = true;

                for (Edge edge : adjList.get(u)) {
                    int v = edge.target;
                    int weight = edge.weight;

                    if (!visited[v] && distances[u] + weight < distances[v]) {
                        distances[v] = distances[u] + weight;
                        pq.add(new Edge(v, distances[v]));
                    }
                }
            }

            printSolution(distances, startVertex);
        }
        
        void printSolution(int[] distances, int startVertex) {
            int costoTotal = 0;
            System.out.println("TIEMPOS MIN DESDE EL CENTRO PRINCIPAL " + startVertex + " HACIA LOS OTROS:\n");
            for (int i = 0; i < vertices; i++) {
                System.out.println("Centro " + startVertex + " -> Centro " + i + " (Tiempo: " + distances[i] + " minutos)");
                costoTotal += distances[i];
            }
            System.out.println("\nTiempo total: " + costoTotal + " minutos");
        }

    }
    
    
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 1);
        graph.addEdge(3, 5, 2);

        graph.dijkstra(0);  //Ejecutamos desde el vertice de la sede central
    }
}
