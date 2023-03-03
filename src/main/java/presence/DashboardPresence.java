package presence;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import presence.dashboard.DashboardBindCourses;
import presence.database.Database;
import presence.utilities.BasicFunctions;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardPresence implements Initializable  {
    Database importData = new Database();
    BasicFunctions utilities = new BasicFunctions();
    @FXML
    private Pane AttendancePane;
    @FXML
    private Pane CalendarPane;
    @FXML
    private Pane DashboardPane;
    @FXML
    private JFXComboBox<String> combobox1;

    @FXML
    private Text TTT;

    public DashboardPresence() throws IOException {

    }

    @FXML
    void AttendanceBclicked(ActionEvent event) throws IOException {
        AttendancePane.setVisible(true);
        DashboardPane.setVisible(false);
        CalendarPane.setVisible(false);
    }

    @FXML
    void CalendarBclicked(ActionEvent event) {
        AttendancePane.setVisible(false);
        DashboardPane.setVisible(false);
        CalendarPane.setVisible(true);
    }

    @FXML
    void DashboardBclicked(ActionEvent event) {
        AttendancePane.setVisible(false);
        DashboardPane.setVisible(true);
        CalendarPane.setVisible(false);
    }

    @FXML
    private JFXButton courseCardCCE107;
    @FXML
    private GridPane courseContainer;

    public void loadDashboardCourses() throws IOException {
        String FilePath = importData.getDatabaseCourseList();
        DashboardBindCourses courseBinder = new DashboardBindCourses();
        courseBinder.bindCourseCard(courseContainer);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [] classes = {"Class 1", "Class 2", "Class 3", "Class 4","Class 5","Class 6"};
        combobox1.getItems().addAll(classes);
        try {
            loadDashboardCourses();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
