package presence.attendance;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import presence.Database;
import presence.BasicFunctions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AttendanceBindStudentCard {
    int row = 1;
    int col = 0;
    int counter = 0;

    BasicFunctions utilities = new BasicFunctions();
    Database importData = new Database();
    FileReader fileReader = new FileReader("src/main/resources/attendance/9709_CCE107_ATTENDANCE_SHEET.csv");
    BufferedReader ComponentLabelReader = new BufferedReader(fileReader);
    String rowStudentInformation;

    public AttendanceBindStudentCard() throws FileNotFoundException {
    }

    public void bindStudentCard(GridPane embedContainer) throws IOException {
        ComponentLabelReader.readLine();
        int counter = 0;
        while ((rowStudentInformation = ComponentLabelReader.readLine()) != null && !(counter == 100)) {
            HBox newStudentCard = new HBox();
            String[] courseInformationArray = rowStudentInformation.split(",");
            utilities.createStudentHBox(newStudentCard, courseInformationArray[2], "100", "500");
            embedContainer.add(newStudentCard, 0, row);
            ++counter;
            row++;
            if (row >= 6) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 100);
            }
            System.out.println("Bounded!");
        }
    }
    public void bindStudentAttendanceCell(GridPane embedContainer) throws IOException {
        while ((rowStudentInformation = ComponentLabelReader.readLine()) != null) {
            VBox newMeetingCell = new VBox();
            utilities.setPropertyNewMeetingCell(newMeetingCell);
            embedContainer.add(newMeetingCell, 1, row);
            ++counter;
            row++;
            if (row == 0 && col < 20) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 138.75);
                embedContainer.addRow(1);
            }
            System.out.println("Cell!");
        }
    }
}
