package presence.backend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import presence.API_Utilities;
import presence.HomeTab;
import presence.attendance.AttendanceBindAndCell;
import presence.attendance.AttendanceFunction;
import presence.dashboard.DashboardBindCourses;
import presence.scanning.QuickReadPresence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AttendancePresence extends AttendanceFunction {
    int row = 1;
    int col = 0;
    int counter = 0;
    API_Utilities utilities = new API_Utilities();
    @FXML
    private Label COURSE;
    @FXML
    private Label MEETING_DATE;
    @FXML
    private MenuButton STATUS_MARK;
    @FXML
    private GridPane STUDENT_CONTAINER;
    @FXML
    private Label STUDENT_NAME;
    @FXML
    private Label STUDENT_OVERALL;
    @FXML
    private HBox STUDENT_REFERENCE;
    @FXML
    private ScrollPane MEETING_SP;
    @FXML
    private ScrollPane STUDENT_SP;
    @FXML
    private GridPane ATTENDANCE_MEETING_COLUMN;
    @FXML
    private HBox MEETING_COLUMN_CONTAINER;

    private String AttendanceCSVLocation;
    private String AttendanceStatus = "PRESENT"; // STATUS FROM COMBOBOX
    private String CURRENT_STUDENT_ID = QuickReadPresence.QR_Read("src/main/resources/presence/test.png");

    public AttendancePresence() throws FileNotFoundException {
        this.AttendanceCSVLocation = "src/main/resources/presence/" + getCourseCode() + "_" + getCourseSubject() + "_ATTENDANCE_SHEET.csv";
    }
    AttendanceBindAndCell bind = new AttendanceBindAndCell();

    @FXML
    void initialize() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardHome.fxml"));
        HomeTab homeTab = loader.getController();

        bind.bindStudentCard(STUDENT_CONTAINER, row, col, counter);
    }

    @FXML
    public void COURSE_NEW_MEETING(javafx.event.ActionEvent actionEvent) throws IOException {
        generateAttendanceSheet();
        ++col;
        AttendanceBindAndCell bind = new AttendanceBindAndCell();
        bind.newStudentCell(STUDENT_CONTAINER, row, col, counter);
    }

    public void backToDashboard(ActionEvent actionEvent) throws IOException {

    }
}
