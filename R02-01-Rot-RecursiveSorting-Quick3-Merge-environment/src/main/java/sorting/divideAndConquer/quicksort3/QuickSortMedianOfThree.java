package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		if(leftIndex < 0 || rightIndex > array.length -1 || array.length == 1) {
			return;
		}
			if(leftIndex < rightIndex) {
				int posicaoDoPivot = particiona(array,leftIndex,rightIndex);
				sort(array,leftIndex,posicaoDoPivot - 1);
				sort(array,posicaoDoPivot + 1,rightIndex);
			}
	}

	private int particiona (T [] array, int inicio, int fim) {
		
		int meio = (inicio + fim)/2;
		mediaDeTres(array,inicio,meio,fim);
		T pivot = array[meio];
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
	
	private void mediaDeTres(T[] array, int leftIndex, int meio, int rightIndex) {
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


