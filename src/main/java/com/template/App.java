package com.template;

import java.util.Collections;
import java.util.Map;

public class App {


    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        if (accounts.containsKey(account)) {
            if (amount > 0) {
                int newAmount = accounts.get(account) + amount;
                accounts.put(account, newAmount);
            }
            return accounts;
        }
        return accounts;
    }

    public static Map<String, Integer> withdraw(Map<String, Integer> accounts, String account, int amount) {
         if (amount > 0 && accounts.containsKey(account)) {
             if (accounts.containsKey(account) && accounts.get(account) > 0) {
                 int NewAmount = accounts.get(account);
                 if (NewAmount >= amount) {
                     accounts.put(account, NewAmount - amount);
                 }
             }
         }
        return accounts;
    }

    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String fromAccount, String toAccount, int amount) {
        if (accounts.containsKey(fromAccount) && accounts.containsKey(toAccount)) {
             if (fromAccount != toAccount) {
                 if ((accounts.get(fromAccount) > amount || accounts.get(toAccount) > amount) && (amount>0)){
                     int increasedAmount = accounts.get(toAccount) + amount;
                     int decreasedAmount = accounts.get(fromAccount) - amount;
                     accounts.put(toAccount, increasedAmount);
                     accounts.put(fromAccount, decreasedAmount);
                 }
             }
        }
        return accounts;
    }
}
