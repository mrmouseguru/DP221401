package buoi9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDataExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/db221401";
        String user = "root";
        String password = "12345678";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        //1. Kết nối đến db221401
        //nạp driver vào app
        Class.forName("com.mysql.cj.jdbc.Driver");
        //tạo kết nối 
        connection = DriverManager.getConnection(url, user,password);
        //2. thực thi câu SQL: SELECT
        String sql = "Select Emp_Id, Emp_No, Emp_Name from Employee";
        //đối tượng java.sql.Statement
        statement = connection.createStatement();
        //thực thi sql
        rs =  statement.executeQuery(sql);
        //3. in danh sánh nhân viên
        while (rs.next()) {
            int empId = rs.getInt(1);
            String empNo = rs.getString(2);
            String empName = rs.getString("Emp_Name");
            System.out.println("--------------------");
            System.out.println("EmpId:" + empId);
            System.out.println("EmpNo:" + empNo);
            System.out.println("EmpName:" + empName);
        }

        connection.close();//đóng kết nối
    }   

}
