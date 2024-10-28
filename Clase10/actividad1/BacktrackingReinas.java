package actividad1;

/*	CONSIGNA
Dado un tablero de ajedrez de tamaño 4x4, debes
encontrar todas las posibles posiciones donde se pueden colocar dos reinas de
tal manera que no se ataquen entre sí. El objetivo es imprimir todas las
configuraciones válidas del tablero. Las dos reinas no deben compartir la misma
fila, columna ni estar en la misma diagonal.
*/

public class BacktrackingReinas {
	
	static int N; // Tamaño del tablero
	static int tablero[][];
	static int contadorSoluciones = 0; // Contador de soluciones
	
    public static void main(String[] args) {
    	N = 4; //tablero 4x4
        tablero = new int[N][N]; // Crear un tablero vacío
        colocarReina(tablero, 0, 0, 0); // Intentar colocar la primera reina
        //(tablero, fila, columna, reinasColocadas)
        System.out.println("Cantidad de soluciones encontradas: " + contadorSoluciones);
    }
	
	
    // Función recursiva para colocar reinas
    public static boolean colocarReina(int tablero[][], int fila, int col, int reinasColocadas) {
        if (reinasColocadas == 2) { // Si ya se han colocado dos reinas
            imprimirTablero(tablero);
            contadorSoluciones++; // Se incrementa el contador de soluciones
            return true;
        }

        // Recorrer todas las filas y columnas para colocar las reinas -> matriz[fila][columna]
        for (int i = fila; i < N; i++) {
            for (int j = col; j < N; j++) {
                if (esSeguro(tablero, i, j)) {
                    // Colocar reina
                    tablero[i][j] = 1;

                    // Intentar colocar la siguiente reina
                    colocarReina(tablero, i, j + 1, reinasColocadas + 1);

                    // Backtrack: eliminar reina si no es solución
                    tablero[i][j] = 0;
                }
            }
            col = 0; // Reiniciar columna cuando pasamos a la siguiente fila
        }

        return false; // No se encuentra solución válida en esta rama
    }
	
    // Verifica la posición es segura (fila, col)
    public static boolean esSeguro(int tablero[][], int fila, int col) {
        
    	// Verificar la fila y columna actual
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1 || tablero[i][col] == 1) {
                return false;
            }
        }
        
        // Diagonal superior izquierda
        for (int i = fila, j = col; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        // Diagonal inferior derecha
        for (int i = fila, j = col; i < N && j < N; i++, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        // Diagonal superior derecha
        for (int i = fila, j = col; i >= 0 && j < N; i--, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        // Diagonal inferior izquierda
        for (int i = fila, j = col; i < N && j >= 0; i++, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Función para imprimir el tablero
    public static void imprimirTablero(int tablero[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("R ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
