package presence.attendance;

import javafx.scene.layout.*;
import presence.API_CourseSheet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttendanceBindAndCell implements AttendanceBinder {
    String LOCATION_SHEET_FILE_PATH = API_CourseSheet.getInstance().getCourseSheet();
    FileReader fileReader = new FileReader(LOCATION_SHEET_FILE_PATH);
    BufferedReader ComponentLabelReader = new BufferedReader(fileReader);
    String rowStudentInformation;

    public AttendanceBindAndCell() throws FileNotFoundException {
    }

    @Override
    public String[] setAttendanceLabel() throws IOException {
        FileReader fileReader = new FileReader(LOCATION_SHEET_FILE_PATH);
        BufferedReader getCourse = new BufferedReader(fileReader);
        getCourse.readLine();
        String getCurrentCourse = getCourse.readLine();
        String[] rowToArray = getCurrentCourse.split(",");
        System.out.println("COURSES" + Arrays.asList(rowToArray));
        return rowToArray;
    }

    @Override
    public List<String> getAttendanceHeaders() throws IOException {
        FileReader fileReader = new FileReader(LOCATION_SHEET_FILE_PATH);
        BufferedReader getCourse = new BufferedReader(fileReader);
        String getCurrentCourse = getCourse.readLine();
        List<String> attendanceHeaders = new ArrayList<>(Arrays.asList(getCurrentCourse.split(",")));
        attendanceHeaders.remove(0);
        attendanceHeaders.remove(0);
        attendanceHeaders.remove(0);
        attendanceHeaders.remove(0);
        System.out.println(attendanceHeaders);
        return attendanceHeaders;
    }

    @Override
    public void bindStudentCard(GridPane embedContainer, int row, int col, int counter) throws IOException {
        ComponentLabelReader.readLine();
        while ((rowStudentInformation = ComponentLabelReader.readLine()) != null) {
            HBox newStudentCard = new HBox();
            String[] courseInformationArray = rowStudentInformation.split(",");
            utilities.createStudentHBox(newStudentCard, courseInformationArray[3], "100", "500");
            embedContainer.add(newStudentCard, 0, row);
            ++counter;
            row++;
            if (row >= 6) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 100);
            }
            if (row == 0 && col < 20) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 138.75);
                embedContainer.addRow(1);
            }
        }
    }

    @Override
    public void newStudentCell(GridPane embedContainer, int row, int col, int counter) throws IOException {
        String MeetingDateID = getAttendanceHeaders().get(col-1);
        HBox hBox = (HBox) utilities.generateMeetingHeader(embedContainer, MeetingDateID);
        embedContainer.add(hBox, col, 0);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.SOMETIMES);
        columnConstraints.setMaxWidth(175.0);
        columnConstraints.setMinWidth(175.0);
        columnConstraints.setPrefWidth(175.0);
        embedContainer.getColumnConstraints().add(columnConstraints);
        ComponentLabelReader.readLine();
        while ((rowStudentInformation = ComponentLabelReader.readLine()) != null) {
            String[] courseInformationArray = rowStudentInformation.split(",");
            ArrayList<String> statusRow = new ArrayList<>(Arrays.asList(courseInformationArray));
            statusRow.remove(0);
            statusRow.remove(0);
            statusRow.remove(0);
            statusRow.remove(0);
            String MeetingStatus = statusRow.get(col-1);
            VBox newMeetingCell = new VBox();
            utilities.setPropertyNewMeetingCell(newMeetingCell, MeetingDateID, courseInformationArray[2], MeetingStatus, col);
            embedContainer.add(newMeetingCell, col, row);
            row++;
            if (row == 0 && col < 20) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 138.75);
                embedContainer.addRow(1);
            }
        }
    }
}
