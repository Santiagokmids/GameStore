package model;

import java.util.ArrayList;

import dataStructures.HashTable;
import dataStructures.Queue;
import dataStructures.QueueNode;
import dataStructures.Stack;

public class GameStore {

	public ArrayList<Stand> stands = new ArrayList<>();
	private ArrayList<Client> client;
	private ArrayList<Game> clientGames;
	private Client clientsOfInsertion;
	private Client clientsOfSelection;
	private ArrayList<Stack<Game>> stacks;
	private ArrayList<Client> finalClients;
	private ArrayList<Long> times;
	private Queue<Client> queue;

	public GameStore() {
		client = new ArrayList<>();
		stacks = new ArrayList<>();
		times = new ArrayList<>();
		queue = new Queue<>();
		setFinalClients(new ArrayList<>());
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

		} catch (NumberFormatException nfe) {
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

				for (int j = 0; j < games.length; j++) {

					Game game = stands.get(i).getHash().searchElement(Integer.parseInt(games[j]));

					if (game != null) {
						contGamesFinds++;
						clientGames.add(game);
					}
				}

				if (contGamesFinds == games.length) {
					verify = true;

				}
			}

		} catch (NumberFormatException nfe) {
		}

		return verify;
	}

	public int checkCuantityTheGames(String txtGames) {

		int verify = 0;
		String[] games = txtGames.split(";");
		try {
			clientGames = new ArrayList<Game>();
			for (int i = 0; i < stands.size(); i++) {

				for (int j = 0; j < games.length; j++) {

					Game game = stands.get(i).getHash().searchElement(Integer.parseInt(games[j]));

					if (game != null) {
						if (game.getCuantity() >= 1) {
							clientGames.add(game);
							verify++;
						}
					}
				}

			}

		} catch (NumberFormatException nfe) {
		}
		if (verify >= games.length) {
			verify = 1;
		} else if (verify < games.length && verify >= 1) {
			verify = 2;
		} else {
			verify = 3;
		}
		return verify;
	}

	public void removeCuantityGame(String txtGames) {

		boolean verify = false;
		String[] games = txtGames.split(";");
		int contGamesFinds = 0;
		try {
			clientGames = new ArrayList<Game>();
			for (int i = 0; i < stands.size() && !verify; i++) {

				for (int j = 0; j < games.length; j++) {

					Game game = stands.get(i).getHash().searchElement(Integer.parseInt(games[j]));

					if (game != null) {
						if (game.getCuantity() > 0) {
							contGamesFinds++;
							clientGames.add(game);
							int newCuanity = stands.get(i).getHash().searchElement(Integer.parseInt(games[j]))
									.getCuantity();
							stands.get(i).getHash().searchElement(Integer.parseInt(games[j]))
									.setCuantity(newCuanity - 1);
						}
					}
				}

				if (contGamesFinds == games.length) {
					verify = true;

				}
			}

		} catch (NumberFormatException nfe) {
		}

	}

	public void changeInformation(String name, Integer numGame, int index) {
		stands.get(index).setName(name);
		stands.get(index).setHash(new HashTable<>(numGame));
	}

	public void addClient(String code) {
		client.add(new Client(code, clientGames));
	}

	public void insertionSort(Client clients) {

		for (int i = 1; i < clients.getCodeGame().size(); i++) {

			for (int j = i; j > 0 && clients.getCodeGame().get(j - 1).getStand()
					.compareTo(clients.getCodeGame().get(j).getStand()) > 0; j--) {

				Game tem = clients.getCodeGame().get(j);
				clients.getCodeGame().set(j, clients.getCodeGame().get(j - 1));
				clients.getCodeGame().set(j - 1, tem);
			}
		}
		clientsOfInsertion = clients;
	}

	public void addStackInsertion() {

		Stack<Game> stack = new Stack<>();

		for (int i = 0; i < clientsOfInsertion.getCodeGame().size(); i++) {
			stack.push(clientsOfInsertion.getCodeGame().get(i));
		}
		stacks.add(stack);
	}

	public void getListOfClient() {
		for (int i = 0; i < client.size(); i++) {
			long start = System.nanoTime();
			insertionSort(client.get(i));
			addStackInsertion();
			long end = System.nanoTime();
			Long total = end - start;
			total += calculateTimeInsertion();
			times.add(total);
			client.get(i).calculatePrice();
		}
	}

	public void initializatedSelectionSort() {
		for (int i = 0; i < client.size(); i++) {
			long start = System.currentTimeMillis();
			selectionSort(client.get(i));
			addStackSelection();
			long end = System.currentTimeMillis();
			Long total = end - start;
			total += calculateTimeSelection();
			times.add(total);
			client.get(i).calculatePrice();
		}
	}

	public void selectionSort(Client objClient) {

		Client newClient = objClient;
		ArrayList<Game> newArray = objClient.getCodeGame();

		for (int i = 0; i < newArray.size(); i++) {

			Game min = newArray.get(i);

			for (int j = i + 1; j < newArray.size(); j++) {
				if (newArray.get(j).getStand().compareTo(min.getStand()) < 0) {
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

		clientsOfSelection = newClient;
	}

	public void addQueue() {
		int contQueue = 0;
		
		if(times.size() == 1) {
			times.remove(0);
			queue.enqueue(new QueueNode<Client>(client.get(0)));
			stacks.set(contQueue, stacks.get(0));
			
		}else {
			for (int i = 0; i < times.size(); i++) {
				int cont = 1;
				for (int j = 0; j < times.size(); j++) {
					if (times.get(i) > times.get(j)) {
						cont++;
					}
				}
				if (cont == times.size() && client != null) {
					queue.enqueue(new QueueNode<Client>(client.get(i)));
					stacks.set(contQueue, stacks.get(i));
					contQueue++;
					
				} else if(i == times.size()-1 && client != null) {
					queue.enqueue(new QueueNode<Client>(client.get(i)));
					stacks.set(contQueue, stacks.get(i));
				}
			}
		}
	}

	public void addStackSelection() {

		Stack<Game> stack = new Stack<>();
		
		for (int i = 0; i < clientsOfSelection.getCodeGame().size(); i++) {
			stack.push(clientsOfSelection.getCodeGame().get(i));
		}
		stacks.add(stack);
	}

	public Long calculateTimeInsertion() {
		Long total = (long) 0;
		String letter = "A";
		for (int i = 0; i < clientsOfInsertion.getCodeGame().size(); i++) {
			
			if (letter.compareTo(clientsOfInsertion.getCodeGame().get(i).getStand().toUpperCase()) > 0) {
				total += 10;
			}
		}
		return total;
	}

	public Long calculateTimeSelection() {
		Long total = (long) 0;
		String letter = "A";
		for (int i = 0; i < clientsOfSelection.getCodeGame().size(); i++) {

			if (letter.compareTo(clientsOfSelection.getCodeGame().get(i).getStand().toUpperCase()) > 0) {
				total += 10;
			}
		}
		return total;
	}

	public ArrayList<Stand> getStands() {
		return stands;
	}

	public void setStands(ArrayList<Stand> stands) {
		this.stands = stands;
	}

	public void addStand(String name, ArrayList<Game> games) {

	}

	public ArrayList<Client> getClient() {
		return client;
	}

	public void setClient(ArrayList<Client> client) {
		this.client = client;
	}

	public boolean searchGame(int codeGame) {
		boolean find = false;

		for (int i = 0; i < stands.size(); i++) {
			Game game = stands.get(i).getHash().searchElement(codeGame);
			if (game != null) {
				find = true;
			}
		}
		return find;
	}

	public Queue<Client> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Client> queue) {
		this.queue = queue;
	}

	public ArrayList<Stack<Game>> getStacks() {
		return stacks;
	}

	public void setStacks(ArrayList<Stack<Game>> stacks) {
		this.stacks = stacks;
	}

	public ArrayList<Client> getfinalClients() {
		return finalClients;
	}

	public void setFinalClients(ArrayList<Client> finalClients) {
		this.finalClients = finalClients;
	}
	
}
