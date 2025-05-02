package com.pluralsight; // class is part of a folder
import java.util.*; //imports Java’s utility classes

public class Transaction {//The Transaction class helps you store and manage the details of a single financial transaction.
    //These lines declare private variables, which means they can only be accessed inside this class.
    private String date;
    private String time;
    private String description;//details
    private String vendor;
    private double amount; // can be positive or negative


//Getter and toString method // to access or change private variables safely from outside the class.
    public String getDate() {
        return date;
    } // gives you the date

    public void setDate(String date) {
        this.date = date;
    } // it will help to change the date.

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //This is a constructor. It's used to create a new Transaction object and give it values.
    public Transaction(String date, String time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
}
