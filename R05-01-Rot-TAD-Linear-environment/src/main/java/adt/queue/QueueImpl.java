package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
		head = 0;
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
		if(tail == -1) {
			return true;
		}else {
			return false;
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if(tail == array.length -1) {
			return true;
		}
		return false;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	private void shiftLeft() {
		// TODO Auto-generated method stub
		if(head > 0) {	
		for(int i = head ; i <=tail ; i++) {
			array[i-1] = array[i];
		}
			head = 0;
			tail--;
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		if(element != null) {
			if(isFull()) {
				 throw new QueueOverflowException();
			}
			array[tail+1] = element;
			tail++;

		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if(tail >=0) {
			T retorno = array[head];
			head++;
			shiftLeft();
			return retorno;
			
		}else {
			throw new QueueUnderflowException();
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

}
