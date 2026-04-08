package dao;

import model.Transaction;
import util.DBUtil;

import java.sql.*;

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
}
