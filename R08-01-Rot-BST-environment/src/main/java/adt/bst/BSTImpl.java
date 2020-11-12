package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
//		if(!isEmpty()) {
//			
//		}
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> search(T element) {
		// TODO Auto-generated method stub
		BSTNode<T> aux = this.root;
        
	    while (aux != null) {   
	        if (aux.getData().equals(element)) {
	        	return aux;
	        }
	        if (element.compareTo(aux.getData()) < 0) {
	        	aux = (BSTNode<T>) aux.getLeft();
	        }
	        if (element.compareTo(aux.getData()) > 0) {
	        	aux = (BSTNode<T>) aux.getRight();
	        }
	    }
	        
	    return new BSTNode<T>();
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			BSTNode<T> insert = new BSTNode<T>();
			insert.setData(element);
			this.root = insert;
		}else {
			BSTNode<T> aux = this.root;
			 while (aux != null) {
	                
		            if (element.compareTo(aux.getData()) < 0) {
		                if (aux.getLeft() == null) { 
		                	BSTNode<T> novoNo = new BSTNode<T>();
		                	novoNo.setData(element);
		                    aux.setLeft(novoNo);
		                    novoNo.setParent(aux);
		                    return;
		                }
		                if(aux instanceof BSTNode<?>) {
		                    aux =  (BSTNode<T>) aux.getLeft();
		                }
		            } else {
		                if (aux.getRight() == null) { 
		                	BSTNode<T> novoNo = new BSTNode<T>();
		                	novoNo.setData(element);
		                    aux.setRight(novoNo);
		                    novoNo.setParent(aux);
		                    return;
		                }
		                if(aux instanceof BSTNode<?>) {   
		                aux = (BSTNode<T>) aux.getRight();
		                }
		            }
		        }
		}
	        
       
    }

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
