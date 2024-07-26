package project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;

public class loginControl {
    @FXML
    private TextField userLogin;

    @FXML
    private TextField passLogin;

    private String adminPass = "admin";
    private String emplPass = "employee";
    private String emplUser = "employee";
    private String adminUser = "admin";

    @FXML
    private void checkLogin() throws IOException {
        String username = userLogin.getText();
        String password = passLogin.getText();
        if (username.equals(adminUser) && password.equals(adminPass)){
            demoApp.setRoot("admin");
        }
        else if (username.equals(emplUser) && password.equals(emplPass)) {
            demoApp.setRoot("employee");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password");
            alert.showAndWait();
        }
    }
 
}
