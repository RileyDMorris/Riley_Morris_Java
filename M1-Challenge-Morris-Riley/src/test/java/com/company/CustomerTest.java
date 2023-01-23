package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class CustomerTest {
    // Create a test customer with a name, id, and charges
    Customer testCustomer = new Customer();

    @Before
    public void setup() {
        String name = "Riley Morris";
        testCustomer.setName(name);
        testCustomer.setId(1);
        List<AccountRecord> charges = testCustomer.getCharges();

        AccountRecord charge1 = new AccountRecord();
        AccountRecord charge2 = new AccountRecord();
        AccountRecord charge3 = new AccountRecord();
        AccountRecord charge4 = new AccountRecord();

        charge1.setCharge(1);
        charge1.setChargeDate("1-23-2023");
        charge2.setCharge(-2);
        charge2.setChargeDate("1-23-2023");
        charge3.setCharge(3);
        charge3.setChargeDate("1-23-2023");
        charge4.setCharge(-4);
        charge4.setChargeDate("1-23-2023");

        charges.add(charge1);
        charges.add(charge2);
        charges.add(charge3);
        charges.add(charge4);
    }

    @Test
    public void getBalanceTest() {
        assertEquals(testCustomer.getBalance(), -2);
    }

    // Test that toString() returns customer ID, customer name, and customer balance
    @Test
    public void toStringTest() {
        assertEquals(testCustomer.toString(), "ID: 1, Name: Riley Morris, Balance: -2");
    }

}
