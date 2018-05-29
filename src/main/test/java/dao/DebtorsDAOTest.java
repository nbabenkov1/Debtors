package dao;

import com.config.AppConfig;
import com.dao.DebtorsDAO;
import com.model.Debtor;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by N.Babenkov on 17.04.2018.
 **/
@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DebtorsDAOTest {
    @Autowired
    private DebtorsDAO dao;

    @Test
    @Ignore
    public void getDebtorsTest() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            dao.selectDebtors();
        }
        System.out.println("Table to model in: " + (System.currentTimeMillis() - start) / 100 + "ms.");

    }

    @Test
    @Ignore
    public void formDocxTest() {
        List<Debtor> debtors = dao.selectDebtors();
        debtors.forEach(x -> x = dao.getSingleDebtor(x.getDistrict(), x.getContract(), x.getSerNbr()));
    }
}
