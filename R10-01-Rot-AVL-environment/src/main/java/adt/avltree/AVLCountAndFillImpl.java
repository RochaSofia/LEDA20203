package adt.avltree;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		// TODO Auto-generated method stub
		for(T e: array) {
			insert(getRoot(), e);
		}

		//throw new UnsupportedOperationException("Not implemented yet!");
	}
	  
	@Override
    public void insert(T element) {
        insert(getRoot(), element);
    }

	 private void insert(BSTNode<T> node, T element) {
	        if(node.isEmpty()) {
				node.setData(element);
				node.setLeft(new BSTNode<T>());
				node.getLeft().setParent(node);
				node.setRight(new BSTNode<T>());
				node.getRight().setParent(node);
		    	this.root.setParent(new BSTNode<T>());
	        }
	        else {
	            if (element.compareTo(node.getData()) < 0) {
	                insert((BSTNode<T>) node.getLeft(), element);
	            } else if(element.compareTo(node.getData()) > 0){
	                insert((BSTNode<T>) node.getRight(), element);
	            }
	        }
	        
	        this.rebalance(node);
	    }
    
    protected void rebalance(BSTNode<T> node) {
        BSTNode<T> aux;
        
        if (calculateBalance(node) > 1) {
            
            if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
            	RRcounter++;
               // aux = Util.rightRotation(node);                
            } else {
            	RLcounter++;
//                Util.leftRotation((BSTNode<T>) node.getLeft());
//               aux = Util.rightRotation(node);
            }
            
//          if (aux.getParent().isEmpty()) {
//               root = aux;
//            }
        } else if (calculateBalance(node) < -1) {
            if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
            	LLcounter++;
//               aux = Util.leftRotation(node);
            } else {
            	LRcounter++;
//                Util.rightRotation((BSTNode<T>) node.getRight());
//               aux = Util.leftRotation(node);
                
            }
            
//            if (aux.getParent().isEmpty()) {
//                root = aux;
//            }
        }
    }


}

