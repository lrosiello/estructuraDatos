package Lists;


public class Node<T> {

	private T info;
	private Node<T> next;
	
	//CONSTRUCTOR
	public Node() {
		this.info=null;
		this.next=null;
	}
	
	//METODOS BASE
	public Node(T info, Node<T> next) {
		this.setInfo(info);
		this.setNext(next);
	}

	public void setNext(Node<T> next) {
		this.next=next;
	}

	public void setInfo(T info) {
		this.info=info;
	}
	
	public Node<T> getNext(){
		return this.next;
	}
	
	public T getInfo() {
		return this.info;
	}
	
	public boolean hasNext() {
		if(this.getNext()!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
