package FinalProj.access;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class managementPage {
    @FXML
    private void handleScheduleButtonAction() {
        try {
            loadPage("schedule.fxml", "Schedule Page");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPage(String fxmlFile, String title) throws Exception {
        Stage stage = (Stage) schedule.getScene().getWindow(); // Assume scheduleButton is defined in FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Pane root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}