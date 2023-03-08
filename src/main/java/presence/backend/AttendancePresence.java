package presence.backend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import presence.API_Utilities;
import presence.HomeTab;
import presence.attendance.AttendanceBindAndCell;
import presence.attendance.AttendanceFunction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AttendancePresence extends AttendanceFunction {
    API_Utilities utilities = new API_Utilities();
    int row = 1;
    int col = 0;
    int counter = 0;
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
    private String Course;
    private String AttendanceCSVLocation;
    private final String AttendanceStatus = "PRESENT"; // STATUS FROM COMBOBOX
    AttendanceBindAndCell bind = new AttendanceBindAndCell();
    public AttendancePresence() throws FileNotFoundException {
    }
    @FXML
    void initialize() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardHome.fxml"));
        HomeTab homeTab = loader.getController();
        bind.bindStudentCard(STUDENT_CONTAINER, row, col, counter);
        System.out.println(getCourseCode());
        System.out.println(getCourseSubject());
        COURSE.setText(bind.setAttendanceLabel());
        for (String existingHeaders : bind.getAttendanceHeaders()) {
            ++col;
            generateAttendanceSheet();
            AttendanceBindAndCell bind = new AttendanceBindAndCell();
            bind.newStudentCell(STUDENT_CONTAINER, row, col, counter);
        }
    }

    @FXML
    public void GENERATE_NEW_COLUMN() throws IOException {
        ++col;
        generateAttendanceSheet();
        AttendanceBindAndCell bind = new AttendanceBindAndCell();
        bind.newStudentCell(STUDENT_CONTAINER, row, col, counter);
    }

    @FXML
    public void COURSE_NEW_MEETING() throws IOException {
        addNewColumnSheet();
        GENERATE_NEW_COLUMN();
    }

    public void backToDashboard(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) COURSE.getScene().getWindow();
        stage.close();
    }

}
