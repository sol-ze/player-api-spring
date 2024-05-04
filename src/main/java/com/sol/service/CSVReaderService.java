package com.sol.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.sol.Utils.DateUtils;
import com.sol.dao.PlayerDAO;
import com.sol.model.Player;
import jakarta.annotation.PostConstruct;

@Service
public class CSVReaderService {

	private final PlayerDAO playerDAO;

	@Autowired
	public CSVReaderService(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}

	public void readCSV(String path) {
		Reader reader = null;
		CSVParser csvParser = null;
		try {
			InputStream is = new ClassPathResource(path).getInputStream();
			reader = new InputStreamReader(is, StandardCharsets.UTF_8);

			CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().setIgnoreHeaderCase(true).setTrim(true).build();

			csvParser = new CSVParser(reader, format);

			for (CSVRecord record : csvParser) {
			

				Player player = new Player();

				player.setPlayerId(record.get("playerID"));
				player.setFirstName(record.get("nameFirst"));
				player.setLastName(record.get("nameLast"));
				player.setGivenName(record.get("nameGiven"));
				
				String weight = record.get("weight");
				String height = record.get("height");
				if(!weight.isEmpty())
					player.setWeight(Integer.parseInt(weight));
				if(!height.isEmpty())
				player.setHeight(Integer.parseInt(height));

				String year = record.get("birthYear");
				String birthMonth = record.get("birthMonth");
				String birthDay = record.get("birthDay");

				if (!year.isEmpty() && !birthMonth.isEmpty() && !birthDay.isEmpty()) {
					Date birthDate = DateUtils.buildSQLDate(Integer.parseInt(year), Integer.parseInt(birthMonth),
							Integer.parseInt(birthDay));
					player.setBirthDate(birthDate.toString());
				}

				String deathYear = record.get("deathYear");
				String deathMonth = record.get("deathMonth");
				String deathDay = record.get("deathDay");

				if (!deathYear.isEmpty() && !deathMonth.isEmpty() && !deathDay.isEmpty()) {
					Date deathDate = DateUtils.buildSQLDate(Integer.parseInt(deathYear), Integer.parseInt(deathMonth),
							Integer.parseInt(deathDay));
					player.setDeathDate(deathDate.toString());
				}

				player.setBirthCountry(record.get("birthCountry"));
				player.setBirthState(record.get("birthState"));
				player.setBirthCity(record.get("birthCity"));
				
				player.setDeathCountry(record.get("deathCountry"));
				player.setDeathState(record.get("deathState"));
				player.setDeathCity(record.get("deathCity"));
				
				player.setBats(record.get("bats"));
				player.setThrows_(record.get("throws"));
				
				player.setDebut(record.get("debut"));
				player.setFinalGame(record.get("finalGame"));
				
				player.setRetroId(record.get("retroID"));
				player.setBbrefId(record.get("bbrefID"));

				playerDAO.insertPlayer(player);				
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvParser.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
