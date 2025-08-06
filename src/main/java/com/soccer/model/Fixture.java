package com.soccer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FIXTURES")
public class Fixture {
	@Id
	@Column(name = "match_no")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long matchNo;

	@Column(name = "home_team")
	private String homeTeam;

	@Column(name = "away_team")
	private String awayTeam;
	
	@Column(name = "match_date")
	private String match_date;

	@Column(name = "match_time")
	private String match_time;

	@Column(name = "stadium")
	private String stadium;

	public long getMatchNo() {
		return matchNo;
	}

	public void setMatchNo(long matchNo) {
		this.matchNo = matchNo;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getMatch_date() {
		return match_date;
	}

	public void setMatch_date(String match_date) {
		this.match_date = match_date;
	}

	public String getMatch_time() {
		return match_time;
	}

	public void setMatch_time(String match_time) {
		this.match_time = match_time;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	
	
}
