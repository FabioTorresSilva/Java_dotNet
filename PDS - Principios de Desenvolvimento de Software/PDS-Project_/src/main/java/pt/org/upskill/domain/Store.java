package pt.org.upskill.domain;

import java.util.Random;
import java.util.Objects;

public class Store {
    private String storeCode;
    private String openingTime;
    private String closingTime;
    private String designation;
    private String address;

    public Store(String openingTime, String closingTime, String designation, String address) {
        this.storeCode = generateStoreCode();
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.designation= designation;
        this.address= address;
    }

    private String generateStoreCode() {
        Random rand = new Random();
        int num = rand.nextInt(100000);
        String formatted = String.format("%05d", num);
        return formatted;
    }

    public String getCode() {
        return storeCode;
    }
    public String getDesignation(){
        return designation;
    }
    public String getAddress(){
        return address;
    }

    public Store clone() {
        return new Store(this.openingTime, this.closingTime, this.designation, this.address);
    }
}