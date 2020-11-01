package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	
	
	@Override
	public T search(T element) {
		T retorno = null;
		if(element == null || isEmpty()) {
			return retorno;
		}
		if(this.getHead() instanceof DoubleLinkedListNode<?>) {
			
			DoubleLinkedListNode<T> headaux = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> lastaux = this.last;
			while(headaux != lastaux && headaux.next != lastaux && !headaux.getData().equals(element) && !lastaux.getData().equals(element)) {
				headaux = (DoubleLinkedListNode<T>) headaux.getNext();
				lastaux = lastaux.getPrevious();
			}
			if(headaux.getData().equals(element)){
				retorno= headaux.getData();
			}
			if(lastaux.getData().equals(element)) {
				retorno= lastaux.getData();
			}
		}

		return retorno;
	}
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
	    public void insert(T element) {
	        if (isEmpty()) {
	            DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
	            newNode.getPrevious().setNext(newNode);
	            ((DoubleLinkedListNode<T>) newNode.getNext()).setPrevious(newNode);
	            
	            this.setHead(newNode);
	            this.setLast(newNode);
	            
	        } else {
	            DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) last.getNext(), last);
	            ((DoubleLinkedListNode<T>) newNode.getNext()).setPrevious(newNode);
	            this.last.setNext(newNode);
	            
	            this.setLast(newNode);
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
	@Override
	public void remove(T element) {
		if( element != null && !isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			if(this.head.getData().equals( element)) {
				this.head = this.head.getNext();
			}
			while(!aux.getNext().isNIL() ) {
				if(aux.getNext().getData().equals(element)) {
					aux.setNext(aux.getNext().getNext());
					break;
				}
				aux = aux.getNext();
			}
		}
	}
	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
