package Lists;

import java.util.HashMap;
import java.util.Iterator;

public class DoubleLinkedList<T extends Comparable<T>> implements Iterable<T> {

	private DoubleNode<T> first;
	private DoubleNode<T> last;
	private int size;

	public DoubleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	
	
	// METODOS BASE
		public void setFirst(DoubleNode<T> first) {
			this.first = first;
		}

		public DoubleNode<T> getFirst() {
			return this.first;
		}
		
		public DoubleNode<T> getLast() {
			return this.last;
		}

		public boolean isEmpty() {
			return this.first == null;
		}

		public int getSize() {
			return this.size;
		}

		// SERVICIOS
		public void insertFront(T info) {
		    DoubleNode<T> tmp = new DoubleNode<>(info, null, null); // creo nodo a insertar
		    if (!isEmpty()) { // pregunto si no estoy vacío
		        tmp.setNext(this.first); // si es verdad, nuevo nodo toma al primero como siguiente
		        tmp.setPrev(null); // y toma null como previo
		        this.first.setPrev(tmp); // el previo del primer nodo actual se establece como el nuevo nodo
		        this.first = tmp; // ahora la lista toma al nuevo como referencia
		        size++; // aumento tamaño de lista
		    } else { // si estoy vacío
		        last = tmp; // me aseguro la primer inserción que este será el último
		        first = tmp; // agrego el nuevo de una
		        size++;
		    }
		}

		public void insertBack(T info) {
		    DoubleNode<T> tmp = new DoubleNode<>(info, null, null); // creo nodo a insertar
		    if (!isEmpty()) { // pregunto si no estoy vacío
		        tmp.setPrev(this.last); // si es verdad, nuevo nodo toma al último como previo
		        tmp.setNext(null); // y toma null como siguiente
		        this.last.setNext(tmp); // el siguiente del último nodo actual se establece como el nuevo nodo
		        this.last = tmp; // ahora la lista toma al nuevo último como referencia
		        size++; // aumento tamaño de lista
		    } else { // si estoy vacío
		        last = tmp; // last también es como first al ser un solo nodo
		        first = tmp; // agrego el nuevo de una
		        size++;
		    }
		}


		public T extractFront() {
			DoubleNode<T> tmp = null; // declaro variable temporal
			DoubleNode<T> nuevoPrimerNodo = null; // declaro variable temporal
			if (this.isEmpty()) { // pregunto si estoy vacio
				return null; // si estoy vacio no hago nada
			} else if (first.hasNext()) { // pregunto si tiene siguiente
				tmp = first; // si tiene guardo el first para luego retornar eliminado
				nuevoPrimerNodo = this.first.getNext(); //tomo siguiente nodo
				nuevoPrimerNodo.setPrev(null); //elimino el previo para recolector de basura de java
				this.first = nuevoPrimerNodo; // first cambia a su siguiente
				size--; // resto el tama�o de lista
				return tmp.getInfo(); // retorno nodo eliminado
			} else { // si soy el ultimo de la lista
				tmp = first; // tmp se vuelve first
				this.first = null; // me elimino directamente
				size--; // reduzco tama�o lista
				return tmp.getInfo(); // devuelvo nodo eliminado
			}
		}
		
		public T extractBack() {
			DoubleNode<T> tmp = last; // temp se vuelve el ultimo
			DoubleNode<T> nuevoUltimoNodo = null; // declaro variable temporal
			if (this.isEmpty()) { // pregunto si estoy vacio
				return null; // si estoy vacio no hago nada
			} else if (last.hasPrev()) { // pregunto si tiene anterior
				tmp = last; // si tiene guardo el ultimo
				nuevoUltimoNodo = this.last.getPrev();
				nuevoUltimoNodo.setNext(null);
				this.last = nuevoUltimoNodo; // el ultimo se vuelve uno anterior
				size--; // resto el tama�o de lista
				return tmp.getInfo(); // retorno nodo eliminado
			} else { // si no tengo atras soy el primero
				tmp = last; // tmp se vuelve el ultimo
				this.last = null; // me elimino directamente
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
			DoubleNode<T> actual = this.first; //NODO CURSOR
			DoubleNode<T> anterior = null; //NODO ANTERIOR
	
			
			while (actual != null) { //PREGUNTO SI NO ESTOY VACIO
				if (actual.getInfo().equals(index)) { //PREGUNTO SI EL ACTUAL ES EL MISMO INDICE
					if (anterior == null) { //
						DoubleNode<T> siguienteNodo = actual.getNext(); //nuevo primer nodo es el siguiente
						siguienteNodo.setPrev(null); //al ser el primero, le cambio el nodo previo a null
						this.first = siguienteNodo; // Si el nodo a eliminar es el primero
						size--;
					} else { //si el nodo a eliminar es el siguiente
						DoubleNode<T> siguienteNodo = actual.getNext();
						anterior.setNext(siguienteNodo);// enlazo el anterior con el siguiente
						siguienteNodo.setPrev(anterior);
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
			DoubleNode<T> nuevoNodo = new DoubleNode<>(info, null, null);
		    
		    if (this.isEmpty() || info.compareTo(this.first.getInfo()) < 0) {
		        // Si la lista está vacía o el nuevo elemento es menor que el primer elemento de la lista,
		        // insertar el nuevo nodo al principio de la lista
		        nuevoNodo.setNext(this.first);
		        this.first = nuevoNodo;
		    } else {
		    	DoubleNode<T> actual = this.first;
		    	DoubleNode<T> anterior = null;
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
		


		public DoubleLinkedList<T> encontrarElementosComunes(DoubleLinkedList<T> lista1, DoubleLinkedList<T> lista2) {
		    DoubleLinkedList<T> listaResultante = new DoubleLinkedList<>();
		    HashMap<T, Boolean> mapa = new HashMap<>();

		    // Insertar todos los elementos de la primera lista en el mapa
		    DoubleNode<T> actualLista1 = lista1.getFirst();
		    while (actualLista1 != null) {
		        mapa.put(actualLista1.getInfo(), true);
		        actualLista1 = actualLista1.getNext();
		    }

		    // Verificar cada elemento de la segunda lista en el mapa
		    DoubleNode<T> actualLista2 = lista2.getFirst();
		    while (actualLista2 != null) {
		        if (mapa.containsKey(actualLista2.getInfo())) {
		            listaResultante.insertarOrdenado(actualLista2.getInfo());
		        }
		        actualLista2 = actualLista2.getNext();
		    }

		    return listaResultante;
		}

		public DoubleLinkedList<T> soloEnLaPrimerLista(DoubleLinkedList<T> lista1, DoubleLinkedList<T> lista2) {
			DoubleLinkedList<T> listaResultante = new DoubleLinkedList<>();
		    HashMap<T, Boolean> mapa = new HashMap<>();

		    // Insertar todos los elementos de la segunda lista en el mapa
		    DoubleNode<T> actualLista2 = lista2.getFirst();
		    while (actualLista2 != null) {
		        mapa.put(actualLista2.getInfo(), true);
		        actualLista2 = actualLista2.getNext();
		    }
		    // Verificar cada elemento de la primera lista en el mapa
		    DoubleNode<T> actualLista1 = lista1.getFirst();
		    while (actualLista1 != null) {
		        if (!mapa.containsKey(actualLista1.getInfo())) {
		            listaResultante.insertarOrdenado(actualLista1.getInfo());
		        }
		        actualLista1 = actualLista1.getNext();
		    }

		    return listaResultante;
		}

	
	
	
	@Override
	public IteradorDouble<T> iterator() {
		IteradorDouble<T> it = new IteradorDouble<T>(this.first); // mando primer nodo de referencia
		return it;
	}
	
	public IteradorDouble<T> iteratorBack() {
		IteradorDouble<T> it = new IteradorDouble<T>(this.last); // mando primer nodo de referencia
		return it;
	}

	@Override
	public String toString() {
		return " " + this.first.getInfo();
	}

}
