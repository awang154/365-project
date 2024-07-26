package project;

import java.io.IOException;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;

public class showAllControl {
    @FXML
    private void back() throws IOException{
        demoApp.setRoot("admin");
    }
}
