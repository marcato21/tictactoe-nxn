package com.demo.game.model;

public class Player {
	
	private String username;
	private String symbol;
	private Boolean turn;
	
	public Player(String username) {
		this.username = username;
		this.turn = false;
	}
	
	public void changeTurn() {
		if(turn) {
			turn = false;
		} else {
			turn = true;
		}
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Boolean getTurn() {
		return turn;
	}

	public void setTurn(Boolean turn) {
		this.turn = turn;
	}
}
