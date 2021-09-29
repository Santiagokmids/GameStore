package threads;

import dataStructures.Stack;
import javafx.application.Platform;
import model.Client;
import model.Game;
import ui.GameStoreGUI;

public class Cashier extends Thread {

	private Client client;
	private Stack<Game> stack;
	private GameStoreGUI gameStore;

	public Cashier(GameStoreGUI gameStore) {
		setClient(null);
		stack = new Stack<>();
		this.gameStore = gameStore;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void run() {

		int numGames = client.getCodeGame().size();

		for (int j = 0; j < client.getCodeGame().size(); j++) {
			client.getCodeGame().remove(j);
			client.getCodeGame().add(stack.top().getElement());
		}

		if(7 < numGames) {

			Platform.runLater(() -> { // Para cambiar algo grafico-- desde un hilo alternativo
				try {
					Thread.sleep(800);
					gameStore.getFinalClients().add(client);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	//setprogre para el avance	
			});

		}else {
			
			Platform.runLater(() -> { // Para cambiar algo grafico-- desde un hilo alternativo
				try {
					Thread.sleep(150*numGames);
					gameStore.getFinalClients().add(client);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	//setprogre para el avance	
			});
		}
	}

	public Stack<Game> getStack() {
		return stack;
	}

	public void setStack(Stack<Game> stack) {
		this.stack = stack;
	}
}
