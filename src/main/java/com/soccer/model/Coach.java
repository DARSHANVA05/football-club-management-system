package com.soccer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "COACHES")
public class Coach {

	@Id
	@Column(name = "coach_id")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long coachId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nationality")
	private String nationality;

	@Column(name = "team_name")
	private String teamName;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "club_id")
	private String clubId;

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public long getCoachId() {
		return coachId;
	}

	public void setCoachId(long coachId) {
		this.coachId = coachId;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Coach [coachId=" + coachId + ", firstName=" + firstName + ", lastName=" + lastName + ", nationality="
				+ nationality + ", teamName=" + teamName + ", designation=" + designation + ", clubId=" + clubId + "]";
	}
	
	
}
