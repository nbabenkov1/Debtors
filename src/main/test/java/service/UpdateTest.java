package service;

import com.config.AppConfig;
import com.service.DebtorsService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by N.Babenkov on 13.04.2018.
 **/
public class UpdateTest {
    @Test
//    @Ignore
    public void fullUpdateTest() throws SQLException, ClassNotFoundException, IOException{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DebtorsService service = context.getBean(DebtorsService.class);
        service.fullUpdate();
    }
}
