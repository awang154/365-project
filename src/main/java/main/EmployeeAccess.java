package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeAccess{

    // adding a new employee
    public void addEmployee(Employee employee){
        String insertStatement = "insert into Employee(firstName, lastName, phoneNumber, employeeType) values(?, ?, ?, ?)";
        try(Connection conn = DatabaseConnection.connect(); // connect to database
            PreparedStatement statement = conn.prepareStatement(insertStatement)){
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getPhoneNumber());
            statement.setInt(4, employee.getEmpType());
            statement.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    // delete employee
    public void deleteEmployee(int employeeId){
        String deleteStatement = "delete from Employee where employee_id = ?";
        try(Connection conn = DatabaseConnection.connect(); // connect to database
            PreparedStatement statement = conn.prepareStatement(deleteStatement)){
                statement.setInt(1, employeeId);
                statement.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
