package actividad2;

import java.util.*;

public class UCS {
	
	class Node { //representa un destino
	    String name;
	    int cost;

	    public Node(String name, int cost) {
	        this.name = name;
	        this.cost = cost;
	    }
	}
	
	//comienzo del codigo Uniform Cost Search
	
	private final Map<String, List<Node>> graph = new HashMap<>();
	
    // Agregar conexiones al grafo
	public void addEdge(String from, String to, int cost) {
	    graph.putIfAbsent(from, new ArrayList<>());
	    graph.get(from).add(new Node(to, cost));
	}
	
	// Método para realizar la búsqueda UCS
	public int uniformCostSearch(String start, String goal) {
	    PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
	    priorityQueue.add(new Node(start, 0));
	    Set<String> visited = new HashSet<>();
	
	    while (!priorityQueue.isEmpty()) {
	    	Node current = priorityQueue.poll();
	
	        // Si alcanzamos el nodo objetivo, retornamos el costo
			if (current.name.equals(goal)) {
			    return current.cost;
			}
	
			// Si ya hemos visitado este nodo, lo ignoramos
			if (visited.contains(current.name)) continue;
			visited.add(current.name);
			
			// Explorar vecinos
		    for (Node neighbor : graph.getOrDefault(current.name, new ArrayList<>())) {
		        if (!visited.contains(neighbor.name)) {
		            priorityQueue.add(new Node(neighbor.name, current.cost + neighbor.cost));
		        }
		    }
	    }
	
	    return -1; // Retorna -1 si no se encuentra un camino
	}
}