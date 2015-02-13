package com.springapp.mvc.mapper;

import com.springapp.mvc.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class QuestionsMapper implements RowMapper<Question> {
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question(rs.getString("question_id"),rs.getString("question"),rs.getInt("page_number"));

        question.setCompany_name(rs.getString("company_name"));



        return question;
    }
}