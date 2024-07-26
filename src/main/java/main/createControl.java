package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
    private void createEmployee() {
        String insertEmployeeType = "insert into EmployeeType(tName) values(?) on duplicate key update tName=tName";
        String insertEmployee = "insert into Employee(firstName, lastName, phoneNumber, employeeType) values(?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect()) {
            // Insert into EmployeeType table
            try (PreparedStatement typeStatement = conn.prepareStatement(insertEmployeeType)) {
                typeStatement.setString(1, employeeTypeField.getText());
                typeStatement.executeUpdate();
            }

            // Insert into Employee table
            try (PreparedStatement employeeStatement = conn.prepareStatement(insertEmployee)) {
                employeeStatement.setString(1, firstNameField.getText());
                employeeStatement.setString(2, lastNameField.getText());
                employeeStatement.setString(3, phoneNumberField.getText());
                employeeStatement.setString(4, employeeTypeField.getText());
                employeeStatement.executeUpdate();
            }

            System.out.println("Employee and employee type inserted successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void back() throws IOException {
        App.setRoot("admin");
    }
}
