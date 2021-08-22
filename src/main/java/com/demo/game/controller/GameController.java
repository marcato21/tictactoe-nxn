package com.demo.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.game.model.Game;
import com.demo.game.service.GameService;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@Controller
@RestController
@RequestMapping({ "/api/test" })
public class GameController {
	
	@Autowired
	private GameService gameService;

	//	Create New Game
	@PostMapping(value = "/game/new")
	public ResponseEntity<?> newGame(int size, String player1, String player2) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(gameService.newGame(size, player1, player2));
	}

	//	Print Game Board
	@PostMapping(value = "/game/print")
	public ResponseEntity<?> printBoard(@RequestBody Game game) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(gameService.printBoard(game));
	}
	
	//	Execute player turn
	@PostMapping(value = "/game/player/turn")
	public ResponseEntity<?> playerTurn(@RequestBody Game game, String playerName, int boardNumber) throws Exception {
		try {
			return ResponseEntity.ok(gameService.playerTurn(game, playerName, boardNumber));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}
	}
}
