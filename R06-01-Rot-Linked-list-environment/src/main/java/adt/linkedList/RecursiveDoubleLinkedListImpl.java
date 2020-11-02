package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<>();
				((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
				
				if (getPrevious() == null) {
					setPrevious(new RecursiveDoubleLinkedListImpl<>());
					getPrevious().setNext(this);
				}
				
			} else {
				next.insert(element);
			}
				
			
		}
	}
	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		if(element != null) {
			if(this.isEmpty()) {
					insert(element);
			}else {
				setPrevious(new RecursiveDoubleLinkedListImpl<>());
				RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<T>();
				((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(aux);
				aux.setNext(next);
				this.setNext(aux);
				aux.setPrevious(this);
				aux.setData(data);
				this.setData(element);
				//previous.setNext(aux);
			}
			
			}
		}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		if(!this.isEmpty()) {
			if(!getNext().isEmpty()) {
			    this.setData(next.getData());
				this.setNext(next.getNext());
			}else {
				setData(null);
				setNext(new RecursiveDoubleLinkedListImpl<>());
			}
			setPrevious(new RecursiveDoubleLinkedListImpl<>());
	}
	}

	@Override
	public void removeLast() {
        if(!isEmpty()) {
            if(getNext().isEmpty()) {
                setData(null);
            } else {
                ((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();
            }
        }
    }
	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			if (data.equals(element)) {
				data = next.getData();
				next = next.getNext();
				((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);		
			} else {
				next.remove(element);
			}
				
		}
	}
	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
