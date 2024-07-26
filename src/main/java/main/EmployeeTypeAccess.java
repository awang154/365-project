package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeTypeAccess{

    // add a new employee type
    public void addEmployeeType(EmployeeType employeeType){
        String insertStatement = "insert into EmployeeType (tName) values (?)";
        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement statement = conn.prepareStatement(insertStatement)){
            statement.setString(1, employeeType.gettName());
            statement.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    // delete an employee type
    public void deleteEmployeeType(int etID){
        String deleteStatement = "delete from EmployeeType where etID = ?";
        try(Connection conn = DatabaseConnection.connect();
             PreparedStatement statement = conn.prepareStatement(deleteStatement)){
             statement.setInt(1, etID);
             statement.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
