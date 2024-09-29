package actividad2;

import java.util.ArrayList;
import java.util.List;
/*	CONSIGNA
	Implementar un grafo utilizando una matriz de adyacencia. Dado un grafo dirigido, 
	implementar las siguientes operaciones: Inicialización del Grafo, 
	Agregar Arista, Eliminar Arista, Verificar Arista, Listar Adyacentes, 
	Contar Grado de Entrada y Salida: Implementa métodos
	para contar el grado de salida (número de aristas que salen) y el grado de entrada
	(número de aristas que entran) de un vértice dado.		
*/
public class GrafoMatrizAd {	
	
	private int[][] matrizAdyacencia;
	private int numVertices;
	
    
    //operacion inicializar grafo
    public void InicializarGrafo(int numVertices) {
    	this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }
    
    //operacion agregar arista
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;	//si esta en el rango lo agrega
        } else {
            System.out.println("Los vértices ingresados estan fuera de rango.");
        }
    }
    
    //operacion eliminar arista
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0;	//si esta en el rango lo borra
        } else {
            System.out.println("Los vértices ingresados estan fuera de rango.");
        }
    }
    
    //operacion verificar arista
    public boolean existeArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matrizAdyacencia[origen][destino] == 1;	//= true
        } else {
            System.out.println("Los vértices ingresados estan fuera de rango.");
            return false;
        }
    }

    //operacion listar adyacentes (de un vertice dado)
    public List<Integer> listarAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();	//creamos lista de adyacentes
        if (vertice >= 0 && vertice < numVertices) {	//si esta en el rango
            for (int i = 0; i < numVertices; i++) {		//iniciamos un viajero desde 0 hasta el final
                if (matrizAdyacencia[vertice][i] == 1) {//si hay una relacion desde origen
                    adyacentes.add(i);					//añadimos el vertice destino a la lista
                }
            }
        } else {
            System.out.println("Los vértices ingresados estan fuera de rango.");
        }
        return adyacentes;
    }
    
    //operacion contar el grado de entrada (de un vertice dado)
    public int contarGradoEntrada(int vertice) {
        int gradoEntrada = 0;
        if (vertice >= 0 && vertice < numVertices) {		//si esta en el rango
            for (int i = 0; i < numVertices; i++) {			//creamos un viajero
                if (matrizAdyacencia[i][vertice] == 1) {	//si el vertice es el destino
                    gradoEntrada++;							//el grado de entrada crece
                }
            }
        } else {
            System.out.println("Los vértices ingresados estan fuera de rango.");
        }
        return gradoEntrada;
    }
    
    //operacion contar el grado de salida (de un vertice dado)
    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0;
        if (vertice >= 0 && vertice < numVertices) {		//si esta en el rango
            for (int i = 0; i < numVertices; i++) {			//creamos un viajero
                if (matrizAdyacencia[vertice][i] == 1) {	//si el vertice se relaciona con este
                    gradoSalida++;							//el grado de salida crece
                }
            }
        } else {
            System.out.println("Los vértices ingresados estan fuera de rango.");
        }
        return gradoSalida;
    }

    //operaacion de impresion
    public void imprimirMatrizAdy() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }   	
}
