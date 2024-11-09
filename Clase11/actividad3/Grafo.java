package actividad3;

import java.util.*;

public class Grafo {
	
	private List<Almacen> almacenes; // Lista de almacenes
    private List<LinkedList<Almacen>> adj; // Lista de adyacencia para cada almacén

    // Constructor
    public Grafo() {
        almacenes = new ArrayList<>();
        adj = new ArrayList<>();
    }

    // Agregar un almacén al grafo
    public void agregarAlmacen(Almacen almacen) { //crear vertice
        almacenes.add(almacen);
        adj.add(new LinkedList<>());
    }

    // Conectar dos almacenes
    public void conectarAlmacenes(Almacen origen, Almacen destino) { //agregar arista
        int indiceOrigen = almacenes.indexOf(origen);
        int indiceDestino = almacenes.indexOf(destino);
        
        if (indiceOrigen != -1 && indiceDestino != -1) {
            adj.get(indiceOrigen).add(destino); 
            adj.get(indiceDestino).add(origen);
        }
    }

    // Implementación de BFS
    public void BFS(Almacen inicio) {
        int indiceInicio = almacenes.indexOf(inicio);
        
        if (indiceInicio == -1) //condicion de salida
        	return;

        boolean[] visitado = new boolean[almacenes.size()];
        LinkedList<Almacen> cola = new LinkedList<>();

        visitado[indiceInicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Almacen actual = cola.poll();
            System.out.print(" -> " + actual.getNombre());

            int indiceActual = almacenes.indexOf(actual);
            for (Almacen vecino : adj.get(indiceActual)) {
                int indiceVecino = almacenes.indexOf(vecino);
                if (!visitado[indiceVecino]) {
                    visitado[indiceVecino] = true;
                    cola.add(vecino);
                }
            }
        }
    }

    // Método auxiliar de DFS que se llama recursivamente
    private void DFSUtil(int index, boolean[] visitado) {
        visitado[index] = true;
        System.out.print(" -> " + almacenes.get(index).getNombre());

        for (Almacen vecino : adj.get(index)) {
            int indiceVecino = almacenes.indexOf(vecino);
            if (!visitado[indiceVecino]) {
                DFSUtil(indiceVecino, visitado);
            }
        }
    }

    // Método principal DFS
    public void DFS(Almacen inicio) {
        int indiceInicio = almacenes.indexOf(inicio);
        
        if (indiceInicio == -1) //condicion de salida
        	return;

        boolean[] visitado = new boolean[almacenes.size()];
        DFSUtil(indiceInicio, visitado);
    }
	
}
