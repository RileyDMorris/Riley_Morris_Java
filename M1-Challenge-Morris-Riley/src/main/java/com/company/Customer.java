package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        // Create an AccountRecord and a balance tracker
        AccountRecord currentAccountRecord;
        int totalBalance = 0;

        // Loop through all charges the customer has an add each charge to the totalBalance
        for (int i = 0; i < charges.size(); i++) {
            currentAccountRecord = charges.get(i);
            totalBalance += currentAccountRecord.getCharge();
        }

        return totalBalance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        String customerString = "ID: " + id + ", Name: " + name + ", Balance: " + this.getBalance();
        return customerString;
    }
}
