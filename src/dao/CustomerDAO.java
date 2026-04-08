package dao;

import model.Customer;
import util.DBUtil;

import java.sql.*;

public class CustomerDAO {
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
