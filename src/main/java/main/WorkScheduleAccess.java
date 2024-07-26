package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkScheduleAccess {

    // adding work schedule 
    public void addWorkSchedule(WorkSchedule workSchedule){
        String insertStatement = "insert into WorkingSchedule (date, employeeID) values (?, ?)";
        try(Connection conn = DatabaseConnection.connect(); // connect to database
             PreparedStatement statement = conn.prepareStatement(insertStatement)){
            statement.setString(1, workSchedule.getDate());
            statement.setInt(2, workSchedule.getempID());
            statement.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    // delete work schedule 
    public void deleteWorkSchedule(int schedID){
        String deleteStatement = "delete from WorkingSchedule where scheduleID = ?";
        try(Connection conn = DatabaseConnection.connect(); // connect to database
             PreparedStatement statement = conn.prepareStatement(deleteStatement)){
            statement.setInt(1, schedID);
            statement.executeUpdate();
        }catch(SQLException ex){    
            System.out.println(ex.getMessage());
        }
    }

    // get all work schedules
    public List<WorkSchedule> getAllWorkSchedules(){
        String selectStatement = "select * from WorkingSchedule";
        List<WorkSchedule> workScheduleList = new ArrayList<>();
        try(Connection conn = DatabaseConnection.connect(); // connect to database
             PreparedStatement statement = conn.prepareStatement(selectStatement);
             ResultSet resultSet = statement.executeQuery()){
            while(resultSet.next()){
                WorkSchedule workSchedule = new WorkSchedule(
                        resultSet.getInt("scheduleID"),
                        resultSet.getString("date"),
                        resultSet.getInt("employeeID")
                );
                workScheduleList.add(workSchedule);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return workScheduleList;
    }
}
