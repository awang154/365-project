package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://ambari-node5.csc.calpoly.edu/employeedatabase"; 
    private static final String USER = "employeedatabase"; 
    private static final String PASS = "Trancers5";

    public static Connection connect(){
        Connection connect = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection success.");
        }
        catch(ClassNotFoundException e){
            System.out.println("Could not load JDBC driver");
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
        catch(SQLException ex){
            System.err.println("SQLException information");
            while(ex != null){
                System.err.println ("Error msg: " + ex.getMessage());
                System.err.println ("SQLSTATE: " + ex.getSQLState());
                System.err.println ("Error code: " + ex.getErrorCode());
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return connect;
    }
}
