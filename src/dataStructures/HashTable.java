package dataStructures;

import model.IElementsOfStore;

public class HashTable<K, V> implements IElementsOfStore, IHashTable<K, V>{

	private int sizeArray;
	private HashNode<K, V>[] nodes;

	public HashTable(int sizeArray) {
		this.sizeArray = sizeArray;
		create();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean create() {

		nodes = (HashNode<K, V>[])(new HashNode[sizeArray]);

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = null;
		}

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
		return sizeArray;
	}

	@Override
	public boolean inserTable(K key, V value) {

		boolean verify = false;
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		int i = 0;

		while(i < sizeArray && !verify) {
			Integer index = (((Integer)key) + i)% sizeArray;

			if(nodes[index] == null) {
				verify = true;
				nodes[index] = newNode;
			}else {
				i++;
			}
		}

		return verify;
	}

	@Override
	public boolean deleteElement(K key) {

		boolean verify = false;
		int i = 0;

		while(i < sizeArray && !verify) {
			Integer index = (((Integer)key) + i) % sizeArray;

			if(nodes[index].getKey() == key) {
				verify = true;
				nodes[index] = null;
			}else {
				i++;
			}
		}
		return verify;
	}

	@Override
	public V searchElement(K key) {

		boolean verify = false;
		HashNode<K, V> newNode = new HashNode<K, V>(null, null);
		int i = 0;

		while(i < sizeArray && !verify) {
			
			Integer index = (((Integer)key) + i) % sizeArray;

			if(nodes[index] != null && nodes[index].getKey() == key) {
				verify = true;
				newNode = nodes[index];
			}else {
				i++;
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
