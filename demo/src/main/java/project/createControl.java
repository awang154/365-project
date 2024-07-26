package project;

import java.io.IOException;

import javafx.fxml.FXML;

public class createControl {
    
    @FXML
    private void createEmployee(){

    }

    @FXML
    private void back() throws IOException {
        demoApp.setRoot("employee");
    }
}
