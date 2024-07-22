package buoi9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSQLExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //kết nối CSDL
        String url = "jdbc:mysql://localhost:3306/db221401";
        String user = "root";
        String password = "12345678";
        Connection connection = null;
        Statement statement = null;
        int rowCount = 0;
        //1. Kết nối đến db221401
        //nạp driver vào app
        Class.forName("com.mysql.cj.jdbc.Driver");
        //tạo kết nối 
        connection = DriverManager.getConnection(url, user,password);
        //thực thi câu SQL
        String sql = "Insert into Salary_Grade (Grade, High_Salary, Low_Salary) " +
                 "values (2, 20000, 10000) ";
        //đối tượng Statement
        statement = connection.createStatement();
        //thực thi
        rowCount = statement.executeUpdate(sql);

        System.out.println("Row count affected: " + rowCount);

        connection.close();
    }

}
