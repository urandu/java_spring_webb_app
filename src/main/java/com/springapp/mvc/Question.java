package com.springapp.mvc;

/**
 * Created by bildad on 15/10/14.
 */
public class Question {
    private int question_id;
    private String question;
    private String company_name;
    private int page_number;

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getPage_number() {
        return page_number;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getQuestion() {
        return question;
    }
}
