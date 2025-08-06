package com.soccer.model;

//import java.sql.Date;
//import org.springframework.format.annotation.DateTimeFormat;

//import java.sql.Date;
//import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "PLAYERS") // creates a table of name PlayerTable in the database.
public class Player {

	@Id
	@Column(name = "player_id")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long playerId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nationality")
	private String nationality;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "jersey_number")
	private String jerseyNo;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "club_id")
	private String clubId;

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getJerseyNo() {
		return jerseyNo;
	}

	public void setJerseyNo(String jerseyNo) {
		this.jerseyNo = jerseyNo;
	}

//	public Date getBirthDate() {
//		return birthDate;
//	}
//
//	public void setBirthDate(Date birthDate) {
//		this.birthDate = birthDate;
//	}
	
}
