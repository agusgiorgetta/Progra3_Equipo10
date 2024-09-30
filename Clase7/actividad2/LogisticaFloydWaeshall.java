package actividad2;

/*	CONSIGNA
	Una empresa de logística tiene varios centros de distribución. Cada centro de
	distribución está conectado a otros mediante carreteras, y cada carretera tiene
	un tiempo de viaje asociado en minutos. Además, algunos centros pueden tener costos
	adicionales asociados.La empresa desea:
	-minimizar el tiempo total de entrega desde su centro principal 
	-identificar si existen ciclos negativos que podrían llevar a oportunidades de ahorro infinito
	Aplicar el algoritmo de Floyd-Warshall para: Encontrar el tiempo mínimo de entrega
	desde el centro de distribución principal hasta todos los demás centros de distribución,
	considerando las diferentes rutas disponibles.
*/
public class LogisticaFloydWaeshall {
	
	final static int INF = 99999;  //valor grande para representar el infinito
    
    public static void main(String[] args) {
    	
    	LogisticaFloydWaeshall fw = new LogisticaFloydWaeshall();
        
    	//cargamos una matriz con tiempos de viaje (en minutos) y costos negativos
    	int graph[][] = { 
                    {0, 8, 5, INF},		//Centro 0
                    {3, 0, INF, 2},		//Centro 1
                    {INF, 2, 0, 1},		//Centro 2
                    {INF, INF, -2, 0},	//Centro 3
                        };
        
    	int V = graph.length;
        
    	fw.floydWarshall(graph, V);
        
    }    
    // Variables de instancia para la matriz de distancias y la matriz de recuperación de caminos
    int[][] dist;
    int[][] P; // Matriz de recuperación de caminos

    // Algoritmo de Floyd-Warshall
    void floydWarshall(int graph[][], int V) {
        dist = new int[V][V];
        P = new int[V][V]; // Inicializamos la matriz P

        // Inicializar las matrices de distancias y recuperación de caminos
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (i != j && graph[i][j] != INF) {
                    P[i][j] = i; // Si hay un camino directo entre i y j, el antecesor es i
                } else {
                    P[i][j] = -1; // Si no hay camino, se inicializa como -1
                }
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        P[i][j] = P[k][j]; // Guardamos el vértice intermedio que permitió reducir la distancia
                    }
                }
            }
        }
        
        // Imprimir tiempos desde el centro principal
        tiemposDesdeUnOrigen(0, V);
        
        deteccionCiclosNegativos(V);
    }
    
    // Función para detectar ciclos negativos
    void deteccionCiclosNegativos(int V) {
        boolean existen = false;
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Ciclo negativo detectado en el centro " + i);
                existen = true;
            }
        }
        if (!existen) {
            System.out.println("No se detectaron ciclos negativos.");
        }
    }
    
    // Función para imprimir los tiempos mínimos de entrega desde el centro principal
    void tiemposDesdeUnOrigen(int origen, int V) {
        System.out.println("Tiempos mínimos de entrega desde el centro " + origen + ":");
        for (int i = 0; i < V; i++) {
            if (dist[origen][i] == INF) {
                System.out.println("Centro " + origen + " -> Centro " + i + ": No hay ruta");
            } else {
                System.out.println("Centro " + origen + " -> Centro " + i + ": " + dist[origen][i] + " minutos");
            }
        }
    }
}
