package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		// TODO Auto-generated method stub
		if(isFull()) {
			throw new StackOverflowException();
		}
		if(element != null) {
			this.top.insertFirst(element);
		}
		

		//throw new UnsupportedOperationException("Not implemented!");

	}

	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		T[] retorno = this.top.toArray();
		T saida =  retorno[0];
		this.top.removeLast();
		return saida;

		//throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		T[] retorno = this.top.toArray();
		return retorno[0];
		//throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.top.isEmpty();
		//throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return top.size() == size;
		//throw new UnsupportedOperationException("Not implemented!");
	}

}
