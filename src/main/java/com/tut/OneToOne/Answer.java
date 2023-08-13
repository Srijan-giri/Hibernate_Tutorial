package com.tut.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="answer_oneToone")
public class Answer {
	@Id
	@Column(name="ansewer_id")
	private int answerId;
	
	private String answer;
	@OneToOne(mappedBy = "answer")
    private Question qId;

	public Answer(int answerId, String answer,Question qId) {
		super();
		this.answerId = answerId;
		this.answer = answer;
    	this.qId = qId;
	}

	public Question getqId() {
		return qId;
	}

	public void setqId(Question qId) {
		this.qId = qId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answer=" + answer + ", qId=" + qId + "]";
	}

	
	
	
	
}
