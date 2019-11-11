package server.model;

import java.util.ArrayList;

/**
 * A class representing an account in the system.
 *
 */
public class Account{

    private int accountId;
    private int customerId;
    private int balance;



    public Account(int accountId,int customerId,int balance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;


    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    //TODO: Implement the class. See init.sql for suggested fields - though remember that they may be
    //named differently here, if you so wish.
}
