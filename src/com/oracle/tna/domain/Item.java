package com.oracle.tna.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Item implements Serializable
{
	private static final long serialVersionUID = 6400135843683633269L;
	@Id
	private int qid;
	private String question;
	@Column(name="option_a")
	private String optionA;
	@Column(name="option_b")
	private String optionB;
	@Column(name="option_c")
	private String optionC;
	@Column(name="option_d")
	private String optionD;
	private String answer;
	
	public Item(int qid, String question, String optionA, String optionB,
			String optionC, String optionD, String answer) {
		super();
		this.qid = qid;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
	}
	
	public Item(String question, String optionA, String optionB,
			String optionC, String optionD, String answer) {
		super();
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
	}

	public Item() {
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "Item [qid=" + qid + ", question=" + question + ", optionA="
				+ optionA + ", optionB=" + optionB + ", optionC=" + optionC
				+ ", optionD=" + optionD + ", answer=" + answer + "]";
	}
	
	
}
