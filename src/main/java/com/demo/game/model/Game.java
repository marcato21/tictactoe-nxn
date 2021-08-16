package com.demo.game.model;

public class Game {
	
	private enum Symbol {
		x,
		o
	}
	
	private Player player1;
	private Player player2;
	private Board board;
	
	public Game(Player player1, Player player2, Board board) {
		player1.setSymbol(Symbol.x.toString());
		player1.setTurn(true);
		player2.setSymbol(Symbol.o.toString());
		this.player1 = player1;
		this.player2 = player2;
		this.board = board;
	}
	
	public void playerTurn(Player player, Integer boardNumber) throws Exception {
		Integer size = board.getSize();
		Integer row = (boardNumber - 1) / size;
		Integer column = (boardNumber - 1) % size;
		char field = board.getBoard()[row][column];

		if (String.valueOf(field).trim().isEmpty()) {
			field = player.getSymbol().charAt(0);
			board.getBoard()[row][column] = field;
//			player.changeTurn();
		} else {
			throw new Exception("Field is already used! Please select another place");
		}
		checkWinnerHorizontal();
		checkWinnerVertical();
		checkWinnerDiagonal();
	}
	
//	public void checkWinner() {
//		char[][] board = this.board.getBoard();
//		String message = "No winner";
//		for(int i = 0; i < board.length; i++) {
//			for(int j = 0; j < board[i].length; j++) {
//				if(board[i][j] != null) {
//					if(board[i][j].equals(Symbol.x.toString().charAt(0))) {
//						
//					} else if(board[i][j].equals(Symbol.o.toString().charAt(0))) {
//						
//					} else {
//						
//					}
//				} else {
//					
//				}
//
//			}
//		}
//		
//		
//	}
	
	public void checkWinnerHorizontal() {
		char[][] board = this.board.getBoard();
		char[] ch = new char[board.length];
		
		String p1Win = new String(new char[board.length]).replace("\0", Symbol.x.toString());
		String p2Win = new String(new char[board.length]).replace("\0", Symbol.o.toString());
		String message = "No winner";
		
		int i = 0;
		int j = 0;
		
		while(i < board.length && !String.valueOf(ch).equals(p1Win) && !String.valueOf(ch).equals(p2Win)) {
			ch = new char[board.length];
			for(j = 0; j < board[i].length; j++) {
				if(!String.valueOf(board[i][j]).trim().isEmpty()) {
					if(String.valueOf(board[i][j]).equals(Symbol.x.toString())) {
						ch[j] = board[i][j];
					} else if(String.valueOf(board[i][j]).equals(Symbol.o.toString())) {
						ch[j] = board[i][j];
					}
				} else {
					ch[j] = ' ';
				}
			}
			i++;
		}
		
		if(String.valueOf(ch).equals(p1Win)) {
			message = "Player 1 Wins!";
			System.out.println(message);
		} else if (String.valueOf(ch).equals(p2Win)) {
			message = "Player 2 Wins!";
			System.out.println(message);
		} else {
			System.out.println(message);
		}
	}
	
	public void checkWinnerVertical() {
		char[][] board = this.board.getBoard();
		char[] ch = new char[board.length];
		
		String p1Win = new String(new char[board.length]).replace("\0", Symbol.x.toString());
		String p2Win = new String(new char[board.length]).replace("\0", Symbol.o.toString());
		String message = "No winner";
		
		int i = 0;
		int j = 0;
		
		while(j < board.length && !String.valueOf(ch).equals(p1Win) && !String.valueOf(ch).equals(p2Win)) {
			ch = new char[board.length];
			for(i = 0; i < board[j].length; i++) {
				if(!String.valueOf(board[i][j]).trim().isEmpty()) {
					if(String.valueOf(board[i][j]).equals(Symbol.x.toString())) {
						ch[i] = board[i][j];
					} else if(String.valueOf(board[i][j]).equals(Symbol.o.toString())) {
						ch[i] = board[i][j];
					}
				} else {
					ch[i] = ' ';
				}
			}
			j++;
		}
		
		if(String.valueOf(ch).equals(p1Win)) {
			message = "Player 1 Wins!";
			System.out.println(message);
		} else if (String.valueOf(ch).equals(p2Win)) {
			message = "Player 2 Wins!";
			System.out.println(message);
		} else {
			System.out.println(message);
		}
	}
	
	public void checkWinnerDiagonal() {
		char[][] board = this.board.getBoard();
		char[] ch = new char[board.length];
		
		String p1Win = new String(new char[board.length]).replace("\0", Symbol.x.toString());
		String p2Win = new String(new char[board.length]).replace("\0", Symbol.o.toString());
		String message = "No winner";
		
		int i = 0;
		int j = 0;
		
		while(i < board.length && j < board.length && !String.valueOf(ch).equals(p1Win) && !String.valueOf(ch).equals(p2Win)) {
			ch = new char[board.length];
//			for(i = 0; i < board[j].length; i++) {
			if(!String.valueOf(board[i][j]).trim().isEmpty()) {
				if(String.valueOf(board[i][j]).equals(Symbol.x.toString())) {
					ch[i] = board[i][j];
				} else if(String.valueOf(board[i][j]).equals(Symbol.o.toString())) {
					ch[i] = board[i][j];
				}
			} else {
				ch[i] = ' ';
			}
//			}
			i++;
			j++;
			System.out.println(String.valueOf(ch));
		}
		
		if(String.valueOf(ch).equals(p1Win)) {
			message = "Player 1 Wins!";
			System.out.println(message);
		} else if (String.valueOf(ch).equals(p2Win)) {
			message = "Player 2 Wins!";
			System.out.println(message);
		} else {
			System.out.println(message);
		}
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Board getBoard() {
		return board;
	}
}
