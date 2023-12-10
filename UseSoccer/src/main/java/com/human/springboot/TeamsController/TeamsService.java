package com.human.springboot.TeamsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.human.springboot.util.NoResultsException;

@Service
public class TeamsService {
	
	@Autowired
	private TeamsDAO teamsDAO;
	
	public List<TeamsDTO> getTeam(String name){
		if(teamsDAO.teamList(name) == null) {
			 throw new NoResultsException("No team info found for name: " + name);
		}
		return teamsDAO.teamList(name);
	}
	
	public List<TeamsDTO> getTeams(){
		return teamsDAO.teamListAll();
	}
	
	public void insertTeams(TeamsDTO team) {
		teamsDAO.insertTeam(team);;
	}
	
	public void deleteTeams() {
		teamsDAO.deleteAll();
	}
}
