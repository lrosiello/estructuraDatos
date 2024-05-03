package unidad1;

import Lists.DoubleLinkedList;
import Lists.Iterador;
import Lists.MySimpleLinkedList;
import Lists.Node;
import Lists.DoubleNode;
import Lists.IteradorDouble;

public class Main {

	public static void main(String args[]) {
		
		MySimpleLinkedList<Integer> listaA = new MySimpleLinkedList();
		MySimpleLinkedList<Integer> listaB = new MySimpleLinkedList();

		listaA.insertarOrdenado(1);
		listaA.insertarOrdenado(5);
		listaA.insertarOrdenado(3);
		listaA.insertarOrdenado(4);
		listaA.insertarOrdenado(4);
		listaA.insertarOrdenado(2);
		listaA.insertarOrdenado(7);
		listaA.insertarOrdenado(6);
		
		listaB.insertFront(1);
		listaB.insertFront(5);
		listaB.insertFront(3);
		listaB.insertFront(4);
		listaB.insertFront(4);
		listaB.insertFront(2);
		listaB.insertFront(36);
		listaB.insertFront(33);
		listaB.insertFront(22);
		
	
		
	/*  esto es o(n al cuadrado) de complejidad, porque esto depende n veces 
	 * y el metodo del getindex tambien es n veces, n*n, para evitarlo se implementa iterator.
		
		for(int indice=0; indice< nuevaLista.size() ;indice=1) {
			Integer valor = nuevaLista.getNodeByIndex(indice);
			System.out.println(valor);
		}
		
	*/
		//el Next es recomendable consultar el siguiente nodo, pero desde afuera.
		//tambien es o(1) la complejidad de este llamado del iterador, o(1)*o(n) = o(n)
		Iterador<Integer> iterador = listaA.iterator();
		while(iterador.hasNext()) {
			Integer valor = iterador.next();
			System.out.println(valor);
		}
		
		System.out.println(listaA.getNodeByIndex(1)+ " por index");
		System.out.println(listaA.getSize() + " tamanio");
		

		listaA.extractByIndex(4);
		System.out.println(listaA.getSize() + " tamanio");
		
		Iterador<Integer> iterador2 = listaA.iterator();
		while(iterador2.hasNext()) {
			Integer valor = iterador2.next();
			System.out.println("//" + valor + "//");
		}
		
		System.out.println("////////////COMBINACION DE LISTAS////////////////");
		
		MySimpleLinkedList<Integer> listaResult = new MySimpleLinkedList<Integer>();
		listaResult = listaResult.soloEnLaPrimerLista(listaA, listaB);
		
		Iterador<Integer> iterador3 = listaResult.iterator();
		while(iterador3.hasNext()) {
			Integer valor = iterador3.next();
			System.out.println("//" + valor + "//");
		}
		
		System.out.println("////////////LISTAS DOBLEMENTE VINCULADAS////////////////");
		DoubleLinkedList<Integer> listaDoble = new DoubleLinkedList<Integer>();
		listaDoble.insertFront(3);
		listaDoble.insertFront(1);
		listaDoble.insertFront(4);
		listaDoble.insertBack(6);
		listaDoble.insertBack(16);
		listaDoble.insertFront(2);
		listaDoble.extractByIndex(3);

		
		IteradorDouble<Integer> iteradorDoble = listaDoble.iterator();
		while(iteradorDoble.hasNext()) {
			Integer valor = iteradorDoble.next();
			System.out.println("//" + valor + "//");
		}
		System.out.println(listaDoble.getLast().getInfo()+ " /ultimo/");
		System.out.println(listaDoble.getFirst().getInfo()+ " /primero/");
	
	}
	
	

	
	
	
}
