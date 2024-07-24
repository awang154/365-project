package FinalProj.access;

import FinalProj.DatabaseConnection;
import FinalProj.classes.Employee;
import java.sql.*;

public class EmployeeAccess{

    // adding a new employee
    public void addEmployee(Employee employee){
        String insertStatement = "insert into Employees(first_name, last_name, phone_number, employee_type) values(?, ?, ?, ?)";
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

    // select all employees
    // public List<Employee> getAllEmployees(){
    //     String selectStatement = "select * from Employees";
    //     List<Employee> employees = new ArrayList<>();
    //     try(Connection conn = DatabaseConnection.connect(); // connect to database
    //     Statement stmt = conn.createStatement();
    //     ResultSet dataResult = stmt.executeQuery(selectStatement)){
    //         while(dataResult.next()){
    //             Employee employee = new Employee(
    //             dataResult.getInt("employee_id"),
    //             dataResult.getString("first_name"),
    //             dataResult.getString("last_name"),
    //             dataResult.getString("phone_number"),
    //             dataResult.getInt("employee_type")
    //             );
    //             employees.add(employee);
    //         }
    //     }catch(SQLException ex){
    //         System.out.println(ex.getMessage());
    //     }
    //     return employees;
    // }

    // Method to update an existing employee
    // public void updateEmployee(Employee employee){
    //     String updateStatement = "update Employees set first_name = ?, last_name = ?, phone_number = ?, employee_type = ? where employee_id = ?";
    //     try(Connection conn = DatabaseConnection.connect(); // connect to database
    //         PreparedStatement statement = conn.prepareStatement(updateStatement)){
    //             statement.setString(1, employee.getFirstName());
    //             statement.setString(2, employee.getLastName());
    //             statement.setString(3, employee.getPhoneNumber());
    //             statement.setInt(4, employee.getEmpType());
    //             statement.setInt(5, employee.getEmployeeId());
    //             statement.executeUpdate();
    //     }catch(SQLException ex){
    //         System.out.println(ex.getMessage());
    //     }
    // }

    // delete employee
    public void deleteEmployee(int employeeId){
        String sql = "delete from Employees where employee_id = ?";
        try(Connection conn = DatabaseConnection.connect(); // connect to database
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, employeeId);
                pstmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
