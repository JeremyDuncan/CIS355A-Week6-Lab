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
    private final String USERNAME = "root";
    private final String PASSWORD = "devry123";
    
    // behaviors
    // save a student object to database
    public void add(Student stu) throws ClassNotFoundException {
        // check for Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    
}
