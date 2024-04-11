package Lists;

import java.util.Iterator;


public class Iterador<T> implements Iterator<T>{

	private Node<T> cursor;

	
	public Iterador(Node<T> cursor) {
		this.cursor=cursor;

	}

	@Override
	public boolean hasNext() {
		if(cursor!=null) {
			return true;
		}
		return false;
	}

	@Override
	public T next() { //en este contexto, next busca informacion del siguiente cursor, no el mismo cursor
		T temporal = cursor.getInfo(); //tomo la info del cursor
		cursor = cursor.getNext(); //muevo el cursor un lugar al siguiente
		return temporal; //retorno el cursor actual
	}
	
	
	//este metodo sirve para devolver la info sin avanzar en el iterador
	public T get() {
		return cursor.getInfo();
	}
	//la complejidad del next es o(n)
	
	
}
