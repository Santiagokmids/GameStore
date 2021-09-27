package model;

import java.util.ArrayList;

public class Client {
	
	private String code;
	private ArrayList<Game> codeGame;
	private int price;
	
	public Client(String code, ArrayList<Game> codeGame) {
		this.code = code;
		this.setCodeGame(codeGame);
		setPrice(0);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Game> getCodeGame() {
		return codeGame;
	}

	public void setCodeGame(ArrayList<Game> codeGame) {
		this.codeGame = codeGame;
	}
	
	public void calculatePrice() {
		for (int i = 0; i < codeGame.size(); i++) {
			price += codeGame.get(i).getPrice();
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
