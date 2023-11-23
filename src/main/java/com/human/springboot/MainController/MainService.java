package com.human.springboot.MainController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.springboot.util.NoResultsException;

@Service
public class MainService {
	
	@Autowired
	private MainDAO mainDAO;
	
	public List<MainDTO> getPlayerListAll() {
		if(mainDAO.playerListAll() == null) {
			 throw new NoResultsException("No player list found");
		}
		return mainDAO.playerListAll();
	}
	
	public List<MainDTO> getPlayerList(String name){
		if(mainDAO.playerList(name) == null) {
			 throw new NoResultsException("No player found for name: " + name);
		}
		return mainDAO.playerList(name);
	}
}
