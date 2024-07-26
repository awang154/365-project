package main;

import java.io.IOException;

import javafx.fxml.FXML;

public class emplControl {

    @FXML
    private void emplBack() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void goSchedule() throws IOException {
        App.setRoot("schedule");
    }

    @FXML
    private void emplHours() throws IOException {
        App.setRoot("hours");
    }

    @FXML
    private void ecreate() throws IOException {
        App.setRoot("createemployee");
    }
 
}