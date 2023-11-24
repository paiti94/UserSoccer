package com.human.springboot.PlayerInfoController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.springboot.util.NoResultsException;


@Service
public class PlayerInfoService {
	@Autowired
	private PlayerInfoDAO playerInfoDAO;
	
	public List<PlayerInfoDTO> getInfoList(String name){
		if(playerInfoDAO.InfoList(name) == null) {
			 throw new NoResultsException("No player info found for name: " + name);
		}
		return playerInfoDAO.InfoList(name);
	}
}
