package actividad1;

import java.util.Scanner;
/*	CONSIGNA
	Desarrolla un programa que modele un sistema de seguidores en una red social
	utilizando un grafo representado con una lista de adyacencia. En este sistema,
	cada usuario puede seguir a otros usuarios, y queremos almacenar y consultar
	estas relaciones de manera eficiente.
	Utiliza una lista de adyacencia para representar el grafo. En esta representación,
	cada nodo (usuario) tiene una lista de nodos a los que sigue (usuarios que lo
	siguen).		
*/
public class Main {
	
	static Scanner leer = new Scanner(System.in);
	static SistemaSeguidores sistema = new SistemaSeguidores();
	
	public static void main(String[] args) {
		
		//menu de operaciones
		while (true) {
			System.out.println();
			System.out.println("ELIJA UNA OPCIÓN");
			System.out.println("1- Agregar usuario");
			System.out.println("2- Seguir a un usuario");
			System.out.println("3- Dejar de seguir");
			System.out.println("4- Ver lista de seguidos de un usuario");
			System.out.println("5- Ver lista de seguidores de un usuario");
			System.out.println("6- Ver grafo de la red social");
			System.out.println("7- Salir");
			System.out.print("Opción: ");
			
			int opcion = leer.nextInt();
			System.out.println();
			switch (opcion) {
				case 1:
					agregarUsuario();
					break;
				case 2:
					seguir();
					break;
				case 3:
					dejarDeSeguir();
					break;
				case 4:
					verListaSeguidos();
					break;
				case 5:
					verListaSeguidores();
					break;
				case 6:
					sistema.mostrarGrafo();
					break;
				case 7:
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
	
	public static void agregarUsuario() {
		System.out.print("Ingrese el ID del usuario a agregar: ");
		int id = leer.nextInt();
		sistema.agregarUsuario(id);
	}
	
	public static void seguir() {
		System.out.println("Ingrese los ID del usuario origen y del destinatario a seguir.");
		System.out.print("ID del seguidor: ");
		int seguidor = leer.nextInt();
		System.out.print("ID del a seguir: ");
		int seguido = leer.nextInt();
		sistema.seguir(seguidor, seguido);		
	}
	
	public static void dejarDeSeguir() {
		System.out.println("Ingrese los ID del usuario origen y del destinatario a dejar de seguir.");
		System.out.print("ID del seguidor: ");
		int seguidor = leer.nextInt();
		System.out.print("ID a dejar de seguir: ");
		int seguido = leer.nextInt();
		sistema.dejarDeSeguir(seguidor, seguido);		
	}
	
	public static void verListaSeguidos() {
		System.out.print("Ingrese el ID del usuario a consultar: ");
		int usuario = leer.nextInt();
		sistema.verListaSeguidos(usuario);
	}
	
	public static void verListaSeguidores() {
		System.out.print("Ingrese el ID del usuario a consultar: ");
		int usuario = leer.nextInt();
		sistema.verListaSeguidores(usuario);
	}
	
}