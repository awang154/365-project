package project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class scheduleControl {

    @FXML
    private TextField ename;

    @FXML
    private void goBack() throws IOException {
        if (loginControl.admin == true){
            demoApp.setRoot("admin");
        }
        else {
            demoApp.setRoot("employee");
        }
    }

    @FXML
    private Label monMorn;

    public void reg() {
        String emplName= ename.getText();
        monMorn.setText(emplName);
    }

}
