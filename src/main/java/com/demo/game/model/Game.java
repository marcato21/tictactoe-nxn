package com.demo.game.model;

public class Game {
	
	//	Player Symbol
	private enum Symbol {
		x,
		o
	}
	
	private Player player1;
	private Player player2;
	private Board board;
	
	public Game() {
		super();
	}

	public Game(Player player1, Player player2, Board board) {
		player1.setSymbol(Symbol.x.toString());
		player1.setTurn(true);
		player2.setSymbol(Symbol.o.toString());
		this.player1 = player1;
		this.player2 = player2;
		this.board = board;
	}
	
	//	Player Turn & place symbol
	public String playerTurn(Player player, Integer boardNumber) throws Exception {
		try {
			if (checkBoardFull()) {
				throw new Exception("Game Ended, Board already full!");
			}
			
			Integer size = board.getSize();
			Integer row = (boardNumber - 1) / size;
			Integer column = (boardNumber - 1) % size;
			char field = board.getBoard()[row][column];

			if (String.valueOf(field).trim().isEmpty()) {
				field = player.getSymbol().charAt(0);
				board.getBoard()[row][column] = field;
				player1.changeTurn();
				player2.changeTurn();
			} else {
				throw new Exception("Field is already used! Please select another place");
			}
			
			if (checkWinnerHorizontal() || checkWinnerVertical() ||	checkWinnerDiagonal()) {
				return player.getUsername();
			} else {
				return "Turn Ended, No winner";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Turn Ended, No winner";
		}

	}
	
	//	Check if winner is in horizontal pattern
	private Boolean checkWinnerHorizontal() {
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
			return true;
		} else if (String.valueOf(ch).equals(p2Win)) {
			message = "Player 2 Wins!";
			System.out.println(message);
			return true;
		} else {
			System.out.println(message);
			return false;
		}
	}
	
	//	Check if winner in vertical pattern
	private Boolean checkWinnerVertical() {
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
			return true;
		} else if (String.valueOf(ch).equals(p2Win)) {
			message = "Player 2 Wins!";
			System.out.println(message);
			return true;
		} else {
			System.out.println(message);
			return false;
		}
	}
	
	//	Check if winner in diagonal pattern
	private Boolean checkWinnerDiagonal() {
		char[][] board = this.board.getBoard();
		char[] chLeft = new char[board.length];
		char[] chRight = new char[board.length];
		
		String p1Win = new String(new char[board.length]).replace("\0", Symbol.x.toString());
		String p2Win = new String(new char[board.length]).replace("\0", Symbol.o.toString());
		String message = "No winner";
		
		int i = 0;
		int j = 0;
		
		while (i < board.length && j < board.length && !String.valueOf(chLeft).equals(p1Win)
				&& !String.valueOf(chLeft).equals(p2Win) && !String.valueOf(chRight).equals(p1Win)
				&& !String.valueOf(chRight).equals(p2Win)) {
			chLeft = new char[board.length];
			chRight = new char[board.length];
			for(i = 0, j = 0; i < board.length && j < board.length; i++, j++) {
				if(!String.valueOf(board[i][j]).trim().isEmpty()) {
					if(String.valueOf(board[i][j]).equals(Symbol.x.toString())) {
						chLeft[i] = board[i][j];
					} else if(String.valueOf(board[board.length - i - 1][j]).equals(Symbol.x.toString())) {
						chRight[i] = board[board.length - i - 1][j];
					} else if(String.valueOf(board[i][j]).equals(Symbol.o.toString())) {
						chLeft[i] = board[i][j];
					} else if(String.valueOf(board[board.length - i - 1][j]).equals(Symbol.o.toString())) {
						chRight[i] = board[board.length - i - 1][j];
					}
				} else {
					chLeft[i] = ' ';
					chRight[i] = ' ';
				}
			}
		}
		
		if (String.valueOf(chLeft).equals(p1Win) || String.valueOf(chRight).equals(p1Win)) {
			message = "Player 1 Wins!";
			System.out.println(message);
			return true;
		} else if (String.valueOf(chLeft).equals(p2Win) || String.valueOf(chRight).equals(p2Win)) {
			message = "Player 2 Wins!";
			System.out.println(message);
			return true;
		} else {
			System.out.println(message);
			return false;
		}
	}
	
	//	Check if board already full
	private Boolean checkBoardFull() {
		char[][] board = this.board.getBoard();
		int countEmpty = 0;

		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if (String.valueOf(board[i][j]).trim().isEmpty()) {
					countEmpty++;
				}
			}
		}
		
		if(countEmpty > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	//	Getter
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
