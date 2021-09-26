package model;

import java.util.ArrayList;

public class GameStore {

	
	public ArrayList<Stand>stands = new ArrayList<>();
	
	private ArrayList<Client>client;
	
	public GameStore() {}
	
	public void createStand(int numberStand) {
		
		for (int i = 0; i < numberStand; i++) {
			stands.add(new Stand(null, 0));
		}
	}
	
	public void addStand(String name,ArrayList<Game>games) {
		
	}
	
	public void addClient(String code,String codeGame) {
		client.add(new Client(code, codeGame));
	}
	
	public ArrayList<Stand> getStands() {
		return stands;
	}
	
	public void setStands(ArrayList<Stand> stands) {
		this.stands = stands;
	}
}
