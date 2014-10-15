package com.springapp.mvc.dao;

import com.springapp.mvc.Question;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by bildad on 15/10/14.
 */
public interface QuestionsDAO {


    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);
    /**
     * This is the method to be used to create
     * a record in the Student table.
     */

    public Question getQuestion(String question_id);


    public List<Question> listQuestions(int page_number);

    public void delete(String question_id) ;

    public void create(String question_id,String question,String company_name,int page_number) ;


}
