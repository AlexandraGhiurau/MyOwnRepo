package com.alexa.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name ="details")
    private String details;

    @Column(name ="date")
    private Date date;

    public Activity() {
    }

    public Activity(int id, String details, Date date) {
        this.id = id;
        this.details = details;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
