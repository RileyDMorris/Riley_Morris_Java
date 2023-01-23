package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        // Create a List<Customer> to update
        List<Customer> customerArray = new ArrayList<>();

        // Loop through all instances of customer data
        for (int i = 0; i < customerData.size(); i++) {
            // Check to see if the customer is already in the customerArray
            int currentId = Integer.parseInt(customerData.get(i)[0]);

            int found_customer = 0;
            for (int j = 0; j < customerArray.size(); j++) {
                Customer currentCustomer = customerArray.get(j);

                // If we find that we already created this customer, update the charge list with a new AccountRecord
                if (currentCustomer.getId() == currentId) {
                    found_customer = 1;

                    // Create an AccountRecord for this charge
                    AccountRecord newRecord = new AccountRecord();
                    newRecord.setCharge(Integer.parseInt(customerData.get(i)[2]));
                    newRecord.setChargeDate(customerData.get(i)[3]);

                    // Add the AccountRecord to the charges
                    List<AccountRecord> charges = currentCustomer.getCharges();
                    charges.add(newRecord);
                }
            }

            // If we never found the customer, create a new one and add it to the list
            if (found_customer == 0) {
                // Set name and Id
                Customer newCustomer = new Customer();
                newCustomer.setId(Integer.parseInt(customerData.get(i)[0]));
                newCustomer.setName(customerData.get(i)[1]);

                // Create an AccountRecord for this charge
                AccountRecord newRecord = new AccountRecord();
                newRecord.setCharge(Integer.parseInt(customerData.get(i)[2]));
                newRecord.setChargeDate(customerData.get(i)[3]);

                // Add the AccountRecord to the charges
                List<AccountRecord> charges = newCustomer.getCharges();
                charges.add(newRecord);

                // Finally, add the newCustomer to the customerList
                customerArray.add(newCustomer);
            }
        }

        // Print all positive balance accounts
        System.out.println("Positive accounts:");
        for(int i = 0; i < customerArray.size(); i++) {
            if (customerArray.get(i).getBalance() >= 0) {
                System.out.println(customerArray.get(i).toString());
            }
        }

        // Print all negative balance accounts
        System.out.println("Negative accounts:");
        for(int i = 0; i < customerArray.size(); i++) {
            if (customerArray.get(i).getBalance() < 0) {
                System.out.println(customerArray.get(i).toString());
            }
        }
    }
}
