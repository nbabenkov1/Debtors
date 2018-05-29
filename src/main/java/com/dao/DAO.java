package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.SQLException;

/**
 * Created by N.Babenkov on 07.11.2017.
 **/
public abstract class DAO {
    JdbcTemplate jdbcTemplate;

    public DAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void callProcedure(String procedureName) throws ClassNotFoundException, SQLException{
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(procedureName);
        jdbcCall.execute();
    }

}
