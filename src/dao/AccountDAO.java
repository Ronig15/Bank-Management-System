package dao;

import model.Account;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

public class AccountDAO {

    public boolean createBankAccount(Account account) throws SQLException {
        String sql = "INSERT INTO bankaccounts(AccountNumber, CustomerID, AccountType, Balance, Status, OpeningDate) VALUES (?,?,?,?,?,?)";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql) ;) {

            ps.setLong(1, account.getAccNumber());
            ps.setInt(2, account.getCustomerID());
            ps.setString(3, account.getAccountType());
            ps.setDouble(4, account.getBankBalance());
            ps.setString(5, account.getStatus());
            ps.setDate(6, Date.valueOf(account.getOpeningDate()));

            int affectedRows = ps.executeUpdate();
            if(affectedRows != 0) {
                return true;
            }
        }
        return false;
    }

    public Account getAccount(long accNumber) throws SQLException {
        String sql = "SELECT * FROM bankaccounts WHERE AccountNumber = ?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql) ;) {
            ps.setLong(1, accNumber);

            // Execute the Query and extract all the details from the result.
            try(ResultSet resultSet = ps.executeQuery()){
                if(resultSet.next()){
                    // Load those details into an object of Account type.
                    return new Account(
                            resultSet.getLong("AccountNumber"),
                            resultSet.getInt("customerID"),
                            resultSet.getString("AccountType"),
                            resultSet.getDouble("Balance"),
                            resultSet.getString("Status"),
                            resultSet.getDate("OpeningDate").toLocalDate()
                    );
                }else{
                    return null;
                }
            }
        }
    }

    public boolean closeBankAccount(long accNumber) throws SQLException {
        String sql = "UPDATE  bankaccounts SET status = 'Closed' WHERE AccountNumber = ? ";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql) ;) {
            ps.setLong(1, accNumber);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean activeBankAccount(long accNumber) throws SQLException {
        String sql = "UPDATE  bankaccounts SET status = 'Active' WHERE AccountNumber = ? ";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql) ;) {
            ps.setLong(1, accNumber);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateAccount(Account account) throws SQLException{
        String sql = "UPDATE bankaccounts SET Balance = ? WHERE AccountNumber = ?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setDouble(1, account.getBankBalance());
            ps.setLong(2, account.getAccNumber());
            return ps.executeUpdate() == 1;
        }
    }

    public boolean transactionUpdateBalance(Account acc, Connection conn) throws SQLException {
        String sql = "UPDATE bankaccounts SET Balance = ? WHERE AccountNumber = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDouble(1, acc.getBankBalance());
            ps.setLong(2, acc.getAccNumber());

            return ps.executeUpdate() == 1;
        }
    }

    public static ArrayList<Account> getAccDetails(long accNumber) throws SQLException {
        String sql = "SELECT * FROM bankaccounts WHERE AccountNumber = ?";
        ArrayList<Account> accDetails = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, accNumber);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Account a = new Account(
                            rs.getLong("AccountNumber"),
                            rs.getInt("CustomerID"),
                            rs.getString("AccountType"),
                            rs.getDouble("Balance"),
                            rs.getString("Status"),
                            rs.getDate("OpeningDate").toLocalDate()
                    );
                    accDetails.add(a);
                }
            }
        }
        return accDetails;
    }


}
