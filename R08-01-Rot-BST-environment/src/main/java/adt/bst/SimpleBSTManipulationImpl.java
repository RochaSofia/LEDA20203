package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		// TODO Implement this method

		return equalsRecursivo((BSTNode<T>)tree1.getRoot(), (BSTNode<T>)tree2.getRoot());
		//throw new UnsupportedOperationException("Not implemented yet!");
	}
	private boolean equalsRecursivo(BSTNode<T> node1, BSTNode<T> node2) {
	        if (node1.isEmpty() && node2.isEmpty()) {
	            return true;
	        } else if (!node1.isEmpty() && !node2.isEmpty()) {
	            if (node1.equals(node2)) {
	                return equalsRecursivo((BSTNode<T>)node1.getLeft(),(BSTNode<T>) node2.getLeft()) && equalsRecursivo((BSTNode<T>)node1.getRight(),(BSTNode<T>) node2.getRight()) ;
	            } else {
	                return false;
	            }
	        } else {
	            return false;
	        }
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		// TODO Implement this method
		if(tree1.height() != tree2.height()) {
			return false;
		}
		return isSimilarRecursivo((BSTNode<T>)tree1.getRoot(),(BSTNode<T>)tree2.getRoot());
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	private boolean isSimilarRecursivo(BSTNode<T> root, BSTNode<T> root2) {
		boolean eIgual = false;
		if(root.isEmpty() && root2.isEmpty()) {
			return true;
		}
		eIgual = isSimilarRecursivo((BSTNode<T>)root.getLeft(), (BSTNode<T>)root2.getLeft());
		eIgual = isSimilarRecursivo((BSTNode<T>)root.getRight(),(BSTNode<T>)root2.getRight());
		// TODO Auto-generated method stub
		return eIgual;
	}
	@Override
	public T orderStatistic(BST<T> tree, int k) {
		// TODO Implement this method
		if (tree.isEmpty()) {
            return null;
        }
        return recurOrdem(tree, tree.minimum(), k, 1);
	}
	private T recurOrdem(BST<T> tree, BSTNode<T> node, int k, int i) {
		// TODO Auto-generated method stub
	        if (node != null) {
	            if (k == i) {
	                return node.getData();
	            }
	            return recurOrdem(tree, tree.sucessor(node.getData()), k, i + 1);
	        }
	        return null;
	    }

}
