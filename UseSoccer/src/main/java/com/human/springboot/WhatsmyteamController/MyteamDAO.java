package com.human.springboot.WhatsmyteamController;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyteamDAO {
	ArrayList<MyteamDTO> showMyTeam(String formation, String tactics);
}
