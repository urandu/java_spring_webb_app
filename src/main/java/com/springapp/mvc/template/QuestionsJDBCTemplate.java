package com.springapp.mvc.template;

import com.springapp.mvc.Question;
import com.springapp.mvc.dao.QuestionsDAO;
import com.springapp.mvc.mapper.QuestionsMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by bildad on 15/10/14.
 */
public class QuestionsJDBCTemplate implements QuestionsDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public Question getQuestion(int question_id)
    {
        String SQL = "select * from questions where question_id = ? limit 1";
        Question question = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{question_id}, new QuestionsMapper());
        return question;
    }


    public List<Question> listQuestions(int page_number) {

        String SQL = "select * from `questions` where `page_number` =" + page_number;
        List <Question> questions = jdbcTemplateObject.query(SQL,
                new QuestionsMapper());
        return questions;
    }

    public void delete(int question_id) {
        String SQL = "delete * from questions where cid=?";

        jdbcTemplateObject.update( SQL, question_id);

        return;
    }


    public void create(int question_id,String question,String company_name,int page_number) {
        String SQL = "insert into questions ( question_id,question,company_name,page_number) values (?, ?, ?,?)";

        jdbcTemplateObject.update( SQL, question_id, question, company_name,page_number);

        return;
    }






}
