package actividad2;

import java.util.Random;

/*	CONSIGNA
	Modificar un programa de Sudoku para que trabaje con un tablero de 6x6, usando
	los números del 1 al 6 y con tres subcuadrantes de 6 números cada uno.
	Siguiendo estas instrucciones:
	-Cambiar el tamaño del tablero de 9x9 a 6x6.
	-Ajustar las reglas del juego para que en lugar de 9 subcuadrantes de 3x3, ahora
		el tablero tenga tres subcuadrantes de 6 números. Es decir, cada subcuadrante
		contendrá 6 celdas en total, de 2x3.
	-Asegurarse de que los números utilizados sean del 1 al 6.
*/

public class SudokuSolver {
	// Tamaño del tablero
    private static final int SIZE = 6;
    private static final int SUBGRID_ROWS = 2; // 2x3 
    private static final int SUBGRID_COLS = 3; 
    private static final int EMPTY = 0; // Valor para las celdas vacías
    private static int[][] board;
    
    public SudokuSolver() {
    	board = new int[SIZE][SIZE];
	}

	public void generateSudoku() {
    	solveSudoku(board); // Llena el tablero con una solución completa
        removeNumbers(); // Elimina algunos números para crear el desafío
    }

    // Método que resuelve el Sudoku usando backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {  				// Encuentra una celda vacía
                    for (int num = 1; num <= SIZE; num++) {		//del 1 al size (6)
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursivamente intenta resolver el tablero
                            if (solveSudoku(board)) {
                                return true;
                            }

                            // Deshacer el intento si falla
                            board[row][col] = EMPTY;
                        }
                    }
                    return false;  // Si ningún número es válido, retrocede
                }
            }
        }
        return true;  // El tablero está completo y es válido
    }

    // Método para verificar si un número puede ser colocado en una posición
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Verificar fila
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Verificar columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Verificar subcuadro 2x3
        int startRow = row - row % SUBGRID_ROWS;
        int startCol = col - col % SUBGRID_COLS;
        for (int i = 0; i < SUBGRID_ROWS; i++) {
            for (int j = 0; j < SUBGRID_COLS; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;  // Si pasa todas las pruebas, es válido
    }

    
    // Elimina algunos números para crear el rompecabezas
    private void removeNumbers() {
        Random rand = new Random();
        int cellsToRemove = 12 + rand.nextInt(6); // Elimina entre 12 y 18 celdas

        while (cellsToRemove > 0) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);

            if (board[row][col] != EMPTY) {
                board[row][col] = EMPTY;
                cellsToRemove--;
            }
        }
    }
    // Método para imprimir el tablero
    public void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
