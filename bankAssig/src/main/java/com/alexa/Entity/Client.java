package com.alexa.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    private int pKey;

    @Column(name ="name")
    private String name;

    @Column(name ="address")
    private String address;

    @Column(name ="personal_num_code")
    private long personalNumCode;

    @Column(name ="card_no")
    private String cardNo;

    @OneToMany
    @JoinColumn(name ="client_id")
    private List<Account> accounts; //va fi coloana in account

    public Client(){}

    public Client(String name, String cardNo, long personalNumCode, String address) {
        this.name = name;
        this.address = address;
        this.cardNo = cardNo;
        this.personalNumCode = personalNumCode;
    }

    public Client(String name, String cardNo, long personalNumCode, String address, int pKey) {
        this.name = name;
        this.cardNo = cardNo;
        this.personalNumCode = personalNumCode;
        this.address = address;
        this.pKey = pKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public long getPersonalNumCode() {
        return personalNumCode;
    }

    public void setPersonalNumCode(long personalNumCode) {
        this.personalNumCode = personalNumCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getpKey() {
        return pKey;
    }

    public void setpKey(int pKey) {
        this.pKey = pKey;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
