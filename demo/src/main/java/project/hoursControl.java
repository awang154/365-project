package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;


public class hoursControl {
    @FXML
    private TextField name;

    @FXML
    private TextField date;
    
    @FXML
    private TextField hours;

    
    @FXML
    private void input() {
        String hoursWorked = "INSERT INTO HoursWorked(name, date, hours_worked) values (?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement statement = conn.prepareStatement(insertStatement)) {
            statement.setString(1, name.getText());
            statement.setString(2, date.getText());
            statement.setString(3, hours.getText());
            statement.executeUpdate();

            System.out.println("Sample employees inserted successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        name.setText("");
        date.setText("");
        hours.setText("");
    }
}
