package com.human.springboot.WhatsmyteamController;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class WhatsmyteamController {
	
	@Autowired
    private MyteamDAO myteamdao;
	
	@Autowired
	private MyteamService myteamService;

    @GetMapping("/showmyteams/{formation}/{tactics}")
    @ResponseBody
    public String showMyTeam(@PathVariable String formation, @PathVariable String tactics) {
        Gson gson = new Gson();
    	if(myteamService.showMyTeam(formation,tactics) != null) {
    		return gson.toJson(myteamService.showMyTeam(formation,tactics));
    	}else {
    		return gson.toJson("error");
    				
    	}
    }

}
