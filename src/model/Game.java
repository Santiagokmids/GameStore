package model;

public class Game {
	
	private int code;
	private int price;
	private int cuantity;
	private String stand;
	
	public Game(int code, int price, int cuantity, String stand) {
		this.code = code;
		this.price = price;
		this.cuantity = cuantity;
		this.stand = stand;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCuantity() {
		return cuantity;
	}

	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}

	public String getStand() {
		return stand;
	}

	public void setStand(String stand) {
		this.stand = stand;
	}
}
