package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		if(leftIndex < 0 || rightIndex > array.length -1 || array.length == 1) {
			return;
		}else {
			if(leftIndex < rightIndex) {
				int posicaoDoPivot = particiona(array,leftIndex,rightIndex);
				sort(array,leftIndex,posicaoDoPivot - 1);
				sort(array,posicaoDoPivot + 1,rightIndex);
			}
	}

	}
	
	private int particiona (T [] array, int inicio, int fim) {
		T pivot = array[inicio];
		int i = inicio;
		for(int j = i +1;j <= fim ;j++) {
			if(array[j].compareTo(pivot) < 0 || array[j].compareTo(pivot) == 0) {
				i = i+1;
				Util.swap(array,i,j);
			}
		}
		Util.swap(array,inicio,i);
		
		return i;
	}
	
}
