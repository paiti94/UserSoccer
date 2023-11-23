package com.human.springboot.MainController;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import jakarta.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
//import java.util.Optional;
import com.google.gson.Gson;


@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class MainController {

    
    @Autowired
    private MainService mainService;
    
    private static final String API_KEY = "AIzaSyAhFFbfs9k7deCHW_uR_XvWwTTx38Nsjq0";
    
    @GetMapping("/player/{name}")
    public String getPlayerList(@PathVariable String name) {
    	Gson gson = new Gson();
    	if(mainService.getPlayerList(name) != null) {
    		return gson.toJson(mainService.getPlayerList(name).get(0));
    	}else {
    		return gson.toJson("error");
    	}
    }
    
    // to show all the list of player in the system.
    @GetMapping("/player")
    public String getPlayerListAll() {
    	Gson gson = new Gson();
    	if(mainService.getPlayerListAll() != null) {
    		return gson.toJson(mainService.getPlayerListAll());
    	}else {
    		return gson.toJson("error");
    	}
    }
    
    // YouTube 동영상 URL에서 비디오 ID를 추출하는 함수
    private String getYoutubeVideoId(String url) {
        String videoId = url.split("v=")[1];
        int ampersandPosition = videoId.indexOf('&');
        if (ampersandPosition != -1) {
            videoId = videoId.substring(0, ampersandPosition);
        }
        return videoId;
    }

}
