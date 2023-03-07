package presence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presence.attendance.AttendanceBindStudentCard;
import presence.attendance.AttendanceFunction;
import presence.scanning.QuickReadPresence;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AttendancePresence extends AttendanceFunction {
    String AttendanceCSVLocation = "src/main/resources/presence/9709_CCE107_ATTENDANCE_SHEET.csv";
    String AttendanceStatus = "PRESENT"; // STATUS FROM COMBOBOX
    String CURRENT_STUDENT_ID = QuickReadPresence.QR_Read("src/main/resources/presence/test.png");
    BasicFunctions utilities = new BasicFunctions();
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

    public AttendancePresence() throws FileNotFoundException {
    }

    @FXML
    void initialize() throws IOException {
        Stage stage = null;
        if (COURSE.getScene() != null) {
            stage = (Stage) COURSE.getScene().getWindow();
        }
        if (stage != null) {
            stage.setOnCloseRequest(we -> {
                System.out.println("Stage is closing");
            });
        }
        AttendanceBindStudentCard bindStudentCard = new AttendanceBindStudentCard();
        bindStudentCard.bindStudentCard(STUDENT_CONTAINER);
        AttendanceBindStudentCard attendanceBindStudentCard = new AttendanceBindStudentCard();
        attendanceBindStudentCard.bindStudentAttendanceCell(STUDENT_CONTAINER);
    }
    @FXML
    private GridPane ATTENDANCE_MEETING_COLUMN;
    @FXML
    private HBox MEETING_COLUMN_CONTAINER;

    @FXML
    public void COURSE_NEW_MEETING(javafx.event.ActionEvent actionEvent) throws IOException {
        VBox newMeetingColumn = new VBox();
        utilities.setPropertyNewBindMeetingColumn(newMeetingColumn);
        MEETING_COLUMN_CONTAINER.getChildren().add(newMeetingColumn);
    }

    public void backToDashboard(ActionEvent actionEvent) throws IOException {

    }
}
