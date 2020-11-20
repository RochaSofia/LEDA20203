package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		// TODO Auto-generated method stub
		Integer retorno = null;
		HeapImpl<Integer> h = new HeapImpl(comparator);
		for(int i=0; i< array.length; i++) {
			h.insert(array[i]);
		}
		for(int i=0;i<array.length;i++) {
			if(h.rootElement() == numero) {
				return h.rootElement();
			}else
			if(h.rootElement() < numero) {
				if(retorno == null) {
					retorno = h.rootElement();
				}else {
					if(h.rootElement() > retorno) {
						retorno = h.rootElement();
					}
				}
			}
			h.extractRootElement();
		}
		
		return retorno;
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		// TODO Auto-generated method stub
//		Integer retorno = null;
//		HeapImpl<Integer> h = new HeapImpl(comparator);
//		for(int i=0; i< array.length; i++) {
//			h.insert(array[i]);
//		}
//		for(int i=0;i<array.length;i++) {
//			if(h.rootElement() == numero) {
//				return h.rootElement();
//			}else
//			if(h.rootElement() > numero) {
//				if(retorno == null) {
//					retorno = h.rootElement();
//				}else {
//					if(h.rootElement() > retorno) {
//						retorno = h.rootElement();
//					}
//				}
//			}
//			h.extractRootElement();
//		}
//		
//		return retorno;
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
