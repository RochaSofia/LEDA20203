package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.head.isNIL();
		//throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return 0;
		}else {
			int contador = 0;
			SingleLinkedListNode<T> aux = this.head;
			while(!aux.isNIL()) {
				contador++;
				aux = aux.getNext();
			}
			return contador;
		}
		//throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		T retorno = null;
		if(element != null) {
			SingleLinkedListNode<T> aux = this.head;
			while(!aux.isNIL()) {
				if(aux.getData().equals(element)) {
					retorno = aux.getData();
				}
					aux = aux.getNext();
				
		      }
			}
		return retorno;
		}
		
	

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		if(element != null) {
			if(isEmpty()) {
				this.head.setData(element);
				this.head.setNext(new SingleLinkedListNode<T>());
			}else {
				SingleLinkedListNode<T> aux = this.head;
				while(!aux.isNIL()) {
					aux = aux.getNext();
				}
				aux.setData(element);
				aux.setNext(new SingleLinkedListNode<T>());
			}
			
		}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
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
		//throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
        T[] array = (T[]) new Comparable[size()];
        SingleLinkedListNode<T> aux = head;
        int i = 0;
        
        while(!aux.isNIL()) {
            array[i] = aux.getData();
            i++;
            aux = aux.getNext();
        }
        
        return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
