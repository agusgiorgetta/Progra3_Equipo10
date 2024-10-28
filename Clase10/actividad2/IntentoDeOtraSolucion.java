package actividad2;

//el codigo no funcionó, habría que aalizarlo más

public class IntentoDeOtraSolucion {
	
	static int N; // Tamaño del tablero
	static int tablero[][];
	static int contadorSoluciones = 0; // Contador de soluciones
	
    public static void main(String[] args) {
    	
    	N = 4; //tablero 4x4
        tablero = new int[N][N]; // Crear un tablero vacío
        
        int objetosPorColocar = 8;	//4 escritorios + 4 sillas
        
        colocar(tablero, 0, 0, objetosPorColocar); // Intentar colocar
        //(tablero, fila, columna, objetosPorColocar)
        
        System.out.println("Cantidad de soluciones encontradas: " + contadorSoluciones);
    }
	
	
    // Función recursiva para colocar reinas
    public static boolean colocar(int tablero[][], int fila, int col, int PorColocar) {
        if (PorColocar == 0) { // Si ya se han colocado
            imprimirTablero(tablero);
            contadorSoluciones++; // Se incrementa el contador de soluciones
            return true;
        }
        
        // Alterna el numero de objeto a colocar
        int objeto; // objeto a colocar
        if (PorColocar > 4) {
            objeto = 1; // Asignar 1 (escritorio)
        } else {
            objeto = 2; // Asignar 2 (silla)
        }
      	//version acotada -> int objeto = objetosColocados > 4 ? 1 : 2;
        
        
        // Recorrer todas las filas y columnas para la colocacion
        for (int i = fila; i < N; i++) {
        	for (int j = (i == fila) ? col : 0; j < N; j++) { // Reiniciar columna cuando pasamos a la siguiente fila
                if (esSeguro(tablero, i, j)) {
                    // Colocar
                    tablero[i][j] = objeto;

                    // Intentar colocar la siguiente reina
                    colocar(tablero, i, j + 1, PorColocar - 1);

                    // Backtrack: eliminar si no es solución
                    tablero[i][j] = 0;
                }
            }
        }

        return false; // No se encuentra solución válida en esta rama
    }
	
    // Verifica la posición es segura (fila, col)
    public static boolean esSeguro(int tablero[][], int fila, int col) {
        
    	// Verificar la fila y columna actual
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] != 0 || tablero[i][col] != 0) {
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
                    System.out.print("E "); //Escritorio
                } else if (tablero[i][j] == 2) {
                    System.out.print("S ");	//Silla
                } else {
                    System.out.print(". "); //Vacio
                }
            }
            System.out.println();
        }
        System.out.println();
    }
     
}
