package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameStoreTest {
	private 	GameStore  gameStore;
	public void setupScenary1() {
	
	}

	public void setupScenary2() {

	}

	public void setupScenary3() {

	}

	public void setupScenary4() {
		gameStore = new GameStore();
		//gameStore.CreateQueue();
	}

	public void setupScenary5() {
		gameStore = new GameStore();
		//gameStore.CreateQueue();
		String code = "4444654"; 
		String  codeGame = "98766543";
		
		String code2= "6543365";
		String codeGame2 = "12343333";
		
		gameStore.addClient(code, codeGame);
		gameStore.addClient(code2, codeGame2);
		
	}

	public void setupScenary6() {
		gameStore = new GameStore();
		//gameStore.CreateStack();
	}

	public void setupScenary7() {
		gameStore = new GameStore();
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
	void test1() {
		
	}

}
