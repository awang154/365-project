package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class scheduleControl {
    private Map<String, String> columnMap;

    @FXML
    private TextField date; // This will now be used to enter time slot column names like "monmorn"

    @FXML
    private TextField ename;

    @FXML
    private void initialize() {
        columnMap = new HashMap<>();
        columnMap.put("monMorn", "monmorn");
        columnMap.put("monNoon", "monnoon");
        columnMap.put("monAft", "monaft");
        columnMap.put("tuesMorn", "tuesmorn");
        columnMap.put("tuesNoon", "tuesnoon");
        columnMap.put("tuesAft", "tuesaft");
        columnMap.put("wedMorn", "wedmorn");
        columnMap.put("wedNoon", "wednoon");
        columnMap.put("wedAft", "wedaft");
        columnMap.put("thursMorn", "thursmorn");
        columnMap.put("thursNoon", "thursnoon");
        columnMap.put("thursAft", "thursaft");
        columnMap.put("friMorn", "frimorn");
        columnMap.put("friNoon", "frinoon");
        columnMap.put("friAft", "friaft");
    }

    @FXML
    private void goBack() throws IOException {
        if (loginControl.admin == true) {
            App.setRoot("admin");
        } else {
            App.setRoot("employee");
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

    @FXML
    public void reg() {
        String emplName = ename.getText();
        String columnKey = date.getText();
        String columnName = columnMap.get(columnKey);

        if (columnName != null) {
            Label label = getLabelByColumnKey(columnKey);
            if (label != null) {
                label.setText(emplName);
            }

            try (Connection conn = DatabaseConnection.connect()) {
                String getEmpIdSQL = "select empID from Employee where firstName = ?";
                int employeeID = -1;

                try (PreparedStatement pstmt = conn.prepareStatement(getEmpIdSQL)) {
                    pstmt.setString(1, emplName);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        employeeID = rs.getInt("empID");
                    }
                }

                if (employeeID != -1) {
                    String insertSQL = "insert into WorkingSchedule (" + columnName + ", employeeID) values (?, ?)";
                    try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                        pstmt.setString(1, emplName);
                        pstmt.setInt(2, employeeID);
                        pstmt.executeUpdate();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee not found: " + emplName);
                    alert.showAndWait();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setHeaderText(null);
                alert.setContentText("Error inserting into WorkingSchedule table: " + ex.getMessage());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Column not found: " + columnKey);
            alert.showAndWait();
        }
    }

    private Label getLabelByColumnKey(String columnKey) {
        switch (columnKey) {
            case "monMorn":
                return monMorn;
            case "monNoon":
                return monNoon;
            case "monAft":
                return monAft;
            case "tuesMorn":
                return tuesMorn;
            case "tuesNoon":
                return tuesNoon;
            case "tuesAft":
                return tuesAft;
            case "wedMorn":
                return wedMorn;
            case "wedNoon":
                return wedNoon;
            case "wedAft":
                return wedAft;
            case "thursMorn":
                return thursMorn;
            case "thursNoon":
                return thursNoon;
            case "thursAft":
                return thursAft;
            case "friMorn":
                return friMorn;
            case "friNoon":
                return friNoon;
            case "friAft":
                return friAft;
            default:
                return null;
        }
    }
}
