package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		// TODO implement your code here
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(array.length > 0 && array != null) {
			quickSortM3(array,0,array.length);
			return floorRecursivo(array,x,null,0,array.length - 1);
		}
		return null;
		
		
		
	}
	
	private Integer floorRecursivo(Integer[] array, Integer x,Integer floor, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex >0 && rightIndex < leftIndex) {
			int meio = (rightIndex + leftIndex)/2;
			if(array[meio].compareTo(x) == 0) {
				return array[meio];
		}
			if(array[meio].compareTo(x) > 0) {
				return floorRecursivo(array,x,floor,leftIndex,meio -1 );
		}
			if(array[meio].compareTo(x) < 0) {
				return floorRecursivo(array,x,floor,meio + 1,rightIndex );
		}
		}
		return floor;
	}
private void quickSortM3(Integer[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		if(leftIndex < 0 || rightIndex > array.length -1 || array.length == 1) {
			return;
		}
			if(leftIndex < rightIndex) {
				int posicaoDoPivot = particiona(array,leftIndex,rightIndex);
				quickSortM3(array,leftIndex,posicaoDoPivot - 1);
				quickSortM3(array,posicaoDoPivot + 1,rightIndex);
			}
	}
private int particiona (Integer [] array, int inicio, int fim) {
		
		int meio = (inicio + fim)/2;
		mediaDeTres(array,inicio,meio,fim);
		Integer pivot = array[meio];
		Util.swap(array,meio,fim-1);
		int pivotIndex = fim - 1;
		
		for(int j = pivotIndex-1; j > inicio;j-- ) {
			if(pivot.compareTo(array[j]) < 0) {
				pivotIndex--;
				Util.swap(array,pivotIndex,j);
			}
		}
		Util.swap(array,fim-1,pivotIndex);
		
		return pivotIndex;
	}
	
	private void mediaDeTres(Integer[] array, int leftIndex, int meio, int rightIndex) {
		if(array[leftIndex].compareTo(array[meio]) > 0) {
			Util.swap(array,leftIndex, meio);
		}
		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}
		if(array[meio].compareTo(array[rightIndex]) > 0) {
			Util.swap(array,meio ,rightIndex );
		}
	}
}


