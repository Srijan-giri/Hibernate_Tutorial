package com.tut.OneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question_OneToMany {

    @Id
    @Column(name = "qId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int question_id;

    private String question;
    @OneToMany(mappedBy = "question")
    private List<Answer_OneToMany> answers;

    public Question_OneToMany(int question_id, String question, List<Answer_OneToMany> answers) {
        super();
        this.question_id = question_id;
        this.question = question;
        this.answers = answers;
    }

    public Question_OneToMany() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer_OneToMany> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer_OneToMany> list) {
        this.answers = list;
    }

    @Override
    public String toString() {
        return "Question_OneToMany [question_id=" + question_id + ", question=" + question + ", answers=" + answers
                + "]";
    }

}
