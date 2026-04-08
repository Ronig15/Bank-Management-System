package model;
//    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
//    FirstName VARCHAR(50) NOT NULL,
//    LastName VARCHAR(50) NOT NULL,
//    Email VARCHAR(100) NOT NULL,
//    PhoneNumber VARCHAR(13) NOT NULL,
//    Address TEXT,
//    PANNumber CHAR(10) UNIQUE,
//    AadharNumber BIGINT UNIQUE,
//    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String panNumber;
    private long aadharNumber;

    public Customer(String firstName, String lastName, String email, String phoneNumber, String address, String panNumber, long aadharNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.panNumber = panNumber;
        this.aadharNumber = aadharNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public long getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(long aadharNumber) {
        this.aadharNumber = aadharNumber;
    }
}
