package com.demo.game.model;

public class GameStatus {
	
	private Game game;
	private String status;
	
	public GameStatus(Game game, String status) {
		super();
		this.game = game;
		this.status = status;
	}
	
	public GameStatus() {
		super();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
