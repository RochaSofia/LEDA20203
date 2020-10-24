package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public QueueUsingStack<Integer> queue1;
	public QueueUsingStack<Integer> queue2;
	public QueueUsingStack<Integer> queueVazia;
	public QueueUsingStack<Integer> queue4;
	public QueueUsingStack<Integer> queueCriadaVazia;
	public CircularQueue<Integer> queueTamanhoImparCheia;
	public CircularQueue<Integer> queueTamanhoImpar;
	public CircularQueue<Integer> queueTamanhoParCheia;
	public CircularQueue<Integer> queueTamanhoPar;
	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);
		//
		queue4.enqueue(1);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueUsingStack(4);
		queue2 = new QueueUsingStack(2);
		queueVazia = new QueueUsingStack(2);
		queue4 = new QueueUsingStack(1);
		queueCriadaVazia = new QueueUsingStack(0);
		queueTamanhoImparCheia  = new CircularQueue(5);
		queueTamanhoImpar = new CircularQueue(7);
		queueTamanhoParCheia = new CircularQueue(4);
		queueTamanhoPar  = new CircularQueue(6);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmptyFalse() {
		assertFalse(queue1.isEmpty());
	}
	@Test
	public void testIsEmptyTrue() {
		assertTrue(queueVazia.isEmpty());
	}
	@Test
	public void testIsEmptyFalseQueueTamanho0() {
		assertFalse(queueCriadaVazia.isEmpty());
	}
	@Test
	public void testIsEmptyTruequeueCriadaVazia() {
		assertTrue(queueCriadaVazia.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertTrue(queue2.isFull());
		//assertFalse(queue1.isFull());
	}
	@Test
	public void testIsFullTest() {
		assertTrue(queue4.isFull());
		//assertFalse(queue1.isFull());
	}
	@Test
	public void testIsEmptyTest() {
		assertFalse(queue4.isEmpty());
		//assertTrue(queue3.isEmpty());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue1.enqueue(new Integer(5));
		queue1.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue2.dequeue()); // vai depender do
		assertEquals(new Integer(2), queue2.dequeue());	// tamanho que a fial
		assertEquals(new Integer(3), queue2.dequeue());	// foi iniciada!!!
	}
}