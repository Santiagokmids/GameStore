package model;

public class Client {
	
	private String code;
	private String codeGame;
	
	public Client(String code, String codeGame) {
		this.code = code;
		this.codeGame = codeGame;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeGame() {
		return codeGame;
	}

	public void setCodeGame(String codeGame) {
		this.codeGame = codeGame;
	}
}
