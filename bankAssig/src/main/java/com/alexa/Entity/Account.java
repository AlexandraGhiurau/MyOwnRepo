package com.alexa.Entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private int accountId;

    @Column(name ="money")
    private double money;

    @Column(name ="type")
    private String type;

    public Account() {}

    public Account(int accountId, double money, String type) {
        this.accountId = accountId;
        this.money = money;
        this.type = type;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}