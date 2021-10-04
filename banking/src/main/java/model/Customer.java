package model;

public class Customer {
    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private double balance;

    public Customer() {
    }
    public Customer(int id, String fullName, String email, String phoneNumber, double balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public Customer(String fullName, String email, String phoneNumber, double balance) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public Customer(String fullName, String email, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
