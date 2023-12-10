package com.human.springboot.util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.human.springboot.AthleteController.AthleteDTO;
import com.human.springboot.AthleteController.AthleteService;
import com.human.springboot.TeamsController.TeamsDTO;
import com.human.springboot.TeamsController.TeamsService;

import jakarta.annotation.PostConstruct;


@Component
public class generateDataFromAPI {
	
	private List<String> teamNames = new ArrayList<>();
	
	private  List<Map<String,String>> teams = new ArrayList<>();
	
	private List<TeamsDTO> teamsByLg = new ArrayList<>();
	
	private List<AthleteDTO>playerList = new ArrayList<>();
	
	@Autowired
	private TeamsService teamsService;
	
	@Autowired
	private AthleteService playerService;
	
	//@PostConstruct
	public void init() throws Exception{
		getTeamsbyLeague("PL");
		//updateDB();
	}


	@SuppressWarnings("unchecked")
	public void getTeamsbyLeague(String league) {
		String url = "http://api.football-data.org/v4/competitions/"+ league + "/teams";
		String apiKey = "83594fe3d916447da53804c60317e550";
		WebClient webClient = WebClient.builder()
				.defaultHeader( "X-Auth-Token" ,apiKey)
                .build();
	
		Flux<Map<String, Object>> teams = webClient
	                .get()
	                .uri(url)
	                .retrieve()
	                .bodyToFlux(new ParameterizedTypeReference<Map<String, Object>>() {});
		
	     teams.subscribe(
	    		 team -> {
	    			 // Saving teams list in our map
	    			   if (team.containsKey("teams") && team.get("teams") instanceof List) {
	    	                for (Map<String, Object> t : (List<Map<String, Object>>) team.get("teams")) {
	    	                     TeamsDTO detail = new TeamsDTO();
	                        	 detail.setId((int) t.get("id"));
	                        	 detail.setName((String)t.get("name"));
	                        	 detail.setShortName((String)t.get("shortName"));
	                        	 detail.setAddress((String)t.get("address"));
	                        	 detail.setCrest((String) t.get("crest"));
	                        	 detail.setWebsite((String)t.get("website"));
	                        	 detail.setCoach((String)((Map<String, String>) t.get("coach")).get("name"));

	    	                    // Process squad details
	    	                    for (Map<String, Object> p : (List<Map<String, Object>>) t.get("squad")) { 
	    	                    	AthleteDTO player = new AthleteDTO();
	                            	 player.setId((int) p.get("id"));
	                            	 player.setName((String) p.get("name"));
	                            	 player.setPosition((String) p.get("position"));
	                            	 player.setDateOfBirth((String) p.get("dateOfBirth"));
	                            	 player.setNationality((String) p.get("nationality"));
	                            	 player.setTeam((String)t.get("name"));
	                            	 player.setTeamId((int) t.get("id"));
	                            	 
	                            	 if(!this.playerList.isEmpty()) {
	                            		for(AthleteDTO pl : this.playerList) {
	                            			 if(player.getId() == (pl.getId())) {
	                            				 break;
	                            			 }
	                            		 }
	                            	 }
	                            	 this.playerList.add(player);
	                            	 this.playerService.insertPlayer(player);
	    	                    }
	    	                    if(!this.teamsByLg.isEmpty()) {
	                        		for(TeamsDTO tbl : this.teamsByLg) {
	                        			if(detail.getId() == (tbl.getId())) {
	                        				break;
	                        			}
	                        		}
	                        	 }
	                        	 this.teamsByLg.add(detail); 
	                        	 teamsService.insertTeams(detail);
	    	                }
	    	            } else {
	    	                System.err.println("Invalid response format. Expected 'teams' key with a list value.");
	    	            }
	    		 },
	                error -> {
	                    // Handle errors
	                    System.err.println("Error: " + error.getMessage());
	                },
	                () -> {
	                    // Called when the operation is completed
	                    System.out.println("Request completed");
	                }
	     );
	     
	}
	
	
	private static Flux<Map<String, Object>>  getPlayerDetails(String playerName) {
		String url = "https://www.thesportsdb.com/api/v1/json/3/searchplayers.php?p=" + playerName;
		WebClient webClient = WebClient.create();
	
		Flux<Map<String, Object>> player = webClient
	                .get()
	                .uri(url)
	                .retrieve()
	                .bodyToFlux(new ParameterizedTypeReference<Map<String, Object>>() {});
		
		return player;
    }

	public void updateDB() {
		for(TeamsDTO team : this.teamsByLg) {
			teamsService.insertTeams(team);
			System.out.println(team);
		}
		for(AthleteDTO player : this.playerList) {
			playerService.insertPlayer(player);
		}
	}
	
//	public void getPlayerDetails() {
//		for(Map<String, String> player : this.playerList) {
//			String url = "https://www.thesportsdb.com/api/v1/json/3/searchplayers.php?p="+player.get("name");
//			WebClient webClient = WebClient.create();
//			 
//			Flux<Map<String, Object>> players = webClient
//		                .get()
//		                .uri(url)
//		                .retrieve()
//		                .bodyToFlux(new ParameterizedTypeReference<Map<String, Object>>() {});
//		    
//		     
//		     players.subscribe(
//		    		 response -> {
//		                      for(Map<String, String> p : (List<Map<String, String>>) response.get("player")) {
//		                    	  player.put("idTeam_sportsdb", p.get("idTeam"));
//		                    	  player.put("idPlayer_sportsdb", p.get("idPlayer"));
//		                    	  player.put("strAgent", p.get("strAgent"));
//		                    	  player.put("strDescriptionEN", p.get("strDescriptionEN"));
//		                    	  player.put("strFacebook", p.get("strFacebook"));
//		                    	  player.put("strTwitter", p.get("strTwitter"));
//		                    	  player.put("strInstagram", p.get("strInstagram"));
//		                    	  player.put("strYoutube", p.get("strYoutube"));
//		                    	  player.put("strHeight", p.get("strHeight"));
//		                    	  player.put("strWeight", p.get("strWeight"));
//		                    	  player.put("strThumb", p.get("strThumb"));
//		                    	  player.put("strCutout", p.get("strCutout"));
//		                    	  player.put("strRender", p.get("strRender"));
//		                      }
//		    		 },
//		                error -> {
//		                    // Handle errors
//		                    System.err.println("Error: " + error.getMessage());
//		                },
//		                () -> {
//		                    // Called when the operation is completed
//		                    System.out.println("Request completed");
//		                }
//		    		 );
//		 	System.out.println(player);
//		}
//	}
//	

//	

//	public void getPlayersInTeam(String teamName) throws InterruptedException {
//		String url = "https://thesportsdb.com/api/v1/json/3/searchplayers.php?t=";
//		
//		Mono<String> resultMono = WebClient.create()
//	                .get()
//	                .uri(url+teamName)
//	                .retrieve()
//	                .bodyToMono(String.class);
//		 resultMono.subscribe(
//	                result -> {
//	                    // Handle the result asynchronously
//	                	 try {
//	                         ObjectMapper objectMapper = new ObjectMapper();
//	                         Map<String, List<Map<String, String>>> jsonMap = objectMapper.readValue(result, Map.class);
//	                         
//	                         // Saving teams list in our map
//	                         this.playerList = (List<Map<String, String>>) jsonMap.get("player");
//	                         
//	                         //To get the each team's info
//	                         //System.out.println(this.teams.get(0).get("strTeam"));
//	                     } catch (IOException e) {
//	                         e.printStackTrace();
//	                     }
//	                },
//	                error -> {
//	                    // Handle errors
//	                    System.err.println("Error: " + error.getMessage());
//	                },
//	                () -> {
//	                    // Called when the operation is completed
//	                    System.out.println("Request completed");
//	                }
//	     );
//
//	        // Do other work asynchronously while waiting for the HTTP request to complete
//	        // ...
//
//	        // Block the main thread for demonstration purposes (in a real application, you would typically avoid this)
//	     Thread.sleep(5000);
//		
//	}
	
}
