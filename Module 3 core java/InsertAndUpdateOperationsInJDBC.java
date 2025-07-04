import java.sql.*;
class StudentDAO {
    Connection con;
    public StudentDAO() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "**********"); // change as needed
    }
    public void insertStudent(int id, String name, int age) throws SQLException {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        ps.executeUpdate();
    }
    public void updateStudent(int id, String name) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, id);
        ps.executeUpdate();
    }
}
public class InsertAndUpdateOperationsInJDBC {
    public static void main(String[] args) {
        try {
            StudentDAO dao = new StudentDAO();
            dao.insertStudent(1, "Alice", 20);
            dao.updateStudent(1, "Alicia");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
