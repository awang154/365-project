package project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginControl {

    @FXML
    private TextField user;

    @FXML
    private PasswordField pass;

    @FXML
    private void loginCheck() {
        String username = user.getText();
        String password = pass.getText();

        if ("admin".equals(username) && "admin".equals(password)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome Admin!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
