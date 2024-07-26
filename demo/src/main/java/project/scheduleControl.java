package project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class scheduleControl {
    private Map<String, Label> labelMap;

    @FXML
    private TextField date;

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
    @FXML
    private Label monNoon;
    @FXML
    private Label monAft;

    @FXML
    private Label tuesMorn;
    @FXML
    private Label tuesNoon;
    @FXML
    private Label tuesAft;

    @FXML
    private Label wedMorn;
    @FXML
    private Label wedNoon;
    @FXML
    private Label wedAft;

    @FXML
    private Label thursMorn;
    @FXML
    private Label thursNoon;
    @FXML
    private Label thursAft;

    @FXML
    private Label friMorn;
    @FXML
    private Label friNoon;
    @FXML
    private Label friAft;

    public void reg() {
        labelMap = new HashMap<>();
        labelMap.put("monMorn", monMorn);
        labelMap.put("monNoon", monNoon);
        labelMap.put("monAft", monAft);

        labelMap.put("tuesMorn", tuesMorn);
        labelMap.put("tuesNoon", tuesNoon);
        labelMap.put("tuesAft", tuesAft);

        labelMap.put("wedMorn", wedMorn);
        labelMap.put("wedNoon", wedNoon);
        labelMap.put("wedAft", wedAft);

        labelMap.put("thursMorn", thursMorn);
        labelMap.put("thursNoon", thursNoon);
        labelMap.put("thursAft", thursAft);

        labelMap.put("friMorn", friMorn);
        labelMap.put("friNoon", friNoon);
        labelMap.put("friAft", friAft);

        String emplName= ename.getText();

        String labelKey = date.getText();
        Label label = labelMap.get(labelKey);

        if (label != null) {
            label.setText(emplName);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Label not found: " + labelKey);
            alert.showAndWait();
        }
    }

}
