package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		if(stack1.isFull()) {
			throw new QueueOverflowException();
		}else {
			try {
				stack1.push(element);
			}catch(StackOverflowException e) {
				throw new QueueOverflowException();
			}
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		T elemento = null;
		if(stack1.isEmpty()) {
			 throw new QueueUnderflowException();
		}else {
			transfere(stack1,stack2);
			try {
				elemento = stack2.pop();
			}catch(StackUnderflowException e) {
				throw new QueueUnderflowException();
			}

			transfere(stack2,stack1);
		}
		return elemento;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T head() {
		// TODO Auto-generated method stub
		T head = null;
		if(stack1.isEmpty() ) {
			return null;
		}else {
			transfere(stack1,stack2);
			head = stack2.top();
			transfere(stack2,stack1);
		}
		return head;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack1.isEmpty();
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return stack1.isFull();
		//throw new UnsupportedOperationException("Not implemented yet!");
	}
	private void transfere(Stack<T> stack1, Stack<T> stack2) {
		try {
		while(stack1.isEmpty() == false) {
			stack2.push(stack1.pop());
		}
		}catch(Exception e) {
		}
	}

}
