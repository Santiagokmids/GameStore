package model;

import java.util.ArrayList;

import dataStructures.HashTable;

public class GameStore {

	public ArrayList<Stand>stands = new ArrayList<>();
	private ArrayList<Client>client;
	private ArrayList<Game>clientGames;

	public GameStore() {
		client = new ArrayList<>();
	}

	public void createStand(int numberStand) {

		for (int i = 0; i < numberStand; i++) {
			stands.add(new Stand(null, 0));
		}
	}

	public boolean verifyGames(String txtGames) {

		boolean verify = false;

		String[] games = txtGames.split(";");
		int[] listGames = new int[games.length];

		try {
			for (int i = 0; i < games.length; i++) {
				listGames[i] = Integer.parseInt(games[i]);
			}
			verify = true;

		}catch (NumberFormatException nfe) {
		}

		return verify;
	}

	public boolean checkTheGames(String txtGames) {

		boolean verify = false;
		String[] games = txtGames.split(";");
		int contGamesFinds = 0;
		try {
			clientGames = new ArrayList<Game>();
			for (int i = 0; i < stands.size() && !verify; i++) {

				for (int j = 0; j < games.length ; j++) {

					Game game = stands.get(i).getHash().searchElement(Integer.parseInt(games[j]));

					if(game != null) {
						contGamesFinds++;
						clientGames.add(game);
					}
				}

				if(contGamesFinds == games.length) {
					verify = true;

				}
			}

		}catch (NumberFormatException nfe) {
		}

		return verify;
	}

	public void changeInformation(String name, Integer numGame, int index) {
		stands.get(index).setName(name);
		stands.get(index).setHash(new HashTable<>(numGame));
	}

	public void addClient(String code) {
		client.add(new Client(code, clientGames));
	}

	public void insertionSort(Client client) {

		for(int i = 1; i < client.getCodeGame().size();i++) {

			for(int j= i; j > 0 && compareStands(client.getCodeGame().get(j-1), client.getCodeGame().get(j)) == -1;j--) {
				Game tem = client.getCodeGame().get(j);
				client.getCodeGame().remove(j);
				client.getCodeGame().add(j, client.getCodeGame().get(j-1));;
				client.getCodeGame().remove(j-1);
				client.getCodeGame().add(tem);
			}
		}
	}

	public int compareStands(Game game1, Game game2) {
		int number = 0;

		if(game1.getStand().compareTo(game2.getStand()) > -1) {
			number = -1;

		}else if(game1.getStand().compareTo(game2.getStand()) > 1) {
			number = 1;
		}

		return number;
	}

	public void getListOfClient(){
		for(int i = 1; i < client.size();i++) {
			insertionSort(client.get(i));

		}

	}

	public void initializatedSelectionSort() {
		for (int i = 0; i < client.size(); i++) {
			selectionSort(client.get(i));
		}
	}

	public void selectionSort(Client objClient) {

		Client newClient = objClient;
		ArrayList<Game> newArray = objClient.getCodeGame();

		for(int i = 0 ; i < newArray.size(); i++) {

			Game min = newArray.get(i);

			for(int j = i+1; j < newArray.size(); j++) {
				if(newArray.get(j).getStand().compareTo(min.getStand()) < 0) {
					Game temp = newArray.get(j);
					newArray.remove(j);
					newArray.add(j, min);
					min = temp;
				}
			}
			newArray.remove(i);
			newArray.add(i, min);
		}

		newClient.setCodeGame(newArray);
	}


	public ArrayList<Stand> getStands() {
		return stands;
	}

	public void setStands(ArrayList<Stand> stands) {
		this.stands = stands;
	}

	public void addStand(String name,ArrayList<Game>games) {

	}

	public ArrayList<Client> getClient() {
		return client;
	}

	public void setClient(ArrayList<Client> client) {
		this.client = client;
	}

	public boolean searchGame(int codeGame) {
		boolean find = false;

		for(int i = 0;i < stands.size();i++) {
			Game game = stands.get(i).getHash().searchElement(codeGame);
			if(game != null) {
				find = true;
			}
		}
		return find;
	}
}
