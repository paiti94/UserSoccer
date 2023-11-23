package com.human.springboot.WhatsmyteamController;


public class MyteamDTO {
	// for showMyTeam
	public int getTeamseq() {
		return teamseq;
	}
	public void setTeamseq(int teamseq) {
		this.teamseq = teamseq;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_tactics() {
		return team_tactics;
	}
	public void setTeam_tactics(String team_tactics) {
		this.team_tactics = team_tactics;
	}
	public String getTeam_formation() {
		return team_formation;
	}
	public void setTeam_formation(String team_formation) {
		this.team_formation = team_formation;
	}
	public String getAmblem_logo() {
		return amblem_logo;
	}
	public void setAmblem_logo(String amblem_logo) {
		this.amblem_logo = amblem_logo;
	}
	public String getTeam_uniform() {
		return team_uniform;
	}
	public void setTeam_uniform(String team_uniform) {
		this.team_uniform = team_uniform;
	}
	public String getLeague_logo() {
		return league_logo;
	}
	public void setLeague_logo(String league_logo) {
		this.league_logo = league_logo;
	}
	int teamseq;
	String team_name;
	String team_tactics;
	String team_formation;
	String amblem_logo;
	String team_uniform;
	String league_logo;
	
	//
}
