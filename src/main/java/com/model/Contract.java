package com.model;

/**
 * for json output
 **/
public class Contract {
    private int id;
    private String district;
    private String contract;
    private String serNbr;

    public Contract(int id, String district, String contract, String serNbr){
        this.id = id;
        this.district = district;
        this.contract = contract;
        this.serNbr = serNbr;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getSerNbr() {
        return serNbr;
    }

    public void setSerNbr(String serNbr) {
        this.serNbr = serNbr;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", contract='" + contract + '\'' +
                ", serNbr='" + serNbr + '\'' +
                '}';
    }
}
