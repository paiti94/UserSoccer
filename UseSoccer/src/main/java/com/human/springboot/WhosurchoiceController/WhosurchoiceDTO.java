package com.human.springboot.WhosurchoiceController;

public class WhosurchoiceDTO {
	
	public int getPlayer_num() {
		return player_num;
	}
	public void setPlayer_num(int player_num) {
		this.player_num = player_num;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public String getPlayer_pic() {
		return player_pic;
	}
	public void setPlayer_pic(String player_pic) {
		this.player_pic = player_pic;
	}
	int player_num;
	String player_name;
	String player_pic;
}
