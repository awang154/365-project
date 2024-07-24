package FinalProj.access;

import FinalProj.DatabaseConnection;
import FinalProj.classes.EmployeeType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    // get all employee types
    public List<EmployeeType> getAllEmployeeTypes(){
        String selectStatement = "select * frpm EmployeeType";
        List<EmployeeType> employeeTypes = new ArrayList<>();
        try(Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet dataResult = stmt.executeQuery(selectStatement)){
            while (dataResult.next()){
                EmployeeType employeeType = new EmployeeType(
                dataResult.getInt("etID"),
                dataResult.getString("tName")
                );
                employeeTypes.add(employeeType); 
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return employeeTypes;
    }

    // update an existing employee type
    public void updateEmployeeType(EmployeeType employeeType){
        String updateStatement = "update EmployeeType set tName = ? where etID = ?";
        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement statement = conn.prepareStatement(updateStatement)){
            statement.setString(1, employeeType.gettName());
            statement.setInt(2, employeeType.getetID());
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
