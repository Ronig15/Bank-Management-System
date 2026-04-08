package dao;

import model.Account;
import model.Customer;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {
    public static ArrayList<Customer> getCustomerDetails(int customerID) throws SQLException {
        String sql = "SELECT * FROM customers WHERE CustomerID = ?";
        ArrayList<Customer> customerDetails = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, customerID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Customer c = new Customer(
                            rs.getString("FirstName"),
                            rs.getString("LastName"),
                            rs.getString("Email"),
                            rs.getString("PhoneNumber"),
                            rs.getString("Address"),
                            rs.getString("PANNumber"),
                            rs.getLong("AadharNumber")
                    );
                    customerDetails.add(c);
                }
            }
        }
        return customerDetails;
    }

    public int createCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (FirstName, LastName, Email, PhoneNumber, Address, PANNumber, AadharNumber) VALUES (?,?,?,?,?,?,?)";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            // Create Connection
            // Prepare a SQL statement
            ps.setString(1,customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhoneNumber());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getPanNumber());
            ps.setLong(7,customer.getAadharNumber());

            // Execute the query
            int effectedRows = ps.executeUpdate();
            if(effectedRows ==0){
                return -1;
            }
            // Store the result in a resultSet (not mandatory)
            try(ResultSet resultSet = ps.getGeneratedKeys();){
                if(resultSet.next()){
                    return resultSet.getInt(1);
                }
            }

        }
    return 0;
    }

}
