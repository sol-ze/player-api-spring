package com.sol.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import com.sol.model.Player;
import com.sol.rowmapper.PlayerRowMapper;

public class PlayerDAOImpl implements PlayerDAO {

	private JdbcTemplate jdbcTemplate;

	public PlayerDAOImpl(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public List<Player> getPlayers() {
		String sql = "SELECT * FROM `player`";
		List<Player> players = jdbcTemplate.query(sql, new PlayerRowMapper());
		return players;

	}

	@Override
	public List<Player> getPlayers(int page, int resultsPerPage) {
		String sql = "SELECT * FROM `player` LIMIT ? OFFSET ?";

		int offset = page * resultsPerPage;

		List<Player> players = jdbcTemplate.query(sql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, resultsPerPage);
				ps.setInt(2, offset);
			}
		}, new PlayerRowMapper());

		return players;

	}

	@Override
	public void insertPlayer(Player player) {

		Object[] playerInfo = { player.getPlayerId(), player.getFirstName(), player.getLastName(),
				player.getGivenName(), player.getWeight(), player.getHeight(), player.getBirthdate(),
				player.getDeathDate(), player.getBirthCountry(), player.getBirthState(), player.getBirthCity(),
				player.getDeathCountry(), player.getDeathState(), player.getDeathCity(), player.getBats(),
				player.getThrows_(), player.getDebut(), player.getFinalGame(), player.getRetroId(),
				player.getBbrefId() };

		String sql = "INSERT IGNORE INTO `player_api`.`player` (`id`, `first_name`, `last_name`, `given_name`, `weight`, `height`, `birth_date`, `death_date`, "
				+ "`birth_country`, `birth_state`, `birth_city`, `death_country`, `death_state`, `death_city`, `bats`, `throws`, `debut`, `final_game`, "
				+ "`retro_id`, `bbref_id`) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, playerInfo);
	}

	@Override
	public Optional<Player> getPlayerById(String id) {
		String sql = "SELECT * FROM `player` WHERE id = ?";
		try {

			Player player = jdbcTemplate.query(sql, new PreparedStatementSetter() {
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, id);
				}
			}, new PlayerRowMapper()).get(0);

			return Optional.of(player);
		} catch (Exception e) {
			return Optional.empty();
		}

	}

}
