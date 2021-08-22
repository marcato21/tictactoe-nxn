package com.demo.game.service;

import org.springframework.stereotype.Service;

import com.demo.game.model.Board;
import com.demo.game.model.Game;
import com.demo.game.model.GameStatus;
import com.demo.game.model.Player;

@Service
public class GameService {
	
	private void valPlayerExist(Game game, String playerName) throws Exception {
		//	Validate if input not empty string
		if(playerName == null || playerName.trim().isEmpty()) {
			throw new Exception("Input player is empty, please select player");
		}
		
		Player player1 = game.getPlayer1();
		Player player2 = game.getPlayer2();
		
		//	Validate player's existence
		if(!player1.getUsername().equals(playerName) && !player2.getUsername().equals(playerName)) {
			throw new Exception("Player does not exist in this game!");
		}
	}
	
	private void valPlayerTurn(Game game, String playerName) throws Exception {
		Player player1 = game.getPlayer1();
		Player player2 = game.getPlayer2();
		
		//	Validate if it is player1's or player2's turn
		if(player1.getUsername().equals(playerName)) {
			if(!player1.getTurn()) {
				throw new Exception("Illegal player turn, it is " + player2.getUsername() + "'s turn");
			}
		} else if (player2.getUsername().equals(playerName)) {
			if(!player2.getTurn()) {
				throw new Exception("Illegal player turn, it is " + player1.getUsername() + "'s turn");
			}
		}
	}
	
	public Game newGame(int boardSize, String p1Name, String p2Name) throws Exception {
		// Create new player
		Player player1 = new Player(p1Name);
		Player player2 = new Player(p2Name);
		
		// Create Board
		Board board = new Board(boardSize);
		
		// Return created Game
		return new Game(player1, player2, board);
	}
	
	public GameStatus playerTurn(Game game, String playerName, int coordinates) throws Exception {
		//	Validate player
		valPlayerExist(game, playerName);
		valPlayerTurn(game, playerName);
		Player player1 = game.getPlayer1();
		Player player2 = game.getPlayer2();
		
		GameStatus gameStatus = new GameStatus();
		gameStatus.setGame(game);
		
		//	Run player turn function
		try {
			if(player1.getTurn()) {
				gameStatus.setStatus(game.playerTurn(player1, coordinates)); 
			} else if(player2.getTurn()) {
				gameStatus.setStatus(game.playerTurn(player2, coordinates));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gameStatus;
	}
	
	//	Print Board
	public String printBoard(Game game) {
		return game.getBoard().printBoard();
	}

}
