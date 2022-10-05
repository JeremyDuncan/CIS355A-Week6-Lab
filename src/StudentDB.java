import java.sql.*;
import java.util.ArrayList;

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
    
    public ArrayList<Student> getAll() throws ClassNotFoundException, SQLException {
        // Create an empty array
        ArrayList<Student> list = new ArrayList<Student>();
        
        // Check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        
        // Get records from database
        String strSQL  = "SELECT * FROM Students"; 
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(strSQL);
        
        while (rs.next()) {
            int stuID = rs.getInt(1);
            String name = rs.getString(2);
            double test1 = rs.getDouble(3);
            double test2 = rs.getDouble(4);
            double test3 = rs.getDouble(5);
            
            Student stu = new Student(stuID, name, test1, test2, test3);
            
            list.add(stu);
        }
        
        // CLose connection ot database
        conn.close();
        
        // Return ArrayList
        return list;
    }
    
}
 