package com.springapp.mvc.mapper;

import com.springapp.mvc.Clients;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bildad on 27/06/14.
 */
public class ClientsMapper implements RowMapper<Clients> {
    public Clients mapRow(ResultSet rs, int rowNum) throws SQLException {
        Clients client = new Clients();
        client.setCid(rs.getInt("cid"));
        client.setCity(rs.getString("city"));
        client.setEmail(rs.getString("email"));
        client.setNames(rs.getString("names"));
        client.setPhy_address(rs.getString("phy_address"));
        client.setTel1(rs.getString("tel1"));

       return client;
    }
}