package unidad1;

import java.util.ArrayList;

public class MainRecursividad {

	public static void main(String[] args) {
		System.out.println(busquedaBinaria());
		System.out.println(numerosBinarios(26));
		System.out.println(obtenerPrimerosSecuencia(10));
		System.out.println(determinarMismaPosicion(new int[] { -3, 1, 0, 2, 4, 6, 10 }));

		System.out.println("-------------------");
		int[] arregloParaSeleccion = new int[] { 4, 1, 6, 8, 3, 1, 6 };
		int[] arregloParaBurbujeo = new int[] { 4, 1, 6, 8, 3, 1, 6 };
		ordenamientoPorSeleccion(arregloParaSeleccion);
		ordenamientoPorBurbujeo(arregloParaBurbujeo);
		for (int i = 0; i < arregloParaSeleccion.length; i++) {
			System.out.println(arregloParaSeleccion[i]);
		}
		System.out.println("-------------------");
		for (int i = 0; i < arregloParaBurbujeo.length; i++) {
			System.out.println(arregloParaBurbujeo[i]);
		}
		
		System.out.println("-------MERGE------------");
		int[] arregloParaMerge = new int[] { 4, 1, 6, 8, 3, 1, 6 };
		MergeSort merge = new MergeSort();
		merge.sort(arregloParaMerge);
		for (int i = 0; i < arregloParaMerge.length; i++) {
			System.out.println(arregloParaMerge[i]);
		}
		
		System.out.println("-------QUICK------------");
		int[] arregloParaQuick = new int[] { 4, 1, 6, 8, 3, 1, 6 };
		//MergeSort merge = new MergeSort();
		merge.sort(arregloParaQuick);
		for (int i = 0; i < arregloParaQuick.length; i++) {
			System.out.println(arregloParaQuick[i]);
		}
	}

	public static int busquedaBinaria() {
		int[] arreglo = { 1, 4, 5, 6, 8, 10, 15, 20, 25 };
		int inicio = 0;
		int fin = arreglo.length;
		int result = buscar(arreglo, 25, inicio, fin);
		return result;
	}

	private static int buscar(int[] arreglo, int buscado, int inicio, int fin) {
		int medio;
		if (inicio > fin) { // si no encuentro el elemento
			return -1;
		} else {
			medio = (inicio + fin) / 2;
			if (buscado > arreglo[medio]) {
				return buscar(arreglo, buscado, medio, fin);
			} else if (buscado < arreglo[medio]) {
				return buscar(arreglo, buscado, inicio, medio - 1);
			} else {
				return medio;
			}
		}
	}

	public static String numerosBinarios(int numero) {
		if (numero == 0) {
			return "0"; // Caso base: si el número es 0, su representación binaria es 0
		}

		if (numero == 1) {
			return "1"; // Caso base: si el número es 1, su representación binaria es 1
		}

		// Se realiza la división entera por 2 y se obtiene el residuo
		int resto = numero % 2;

		// Se realiza la llamada recursiva con el cociente de la división
		return numerosBinarios(numero / 2) + resto;
	}

	public static String obtenerPrimerosSecuencia(int cantNumeros) {
		int primerNumero = 0;
		int segundoNumero = 1;
		String secuencia = "0,1,";
		if (cantNumeros == 0) {
			return "no corresponde";
		} else if (cantNumeros == 1) {
			return "" + primerNumero;
		} else if (cantNumeros == 2) {
			return secuencia;
		} else {
			return secuencia + obtener(cantNumeros - 2, primerNumero, segundoNumero);
		}
	}

	private static String obtener(int cantNumeros, int primero, int segundo) {

		if (cantNumeros <= 0) {
			return "";
		}
		int nuevoSegundo = primero + segundo;
		primero = segundo;
		return nuevoSegundo + "," + obtener(cantNumeros - 1, primero, nuevoSegundo);
	}

	public static String determinarMismaPosicion(int[] arreglo) {
		int posicion = 0;
		int tamanio = arreglo.length;
		return determinar(posicion, tamanio, arreglo);
	}

	private static String determinar(int posicion, int tamanio, int[] arreglo) {
		String cadena = "";
		if (posicion >= tamanio) {
			return "";
		}
		if (posicion == arreglo[posicion]) {
			cadena = posicion + " ";
		}
		return cadena + determinar(posicion + 1, tamanio, arreglo);
	}

	public static void ordenamientoPorSeleccion(int[] arreglo) {
		int n = arreglo.length; // Obtener la longitud del arreglo

		// Iterar sobre el arreglo hasta el penúltimo elemento
		for (int i = 0; i < n - 1; i++) {
			int indiceMenor = i; // Suponer que el elemento actual es el más pequeño

			// Iterar sobre los elementos restantes del arreglo
			for (int j = i + 1; j < n; j++) {
				// Si encontramos un elemento menor que el actual más pequeño
				if (arreglo[j] < arreglo[indiceMenor]) {
					indiceMenor = j; // Actualizar el índice del elemento más pequeño
				}
			}

			// Intercambiar el elemento actual con el más pequeño encontrado
			int temp = arreglo[indiceMenor];
			arreglo[indiceMenor] = arreglo[i];
			arreglo[i] = temp;
		}
	}

	public static void ordenamientoPorBurbujeo(int[] arreglo) {
		int n = arreglo.length; // Obtener la longitud del arreglo

		// Iterar sobre el arreglo
		for (int i = 0; i < n - 1; i++) {
			// Iterar sobre los elementos restantes del arreglo
			// La cantidad de elementos a comparar disminuye en cada iteración
			for (int j = 0; j < n - i - 1; j++) {
				// Si el elemento actual es mayor que el siguiente
				if (arreglo[j] > arreglo[j + 1]) {
					// Intercambiar los elementos
					int temp = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = temp;
				}
			}
		}
	}

	

}
