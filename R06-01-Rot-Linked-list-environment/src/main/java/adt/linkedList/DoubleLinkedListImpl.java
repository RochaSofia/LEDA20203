package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		
		if(element != null) {
			if(this.isEmpty()) {
				this.setHead(new DoubleLinkedListNode<T>(element,new DoubleLinkedListNode<T>(),new DoubleLinkedListNode<T>()));
				if( this.getHead() instanceof DoubleLinkedListNode<?>) {
					this.setLast((DoubleLinkedListNode<T>)this.getHead());
				}
			}else {
				DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>();
				aux.setData(this.head.getData());
				aux.setNext(this.head.getNext());
				this.setHead(new DoubleLinkedListNode<T>(element,aux,new DoubleLinkedListNode<T>()));
				
			}
		}
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		if(!this.isEmpty()) {
			this.setHead(this.getHead().getNext());
			if(this.getHead().getNext().isNIL()) {
				if(this.getHead() instanceof DoubleLinkedListNode<?>) {
					setLast((DoubleLinkedListNode<T>) this.getHead());
				}
			}
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) return ;
        
        if (this.getHead().equals(this.getLast())) {
            this.setLast(new DoubleLinkedListNode<T>());
            this.setHead(getLast());
        } else {
            this.getLast().getPrevious().setNext(new DoubleLinkedListNode<T>());
            this.setLast(getLast().getPrevious());
        }
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
