package com.springapp.mvc.dao;

import com.springapp.mvc.Clients;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by bildad on 27/06/14.
 */
public interface ClientsDAO {

    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);
    /**
     * This is the method to be used to create
     * a record in the Student table.
     */
    public void create(String names, String email, String tel1);
    public void delete(int cid);
    public List<Map<String, Object>> getList();

    public Clients getClient(Integer id);
    /**
     * This is the method to be used to list down
     * all the records from the Student table.
     */
    public List<Clients> listClients();



}
