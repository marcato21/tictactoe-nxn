package com.demo.game;

import com.demo.game.model.Board;
import com.demo.game.model.Game;
import com.demo.game.model.Player;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int size = 3;
		
		Player player1 = new Player("Levin");
		Player player2 = new Player("Maven Bot");
		
		Board board = new Board(size);
		
		
//		char[] ch = {' ', 'X', 'X'};
//		char c1 = ch[0];
//		String asd = String.valueOf(c1);
//		String str = String.valueOf(ch);
//		System.out.println(asd.trim().isEmpty());
		
		Game game = new Game(player1, player2, board);
		
		/* Horizontal Win */
//		try {
//			game.playerTurn(player1, 5);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//		
//		try {
//			game.playerTurn(player2, 6);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//		
//		try {
//			game.playerTurn(player1, 3);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//		
//		try {
//			game.playerTurn(player2, 7);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//		
//		try {
//			game.playerTurn(player1, 8);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//		
//		try {
//			game.playerTurn(player2, 4);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//		
//		try {
//			game.playerTurn(player1, 2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
		
		/* Vertical Win */
//		try {
//			game.playerTurn(player1, 5);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//
//		try {
//			game.playerTurn(player2, 3);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//
//		try {
//			game.playerTurn(player1, 9);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//
//		try {
//			game.playerTurn(player2, 1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//
//		try {
//			game.playerTurn(player1, 4);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
//
//		try {
//			game.playerTurn(player2, 2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		game.getBoard().printBoard();
		
		/* Diagonal Win */
		try {
			game.playerTurn(player1, 5);
		} catch (Exception e) {
			e.printStackTrace();
		}

		game.getBoard().printBoard();

		try {
			game.playerTurn(player2, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}

		game.getBoard().printBoard();

		try {
			game.playerTurn(player1, 9);
		} catch (Exception e) {
			e.printStackTrace();
		}

		game.getBoard().printBoard();

		try {
			game.playerTurn(player2, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		game.getBoard().printBoard();

		try {
			game.playerTurn(player1, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		game.getBoard().printBoard();
	}

}
