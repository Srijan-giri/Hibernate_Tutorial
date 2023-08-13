package com.tut.FetchingTechnique;
import java.util.*;
import javax.persistence.*;

@Entity
public class Answer_Fetch {
    @Id
	private int aid;
    
	private String answers;
    @ManyToOne
	private Question_Fetch question;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public Question_Fetch getQuestion() {
		return question;
	}
	public void setQuestion(Question_Fetch question) {
		this.question = question;
	}
	public Answer_Fetch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer_Fetch(int aid, String answers, Question_Fetch question) {
		super();
		this.aid = aid;
		this.answers = answers;
		this.question = question;
	}
	@Override
	public String toString() {
		return "Answer_Fetch [aid=" + aid + ", answers=" + answers + ", question=" + question + "]";
	}
    
    
}
