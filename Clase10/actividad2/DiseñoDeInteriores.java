package actividad2;

/*	CONSIGNA
necesitamos un programa que
imprima las combinaciones posibles de la ubicación de escritorios y sillas, en una
habitación de 4x4. Las restricciones son: garantizar que ningún elemento esté en
la misma "fila" (por ejemplo, en una misma fila de escritorios) o en la misma
"columna" (por ejemplo, alineación en una pared) para optimizar el uso del
espacio y facilitar la circulación
*/

public class DiseñoDeInteriores {
	
	static int N = 4; // Tamaño del tablero 4x4
	static int tablero[][];
	static int contadorSoluciones = 0; // Contador de soluciones

    public static void main(String[] args) {
    	
    	N = 4; //tablero 4x4
        tablero = new int[N][N]; // Crear un tablero vacío
        
        colocarEscritorios(tablero, 0, 0); // Intentar colocar el primer objeto
        
        System.out.println("Cantidad de soluciones encontradas: " + contadorSoluciones);
    }
    
    // Función recursiva para colocar escritorios
    public static boolean colocarEscritorios(int[][] tablero, int fila, int escritoriosColocados) {
        if (escritoriosColocados == 4) { // Si ya se han colocado
            colocarSillas(tablero, 0, 0);
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroEscritorio(tablero, i, j)) {
                    // Colocar escritorio
                    tablero[i][j] = 1;
                    
                    // Recursión para colocar el siguiente
                    colocarEscritorios(tablero, i + 1, escritoriosColocados + 1);
                    
                    // Backtrack: eliminar si no es solución
                    tablero[i][j] = 0;
                }
            }
        }

        return false; // No hay solución válida en esta rama
    }
	
	
    // Función para verificar si la posición es segura (fila, col)
    public static boolean esSeguroEscritorio(int tablero[][], int fila, int col) {
        // Verificar fila
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }
        // Verificar columna
        for (int i = 0; i < N; i++) {
            if (tablero[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

    // Función para verificar si la ubicación de una silla es válida
    public static boolean esSeguroSilla(int tablero[][], int fila, int col) {
        // Verificar fila
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 2) {
                return false;
            }
        }
        // Verificar columna
        for (int i = 0; i < N; i++) {
            if (tablero[i][col] == 2) {
                return false;
            }
        }
        return true;
    }

    // Función recursiva para colocar sillas
    public static boolean colocarSillas(int[][] tablero, int fila, int sillasColocadas) {
        if (sillasColocadas == 4) { // Si ya se han colocado
            imprimirTablero(tablero);
            contadorSoluciones++; // Se incrementa el contador de soluciones
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroSilla(tablero, i, j) && tablero[i][j] == 0) {
                    // Colocar silla
                    tablero[i][j] = 2;
                    
                    // Recursión para colocar el siguiente
                    colocarSillas(tablero, i + 1, sillasColocadas + 1);
                    
                    // Backtrack: eliminar si no es solución
                    tablero[i][j] = 0;
                }
            }
        }

        return false; // No hay solución válida en esta rama
    }

    // Función para imprimir el tablero
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("E "); // Escritorio
                } else if (tablero[i][j] == 2) {
                    System.out.print("S "); // Silla
                } else {
                    System.out.print(". ");	//Vacio
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /*	intento FALLIDO de unificacion de la funcion de verificacion
    public static boolean esSeguro(int tablero[][], int fila, int col) {
        // Verificar fila
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] != 0) {
                return false;
            }
        }
        // Verificar columna
        for (int i = 0; i < N; i++) {
            if (tablero[i][col] != 0) {
                return false;
            }
        }
        return true;
    }
	*/
}
