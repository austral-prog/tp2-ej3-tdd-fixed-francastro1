package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }
    @Test
    void testNegativeDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testNonExistingAccountDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "ernesto", 10);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testDecreaseDeposit(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));
    }

    @Test
    void testNegativeDecreaseDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testWithdrawFromNullAccount() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",0);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        assertEquals(0, updatedAccounts.get("mati"));
    }

    @Test
    void testWithdrawInNonExistingAccount(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "ernesto", 203);
        assertEquals(10, updatedAccounts.get("mati"));
        assertEquals(20, updatedAccounts.get("juan"));
    }

    @Test
    void testTransferBetweenAccounts(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan", 5);
        assertEquals(5, updatedAccounts.get("mati"));
        assertEquals(25, updatedAccounts.get("juan"));
    }

    @Test
    void testTransferBetweenNullAccounts(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",0);
        accounts.put("juan",0);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati","juan", 5);
        assertEquals(0, updatedAccounts.get("mati"));
        assertEquals(0, updatedAccounts.get("juan"));
    }

    @Test
    void testTransferBetweenNonExistingAccounts(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "ernesto", "javier", 10);
        assertEquals(10, updatedAccounts.get("mati"));
        assertEquals(20, updatedAccounts.get("juan"));
    }

    @Test
    void testTransferOfNegativeAmounts(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan", -5);
        assertEquals(10, updatedAccounts.get("mati"));
        assertEquals(20, updatedAccounts.get("juan"));
    }

    @Test
    void testTransferToTheAccountThatTransfers(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "mati", 5);
        assertEquals(10, updatedAccounts.get("mati"));
        assertEquals(20, updatedAccounts.get("juan"));
    }
}
