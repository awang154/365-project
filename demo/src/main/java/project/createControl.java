package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class createControl {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField employeeTypeField;
    
    @FXML
    private void createEmployee(){
        String employee = "INSERT INTO Employee(firstName, lastName, phoneNumber, employeeType) VALUES(?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement statement = conn.prepareStatement(insertStatement)) {
            statement.setString(1, firstNameField.getText());
            statement.setString(2, lastNameField.getText());
            statement.setString(3, phoneNumberField.getText());
            statement.setInt(4, 1);
            statement.executeUpdate();


            System.out.println("Sample employees inserted successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void back() throws IOException {
        demoApp.setRoot("employee");
    }
}
