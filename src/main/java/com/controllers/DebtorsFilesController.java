package com.controllers;

import com.service.DebtorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Controller for getting docx files of debtors
 **/

@RestController
@RequestMapping(value = "/docs")
public class DebtorsFilesController {
    private final DebtorsService debtorsService;
    private Logger logger = LoggerFactory.getLogger("updateLogger");

    @Autowired
    public DebtorsFilesController(DebtorsService debtorsService) {
        this.debtorsService = debtorsService;
    }

    @RequestMapping(value = "/{district}/{contract}/{ser_nbr}",
            method = RequestMethod.GET,
            produces = "multipart/data")
    @CrossOrigin(value = "*")
    public void getFile(@PathVariable("district") String district,
                        @PathVariable("contract") String contract,
                        @PathVariable("ser_nbr") String serNbr,
                        HttpServletResponse response) throws ServletException, IOException{
        File outputFile = debtorsService.getFile(district, contract, serNbr);

        response.addHeader("Content-Disposition", "attachment; filename=\"" + outputFile.getName() + "\"");
        response.setContentLength((int) outputFile.length());

        try (BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(outputFile));
             BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            org.apache.commons.io.IOUtils.copy(fileInputStream, outputStream);
        } catch (FileNotFoundException fnf) {
            throw new ServletException("Couldn't open file");
        } finally {
            if (!outputFile.delete())
                logger.error("COULDN'T DELETE OUTPUT FILE");
        }
    }
}
