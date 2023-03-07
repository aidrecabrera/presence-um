package presence.backend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import presence.API_Utilities;
import presence.attendance.AttendanceFunction;
import presence.scanning.QuickReadPresence;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AttendancePresence extends AttendanceFunction {
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

    @FXML
    void initialize() throws IOException {
        bindStudentCard(STUDENT_CONTAINER);
        bindStudentAttendanceCell(STUDENT_CONTAINER);
    }
    @FXML
    public void COURSE_NEW_MEETING(javafx.event.ActionEvent actionEvent) throws IOException {
        VBox newMeetingColumn = new VBox();
        utilities.setPropertyNewBindMeetingColumn(newMeetingColumn);
        MEETING_COLUMN_CONTAINER.getChildren().add(newMeetingColumn);
    }
    public void backToDashboard(ActionEvent actionEvent) throws IOException {

    }
}
