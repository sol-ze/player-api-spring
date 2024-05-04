package com.sol.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sol.model.Player;

public class PlayerRowMapper implements RowMapper<Player>{

	@Override
	public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Player player = new Player();
		player.setPlayerId(rs.getString("id"));
		player.setFirstName(rs.getString("first_name"));
		player.setLastName(rs.getString("last_name"));
		player.setGivenName(rs.getString("given_name"));
		
		player.setWeight(rs.getInt("weight"));
		player.setHeight(rs.getInt("height"));
				
		player.setBirthDate(rs.getString("birth_date"));
		player.setDeathDate(rs.getString("death_date"));
		
		
		player.setBirthCountry(rs.getString("birth_country"));
		player.setBirthState(rs.getString("birth_state"));
		player.setBirthCity(rs.getString("birth_city"));
		
		player.setDeathCountry(rs.getString("death_country"));
		player.setDeathState(rs.getString("death_state"));
		player.setDeathCity(rs.getString("death_city"));
		
		player.setBats(rs.getString("bats"));
		player.setThrows_(rs.getString("throws"));
		
		player.setDebut(rs.getString("debut"));
		player.setFinalGame(rs.getString("final_game"));
		player.setRetroId(rs.getString("retro_id"));
		player.setBbrefId(rs.getString("bbref_id"));
		
		return player;
		
	}
	
	

}
