package com.human.springboot.WhatsmyteamController;

import java.util.List;

import org.springframework.stereotype.Service;

import com.human.springboot.util.NoResultsException;

@Service
public class MyteamService {
	private MyteamDAO myteamDAO;
	
	public List<MyteamDTO> showMyTeam(String teamFormation, String teamTactic){
		if(myteamDAO.showMyTeam(teamFormation, teamTactic) == null) {
			 throw new NoResultsException("No team info found for this informaiton: " + teamFormation + ", " + teamTactic);
		}
		return myteamDAO.showMyTeam(teamFormation, teamTactic);
	}
}
