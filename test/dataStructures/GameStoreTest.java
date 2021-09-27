package dataStructures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Client;
import model.Game;
class GameStoreTest {
	private Queue <Client> queue;
	private Stack<Game>stack;
	private HashTable<Integer, Game> hashTable;
	
	public void setupScenary1() {
		
	}

	public void setupScenary2() {

	}

	public void setupScenary3() {

	}

	public void setupScenary4() {
		queue = new Queue<>();
		//gameStore.CreateQueue();
	}

	public void setupScenary5() {
		queue = new Queue<>();
		//gameStore.CreateQueue();
		String code = "4444654"; 
		String  codeGame = "98766543";
		
		String code2= "6543365";
		String codeGame2 = "12343333";
		Client client = new Client(code, codeGame);
		Client client2 = new Client(code2,codeGame2);
		QueueNode<Client>  clientNode = new QueueNode<Client>(client);
		QueueNode<Client>  clientNode2 = new QueueNode<Client>(client2);
		queue.enqueue(clientNode);
		queue.enqueue(clientNode2);
		
	}

	public void setupScenary6() {
		//gameStore = new GameStore();
		//gameStore.CreateStack();
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
		
		//gameStore.addVideoGame(code,price,cuantity,stand);
		//gameStore.addVideoGame(code2,price2,cuantity2,stand2);
	}
	public void setupScenary8() {
		//gameStore.addHastTable();
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
		 stack = new Stack<Game>();
		boolean stac = stack.isEmpty();
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

}
