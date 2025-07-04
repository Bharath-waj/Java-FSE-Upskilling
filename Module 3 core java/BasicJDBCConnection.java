import java.sql.*;
public class BasicJDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // change as needed
        String user = "root";
        String pass = "**********"; // change as needed
        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " +
                                   rs.getString("name") + " " +
                                   rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
