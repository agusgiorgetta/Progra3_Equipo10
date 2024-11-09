package actividad3;

/*	CONSIGNA
	Desarrolla una aplicación que permita modelar una red de almacenes
	interconectados. El sistema debe: 
	- agregar almacenes, conectar almacenes entre sí realizar recorridos en profundidad
	(DFS) y en anchura (BFS)
	Implementa una clase Almacen que debe tener un identificador único y un nombre. 
	Implementa una clase Grafo que debe:
	- agregar almacenes al grafo, conectar almacenes entre sí e implementar DFS  y BFS.
*/

public class Main {

    public static void main(String[] args) {
        
    	// Crear almacenes
        Almacen a1 = new Almacen(1, "Almacen A");
        Almacen a2 = new Almacen(2, "Almacen B");
        Almacen a3 = new Almacen(3, "Almacen C");
        Almacen a4 = new Almacen(4, "Almacen D");

        // Crear el grafo
        Grafo grafo = new Grafo();

        // Agregar almacenes
        grafo.agregarAlmacen(a1);
        grafo.agregarAlmacen(a2);
        grafo.agregarAlmacen(a3);
        grafo.agregarAlmacen(a4);

        // Conectar almacenes
        grafo.conectarAlmacenes(a1, a2);
        grafo.conectarAlmacenes(a1, a3);
        grafo.conectarAlmacenes(a2, a4);
        grafo.conectarAlmacenes(a3, a4);

        // Realizar recorridos DFS y BFS
        System.out.println("Recorrido DFS iniciando desde " + a1.getNombre() + ":");
        grafo.DFS(a1);
        System.out.println();
        System.out.println("\nRecorrido BFS iniciando desde " + a1.getNombre() + ":");
        grafo.BFS(a1);
    
    }
}
