package Lists;

import java.util.Iterator;
import java.util.HashMap;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {
	// O SEA, T se compara con T
	private Node<T> first;
	private int size;

	// CONSTRUCTOR
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}

	public MySimpleLinkedList(Node<T> first) {
		this.setFirst(first);
	}

	// METODOS BASE
	public void setFirst(Node<T> first) {
		this.first = first;
	}

	public Node<T> getFirst() {
		return this.first;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public int getSize() {
		return this.size;
	}

	// SERVICIOS
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);// creo nodo a insertar
		if (!this.isEmpty()) { // pregunto si no estoy vacio
			tmp.setNext(this.first); // si es verdad,nuevo nodo toma al primero
			this.first = tmp; // ahora la lista toma al nuevo como referencia
			size++; // aumento tama�o de lista
		} else { // si estoy vacio
			first = tmp; // agrego el nuevo de una
			size++;
		}
	}

	public T extractFront() {
		Node<T> tmp = first; // temp se vuelve el primero
		if (this.isEmpty()) { // pregunto si estoy vacio
			return null; // si estoy vacio no hago nada
		} else if (first.hasNext()) { // pregunto si tiene siguiente
			tmp = first; // si tiene guardo el first
			this.first = this.first.getNext(); // first cambia a su siguiente
			size--; // resto el tama�o de lista
			return tmp.getInfo(); // retorno nodo eliminado
		} else { // si soy el ultimo de la lista
			tmp = first; // tmp se vuelve first
			this.first = null; // me elimino directamente
			size--; // reduzco tama�o lista
			return tmp.getInfo(); // devuelvo nodo eliminado
		}
	}

	public T getNodeByIndex(T index) {
		T cursor = this.first.getInfo();
		T node = null;
		Iterator<T> recorrido = this.iterator();
		while (recorrido.hasNext()) { // mientras haya un siguiente
			cursor = recorrido.next(); // el curso se vuelve siguiente
			if (cursor == index) { // si el cursor es el buscado
				node = cursor; // guardo ese nodo
			}
		}
		return node; // lo retorno
	}

	public T extractByIndex(T index) {
		Node<T> actual = this.first; //NODO CURSOR
		Node<T> anterior = null; //NODO ANTERIOR

		while (actual != null) { //PREGUNTO SI NO ESTOY VACIO
			if (actual.getInfo().equals(index)) { //PREGUNTO SI EL ACTUAL ES EL MISMO INDICE
				if (anterior == null) { //
					this.first = actual.getNext(); // Si el nodo a eliminar es el primero
					size--;
				} else { //si el nodo a eliminar es el siguiente
					anterior.setNext(actual.getNext());// enlazo el anterior con el siguiente
					size--;
				}
				return actual.getInfo(); //retorno el nodo eliminado
			}
			anterior = actual; //anterior avanza un paso
			actual = actual.getNext(); //actual avanza el paso adelantado respecto a anterior
		}
		return null; // Si el índice no se encuentra en la lista
	}

	
	public void insertarOrdenado(T info) {
	    Node<T> nuevoNodo = new Node<>(info, null);
	    
	    if (this.isEmpty() || info.compareTo(this.first.getInfo()) < 0) {
	        // Si la lista está vacía o el nuevo elemento es menor que el primer elemento de la lista,
	        // insertar el nuevo nodo al principio de la lista
	        nuevoNodo.setNext(this.first);
	        this.first = nuevoNodo;
	    } else {
	        Node<T> actual = this.first;
	        Node<T> anterior = null;
	        // Buscar el lugar correcto para insertar el nuevo nodo
	        while (actual != null && info.compareTo(actual.getInfo()) > 0) {
	            anterior = actual;
	            actual = actual.getNext();
	        }
	        // Insertar el nuevo nodo entre el nodo anterior y el nodo actual
	        nuevoNodo.setNext(actual);
	        anterior.setNext(nuevoNodo);
	    }
	    size++; // Incrementar el tamaño de la lista
	}
	


	public MySimpleLinkedList<T> encontrarElementosComunes(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {
	    MySimpleLinkedList<T> listaResultante = new MySimpleLinkedList<>();
	    HashMap<T, Boolean> mapa = new HashMap<>();

	    // Insertar todos los elementos de la primera lista en el mapa
	    Node<T> actualLista1 = lista1.getFirst();
	    while (actualLista1 != null) {
	        mapa.put(actualLista1.getInfo(), true);
	        actualLista1 = actualLista1.getNext();
	    }

	    // Verificar cada elemento de la segunda lista en el mapa
	    Node<T> actualLista2 = lista2.getFirst();
	    while (actualLista2 != null) {
	        if (mapa.containsKey(actualLista2.getInfo())) {
	            listaResultante.insertarOrdenado(actualLista2.getInfo());
	        }
	        actualLista2 = actualLista2.getNext();
	    }

	    return listaResultante;
	}

	public MySimpleLinkedList<T> soloEnLaPrimerLista(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {
	    MySimpleLinkedList<T> listaResultante = new MySimpleLinkedList<>();
	    HashMap<T, Boolean> mapa = new HashMap<>();

	    // Insertar todos los elementos de la segunda lista en el mapa
	    Node<T> actualLista2 = lista2.getFirst();
	    while (actualLista2 != null) {
	        mapa.put(actualLista2.getInfo(), true);
	        actualLista2 = actualLista2.getNext();
	    }
	    // Verificar cada elemento de la primera lista en el mapa
	    Node<T> actualLista1 = lista1.getFirst();
	    while (actualLista1 != null) {
	        if (!mapa.containsKey(actualLista1.getInfo())) {
	            listaResultante.insertarOrdenado(actualLista1.getInfo());
	        }
	        actualLista1 = actualLista1.getNext();
	    }

	    return listaResultante;
	}


	
	
	
	@Override
	public Iterador<T> iterator() {
		Iterador<T> it = new Iterador<T>(this.first); // mando primer nodo de referencia
		return it;
	}

	@Override
	public String toString() {
		return " " + this.first.getInfo();
	}
}
