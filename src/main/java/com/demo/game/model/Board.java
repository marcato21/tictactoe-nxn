package com.demo.game.model;

public class Board {
	
	private char[][] board;
	private Integer size;
	
	public Board(Integer size) {
		this.size = size;
		char[][] board = new char[size][size];
		for(int i = 0; i < size; i++) {
//			String[] row = new String[size];
			for(int j = 0; j < size; j++) {
				char fieldInfo = ' ';
				board[i][j] = fieldInfo;
			}
		}
		this.board = board;
	}
	
	public void printBoard() {
		Integer field = 1;
		
//		for (ArrayList<String> arrayList : boardSize) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
//			for (String string : arrayList) {
				if(String.valueOf(board[i][j]).trim().isEmpty()) {
					System.out.print(field.toString());
				} else {
					System.out.print(board[i][j]);
				}
				System.out.print(" | ");
				field++;
			}
			System.out.println();
			System.out.println("----------");
		}
		System.out.println();
	}

	public char[][] getBoard() {
		return board;
	}

	public Integer getSize() {
		return size;
	}
}
