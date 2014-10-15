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



    public Clients getClient(Integer cid) {

        String SQL = "select * from clients where cid = ?";
        Clients client = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{cid}, new ClientsMapper());
        return client;
    }


    public List<Map<String, Object>> getIcompsList() {
        String sqlQuery=sqlQuery = "select * from inscomp";

        return this.jdbcTemplateObject.queryForList(sqlQuery);
    }


    public List<Map<String, Object>> getList(String icomp ,String psta ) {
        String sqlQuery="";
        if (icomp.equals("ALL")) {
            sqlQuery = "select * from vw_polstateunearned where 1=1 order by icomp,invdate,invno";

            if (psta.equals("ALL")){
                //do not change the query

            }
            else {
                sqlQuery= "select * from vw_polstateunearned where 1=1 and psta=" + psta + "  order by icomp,invdate,invno";
            }
        }
        else {
            sqlQuery = "select * from vw_polstateunearned where 1=1 and icomp=" + icomp + " order by icomp,invdate,invno";

            if (psta.equals("ALL")){
                //do not change the query

            }
            else {
                sqlQuery="select * from vw_polstateunearned where 1=1 and icomp=" + icomp + "and psta=" + psta + " order by icomp,invdate,invno";
            }
        }


        return this.jdbcTemplateObject.queryForList(sqlQuery);
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
