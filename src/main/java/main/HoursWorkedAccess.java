package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoursWorkedAccess {

    // add hours
    public void addHoursWorked(HoursWorked hoursWorked){
        String insertStatement = "insert into HoursWorked(employeeID, date, hours_worked) values (?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect(); // connect to database
             PreparedStatement statement = conn.prepareStatement(insertStatement)){
            statement.setInt(1, hoursWorked.getempID());
            statement.setString(2, hoursWorked.getDate());
            statement.setDouble(3, hoursWorked.gethrsWorked());
            statement.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    // delete hours 
    public void deleteHoursWorked(int empID, String date){
        String deleteStatement = "delete from HoursWorked where employeeID = ? and date = ?";
        try (Connection conn = DatabaseConnection.connect(); // connect to database
             PreparedStatement statement = conn.prepareStatement(deleteStatement)){
            statement.setInt(1, empID);
            statement.setString(2, date);
            statement.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    // get all hours 
    public List<HoursWorked> getAllHoursWorked(){
        String selectStatement = "select * from HoursWorked";
        List<HoursWorked> hoursWorkedList = new ArrayList<>();
        try(Connection conn = DatabaseConnection.connect(); // connect to database
             PreparedStatement statement = conn.prepareStatement(selectStatement);
             ResultSet resultSet = statement.executeQuery()){
            while(resultSet.next()){
                HoursWorked hoursWorked = new HoursWorked(
                    resultSet.getInt("employeeID"),
                    resultSet.getString("date"),
                    resultSet.getDouble("hours_worked")
                );
                hoursWorkedList.add(hoursWorked);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return hoursWorkedList;
    }
}
