package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameStore {

	
	public ArrayList<Stand>stands = new ArrayList<>();
	
	public ArrayList<Stand> getStands() {
		return stands;
	}

	public void setStands(ArrayList<Stand> stands) {
		this.stands = stands;
	}
	private ArrayList<Client>client;
	public void addStand(String name,ArrayList<Game>games) {
		
	}
	public void addClient(String code,String codeGame) {
		client.add(new Client(code, codeGame));
	}
	

	public static void insertionSort() {
		for(int i = 1; i<(Nombre).length;i++) {
			for(int j= i; j>0 && (Nombre)[j-1] >(Nombre)[j];j--) {
				int tem = (Nombre)[j];
				(Nombre)[j]= (Nombre)[j-1];
				(Nombre)[j-1]= tem;
			}
		}
	}

	public static void selectionSort() {
		for(int i = 0 ; i<(Nombre).lenth;i++) {
			int min = (Nombre)[i];
			for(int j = i+1;j <(Nombre).length;j++) {
				if((Nombre)[j]<min) {
					int tem = (Nombre)[j];
					min = tem;
				}
			}
			(Nombre)[i]= min;
			
		}
	}
}
