package com.demo.game.model;

public class Board {
	
	private char[][] board;
	private Integer size;
	
	public Board(Integer size) {
		this.size = size;
		char[][] board = new char[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				char fieldInfo = ' ';
				board[i][j] = fieldInfo;
			}
		}
		this.board = board;
	}
	
	public Board() {
		super();
	}

	//	Print Board function
	public String printBoard() {
		Integer field = 1;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(String.valueOf(board[i][j]).trim().isEmpty()) {
					sb.append(field.toString());
					System.out.print(field.toString());
				} else {
					sb.append(board[i][j]);
					System.out.print(board[i][j]);
				}
				sb.append(" | ");
				System.out.print(" | ");
				field++;
			}
			sb.append("\n");
			System.out.println();
			sb.append("---------- \n");
			System.out.println("----------");
		}
		System.out.println();
		
		return sb.toString();
	}

	//	Getter
	public char[][] getBoard() {
		return board;
	}

	public Integer getSize() {
		return size;
	}
}
