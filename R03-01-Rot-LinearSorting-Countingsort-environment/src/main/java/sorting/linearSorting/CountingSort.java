package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		if(leftIndex >= 0 && rightIndex < array.length && rightIndex > leftIndex  ) {
			int elementoMaior = encontraMaior(array,leftIndex,rightIndex);
			
			int[] cumulativa = new int[elementoMaior + 1];
			
			for(int i =leftIndex; i<= rightIndex;i++) {
				
				cumulativa[array[i]] +=1;
				
			}
			
			for(int j = leftIndex + 1; j< cumulativa.length;j++) {
				
				cumulativa[j] += cumulativa[j - 1];
			}
			
			Integer[] resultado = new Integer[(rightIndex - leftIndex) + 1];
			
			
			for(int i = rightIndex; i >= leftIndex ; i--) {
				
				resultado[cumulativa[array[i]]-1] = array[i]; 
				
				cumulativa[array[i]] -=1;
			}
			
			for(int i= leftIndex; i<= rightIndex;i++){
				array[i] = resultado[i];
			}
			
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}
	
	private int encontraMaior(Integer[] array, int leftIndex, int rightIndex) {
		
		int maior = array[leftIndex];
		
		for(int i = leftIndex + 1; i<= rightIndex; i++) {
			if(array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}

}
