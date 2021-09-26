package dataStructures;

import model.IElementsOfStore;

public class HashTable<K, V, L> implements IElementsOfStore<L>{
	
	private int sizeArray;
	private HashNode<K, V>[] nodes;
	private int lengthTable;
	
	public HashTable(int sizeArray) {
		create();
		lengthTable = sizeArray;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean create() {
		nodes = (HashNode<K, V>[])(new HashNode[sizeArray]);
		return true;
	}

}
