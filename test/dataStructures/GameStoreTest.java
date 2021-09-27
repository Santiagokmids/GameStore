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
		String codeGame = "9876,6543";
		setupScenary4();
		ArrayList<Game> list = new ArrayList<Game>();
		list.add(new Game (12312,12312,123123,"A"));
		list.add(new Game (21412,12312,123123,"A"));
		String code2 = "6543365";
		String codeGame2 = "1234,3333";
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
		String code = "955";
		int price = 10000;
		int cuantity = 5;
		String stand = "A";

		String code2 = "895";
		int price2 = 13500;
		int cuantity2 = 2;
		String stand2 = "B";

		// gameStore.addVideoGame(code,price,cuantity,stand);
		// gameStore.addVideoGame(code2,price2,cuantity2,stand2);
	}

	public void setupScenary8() {
		// gameStore.addHastTable();
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
		list.add(new Game (12312,12312,123123,"A"));
		list.add(new Game (21412,12312,123123,"A"));
	Client client = new Client("4444654", list);
	clientNode = new QueueNode<Client>(client);
	queue.enqueue(clientNode);
	assertEquals("4444654", queue.getFront().getElement().getCode());
	list.clear();
	list.add(new Game (123124,12312,123123,"A"));
	list.add(new Game (1012,12312,123123,"A"));
	Client client2 = new Client("6543365", list);
	clientNode = new QueueNode<Client>(client2);
	queue.enqueue(clientNode);
	assertEquals("6543365", queue.getBack().getElement().getCode());
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
}
