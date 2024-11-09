package actividad2;

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

public class Main {
	// Método principal que llama a la función de resolución
    public static void main(String[] args) {
        
    	SudokuSolver sudoku = new SudokuSolver();
        sudoku.generateSudoku();
        sudoku.printBoard();
    }
}
