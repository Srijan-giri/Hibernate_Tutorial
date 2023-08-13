package com.tut.FetchingTechnique;
import java.util.*;

import javax.persistence.*;

@Entity
public class Question_Fetch {
    @Id
	private int qid;
	private String ques;
//	@OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
	private List<Answer_Fetch> answers;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public List<Answer_Fetch> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer_Fetch> answers) {
		this.answers = answers;
	}
	public Question_Fetch(int qid, String ques, List<Answer_Fetch> answers) {
		super();
		this.qid = qid;
		this.ques = ques;
		this.answers = answers;
	}
	public Question_Fetch() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Question_Fetch [qid=" + qid + ", ques=" + ques + ", answers=" + answers + "]";
	}
	
	
	
}
