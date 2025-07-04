import java.sql.*;

public class TransactionHandlingInJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";  // change as needed
        String user = "root", pass = "**********"; // change as needed
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            con.setAutoCommit(false);
            PreparedStatement debit = con.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            PreparedStatement credit = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            debit.setDouble(1, 100);
            debit.setInt(2, 1);
            credit.setDouble(1, 100);
            credit.setInt(2, 2);
            debit.executeUpdate();
            credit.executeUpdate();
            con.commit();
            System.out.println("Transfer successful.");
        } catch (SQLException e) {
            e.printStackTrace();
            try { Connection con = DriverManager.getConnection(url, user, pass); con.rollback(); } catch (Exception ex) {}
            System.out.println("Transfer failed. Rolled back.");
        }
    }
}
