package dao;

import model.Account;
import model.Transaction;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

public class TransactionDAO {
    public void addTransaction(Transaction t) throws SQLException {
        String sql = "INSERT INTO transactions(AccountNumber, TransactionType, Amount, TransactionDate, RelatedAccountNumber, Description) VALUES (?,?,?,?,?,?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

            ps.setLong(1, t.getAccNumber());
            ps.setString(2, t.getTransactionType());
            ps.setDouble(3, t.getAmount());
            ps.setTimestamp(4, Timestamp.valueOf(t.getTimestamp()));
            if (t.getRelatedAccountNumber() == 0) {
                ps.setNull(5, Types.BIGINT);
            } else {
                ps.setLong(5, t.getRelatedAccountNumber());
            }
            ps.setString(6, t.getDescription());
            ps.executeUpdate();
            try(ResultSet resultSet = ps.getGeneratedKeys();) {
                if(resultSet.next()) {
                    t.setTransactionID(resultSet.getInt(1));
                }
            }
        }
    }

    public boolean addTransferTransaction(Transaction t, Connection conn) throws SQLException{
        String sql = "INSERT INTO transactions(AccountNumber, TransactionType, Amount, TransactionDate, RelatedAccountNumber, Description) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

            ps.setLong(1, t.getAccNumber());
            ps.setString(2, t.getTransactionType());
            ps.setDouble(3, t.getAmount());
            ps.setTimestamp(4, Timestamp.valueOf(t.getTimestamp()));
            if (t.getRelatedAccountNumber() == 0) {
                ps.setNull(5, Types.BIGINT);
            } else {
                ps.setLong(5, t.getRelatedAccountNumber());
            }
            ps.setString(6, t.getDescription());
            int updateResult = ps.executeUpdate();
            try(ResultSet resultSet = ps.getGeneratedKeys();) {
                if(resultSet.next()) {
                    t.setTransactionID(resultSet.getInt(1));
                }
            }
            return updateResult == 1;
        }
    }
    public ArrayList<Transaction> getAllTransactions(long accNumber) throws SQLException{
        String sql = "SELECT * FROM transactions WHERE AccountNumber = ? ORDER BY TransactionDate DESC";
        ArrayList<Transaction> allTransactions = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
            ps.setLong(1, accNumber);
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Transaction t = new Transaction(
                            rs.getLong("AccountNumber"),
                            rs.getString("TransactionType"),
                            rs.getDouble("Amount"),
                            rs.getTimestamp("TransactionDate").toLocalDateTime(),
                            rs.getLong("RelatedAccountNumber"),
                            rs.getString("Description")
                    );
                    t.setTransactionID(rs.getInt("TransactionID"));
                    allTransactions.add(t);
                }
            }
        }
        return allTransactions;
    }
    }

