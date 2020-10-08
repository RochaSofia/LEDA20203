package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		if(leftIndex >= 0 && rightIndex < array.length && rightIndex > leftIndex  ) {
			int elementoMaior = encontraMaior(array,leftIndex,rightIndex);
			int elementoMenor = encontraMenor(array,leftIndex,rightIndex);
			
			int[] cumulativa = new int[elementoMaior - elementoMenor + 1];
			
			for(int i =leftIndex; i<= rightIndex;i++) {
				
				cumulativa[array[i] - elementoMenor] +=1;
				
			}
			
			for(int j = 1; j< cumulativa.length;j++) {
				
				cumulativa[j] += cumulativa[j - 1];
			}
			
			Integer[] resultado = new Integer[(rightIndex - leftIndex) + 1];
			
			
			for(int i = rightIndex; i >= leftIndex ; i--) {
				
				resultado[cumulativa[array[i] - elementoMenor]-1] = array[i]; 
				
				cumulativa[array[i] - elementoMenor] -=1;
			}
			for(int i= leftIndex; i<= rightIndex;i++){
				
				array[i] = resultado[i - leftIndex];
				
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
	private int encontraMenor(Integer[] array, int leftIndex, int rightIndex) {
		
		int menor = array[leftIndex];
		
		for(int i = leftIndex + 1; i<= rightIndex; i++) {
			if(array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}
		//throw new UnsupportedOperationException("Not implemented yet!");
}


