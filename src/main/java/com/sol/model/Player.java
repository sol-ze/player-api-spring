package com.sol.model;

public class Player {
	private String playerId;
	private String firstName;
	private String lastName;
	private String givenName;
	private int weight;
	private int height;
	private String birthdate;
	private String deathDate;
	private String birthCountry;
	private String birthState;
	private String birthCity;
	private String deathCountry;
	private String deathState;
	private String deathCity;
	private String bats;
	private String throws_;
	private String debut;
	private String finalGame;
	private String retroId;
	private String bbrefId;
	
	public Player() {
		
	}
	
	
	public Player(String playerId, String firstName, String lastName, String givenName, int weight, int height,
			String birthdate, String deathDate, String birthCountry, String birthState, String birthCity,
			String deathCountry, String deathState, String deathCity, String bats, String throws_,
			String debut, String finalGame, String retroId, String bbrefId) {
		super();
		this.playerId = playerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.givenName = givenName;
		this.weight = weight;
		this.height = height;
		this.birthdate = birthdate;
		this.deathDate = deathDate;
		this.birthCountry = birthCountry;
		this.birthState = birthState;
		this.birthCity = birthCity;
		this.deathCountry = deathCountry;
		this.deathState = deathState;
		this.deathCity = deathCity;
		this.bats = bats;
		this.throws_ = throws_;
		this.debut = debut;
		this.finalGame = finalGame;
		this.retroId = retroId;
		this.bbrefId = bbrefId;
	}


	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;;
	}


	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getGivenName() {
		return givenName;
	}



	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}



	public int getWeight() {
		return weight;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public String getBirthdate() {
		return birthdate;
	}



	public void setBirthDate(String birthdate) {
		this.birthdate = birthdate;
	}



	public String getDeathDate() {
		return deathDate;
	}



	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}



	public String getBirthCountry() {
		return birthCountry;
	}



	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}



	public String getBirthState() {
		return birthState;
	}



	public void setBirthState(String birthState) {
		this.birthState = birthState;
	}



	public String getBirthCity() {
		return birthCity;
	}



	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}



	public String getDeathCountry() {
		return deathCountry;
	}



	public void setDeathCountry(String deathCountry) {
		this.deathCountry = deathCountry;
	}



	public String getDeathState() {
		return deathState;
	}



	public void setDeathState(String deathState) {
		this.deathState = deathState;
	}



	public String getDeathCity() {
		return deathCity;
	}



	public void setDeathCity(String deathCity) {
		this.deathCity = deathCity;
	}



	public String getBats() {
		return bats;
	}



	public void setBats(String bats) {
		this.bats = bats;
	}



	public String getThrows_() {
		return throws_;
	}



	public void setThrows_(String throws_) {
		this.throws_ = throws_;
	}



	public String getDebut() {
		if(debut.isBlank())
			return null;
		return debut;
	}



	public void setDebut(String debut) {
		this.debut = debut;
	}



	public String getFinalGame() {
		if(finalGame.isBlank())
			return null;
		return finalGame;
	}



	public void setFinalGame(String finalGame) {
		this.finalGame = finalGame;
	}



	public String getRetroId() {
		return retroId;
	}



	public void setRetroId(String retroId) {
		this.retroId = retroId;
	}



	public String getBbrefId() {
		return bbrefId;
	}



	public void setBbrefId(String bbrefId) {
		this.bbrefId = bbrefId;
	}


	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName + ", givenName="
				+ givenName + ", weight=" + weight + ", height=" + height + ", birthdate=" + birthdate + ", deathDate="
				+ deathDate + ", birthCountry=" + birthCountry + ", birthState=" + birthState + ", birthCity="
				+ birthCity + ", deathCountry=" + deathCountry + ", deathState=" + deathState + ", deathCity="
				+ deathCity + ", bats=" + bats + ", throws_=" + throws_ + ", debut=" + debut + ", finalGame="
				+ finalGame + ", retroId=" + retroId + ", bbrefId=" + bbrefId + "]";
	}


//	public enum Handedness {
//	    RIGHT('R'), LEFT('L');
//
//	    private final char code;
//
//	    Handedness(char code) {
//	        this.code = code;
//	    }
//
//	    public char getCode() {
//	        return code;
//	    }
//	}
}


