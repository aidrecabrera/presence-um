package presence;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import presence.utilities.BasicFunctions;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardPresence implements Initializable  {
    Database importData = new Database();
    BasicFunctions utilities = new BasicFunctions();

    @FXML
    private JFXButton ButtonCalendar;
    @FXML
    private HBox ButtonDashboard;

    @FXML
    private JFXButton ButtonSignout;

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

    @FXML
    private JFXButton courseCardCCE107;
    @FXML
    private GridPane courseContainer;
    @FXML
    private SplitPane dashboardSplitContainer;

    public void loadDashboardCourses() throws IOException {
//        String FilePath = importData.getDatabaseCourseList();
//        DashboardBindCourses courseBinder = new DashboardBindCourses();
//        courseBinder.bindCourseCard(courseContainer, dashboardSplitContainer);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            importData.setDatabaseGetFXML("DashboardHome.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node rightSide = dashboardSplitContainer.getItems().get(1);
        dashboardSplitContainer.getItems().set(1, importData.getDatabaseGetFXML());
    }
}
