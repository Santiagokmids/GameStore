package model;

import java.util.ArrayList;

public class GameStore {
	
	public ArrayList<Stand>stands = new ArrayList<>();
	
	public ArrayList<Stand> getStands() {
		return stands;
	}

	public void setStands(ArrayList<Stand> stands) {
		this.stands = stands;
	}
}
