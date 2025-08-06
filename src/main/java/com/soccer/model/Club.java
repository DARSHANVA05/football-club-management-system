package com.soccer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLUB")
public class Club {
	
	@Id
	@Column(name = "club_id")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long clubId;

	@Column(name = "club_name")
	private String clubName;

	@Column(name = "country")
	private String country;
	
	@Column(name = "stadium")
	private String stadium;

	public long getClubId() {
		return clubId;
	}

	public void setClubId(long clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	

}
