package com.human.springboot.MainController;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainDAO{
	List<MainDTO> playerList(String name);
	List<MainDTO> playerListAll();
}

