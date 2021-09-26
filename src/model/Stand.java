package model;

import dataStructures.HashTable;

public class Stand {

	private String name;
	private HashTable<Integer, Game> hash;
	
	public Stand(String name, int sizeArray) {
		this.name = name;
		hash = new HashTable<>(sizeArray);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashTable<Integer, Game> getHash() {
		return hash;
	}

	public void setHash(HashTable<Integer, Game> hash) {
		this.hash = hash;
	}
}
