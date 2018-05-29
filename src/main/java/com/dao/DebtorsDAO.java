package com.dao;

import com.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DAO for debtors_stu
 **/
@Component
public class DebtorsDAO extends DAO{
    @Autowired
    public DebtorsDAO(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    /**
     * selects only district, constract and serial number for every debtor
     */
    public List<Debtor> selectDebtors(){
        return jdbcTemplate.query("select DISTINCT d.DISTRICT, d.CONTRACT, d.SER_NBR from DEBTORS_INFO d"
                , new BeanPropertyRowMapper<>(Debtor.class));
    }

    public Debtor getSingleDebtor(String district, String contract, String serNbr){
        List<Debtor> debtors = get(district, contract, serNbr);
        if (debtors != null)
            if(debtors.size()>0)
            return debtors.get(0);
        return null;
    }

    private List<Debtor> get(String district, String contract, String serNbr){
        if (serNbr.equals("_"))
            serNbr = "IS NULL";
        else
            serNbr = "= '" + serNbr +"'";
        return jdbcTemplate.query("select * from DEBTORS_INFO d " +
                        "WHERE substr(d.DISTRICT, 4, 2) = ?"+
                        " AND d.CONTRACT = ?" +
                        " AND d.SER_NBR " + serNbr,
                new Object[]{district, contract},
                new BeanPropertyRowMapper<>(Debtor.class));
    }
}
