package service;

import com.config.AppConfig;
import com.service.DebtorsService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by N.Babenkov on 19.04.2018.
 **/
@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class GetDebtors {
    @Autowired
    private DebtorsService service;

    @Test
    @Ignore
    public void getFileTest() throws IOException{
        service.getFile("11", "113", "253983");
    }
}
