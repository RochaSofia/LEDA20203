package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {
		        return isBST() && verificaEAVL();
		    }

		    private boolean verificaEAVL() {
		        if (this.getAVLTree().isEmpty())
		            return true;
		        return verificaEAVL(this.getAVLTree(), this.getAVLTree().getRoot());
		    }

		    private boolean verificaEAVL(AVLTreeImpl<T> avlTree, BSTNode<T> node) {
		        if (node.isEmpty())
		            return true;
		        int balance = avlTree.calculateBalance(node);
		        if (balance > 1 || balance < -1) {
		        	  return false;
		        }else {
		        	return verificaEAVL(avlTree, (BSTNode<T>) node.getLeft())
		                    && verificaEAVL(avlTree, (BSTNode<T>) node.getRight());
		        }
		            
		    }
	}


