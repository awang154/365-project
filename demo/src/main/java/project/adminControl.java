package project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;

public class adminControl {

    @FXML
    private void adminBack() throws IOException {
        demoApp.setRoot("login");
    }

    @FXML
    private void goSchedule() throws IOException {
        demoApp.setRoot("schedule");
    }

    @FXML
    private void showAll() throws IOException {
        demoApp.setRoot("showAll");
    }
 
}
