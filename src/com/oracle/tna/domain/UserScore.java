package com.oracle.tna.domain;

import java.sql.Timestamp;


public class UserScore {

	private int uid;
	private String username;
	private String name;
	private Timestamp date;
	private int score;
	/*private String answer;
	private String s_answer;*/
	public UserScore() {
		super();
	}
	
	public UserScore(User user,Score score){
		this.name = user.getName();
		this.uid = user.getUid();
		this.username = user.getUsername();
		this.date = score.getDate();
		this.score = score.getScore();
	}
	
	public UserScore(int uid, String username, String name, Timestamp date, int score) {
		super();
		this.uid = uid;
		this.username = username;
		this.name = name;
		this.date = date;
		this.score = score;
	}

	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return String.format(
				"UserScore [uid=%s, username=%s, name=%s, date=%s, score=%s]",
				uid, username, name, date, score);
	}
	
	
}
