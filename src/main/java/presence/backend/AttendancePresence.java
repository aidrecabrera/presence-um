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
import presence.API_CourseSheet;
import presence.HomeTab;
import presence.attendance.AttendanceAutomationQR;
import presence.attendance.AttendanceBindAndCell;
import presence.attendance.AttendanceFunction;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AttendancePresence extends AttendanceFunction {
    AttendanceBindAndCell bind = new AttendanceBindAndCell();
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
    private static String sheetURL;

    public AttendancePresence() throws FileNotFoundException {
    }

    public static void setSheetURL(String sheetURL) {
        AttendancePresence.sheetURL = sheetURL;
    }

    public String getSheetURL() {
        return this.sheetURL;
    }

    @FXML
    void initialize() throws IOException {
        System.out.println("TEST" + getSheetURL());
        String sheetURL = API_CourseSheet.getInstance().getCourseSheet();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardHome.fxml"));
        HomeTab homeTab = loader.getController();
        bind.bindStudentCard(STUDENT_CONTAINER, row, col, counter);
        COURSE.setText(bind.setAttendanceLabel()[1]);
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
    void QCP_COURSE_NEW_MEETING(ActionEvent event) {
        AttendanceAutomationQR quickCheckAPI = new AttendanceAutomationQR();
        quickCheckAPI.apiQQ();
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
