package jdbc_connection;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/StudentsDB";
            String username = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Established Connection");

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM students");

            while (result.next()) {
                System.out.println(result.getInt("id") + " "
                        + result.getString("firstname") + " "
                        + result.getString("lastname") + " "
                        + result.getInt("grade"));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}