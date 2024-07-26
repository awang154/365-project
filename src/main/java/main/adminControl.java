package main;

import java.io.IOException;

import javafx.fxml.FXML;

public class adminControl {

    @FXML
    private void adminBack() throws IOException {
        App.setRoot("login");
    }
 
}