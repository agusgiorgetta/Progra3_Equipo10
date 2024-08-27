package actividad3;

public class Recursividad {
	/* Sumar los primeros n números enteros, implementando en java un algoritmo que
		use recursión.
		Realice el análisis de recurrencia.
	*/
	
	public static void main(String[] args) {
	    System.out.println(sumarEnteros(5));    
	}

	private static int sumarEnteros(int i) {
	    if(i == 0) {
	        return 0;	//caso base: O(c)
	    }
	    return sumarEnteros(i-1) + i;	//caso recursivo: O(n)
	    //empieza a reducir el numero 'i' llamando recursivamente a una funcion sumar que
	    //una vez llegue a 0 deja de continuar llamando y cierra el ciclo sumando todos los 
	    //numeros --> 0+1, 1+2, 2+3, 3+4, 4+5 = 15
	}

}

