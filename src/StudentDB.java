import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jeremy Duncan
 */
public class StudentDB {
    // constants
    private final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/cis355a";
    private final String USER_NAME = "root";
    private final String PASSWORD = "devry123";
    
    // behaviors
    // save a student object to database
    public void add(Student stu) throws ClassNotFoundException, SQLException {
        // check for Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        
        // write the student record to the database
        String sqlStr = "INSERT INTO Students (StudentName, Test1, Test2, Test3) VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = conn.prepareStatement(sqlStr);
        pstm.setString(1, stu.getName());
        pstm.setDouble(2, stu.getTest1());
        pstm.setDouble(3, stu.getTest2());
        pstm.setDouble(4, stu.getTest3());
        
        pstm.execute();
        
        // close connection
        conn.close();
    }
    
}
 