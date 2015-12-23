package com.oracle.tna.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Score")
public class Score implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9169481030512746905L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
	private int uid;
	private Timestamp date;
	private int score;
	private String answer;
	private String s_answer;
	
	public Score() {}
	public Score(int uid, int score, String answer, String s_answer) {
		date = new Timestamp(new Date().getTime());
		this.uid = uid;
		this.score = score;
		this.answer = answer;
		this.s_answer = s_answer;
	}
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getS_answer() {
		return s_answer;
	}
	public void setS_answer(String s_answer) {
		this.s_answer = s_answer;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String[] getAnswers() {
		String[] answers = answer.split(",");
		return answers;
	}
	public String[] getS_answers() {
		String[] s_answers = s_answer.split(",");
		return s_answers;
	}
	
	
	@Override
	public String toString() {
		return "Score [uid=" + uid + ", date=" + date + ", score=" + score
				+ ", answer=" + answer + ", s_answer=" + s_answer + "]";
	}
	
}
