package com.alexa.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

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

    @Column(name="date_of_creation")
    private Date dateOfClient;

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

    public Date getDateOfClient() {
        return dateOfClient;
    }

    public void setDateOfClient(Date dateOfClient) {
        this.dateOfClient = dateOfClient;
    }
}