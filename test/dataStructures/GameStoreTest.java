package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Client;
import model.Game;

class GameStoreTest {
	private Queue<Client> queue;
	private Stack<Game> game;
	private HashTable<Integer, Game> hashTable;
	private QueueNode<Client> clientNode;

	// queue = clientes
	// Stack = game
	public void setupScenary1() {

	}

	public void setupScenary2() {

	}

	public void setupScenary3() {

	}

	public void setupScenary4() {
		queue = new Queue<>();
	}

	public void setupScenary5() {
		queue = new Queue<>();
		String code = "4444654";
		setupScenary4();
		ArrayList<Game> list = new ArrayList<Game>();
		list.add(new Game (9876,2000,1,"A"));
		list.add(new Game (1234,10000,5,"A"));
		String code2 = "6543365";
		Client client = new Client(code, list);
		list.clear();
		list.add(new Game (123124,12312,123123,"A"));
		list.add(new Game (1012,12312,123123,"A"));
		Client client2 = new Client(code2, list);
		QueueNode<Client> clientNode = new QueueNode<Client>(client);
		QueueNode<Client> clientNode2 = new QueueNode<Client>(client2);
		queue.enqueue(clientNode);
		queue.enqueue(clientNode2);
	}

	public void setupScenary6() {
		game = new Stack<>();
	}

	public void setupScenary7() {
		game = new Stack<>();
		Game gm1 = new Game(955,1000,5,"A");
		Game gm2 = new Game (895,13500,2,"B");
		game.push(gm1);
		game.push(gm2);
	}

	public void setupScenary8() {
		hashTable= new HashTable<Integer, Game>(5);
	}
	public void setupScenary9() {
		hashTable= new HashTable<Integer, Game>(5);
		Game gm = new Game(996,1300,4,"A");
		Game gm2 = new Game(995,6000,6,"B");
		hashTable.inserTable(996, gm);
		hashTable.inserTable(995, gm2);
	}

	@Test
	void testCreateQueue() {
		setupScenary1();
		queue = new Queue<>();
		boolean que = queue.isEmpty();
		assertTrue(que);

	}

	@Test
	void testCreateStack() {
		setupScenary2();
		game = new Stack<Game>();
		boolean stac = game.isEmpty();
		assertTrue(stac);

	}

	@Test
	void testCreateHashTable() {
		setupScenary3();
		hashTable = new HashTable<>(25);
		boolean hash = hashTable.verifySpace();
		assertTrue(hash);
		assertEquals(25, hashTable.getSizeArray());
		hashTable = new HashTable<>(10);
		boolean hash2 = hashTable.verifySpace();
		assertTrue(hash2);
		assertEquals(10, hashTable.getSizeArray());
	}

	@Test
	void testValidateAddObjet() {
		setupScenary4();
		ArrayList<Game> list = new ArrayList<Game>();
		list.add(new Game (1234,12312,123123,"A"));
		list.add(new Game (6543,12312,123123,"A"));
		Client client = new Client("6998987", list);
		clientNode = new QueueNode<Client>(client);
		queue.enqueue(clientNode);
		assertEquals("6998987", queue.getFront().getElement().getCode());
		list.clear();
		list.add(new Game (6669,12312,123123,"A"));
		list.add(new Game (33354,12312,123123,"A"));
		Client client2 = new Client("65459876", list);
		clientNode = new QueueNode<Client>(client2);
		queue.enqueue(clientNode);
		assertEquals("65459876", queue.getBack().getElement().getCode());
	}

	@Test
	void testRemoveObject() {
		setupScenary5();
		assertTrue(queue.dequeue());

	}

	@Test
	void testObjectFirst() {
		setupScenary5();
		assertEquals("4444654", queue.getFront().getElement().getCode());
	}

	@Test
	void testQueueIsEmpty() {
		setupScenary4();
		assertTrue(queue.isEmpty());
	}

	@Test
	void testAddObjetctStack() {
		setupScenary6();
		Game gm = new Game (21312,1321,2,"A");
		game.push(gm);
		assertEquals(21312, game.top().getElement().getCode());
	}
	@Test
	void testValidRemoveObjectStack() {
		setupScenary7();
		assertEquals(895, game.pop().getElement().getCode());;

	}
	@Test
	void testValidateStackIsEmpty() {
		setupScenary6();
		assertTrue(game.isEmpty());
	}
	@Test
	void testValidateHashTableIsEmpty() {
		setupScenary8();
		assertTrue(hashTable.verifySpace());
	}
	@Test
	void testValidateHashTableSize() {
		setupScenary8();
		assertEquals(5, hashTable.getSizeArray());
	}
	@Test
	void testValidateHashTableCreateElement() {
		setupScenary8();
		Game gm = new Game(925,7500,2,"B");
		assertTrue(hashTable.inserTable(925, gm));
	}
	@Test
	void testRemoveElementHashTable() {
		setupScenary9();
		int key = 996;
		assertTrue(hashTable.deleteElement(key));
	}

	@Test
	void testSearchElementHashTable() {
		setupScenary9();
		int key = 996;
		assertEquals(key,hashTable.searchElement(key).getCode());
	}
}
