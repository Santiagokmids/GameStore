package dataStructures;

import model.IElementsOfStore;

public class HashTable<K, V, L> implements IElementsOfStore<L>, IHashTable<K, V>{
	
	private int sizeArray;
	private HashNode<K, V>[] nodes;
	private int sizeHashTable;
	
	public HashTable(int sizeArray) {
		create();
		sizeHashTable = sizeArray;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean create() {
		nodes = (HashNode<K, V>[])(new HashNode[sizeArray]);
		return true;
	}

	@Override
	public boolean verifySpace() {
		
		boolean verify = true;
		
		for (int i = 0; i < nodes.length && verify; i++) {
			if(nodes[i] != null) {
				verify = false;
			}
		}
		
		return verify;
	}

	@Override
	public int lengthTable() {
		return sizeHashTable;
	}

	@Override
	public boolean inserTable(K key, V value) {
		
		boolean verify = false;
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		
		Integer index = (Integer)key % sizeHashTable;
		
		Integer i = index;
		
		while(i <= sizeHashTable || !verify) {
			
			if(nodes[i] == null) {
				verify = true;
				nodes[i] = newNode;
			}else {
				i++;
			}
		}
		
		return verify;
	}

	@Override
	public boolean deleteElement(K key) {
		
		boolean verify = false;
		
		for (int i = 0; i < nodes.length && !verify; i++) {
			if(nodes[i].getKey() == key) {
				verify = true;
				nodes[i] = null;
			}
		}
		return verify;
	}

	@Override
	public V searchElement(K key) {
		
		boolean verify = false;
		HashNode<K, V> newNode = new HashNode<K, V>(null, null);
		
		for (int i = 0; i < nodes.length && !verify; i++) {
			if(nodes[i].getKey() == key) {
				verify = true;
				newNode = nodes[i];
			}
		}
		
		return newNode.getValue();
	}

	public int getSizeArray() {
		return sizeArray;
	}

	public void setSizeArray(int sizeArray) {
		this.sizeArray = sizeArray;
	}

	public HashNode<K, V>[] getNodes() {
		return nodes;
	}

	public void setNodes(HashNode<K, V>[] nodes) {
		this.nodes = nodes;
	}
}
