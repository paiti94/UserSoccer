package com.human.springboot.PlayerInfoController;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.human.springboot.MainController.MainDTO;

@Mapper
public interface PlayerInfoDAO {
	List<PlayerInfoDTO> InfoList(String name);
}
