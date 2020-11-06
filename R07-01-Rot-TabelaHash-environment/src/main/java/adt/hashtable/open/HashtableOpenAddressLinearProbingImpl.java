package adt.hashtable.open;

//import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		if(element != null) {
			
			if(search(element) == null) {
				int cont = 0;
				int hash = calculaHash( element,cont);
				while(this.table[hash] != null && cont < this.table.length && !this.table[hash].toString().equals("D")) {
					COLLISIONS++;
					cont++;
					hash =  calculaHash(element,cont);
				}
				if(cont == this.table.length) {
					//lança exeção
					throw new HashtableOverflowException();
				}
				//insere
				this.table[hash] = element;
				elements++;
			}
			
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
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
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
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

		//throw new UnsupportedOperationException("Not implemented yet!");
	}
	private int calculaHash(T element, int prob) {
		return  ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element,prob);
	}
}
