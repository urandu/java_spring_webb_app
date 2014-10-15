package com.springapp.mvc;

/**
 * Created by bildad on 15/10/14.
 */
public class Question {
    private String question_id="none";
    private String question="none";
    private String company_name="none";
    private int page_number=-1;

    public Question(String question_id,String question, int page_number)
    {
        if(!question_id.isEmpty()) {
            this.question_id = question_id;
        }
        if (!question.isEmpty()) {
            this.question = question;
        }
        if (!question.isEmpty()) {
            this.page_number = page_number;
        }
        this.company_name="null";
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public int getPage_number() {
        return page_number;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getQuestion() {
        return question;
    }
}
