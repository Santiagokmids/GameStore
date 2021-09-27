package model;

import java.util.ArrayList;

public class Client {
	
	private String code;
	private ArrayList<Game> codeGame;
	
	public Client(String code, ArrayList<Game> codeGame) {
		this.code = code;
		this.setCodeGame(codeGame);
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

	
}
