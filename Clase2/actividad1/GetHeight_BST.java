package actividad1;

//código base pegado desde el repositorio de la materia
//CONSIGNA abajo del main

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class GetHeight_BST {

	// Método para buscar un valor en el BST
    public TreeNode searchBST(TreeNode root, int x) {
        // Caso base: si el nodo es nulo o si el valor del nodo es el que estamos buscando
        if (root == null || root.value == x) {
            return root;
        }

        // Si el valor a buscar es menor que el valor del nodo actual, buscar en el subárbol izquierdo
        if (x < root.value) {
            return searchBST(root.left, x);
        }

        // Si el valor a buscar es mayor que el valor del nodo actual, buscar en el subárbol derecho
        return searchBST(root.right, x);
    }

    public static void main(String[] args) {
        GetHeight_BST tree = new GetHeight_BST();

        // Crear un árbol de ejemplo
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);
        root.right.right.right = new TreeNode(30);

        // Buscar el valor 7 en el árbol
        int valueToSearch = 7;
        //int valueToSearch = 24; //caso no encontrado
        TreeNode result = tree.searchBST(root, valueToSearch);
        
        if (result != null) {
            System.out.println("Valor " + result.value + " encontrado en el árbol.");
        } else {
            System.out.println("Valor no encontrado en el árbol.");
        }
        
        //RESULTADO
        //Averiguemos la altura del arbol con la funcion getHeight
        System.out.println("\nLa altura del arbol es: " + getHeight(root));

    }
    
    /*	CONSIGNA
     	Implementa el método getHeight en la clase BinarySearchTree para calcular la
		altura de un Árbol Binario de Búsqueda utilizando la técnica de "Dividir y
		Vencerás".
     */
    private static int getHeight(TreeNode raiz) {
        if(raiz==null) { 
        	//si es null retorna -1, porque un arbol de solo 1 nodo tiene altura 0
            return -1;
        } else {	
        	//como hay un valor en la raiz, pasamos a comparar a los hijos. Sumamos 1 para contar el
        	//nodo actual. Se toma la altura maxima entre las de los subarboles, como la recursividad 
        	//se corta en las ramas mas cortas, la mayor será la altura total del arbol
            return 1+ Math.max(getHeight(raiz.left), getHeight(raiz.right));
        }    
    }
    
}
