package com.human.springboot.WhosurchoiceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.springboot.util.NoResultsException;

@Service
public class WhosurchoiceService {
	
	@Autowired
	private WhosurchoiceDAO whosurchoiceDAO;
	
	public List<WhosurchoiceDTO> showMatch(){
		if(whosurchoiceDAO.showMatch() == null) {
			 throw new NoResultsException("No data for choice game");
		}
		return whosurchoiceDAO.showMatch();
	}
	
	public List<WhosurchoiceDTO> showMatchByRound(Integer round){
		if(whosurchoiceDAO.showMatchByRound(round) == null) {
			 throw new NoResultsException("No data for choice game for the round, "+ round );
		}
		return whosurchoiceDAO.showMatchByRound(round);
	}
}
