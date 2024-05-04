package com.sol.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sol.dao.PlayerDAOImpl;
import com.sol.model.ErrorResponse;
import com.sol.model.Player;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired
	private PlayerDAOImpl playerDAOImpl;

	@GetMapping
	public ResponseEntity<?> getPlayers(@RequestParam(required = false) Integer results,
			@RequestParam(required = false) Integer page) {

		try {
			List<Player> players;
			
			// if pagination parameters are provided, use them
			if (results != null && page != null) {
				if (results <= 0 || page < 0) {
					return ResponseEntity.badRequest().body(new ErrorResponse("Invalid pagination parameters"));
				}
				players = playerDAOImpl.getPlayers(page, results);
			} else {
				// otherwise, retrieve all players without pagination
				players = playerDAOImpl.getPlayers();
			}
			return ResponseEntity.ok(players);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ErrorResponse("Error retrieving data"));
		}

	}

	@GetMapping("/{playerID}")
	public ResponseEntity<?> getPlayerById(@PathVariable String playerID) {
		
		if (playerID == null || playerID.trim().isEmpty()) {
	        return ResponseEntity.badRequest().body(new ErrorResponse("Player ID cannot be empty"));
	    }
		
		Optional<Player> player = playerDAOImpl.getPlayerById(playerID);
		if (!player.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("User Not Found"));
		}
		return ResponseEntity.ok(player.get());

	}

//	@PostMapping("/add")
//	public void addPlayer(@RequestBody Player player) {
//		playerDAOImpl.insertPlayer(player);
//
//	}
}
