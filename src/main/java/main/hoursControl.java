package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class hoursControl {
    @FXML
    private TextField name;

    @FXML
    private TextField date;
    
    @FXML
    private TextField hours;

    @FXML
    private void back() throws IOException{
        App.setRoot("employee");
    }

    @FXML
    private void input() {
        String getEmpIdSQL = "select empID from Employee where firstName = ?";
        String hoursWorked = "insert into HoursWorked(employeeID, date, hours_worked) values (?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect()) {
            // Get employee ID
            int employeeID = -1;
            try (PreparedStatement pstmt = conn.prepareStatement(getEmpIdSQL)) {
                pstmt.setString(1, name.getText());
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    employeeID = rs.getInt("empID");
                } else {
                    System.out.println("Employee not found");
                    return;
                }
            }

            // Insert hours worked 
            if (employeeID != -1) {
                try (PreparedStatement statement = conn.prepareStatement(hoursWorked)) {
                    statement.setInt(1, employeeID);
                    statement.setString(2, date.getText());
                    statement.setDouble(3, Double.parseDouble(hours.getText()));
                    statement.executeUpdate();

                    System.out.println("Hours worked inserted successfully.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Database error");
        }

        name.setText("");
        date.setText("");
        hours.setText("");
    }
}
