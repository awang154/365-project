package main;

import java.io.IOException;

import javafx.fxml.FXML;

public class emplControl {

    @FXML
    private void emplBack() throws IOException {
        App.setRoot("login");
    }
 
}