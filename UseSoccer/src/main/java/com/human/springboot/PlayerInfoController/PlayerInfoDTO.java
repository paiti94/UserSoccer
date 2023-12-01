package com.human.springboot.PlayerInfoController;

public class PlayerInfoDTO {
	public int getPlayerseq() {
		return playerseq;
	}
	public void setPlayerseq(int playerseq) {
		this.playerseq = playerseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getHighlight() {
		return highlight;
	}
	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}
	public String getArticle_name() {
		return article_name;
	}
	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}
	int playerseq;
	String name;
	String article;
	String picture;
	String video;
	String highlight;
	String article_name;
}
