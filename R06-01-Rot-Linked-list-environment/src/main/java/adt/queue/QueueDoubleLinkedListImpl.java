package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		if(isFull()) {
			throw new QueueOverflowException();
		}
		if(element != null) {
			this.list.insert(element);
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T elementoRemovido = head();
		this.list.removeFirst();
		return elementoRemovido;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T head() {
		// TODO Auto-generated method stub
		T []array = list.toArray();
		return array[0];
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return list.size() == size;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

}
