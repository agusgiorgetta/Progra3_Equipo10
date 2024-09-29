package actividad2;

import java.util.Scanner;

public class Main {
	
	static Scanner leer = new Scanner(System.in);
	static GrafoMatrizAd grafo = new GrafoMatrizAd();
	
	public static void main(String[] args) {
			
		//menu de operaciones
		while (true) {
			System.out.println();
			System.out.println("ELIJA UNA OPCIÓN");
			System.out.println("1- Inicializar Grafo");
			System.out.println("2- Agregar Arista");
			System.out.println("3- Eliminar Arista");
			System.out.println("4- Verificar Existencia De Arista");
			System.out.println("5- Ver lista de adyacentes de un vértice");
			System.out.println("6- Ver Grado De Entrada");
			System.out.println("7- Ver Grado De Salida");
			System.out.println("8- Imprimir Grafo");
			System.out.println("9- Salir");
			System.out.print("Opción: ");
			
			int opcion = leer.nextInt();
			System.out.println();
			switch (opcion) {
				case 1:
					InicializarGrafo();
					break;
				case 2:
					agregarArista();
					break;
				case 3:
					eliminarArista();
					break;
				case 4:
					existeArista();
					break;
				case 5:
					listarAdyacentes();
					break;
				case 6:
					contarGradoEntrada();
					break;
				case 7:
					contarGradoSalida();
					break;
				case 8:
					grafo.imprimirMatrizAdy();;
					break;
				case 9:
					System.out.println("Saliendo del sistema...");
					try {
						Thread.sleep(800);
						System.out.println("Hasta Pronto!");
					} catch (InterruptedException e) {}
					return;
				default:
					break;
			}
		}
	}
	
	public static void InicializarGrafo() {
    	System.out.print("Ingrese de cuanto por cuanto será el grafo: ");
    	int n = leer.nextInt();
    	grafo.InicializarGrafo(n);
	}
    
    public static void agregarArista() {
        System.out.print("Ingrese el vértice de origen: ");
        int origen = leer.nextInt();
        System.out.print("Ingrese el vértice de destino: ");
        int destino = leer.nextInt();
        grafo.agregarArista(origen, destino);
    }

    public static void eliminarArista() {
    	System.out.print("Ingrese el vértice de origen de la arista: ");
        int origen = leer.nextInt();
        System.out.print("Ingrese el vértice de destino de la arista: ");
        int destino = leer.nextInt();
        grafo.eliminarArista(origen, destino);
    }
    
    public static void existeArista() {
    	System.out.print("Ingrese el vértice de origen: ");
        int origen = leer.nextInt();
        System.out.print("Ingrese el vértice de destino: ");
        int destino = leer.nextInt();
        boolean resultado = grafo.existeArista(origen, destino);
        if (resultado) {
        	System.out.println("La arista consultada existe.");
        }else {
        	System.out.println("La arista consultada no existe.");
        }
    }

    public static void listarAdyacentes() {
        System.out.print("Ingrese el vértice a analizar: ");
        int v = leer.nextInt();
        System.out.println("Adyacentes de " + v + ": " + grafo.listarAdyacentes(v));
    }
    
    public static void contarGradoEntrada() {
        System.out.print("Ingrese el vértice a analizar: ");
        int v = leer.nextInt();
        System.out.println("El grado de entrada de " + v + " es: " + grafo.contarGradoEntrada(v));
    }
    
    public static void contarGradoSalida() {
    	System.out.print("Ingrese el vértice a analizar: ");
        int v = leer.nextInt();
        System.out.println("El grado de salida de " + v + " es: " + grafo.contarGradoSalida(v));
    }	
	
}
