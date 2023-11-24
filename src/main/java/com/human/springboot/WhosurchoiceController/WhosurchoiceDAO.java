package com.human.springboot.WhosurchoiceController;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WhosurchoiceDAO {
	
	List<WhosurchoiceDTO> showMatch();
	List<WhosurchoiceDTO> showMatchByRound(Integer round);
}
