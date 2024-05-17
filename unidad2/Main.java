package unidad2;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		/*
		 * Tree arbolBinario = new Tree(); arbolBinario.add(6); arbolBinario.add(2);
		 * arbolBinario.add(8); arbolBinario.add(1); arbolBinario.add(4);
		 * arbolBinario.add(3); arbolBinario.add(7);
		 * 
		 * arbolBinario.recorridoOrden(); arbolBinario.recorridoPreOrden();
		 * 
		 * System.out.println("eliminando un elemento=========");
		 * 
		 * System.out.println(arbolBinario.getRoot()); arbolBinario.recorridoOrden();
		 * arbolBinario.recorridoPreOrden();
		 * 
		 * System.out.println("HEIGHT=========");
		 * 
		 * arbolBinario.getHeight(); arbolBinario.getLongestBranch();
		 * 
		 * System.out.println("FRONTERA========="); arbolBinario.getFrontera();
		 * System.out.println("MAX ELEMENT========="); arbolBinario.getMaxElem();
		 * System.out.println("SAME LEVEL========="); arbolBinario.getElementAtLevel(3);
		 * System.out.println("IMPRIMIR HOJAS MAYORES AL VALOR K INGRESADO=========");
		 * arbolBinario.getMajorLeafs(2);
		 * System.out.println("SUMATORIA TOTAL========="); arbolBinario.getSumatoria();
		 * 
		 * 
		 * Tree arbolSimpleBinario = new Tree(); arbolSimpleBinario.add("H");
		 * arbolSimpleBinario.add("M"); arbolSimpleBinario.add("A");
		 * arbolSimpleBinario.add("N"); arbolSimpleBinario.add("D");
		 * arbolSimpleBinario.add("F");
		 * 
		 * arbolSimpleBinario.add("I"); arbolSimpleBinario.add("J");
		 * arbolSimpleBinario.add("K"); arbolSimpleBinario.add("L");
		 * 
		 * 
		 * arbolSimpleBinario.add("G"); arbolSimpleBinario.add("C");
		 * arbolSimpleBinario.add("Z"); arbolSimpleBinario.add("B");
		 * 
		 * 
		 * 
		 * arbolSimpleBinario.recorridoOrden(); arbolSimpleBinario.recorridoPreOrden();
		 * 
		 * System.out.println(arbolSimpleBinario.getRoot());
		 * 
		 */

		Libro carrie = new Libro(1, "Carrie", "Stephen King", 1992, 5);
		Libro metamorfosis = new Libro(2, "La metamorfosis", "Franz Kafka", 1979, 11);
		Libro cementerio = new Libro(3, "Cementerio de animales", "Stephen King", 1982, 2);
		Libro pluton = new Libro(4, "Luna de Pluton", "Angel David Revilla", 2011, 5);
		Libro blasfemia = new Libro(5, "El festival de la blasfemia", "Angel David Revilla", 2015, 7);
		Libro arturo = new Libro(6, "Rey Arturo", "Maniel Laport", 1990, 15);
		Libro gancedo = new Libro(7, "Pipa Gancedo", "Pipa Gancedo", 2019, 3);
		Libro maradona = new Libro(8, "El diegote", "Gonzalo Bonadeo", 2022, 1);
		Libro alejandromagno = new Libro(9, "La caida de Alejandro Magno", "Felipe Pigna", 2019, 7);

		carrie.addGenero("Suspenso");
		carrie.addGenero("Horror");
		metamorfosis.addGenero("Suspenso");
		metamorfosis.addGenero("Drama");
		cementerio.addGenero("Horror");
		pluton.addGenero("Ciencia Ficcion");
		pluton.addGenero("Comedia");
		blasfemia.addGenero("Comedia");
		blasfemia.addGenero("Horror");
		arturo.addGenero("Fantastico");
		gancedo.addGenero("Biografia");
		maradona.addGenero("Biografia");
		alejandromagno.addGenero("Historia");

		Tree<Libro> arbolBinario = new Tree<Libro>();

		arbolBinario.add(blasfemia);
		arbolBinario.add(metamorfosis);
		arbolBinario.add(alejandromagno);
		arbolBinario.add(pluton);
		arbolBinario.add(arturo);
		arbolBinario.add(carrie);

		arbolBinario.add(gancedo);
		arbolBinario.add(cementerio);
		arbolBinario.add(maradona);
		
		System.out.println("-------------LISTAR POR GENERO------------------------------------");
	
		FiltroLibro filtroSuspenso = new FiltroGenero("Suspenso");

	    // Obtener elementos que cumplen el filtro
	    List<Libro> librosDeSuspenso = arbolBinario.getElementsByAtribute(filtroSuspenso);

	    
	    // Mostrar los libros de suspenso
	    for (Libro libro : librosDeSuspenso) {
	        System.out.println(libro);
	    }
	    
		System.out.println("-------------LISTAR DENTRO DE RANGO------------------------------------");
		
		FiltroLibro filtroDesde = new FiltroEntreAnios(1900, 1990);

	    // Obtener elementos que cumplen el filtro
	    List<Libro> librosEntreAnios = arbolBinario.getElementsByAtribute(filtroDesde);

	    
	    // Mostrar los libros de suspenso
	    for (Libro libro : librosEntreAnios) {
	        System.out.println(libro);
	    }
		
	}

}
