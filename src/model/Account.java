package model;

import java.time.LocalDate;

public class Account {
    private long accNumber;
    private int customerID;
    private String accountType;
    private double bankBalance;
    private String status;
    private LocalDate openingDate;

    public Account(long accNumber, int customerID, String accountType, double bankBalance, String status, LocalDate openingDate) {
        this.accNumber = accNumber;
        this.customerID = customerID;
        this.accountType = accountType;
        this.bankBalance = bankBalance;
        this.status = status;
        this.openingDate = openingDate;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }
}
