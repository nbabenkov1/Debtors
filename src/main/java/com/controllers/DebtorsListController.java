package com.controllers;

import com.model.Contract;
import com.service.DebtorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.util.List;

/**
 * Controller for getting and updating debtors list
 **/
@Controller
public class DebtorsListController {
    private Logger logger = LoggerFactory.getLogger("updateLogger");
    private DebtorsService debtorsService;

    @Autowired
    public DebtorsListController(DebtorsService debtorsService) {
        this.debtorsService = debtorsService;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public @ResponseBody List<Contract> getList() throws ServletException{
        return debtorsService.getList();
    }

    @RequestMapping(value = "/updateList", method = RequestMethod.POST)
    public void updateList() throws ServletException{
        try{
            debtorsService.fullUpdate();
        } catch (Exception e){
            logger.error("ERROR OCCURED: ", e);
            throw new ServletException(e.getMessage());
        }
    }
}
