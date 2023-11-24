package com.human.springboot.WhosurchoiceController;

import java.util.ArrayList;

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
public class WhosurchoiceController {
	@Autowired 
	private WhosurchoiceDAO whosurchoicedao;

	@GetMapping("/showmatch")
    public String showNewMatch() {
		Gson gson = new Gson();
		if(whosurchoicedao.showMatch() != null) {
			return gson.toJson(whosurchoicedao.showMatch());
		}else {
			return gson.toJson("error");
		}
    }
	
	@GetMapping("/showmatch/{round}")
	public String showNewMatchbyRound(@PathVariable Integer round) {
		Gson gson = new Gson();
	
		if(whosurchoicedao.showMatchByRound(round) != null) {
			return gson.toJson(whosurchoicedao.showMatchByRound(round));
		}else {
			return gson.toJson("error");
		}
	}

}
