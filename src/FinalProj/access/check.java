package FinalProj.access;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class check {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            if ("admin".equals(username) && "admin".equals(password)) {
                loadPage("admin.fxml", "Admin Page");
            } else if ("employee".equals(username) && "employee".equals(password)) {
                loadPage("employee.fxml", "Employee Page");
            } else {
                showAlert(AlertType.ERROR, "Login Failed!", "Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "An error occurred while loading the page.");
        }
    }

    private void loadPage(String fxmlFile, String title) throws Exception {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        Pane root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
