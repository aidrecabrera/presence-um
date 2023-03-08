package presence.attendance;

import javafx.scene.layout.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttendanceBindAndCell implements AttendanceBinder {
    FileReader fileReader = new FileReader("src/main/resources/attendance/9709_CCE107_ATTENDANCE_SHEET.csv");
    BufferedReader ComponentLabelReader = new BufferedReader(fileReader);
    String rowStudentInformation;

    public AttendanceBindAndCell() throws FileNotFoundException {
    }

    @Override
    public String setAttendanceLabel() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/attendance/9709_CCE107_ATTENDANCE_SHEET.csv");
        BufferedReader getCourse = new BufferedReader(fileReader);
        getCourse.readLine();
        String getCurrentCourse = getCourse.readLine();
        String[] rowToArray = getCurrentCourse.split(",");
        return rowToArray[0];
    }

    @Override
    public List<String> getAttendanceMeetings() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/attendance/9709_CCE107_ATTENDANCE_SHEET.csv");
        BufferedReader getCourse = new BufferedReader(fileReader);
        getCourse.readLine();
        String getCurrentCourse = getCourse.readLine();
        List<String> rowToArrayList = new ArrayList<>(Arrays.asList(getCurrentCourse.split(",")));
        System.out.println(rowToArrayList);
        return rowToArrayList;
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
        String MeetingDateID = utilities.generateDate();
        HBox hBox = (HBox) utilities.generateMeetingHeader(embedContainer, MeetingDateID);
        embedContainer.add(hBox, col, 0);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.SOMETIMES);
        columnConstraints.setMaxWidth(125.0);
        columnConstraints.setMinWidth(125.0);
        columnConstraints.setPrefWidth(125.0);
        embedContainer.getColumnConstraints().add(columnConstraints);
        ComponentLabelReader.readLine();
        while ((rowStudentInformation = ComponentLabelReader.readLine()) != null) {
            String[] courseInformationArray = rowStudentInformation.split(",");
            VBox newMeetingCell = new VBox();
            utilities.setPropertyNewMeetingCell(newMeetingCell, MeetingDateID, courseInformationArray[2]);
            embedContainer.add(newMeetingCell, col, row);
            row++;
            if (row == 0 && col < 20) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 138.75);
                embedContainer.addRow(1);
            }
        }
    }
}
