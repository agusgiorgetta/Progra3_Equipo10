package actividad1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaSeguidores {
	/*	CONSIGNA
	Utiliza un diccionario o un mapa para mantener la lista de adyacencia, donde cada clave
	es un Usuario y el valor asociado es una lista de usuarios que ese usuario sigue.		*/
    private Map<Usuario, List<Usuario>> grafo;

    public SistemaSeguidores() {
        grafo = new HashMap<>();
    }

//Métodos de funcionalidades
    public void agregarUsuario(int id) {
        Usuario nuevo = new Usuario(id);
        grafo.putIfAbsent(nuevo, new ArrayList<>());
    }

    public void seguir(int idSeguidor, int idSeguido) {
        Usuario seguidor = new Usuario(idSeguidor);
        Usuario seguido = new Usuario(idSeguido);

        // vamos que ambos existan para q se sigan y sino no hay efecto
        if (grafo.containsKey(seguidor) && grafo.containsKey(seguido)) {
            List<Usuario> seguidores = grafo.get(seguidor);
            if (!seguidores.contains(seguido)) {
                seguidores.add(seguido);
            }
        }
    }

    public void dejarDeSeguir(int idSeguidor, int idSeguido) {
        Usuario seguidor = new Usuario(idSeguidor);
        Usuario seguido = new Usuario(idSeguido);

        // vemos que ambos existan y si no lo sigue no hay efecto
        if (grafo.containsKey(seguidor) && grafo.containsKey(seguido)) {
            List<Usuario> seguidores = grafo.get(seguidor);
            seguidores.remove(seguido);
        }
    }

    public void verListaSeguidos(int idUsuario) {
        Usuario usuario = new Usuario(idUsuario);
        List<Usuario> seguidos = grafo.getOrDefault(usuario, new ArrayList<>());
        System.out.println("LISTA DE SEGUIDOS POR " + idUsuario);
        for (Usuario user : seguidos) {
        	System.out.println("->  " + user.getId());
        }
        //si el usuario no existe, devuelve una lista de seguidos vacia
    }

    // Método para obtener la lista de seguidores de un usuario dado
    public void verListaSeguidores(int idUsuario) {
        Usuario usuario = new Usuario(idUsuario);
        List<Usuario> seguidores = new ArrayList<>();
        
        //buscamos en el map quienes siguen al usuario y los agragamos a la lista
        for (Map.Entry<Usuario, List<Usuario>> entry : grafo.entrySet()) {
            if (entry.getValue().contains(usuario)) {
            	seguidores.add(entry.getKey());
            }
        }
        
        //imprimimos la lista
        System.out.println("LISTA DE SEGUIDORES DE " + idUsuario);
        for (Usuario user : seguidores) {
        	System.out.println("->  " + user.getId());
        }
    }

    // Método para mostrar todos los usuarios y sus seguidores
    public void mostrarGrafo() {
        for (Map.Entry<Usuario, List<Usuario>> entry : grafo.entrySet()) {
            System.out.println(entry.getKey() + " sigue a: " + entry.getValue());
        }
    }
}