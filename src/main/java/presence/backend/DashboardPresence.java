package presence.backend;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import presence.API_Utilities;
import presence.API_Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardPresence implements Initializable  {
    API_Database importData = new API_Database();
    API_Utilities utilities = new API_Utilities();
    @FXML
    private JFXButton ButtonCalendar;
    @FXML
    private HBox ButtonDashboard;
    @FXML
    private JFXButton ButtonSignout;
    @FXML
    private JFXButton courseCardCCE107;
    @FXML
    private GridPane courseContainer;
    @FXML
    private SplitPane dashboardSplitContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dashboardSplitContainer.setPrefHeight(720);
        dashboardSplitContainer.setDividerPositions(0.167);
        try {
            importData.setDatabaseGetFXML("DashboardHome.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node rightSide = dashboardSplitContainer.getItems().get(1);
        dashboardSplitContainer.getItems().set(1, importData.getDatabaseGetFXML());

    }

    public DashboardPresence() throws IOException {

    }

    @FXML
    void AttendanceBclicked(ActionEvent event) throws IOException {

    }

    @FXML
    void CalendarBclicked(ActionEvent event) {

    }

    @FXML
    void DashboardBclicked(ActionEvent event) {

    }
}
