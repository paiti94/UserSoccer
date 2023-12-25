package com.human.springboot.TeamsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class TeamsController {
	@Autowired
	private TeamsService teamsService;
	
	@GetMapping("/teams")
	public String getTeams() {
		Gson gson = new Gson();
		if(teamsService.getTeams() != null) {
			return gson.toJson(teamsService.getTeams());
		}else {
			return gson.toJson("error");
		}
	}
	
	@GetMapping("/teams/{name}")
	public String getTeamByName(@PathVariable String name) {
		Gson gson = new Gson();
		if(teamsService.getTeam(name) != null) {
			return gson.toJson(teamsService.getTeam(name));
		}else {
			return gson.toJson("error");
		}
	}
}
