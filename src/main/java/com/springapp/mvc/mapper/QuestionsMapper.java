package com.springapp.mvc.mapper;

import com.springapp.mvc.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bildad on 15/10/14.
 */
public class QuestionsMapper implements RowMapper<Question> {
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setQuestion_id(rs.getInt("question_id"));
        question.setQuestion(rs.getString("question"));
        question.setCompany_name(rs.getString("company_name"));
        question.setPage_number(rs.getInt("page_number"));


        return question;
    }
}