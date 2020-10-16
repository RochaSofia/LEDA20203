package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new ExtendedCountingSort();
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
	@Test
	public void testeParcialOrdenado() {
		Integer [] array  = {0,1,2,3,4,5,8,6,8,9,7,10};
		Integer[] vetorCopia = Arrays.copyOf(array,array.length);
		Arrays.sort(vetorCopia);
		this.implementation.sort(array,6,11);
		Assert.assertArrayEquals(vetorCopia,array);
	}
	@Test
	public void testeParcialOrdenadoCome�o() {
		Integer [] array  = {9,4,5,2,3,2,8,10,11};
		Integer[] vetorCopia = Arrays.copyOf(array,array.length);
		Arrays.sort(vetorCopia);
		this.implementation.sort(array,0,6);
		Assert.assertArrayEquals(vetorCopia,array);
	}
	@Test
	public void testeParcialOrdenadoMeio() {
		Integer [] array  = {0,1,2,4,7,3,5,2,8,9};
		Integer[] vetorCopia = Arrays.copyOf(array,array.length);
		Arrays.sort(vetorCopia);
		this.implementation.sort(array,2,7);
		Assert.assertArrayEquals(vetorCopia,array);
	}
	@Test
	public void testeVazio() {
		Integer [] array  = {};
		Integer[] vetorCopia = Arrays.copyOf(array,array.length);
		Arrays.sort(vetorCopia);
		this.implementation.sort(array,6,11);
		Assert.assertArrayEquals(vetorCopia,array);
	}
	@Test
	public void testeExtendedCountingComNegativo() {
		/*esse teste nao passa no counting sort normal apenas no extended*/
		Integer [] array  = {0,4,5,-3,4,2,1,-2,6};
		Integer[] vetorCopia = Arrays.copyOf(array,array.length);
		Arrays.sort(vetorCopia);
		this.implementation.sort(array,0,8);
		Assert.assertArrayEquals(vetorCopia,array);
	}
	@Test
	public void testeExtendedCountingOrdenadoCome�oComNegativo() {
		/*esse teste nao passa no counting sort normal apenas no extended*/
		Integer [] array  = {-3,-2,0,3,2,-1,4,5,6};
		Integer[] vetorCopia = Arrays.copyOf(array,array.length);
		Arrays.sort(vetorCopia);
		this.implementation.sort(array,2,5);
		Assert.assertArrayEquals(vetorCopia,array);
	}
	@Test
	public void testeExtendedCountingApenasNegativos() {
		/*esse teste nao passa no counting sort normal apenas no extended*/
		Integer [] array  = {-2,-5,-9,-11,-2,-1,-3,-4};
		Integer[] vetorCopia = Arrays.copyOf(array,array.length);
		Arrays.sort(vetorCopia);
		this.implementation.sort(array,0,array.length-1);
		Assert.assertArrayEquals(vetorCopia,array);
	}
	@Test
	public void testeExtendedCountingNegativoseZero() {
		/*esse teste nao passa no counting sort normal apenas no extended*/
		Integer [] array  = {-2,0,-9,0,-2,-1,-3,-4};
		Integer[] vetorCopia = Arrays.copyOf(array,array.length);
		Arrays.sort(vetorCopia);
		this.implementation.sort(array,0,array.length-1);
		Assert.assertArrayEquals(vetorCopia,array);
	}
}