package com.human.springboot.AthleteController;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AthleteDAO {
	List<AthleteDTO> playerListAll();
	List<AthleteDTO> playerList(String name);
	List<AthleteDTO> playerListForMatch(Integer round);
	void insertPlayer(AthleteDTO player);
	void updatePlayer(AthleteDTO player);
	void deletePlayer(Integer id);
	void deleteAll();
	void refreshAll();
}
