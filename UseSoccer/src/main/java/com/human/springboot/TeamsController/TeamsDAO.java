package com.human.springboot.TeamsController;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TeamsDAO {
	List<TeamsDTO> teamListAll();
	List<TeamsDTO> teamList(String name);
	
	void insertTeam(TeamsDTO team);
	void updateTeam(TeamsDTO team);
	void deleteTeam(int id);
	void deleteAll();
	void refreshAll();
}
