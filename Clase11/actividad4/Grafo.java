package actividad4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {

	private List<Usuario> usuarios; 
    private List<LinkedList<Usuario>> adj;

    public Grafo() {
    	usuarios = new ArrayList<>();
        adj = new ArrayList<>();
    }

    public void agregarUsuario(Usuario user) { //crear vertice
    	usuarios.add(user);
        adj.add(new LinkedList<>());
    }

    public void conectarUsuarios(Usuario origen, Usuario destino) { //agregar arista
        int indiceOrigen = usuarios.indexOf(origen);
        int indiceDestino = usuarios.indexOf(destino);
        
        if (indiceOrigen != -1 && indiceDestino != -1) {
            adj.get(indiceOrigen).add(destino); 
            adj.get(indiceDestino).add(origen);
        }
    }

    // Implementación de BFS
    public void BFS(Usuario inicio) {
        int indiceInicio = usuarios.indexOf(inicio);
        
        if (indiceInicio == -1) //condicion de salida
        	return;

        boolean[] visitado = new boolean[usuarios.size()];
        LinkedList<Usuario> cola = new LinkedList<>();

        visitado[indiceInicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
        	Usuario actual = cola.poll();
            System.out.print(" -> " + actual.getNombre());

            int indiceActual = usuarios.indexOf(actual);
            for (Usuario vecino : adj.get(indiceActual)) {
                int indiceVecino = usuarios.indexOf(vecino);
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
        System.out.print(" -> " + usuarios.get(index).getNombre());

        for (Usuario vecino : adj.get(index)) {
            int indiceVecino = usuarios.indexOf(vecino);
            if (!visitado[indiceVecino]) {
                DFSUtil(indiceVecino, visitado);
            }
        }
    }

    // Método principal DFS
    public void DFS(Usuario inicio) {
        int indiceInicio = usuarios.indexOf(inicio);
        
        if (indiceInicio == -1) //condicion de salida
        	return;

        boolean[] visitado = new boolean[usuarios.size()];
        DFSUtil(indiceInicio, visitado);
    }
}
