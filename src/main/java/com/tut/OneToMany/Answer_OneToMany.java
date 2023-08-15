package com.tut.OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer_OneToMany {
	@Id
	@Column(name="aId")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int answer_id;
	private String answer; 
	@ManyToOne
	private Question_OneToMany question;
	
	
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question_OneToMany getQuestion() {
		return question;
	}
	public void setQuestion(Question_OneToMany question) {
		this.question = question;
	}
	
	public Answer_OneToMany() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer_OneToMany(int answer_id, String answer, Question_OneToMany question) {
		super();
		this.answer_id = answer_id;
		this.answer = answer;
		this.question = question;
	}
	@Override
	public String toString() {
		return "Answer_OneToMany [answer_id=" + answer_id + ", answer=" + answer + ", question=" + question + "]";
	}

	
	

}
