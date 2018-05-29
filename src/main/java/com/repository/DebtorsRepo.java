package com.repository;

import com.dao.DebtorsDAO;
import com.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Initializes and stores a list of Debtor objects
 **/
@Repository
public class DebtorsRepo {
    private List<Debtor> rowsList;
    private DebtorsDAO dao;

    @Autowired
    public DebtorsRepo(DebtorsDAO dao) {
        this.dao = dao;
        rowsList = new ArrayList<>();
    }

    public void read() {
        rowsList = dao.selectDebtors();
    }

    public Debtor pop() {
        if (!rowsList.isEmpty()) {
            return rowsList.remove(rowsList.size() - 1);
        } else
            return null;
    }

    public void updateTable() throws SQLException, ClassNotFoundException {
        dao.callProcedure("update_debtors");
    }

    public Debtor getSingle(String district, String contract, String serNbr) {
        return dao.getSingleDebtor(district, contract, serNbr);
    }
}
