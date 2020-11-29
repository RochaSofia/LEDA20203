package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		// TODO Auto-generated method stub
		if(this.getBSt() != null) {
			if(this.getBSt().isEmpty()) {
				return true;
			}else {
				return verificaBST(this.getBSt().getRoot());
			}
		}else {
			return false;
		}
		
		
		
			
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	private boolean verificaBST(BTNode<T> no) {
		boolean retorno = true;
        if (!no.isEmpty()) {
            T nodeValue = no.getData();

            if (no.getLeft().getData() != null && no.getLeft().getData().compareTo(nodeValue) > 0) {
                retorno = false;
            }
            if (no.getRight().getData() != null && no.getRight().getData().compareTo(nodeValue) < 0) {
                retorno = false;
            }
            if (retorno) {
                return verificaBST(no.getLeft()) && verificaBST(no.getRight());
            }
            return retorno;
        }

        return retorno;
	}

	
}
