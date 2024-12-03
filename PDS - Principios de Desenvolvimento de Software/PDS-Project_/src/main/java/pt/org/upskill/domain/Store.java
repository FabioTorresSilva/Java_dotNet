package pt.org.upskill.domain;

import java.util.Random;
import java.util.Objects;

public class Store {
    private String storeCode;
    private String openingTime;
    private String closingTime;


    private Employee employee;

    public Store(String openingTime, String closingTime) {
        this.storeCode = generateStoreCode();
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    private String generateStoreCode() {
        Random rand = new Random();
        int num = rand.nextInt(100000);
        String formatted = String.format("%05d", num);
        return formatted;
    }

    public String getCode() {
        return storeCode; // Get the store's name
    }

    public Store clone() {
        return new Store(this.openingTime, this.closingTime);
    }
}