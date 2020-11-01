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
		//throw new UnsupportedOperationException("Not implemented yet!");
		T retorno = null;
		if(isEmpty()) {
			return retorno;
		}
		if(element != null) {
			if(getData().equals(element)) {
				return getData();
			}
			RecursiveSingleLinkedListImpl<T> aux = this.next;
			retorno = recursiveSearch(aux,element);
		}
		return retorno;
	}
	private T recursiveSearch(RecursiveSingleLinkedListImpl<T> aux, T element) {
		if(aux.getData() == null) {
			return null;
		}
		if(aux.getData().equals(element)) {
			return aux.getData();
		}
		return recursiveSearch(aux.getNext(),element);
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
	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		if( element != null && !isEmpty()) {
			RecursiveSingleLinkedListImpl<T> aux = this.next;
			if(getData().equals(element)) {
				setData(aux.getData());
				setNext(aux.getNext());
			}else {
				recursiveRemove(aux,element);
			}
				
			}		
		}
		
	private void recursiveRemove(RecursiveSingleLinkedListImpl<T> aux, T element) {
		if(aux.getData() == null ) {
			return;
		}
		if(aux.getData().equals(element)) {
			setNext(aux.getNext().getNext());
			return;
		}
		recursiveRemove(aux.getNext(),element);
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		 T[] array = (T[]) new Comparable[size()];
		 if(isEmpty()) {
			 return array;
		 }else {
			 RecursiveSingleLinkedListImpl<T> aux = this.next;
		        int i = 1;
		        array[0] = getData();
		       return recursiveToArray(array,aux,i); 
		 }
	}
	private T[] recursiveToArray(T[] array, RecursiveSingleLinkedListImpl<T> aux, int i) {
		if(aux.getData() == null) {
			return array;
		}
		array[i] = aux.getData();
		return recursiveToArray(array,aux.getNext(),i + 1);
		
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
