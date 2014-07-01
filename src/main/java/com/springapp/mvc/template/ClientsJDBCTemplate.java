package com.springapp.mvc.template;

import com.springapp.mvc.Clients;
import com.springapp.mvc.dao.ClientsDAO;
import com.springapp.mvc.mapper.ClientsMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by bildad on 27/06/14.
 */
public class ClientsJDBCTemplate implements ClientsDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Map<String, Object>> getList() {
        return this.jdbcTemplateObject.queryForList("select * from vw_polstateunearned where 1=1 order by icomp,invdate,invno");
    }

    public Clients getClient(Integer cid) {

        String SQL = "select * from clients where cid = ?";
        Clients client = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{cid}, new ClientsMapper());
        return client;
    }


    public void delete(int cid) {
        String SQL = "delete * from clients where cid=?";

        jdbcTemplateObject.update( SQL, cid);

        return;
    }


    public void create(String names, String email, String tel1) {
        String SQL = "insert into clients ( names, email, tel1) values (?, ?, ?)";

        jdbcTemplateObject.update( SQL, names, email, tel1);

        return;
    }

    @Override
    public List<Clients> listClients() {

        String SQL = "select * from clients";
        List <Clients> clients = jdbcTemplateObject.query(SQL,
                new ClientsMapper());
        return clients;
    }







}
