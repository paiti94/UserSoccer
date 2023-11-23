package com.human.springboot.PlayerInfoController;

import java.util.List;

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
public class PlayerInfoController {
	   @Autowired
	    private PlayerInfoService playerInfoService;
	
	  @GetMapping("/info/{name}")
	    public String getInfoList(@PathVariable String name) {
			Gson gson = new Gson();
	    	if(playerInfoService.getInfoList(name) != null) {
	    		return gson.toJson(playerInfoService.getInfoList(name));
	    	}else {
	    		return gson.toJson("error");
	    				
	    	}
	        
	    }

}
