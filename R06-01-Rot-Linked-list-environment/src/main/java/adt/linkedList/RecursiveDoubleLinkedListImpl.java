package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}
	/*
	 * 		    if (isEmpty()) {
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
	 */
	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		if(element != null) {
			
		}
		
		
	}
	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
