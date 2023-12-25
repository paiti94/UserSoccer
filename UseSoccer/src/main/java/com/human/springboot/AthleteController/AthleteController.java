package com.human.springboot.AthleteController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class AthleteController {
	
	@Autowired
	private AthleteService athleteService;
	
	@GetMapping("/athlete/{name}")
	public String getPlayer(@PathVariable String name) {
		Gson gson = new Gson();
    	if(athleteService.getPlayer(name) != null) {
    		return gson.toJson(athleteService.getPlayer(name));
    	}else {
    		return gson.toJson("error");
    				
    	}
	}
	@GetMapping("/athleteall")
	public String getPlayerAll() {
		Gson gson = new Gson();
    	if(athleteService.getPlayers() != null) {
    		return gson.toJson(athleteService.getPlayers());
    	}else {
    		return gson.toJson("error");
    				
    	}
	}
	@GetMapping("/athleteallbypage")
	public String getPlayerAllByPage(@RequestParam(defaultValue = "1") int page,
		    @RequestParam(defaultValue = "10") int itemsPerPage) {
		Gson gson = new Gson();
//    	if(athleteService.getPlayers() != null) {
//    		return gson.toJson(athleteService.getPlayers());
//    	}else {
//    		return gson.toJson("error");
//    				
//    	}
		 List<AthleteDTO> players = athleteService.getPlayers();

		    if (players != null) {
		        // Implement pagination logic here based on the provided page and itemsPerPage
		        int startIndex = (page - 1) * itemsPerPage;
		        int endIndex = Math.min(startIndex + itemsPerPage, players.size());

		        List<AthleteDTO> paginatedPlayers = players.subList(startIndex, endIndex);

		        return gson.toJson(paginatedPlayers);
		    } else {
		        return gson.toJson("error");
		    }
	}
	
	@GetMapping("/athlete/match/{round}")
	public String getPlayerByMatch(@PathVariable Integer round) {
		Gson gson = new Gson();
    	if(athleteService.getPlayersForMatch(round) != null) {
    		return gson.toJson(athleteService.getPlayersForMatch(round));
    	}else {
    		return gson.toJson("error");
    				
    	}
	}
}
