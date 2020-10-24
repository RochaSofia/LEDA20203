package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		if(element != null) {
			
		
			if(isFull()) {
				 throw new QueueOverflowException();
			}
			if(isEmpty()) {
				head = (head + 1) % array.length;
			}
			tail = (tail+1) % array.length;
			array[tail] = element;
			elements ++;
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T retorno = array[head];
		if(head == tail) {
			head = -1;
			tail = -1;
		}else {
			head = (head + 1) %array.length;
		}
		elements--;
		return retorno;
			
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T head() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		return array[head];
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return elements == 0;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return elements == array.length;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

}
