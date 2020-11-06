package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
	if(element != null) {
			if(isFull()) {
				throw new HashtableOverflowException();
			}
			if(search(element) == null) {
				int cont = 0;
				int hash = calculaHash(element,cont);
				while(this.table[hash] != null && cont < this.table.length && !this.table[hash].toString().equals("D")) {
					COLLISIONS++;
					cont++;
					hash =  calculaHash(element,cont);
				}
				
				//insere
				this.table[hash] = element;
				elements++;
			}
	}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		if(element != null && !isEmpty()) {
			if(indexOf(element) != -1) {
				this.table[indexOf(element)] = new DELETED();
				elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		T retorno = null;
		if(element != null && !isEmpty()) {
			if(indexOf(element) != -1) {
				retorno = element;
			}
		}
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		int retorno = -1;
		int cont = 0;
		int hash = calculaHash( element,cont);
		while(this.table[hash] != null && cont < this.table.length) {
			if(this.table[hash].equals(element)) {
				return hash;
			}
			cont++;
			hash =  calculaHash( element,cont);
		}
		return retorno;
	}
	private int calculaHash(T element, int prob) {
		return  ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element,prob);
	}
}
