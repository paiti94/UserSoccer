package com.human.springboot.AthleteController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.springboot.util.NoResultsException;

@Service
public class AthleteService {
	
	@Autowired
	private AthleteDAO athleteDAO;
	
	public List<AthleteDTO> getPlayer(String name){
		if(athleteDAO.playerList(name) == null) {
			 throw new NoResultsException("No player info found for name: " + name);
		}
		return athleteDAO.playerList(name);
	}
	
	public List<AthleteDTO> getPlayers(){
		return athleteDAO.playerListAll();
	}
	
	public List<AthleteDTO> getPlayersForMatch(Integer round){
		return athleteDAO.playerListForMatch(round);
	}
	
	public void insertPlayer(AthleteDTO player) {
		athleteDAO.insertPlayer(player);
	}
	
	public void deletePlayer() {
		athleteDAO.deleteAll();
	}
}


