package Lists;

public class DoubleNode<T> {
	
	private T info;
	private DoubleNode<T> next;
	private DoubleNode<T> prev;

	public DoubleNode(T info) {
		this.info = info;
		this.next = null;
		this.prev = null;
	}
	
	//METODOS BASE
		public DoubleNode(T info, DoubleNode<T> prev, DoubleNode<T> next) {
			this.setInfo(info);
			this.setPrev(prev);
			this.setNext(next);	
		}

		public void setNext(DoubleNode<T> next) {
			this.next=next;
		}
		
		public void setPrev(DoubleNode<T> prev) {
			this.prev=prev;
		}

		public void setInfo(T info) {
			this.info=info;
		}
		
		public DoubleNode<T> getNext(){
			return this.next;
		}
		
		public DoubleNode<T> getPrev(){
			return this.prev;
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
		
		public boolean hasPrev() {
			if(this.getPrev()!=null) {
				return true;
			}else {
				return false;
			}
		}
		
		
	
}
