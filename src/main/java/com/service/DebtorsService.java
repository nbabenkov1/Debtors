package com.service;

import com.model.Debtor;
import com.model.Contract;
import com.repository.DebtorsRepo;
import com.utils.DocxFilesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by N.Babenkov on 05.12.2017.
 **/
@Service
public class DebtorsService {
    @Value("${Rep.Dir.Homedir}")
    private String homeDir;
    private DebtorsRepo debtorsRepo;
    private Logger logger = LoggerFactory.getLogger("updateLogger");

    @Autowired
    public DebtorsService(DebtorsRepo debtorsRepo) {
        this.debtorsRepo = debtorsRepo;
    }

    /**
     * Runs debtors table update
     */
    public void fullUpdate() throws IOException, SQLException, ClassNotFoundException {
        logger.info("Full update starts");
        debtorsRepo.updateTable();
        logger.info("Table updated");
    }

    /**
     * method for getting list of debtors in JSON format
     * @return JSON object with district, contract and serial number of debtors
     */
    public List<Contract> getList() {
        List<Contract> listOfDocxFiles = new ArrayList<>();
        int counter = 0;
        debtorsRepo.read();
        Debtor debtor = debtorsRepo.pop();
        while (debtor != null){
            listOfDocxFiles.add(new Contract(counter, debtor.getDistrict(), debtor.getContract(), debtor.getSerNbr()));
            debtor = debtorsRepo.pop();
            counter++;
        }
        return listOfDocxFiles;
    }

    /**
     * for getting single docx file for single debtor
     * @return File object
     */
    public File getFile(String district, String contract, String serNbr) throws IOException{
        logger.info("Getting file: " + district + " " + contract + " " + serNbr);
        DocxFilesManager filesManager = new DocxFilesManager();
        Debtor debtor = debtorsRepo.getSingle(district,contract,serNbr);
        if (debtor == null) return null;
        File newFile = new File(homeDir
                + File.separator + debtor.getDistrict().replace("/", "").substring(3,5) + "_"
                + debtor.getContract().replace("/", "") + "_"
                + debtor.getSerNbr().replace("/", "") + ".docx");

        if (newFile.exists())
            return newFile;
        else {
            filesManager.createDocxFile(debtor.toMap(), newFile);
            return newFile;
        }
    }
}
