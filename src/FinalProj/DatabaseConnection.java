package FinalProj;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://ambari-node5.csc.calpoly.edu/rnguye65"; 
    private static final String USER = "rnguye65"; 
    private static final String PASS = "026379606";

    public static Connection connect(){
        Connection connect = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection success.");
        }
        catch(ClassNotFoundException e){
            System.out.println("class not found");
            e.printStackTrace();
        }
        catch(SQLException e){
            while(e != null){
                System.out.println("sql exception");
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        return connect;
    }

}
