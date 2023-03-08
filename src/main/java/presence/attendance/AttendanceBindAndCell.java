package presence.attendance;

import javafx.scene.layout.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AttendanceBindAndCell implements AttendanceBinder {
    FileReader fileReader = new FileReader("src/main/resources/attendance/9709_CCE107_ATTENDANCE_SHEET.csv");
    BufferedReader ComponentLabelReader = new BufferedReader(fileReader);
    String rowStudentInformation;

    public AttendanceBindAndCell() throws FileNotFoundException {
    }

    @Override
    public void bindStudentCard(GridPane embedContainer, int row, int col, int counter) throws IOException {
        ComponentLabelReader.readLine();
        while ((rowStudentInformation = ComponentLabelReader.readLine()) != null) {
            HBox newStudentCard = new HBox();
            String[] courseInformationArray = rowStudentInformation.split(",");
            utilities.createStudentHBox(newStudentCard, courseInformationArray[2], "100", "500");
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
        embedContainer.add(utilities.generateMeetingHeader(embedContainer), col, 0);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.SOMETIMES);
        columnConstraints.setMaxWidth(125.0);
        columnConstraints.setMinWidth(125.0);
        columnConstraints.setPrefWidth(125.0);
        embedContainer.getColumnConstraints().add(columnConstraints);
        while ((rowStudentInformation = ComponentLabelReader.readLine()) != null) {
            VBox newMeetingCell = new VBox();
            utilities.setPropertyNewMeetingCell(newMeetingCell);
            embedContainer.add(newMeetingCell, col, row);
            row++;
            if (row == 0 && col < 20) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 138.75);
                embedContainer.addRow(1);
            }
        }
    }
}
