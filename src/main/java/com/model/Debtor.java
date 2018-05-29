package com.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Model of DEBTORS_INFO table from debtors_stu
 **/
public class Debtor {
    private String district;
    private String contract;
    private String contractDate;
    private String contractName;
    private String tuname;
    private String locDetales;
    private String gbpDesc;
    private String puType;
    private String serNbr;
    private Double kr;
    private String inn;
    private String kpp;
    private String jurAddress;
    private String spId;
    private String usageFlg;

    private String reformatString(String line){
        return line.replace("?", "\"");
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district==null?"_":reformatString(district);
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract==null?"_":reformatString(contract);
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate==null?"_":reformatString(contractDate);
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName==null?"_":reformatString(contractName);
    }

    public String getTuname() {
        return tuname;
    }

    public void setTuname(String tuname) {
        this.tuname = tuname==null?"_":reformatString(tuname);
    }

    public String getLocDetales() {
        return locDetales;
    }

    public void setLocDetales(String locDetales) {
        this.locDetales = locDetales==null?"_":reformatString(locDetales);
    }

    public String getGbpDesc() {
        return gbpDesc;
    }

    public void setGbpDesc(String gbpDesc) {
        this.gbpDesc = gbpDesc==null?"_":reformatString(gbpDesc);
    }

    public String getPuType() {
        return puType;
    }

    public void setPuType(String puType) {
        this.puType = puType==null?"_":reformatString(puType);
    }

    public String getSerNbr() {
        return serNbr;
    }

    public void setSerNbr(String serNbr) {
        this.serNbr = serNbr==null?"_":reformatString(serNbr);
    }

    public Double getKr() {
        return kr;
    }

    public void setKr(Double kr) {
        this.kr = kr;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn==null?"_":reformatString(inn);
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp==null?"_":reformatString(kpp);
    }

    public String getJurAddress() {
        return jurAddress;
    }

    public void setJurAddress(String jurAddress) {
        this.jurAddress = jurAddress==null?"_":reformatString(jurAddress);
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId==null?"_":reformatString(spId);
    }

    public String getUsageFlg() {
        return usageFlg;
    }

    public void setUsageFlg(String usageFlg) {
        this.usageFlg = usageFlg==null?"_":reformatString(usageFlg);
    }

    public Map<String, String> toMap(){
        Map<String, String> map = new HashMap<>();
        map.put("districtFlag", this.district==null?"_":this.district);
        map.put("contractFlag", this.contract==null?"_":this.contract);
        map.put("contractDateFlag", this.contractDate==null?"_":this.contractDate);
        map.put("contractNameFlag", this.contractName==null?"_":this.contractName);
        map.put("tuNameFlag", this.tuname==null?"_":this.tuname);
        map.put("locDetailsFlag", this.locDetales==null?"_":this.locDetales);
        map.put("gbpDescFlag", this.gbpDesc==null?"_":this.gbpDesc);
        map.put("puTypeFlag", this.puType==null?"_":this.puType);
        map.put("serialNbrFlag", this.serNbr==null?"_":this.serNbr);
        map.put("krFlag", String.valueOf(this.kr));
        map.put("innFlag", this.inn==null?"_":this.inn);
        map.put("kppFlag", this.kpp==null?"_":this.kpp);
        map.put("jurAddressFlag", this.jurAddress==null?"_":this.jurAddress);

        return map;
    }
}
