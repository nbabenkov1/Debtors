package com.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by N.Babenkov on 24.04.2018.
 **/
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = {ServletException.class, IOException.class})
    public @ResponseBody String servletError(Exception ex){
        return ex.getMessage();
    }

}
