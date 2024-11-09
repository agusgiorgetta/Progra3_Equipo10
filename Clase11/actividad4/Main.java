package actividad4;

/*	CONSIGNA
	Diseña e implementa un sistema que modele una red social utilizando grafos.
	Cada usuario será un nodo, y las amistades entre usuarios serán las aristas. El
	sistema debe permitir:
	-Agregar usuarios a la red, (identificador único y nombre)
	-Conectar usuarios indicando que son amigos (relación bidireccional).
	-Implementar un recorrido DFS (Depth First Search)
	-Implementar un recorrido BFS (Breadth First Search)
*/

public class Main {
	
	public static void main(String[] args) {

		//Creación de usuarios
		Usuario u1 = new Usuario(1, "Juan Alvarez");
		Usuario u2 = new Usuario(2, "Rocio Perez");
		Usuario u3 = new Usuario(3, "Alberto Nuñez");
		Usuario u4 = new Usuario(4, "Ana Gonzalez");
		Usuario u5 = new Usuario(5, "Maria Moreno");
		
		Grafo redSocial = new Grafo();
		
		redSocial.agregarUsuario(u1);
		redSocial.agregarUsuario(u2);
		redSocial.agregarUsuario(u3);
		redSocial.agregarUsuario(u4);
		redSocial.agregarUsuario(u5);
		
		redSocial.conectarUsuarios(u1, u3);
		redSocial.conectarUsuarios(u1, u2);
		redSocial.conectarUsuarios(u2, u4);
		redSocial.conectarUsuarios(u4, u5);
		redSocial.conectarUsuarios(u3, u5);
	
        // DFS y BFS
        System.out.println("Recorrido DFS iniciando desde " + u1.getNombre() + ":");
        redSocial.DFS(u1);
        System.out.println();
        System.out.println("\nRecorrido BFS iniciando desde " + u1.getNombre() + ":");
        redSocial.BFS(u1);
    
	
	}

}
