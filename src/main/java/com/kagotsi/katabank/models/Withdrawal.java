package com.kagotsi.katabank.models;


import javax.persistence.Entity;

@Entity(name = "withdrawal")
public class Withdrawal extends Operation{
    public Withdrawal() {
    }
    public Withdrawal(Double amount, Account account) {
        super(amount, account);
    }
}
