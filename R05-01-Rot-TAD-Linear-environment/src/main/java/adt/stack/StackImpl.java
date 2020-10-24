package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			return array[top];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(top  <= array.length - 1 && top > -1){
			return false;
		}
		return true;
	}

	@Override
	public boolean isFull() {
		if(top  < array.length - 1) {
			return false;
		}
		return true;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		// TODO Auto-generated method stub
		if(element != null) {
			if(array.length -1 == top) {
				throw new StackOverflowException();
			}else {
				array[top + 1] = element;
				top++;
			}
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			top = top-1;
			return array[top + 1];
		}
		 throw new StackUnderflowException();
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

}
