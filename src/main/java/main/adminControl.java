package main;

import java.io.IOException;

import javafx.fxml.FXML;

public class adminControl {

    @FXML
    private void adminBack() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void showAll() throws IOException {
        
    }

    @FXML
    private void goSchedule() throws IOException {
        App.setRoot("schedule");
    }

    @FXML
    private void ecreate() throws IOException {
        App.setRoot("createemployee");
    }
 
}