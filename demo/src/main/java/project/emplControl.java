package project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;

public class emplControl {

    @FXML
    private void emplBack() throws IOException {
        demoApp.setRoot("login");
    }
 
}
