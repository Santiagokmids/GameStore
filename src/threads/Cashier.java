package threads;

import java.io.IOException;

import dataStructures.Stack;
import model.Client;
import model.Game;
import model.GameStore;
import ui.GameStoreGUI;

public class Cashier extends Thread {

	private Client client;
	private Stack<Game> stack;
	private GameStore gameStore;
	private GameStoreGUI gameStoreGUI;

	public Cashier() {
		setClient(null);
		stack = new Stack<>();
		gameStoreGUI = new GameStoreGUI();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void run() {
		System.out.println("entraaa al hilo");
		int numGames = client.getCodeGame().size();
		
		for (int j = 0; j < client.getCodeGame().size(); j++) {
			client.getCodeGame().remove(j);
		}
		
		try{
			if(7 < numGames) {
				Thread.sleep(800);
				
			}else {
				Thread.sleep(150*numGames);
				gameStore.getfinalClients().add(client);
				gameStoreGUI.clientToCashier(this);
			}
		}catch(InterruptedException | IOException e) {

		}
	}

	public Stack<Game> getStack() {
		return stack;
	}

	public void setStack(Stack<Game> stack) {
		this.stack = stack;
	}
}
