package com.sol.dao;

import java.util.List;
import java.util.Optional;

import com.sol.model.Player;

public interface PlayerDAO {
	
	List<Player> getPlayers(int page, int resultsPerPage);
	List<Player> getPlayers();
	void insertPlayer(Player player);
	Optional<Player> getPlayerById(String id);
}
