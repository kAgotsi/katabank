package com.kagotsi.katabank.models;

import javax.persistence.Entity;

@Entity(name = "deposit")
public class Deposit extends Operation{
    public Deposit() {
    }
    public Deposit(Double amount, Account account) {
        super(amount, account);
    }


}
