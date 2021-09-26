package dataStructures;

public interface IHashTable<K, V>{
	
	public boolean verifySpace();
	public int lengthTable();
	public boolean inserTable(K key, V value);
	public boolean deleteElement(K key);
	public V searchElement(K key);
}