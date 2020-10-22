package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;
	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		return array[0];
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tail == -1;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return tail == array.length -1 ;

		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	private void shiftLeft() {
		// TODO Auto-generated method stub
		for(int i = 1 ; i <=tail ; i++) {
			array[i-1] = array[i];
		}
			tail--;
		}
		//throw new UnsupportedOperationException("Not implemented yet!");

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
			T retorno = array[0];
			shiftLeft();
			return retorno;
			
		}else {
			throw new QueueUnderflowException();
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

}
