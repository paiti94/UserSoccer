package com.human.springboot.AthleteController;

public class AthleteDTO {

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public String getTeam() {
			return team;
		}
		public void setTeam(String team) {
			this.team = team;
		}
		public int getTeamId() {
			return teamId;
		}
		public void setTeamId(int teamId) {
			this.teamId = teamId;
		}
		int id;
		String name;
		String position;
		String dateOfBirth;
		String nationality;
		String team;
		int teamId;
		
	}
