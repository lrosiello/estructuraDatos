package Lists;
import java.util.Iterator;

public class IteradorDouble<T> implements Iterator<T>{

	private DoubleNode<T> cursor;
	
	public IteradorDouble(DoubleNode<T> start) {
		 this.cursor = start;
	}
	
	@Override
	public boolean hasNext() {
		if(cursor!=null) {
			return true;
		}
		return false;
	}

	@Override
	public T next() { 
		T temporal = cursor.getInfo();
		cursor = cursor.getNext();
		return temporal; 
	}
	
	public boolean hasPrev() {
		if(cursor.getPrev()!=null) {
			return true;
		}
		return false;
	}
	
	public T back() { 
		T temporal = cursor.getInfo();
		cursor = cursor.getPrev();
		return temporal; 
	}
	

}
