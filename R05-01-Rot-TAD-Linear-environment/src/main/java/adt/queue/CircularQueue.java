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
			array[tail+1] = element;
			elements ++;
			if(tail == array.length) {
				tail = 1;
			}else {
				tail++;
			}
			
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if(head == tail) {
			T retorno = array[head];
			if(head == array.length - 1) {
				head = -1;
				elements--;
			}else {
				head++;	
				elements--;
			}
		return retorno;
			
		}else {
			throw new QueueUnderflowException();
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T head() {
		// TODO Auto-generated method stub
		return array[head + 1];
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == tail;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return elements == array.length  ;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

}
