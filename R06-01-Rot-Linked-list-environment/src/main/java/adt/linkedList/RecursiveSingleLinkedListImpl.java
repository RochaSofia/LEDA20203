package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.data == null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return 0;
		}else {
			int contador = 1;
			RecursiveSingleLinkedListImpl<T> aux = this.next;
			return recursiveSize(aux,contador);
		}
	}
	private int recursiveSize(RecursiveSingleLinkedListImpl<T> aux, int contador) {
			if(aux.getNext() == null) {
				return contador;
			}
			return recursiveSize(aux.getNext(),contador + 1);
		}
	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			setData(element);
			setNext(new RecursiveSingleLinkedListImpl<T>());
		}else {
			RecursiveSingleLinkedListImpl<T> aux = this.next;
			recursiveInsert(aux,element);
		}

	}
	
	private void recursiveInsert(RecursiveSingleLinkedListImpl<T> aux, T element) {
		if(aux.getData() == null) {
			aux.setData(element);
			aux.setNext(new RecursiveSingleLinkedListImpl<T>());
			return;
		}
		recursiveInsert(aux.getNext(),element);
		
		
	}
	//remove esta com erro
	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		if( element != null && !isEmpty()) {
			RecursiveSingleLinkedListImpl<T> aux = this.next;
			if(getData().equals(element)) {
				setNext(getNext());
			}else {
				recursiveRemove(aux,element);
			}
			
		}
		
	}
	private void recursiveRemove(RecursiveSingleLinkedListImpl<T> aux, T element) {
		if(aux.getNext().getData() == null ) {
			return;
		}
		if(aux.getNext().getData().equals(element)) {
			aux.setNext(aux.getNext().getNext());
			return;
		}
		recursiveRemove(aux.getNext(),element);
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
