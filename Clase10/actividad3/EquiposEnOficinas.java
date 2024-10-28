package actividad3;

/*	CONSIGNA
Distribución de Equipos Electrónicos en Oficinas:
En una oficina de 4x4, se necesita organizar la disposición de computadoras e
impresoras de manera que optimice el uso del espacio y facilite el acceso. Las
restricciones de diseño son las siguientes:
	-No puede haber dos computadoras en la misma fila o columna.
	-No puede haber dos impresoras en la misma fila o columna.
*/

public class EquiposEnOficinas {
	
	static int N = 4; // Tamaño del tablero 4x4
	static int tablero[][];
	static int contadorSoluciones = 0; // Contador de soluciones

    public static void main(String[] args) {
    	
    	N = 4; //tablero 4x4
        tablero = new int[N][N]; // Crear un tablero vacío
        
        colocarCompus(tablero, 0, 0); // Intentar colocar el primer objeto
        
        System.out.println("Cantidad de soluciones encontradas: " + contadorSoluciones);
    }
    
    // Función recursiva
    public static boolean colocarCompus(int[][] tablero, int fila, int colocados) {
        if (colocados == 4) { // Si ya se han colocado
            colocarImpresoras(tablero, 0, 0);
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroCompus(tablero, i, j)) {
                    // Colocar
                    tablero[i][j] = 1;
                    
                    // Recursión para colocar el siguiente
                    colocarCompus(tablero, i + 1, colocados + 1);
                    
                    // Backtrack: eliminar si no es solución
                    tablero[i][j] = 0;
                }
            }
        }

        return false; // No hay solución válida en esta rama
    }
	
	
    // verificar posición segura 
    public static boolean esSeguroCompus(int tablero[][], int fila, int col) {
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
    
    // Función recursiva
    public static boolean colocarImpresoras(int[][] tablero, int fila, int colocados) {
        if (colocados == 4) { // Si ya se han colocado
            imprimirTablero(tablero);
            contadorSoluciones++; // Se incrementa el contador de soluciones
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroImpresoras(tablero, i, j) && tablero[i][j] == 0) {
                    // Colocar
                    tablero[i][j] = 2;
                    
                    // Recursión para colocar el siguiente
                    colocarImpresoras(tablero, i + 1, colocados + 1);
                    
                    // Backtrack: eliminar si no es solución
                    tablero[i][j] = 0;
                }
            }
        }

        return false; // No hay solución válida en esta rama
    }
    

    // Función para verificar si la ubicación de una silla es válida
    public static boolean esSeguroImpresoras(int tablero[][], int fila, int col) {
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

    // Función para imprimir el tablero
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("C "); // Escritorio
                } else if (tablero[i][j] == 2) {
                    System.out.print("I "); // Silla
                } else {
                    System.out.print(". ");	//Vacio
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
