package model;

import java.util.ArrayList;

public class Client {
	
	private String code;
	private ArrayList<Integer> codeGame;
	
	public Client(String code, ArrayList<Integer> codeGame) {
		this.code = code;
		this.setCodeGame(codeGame);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Integer> getCodeGame() {
		return codeGame;
	}

	public void setCodeGame(ArrayList<Integer> codeGame) {
		this.codeGame = codeGame;
	}

	
}
