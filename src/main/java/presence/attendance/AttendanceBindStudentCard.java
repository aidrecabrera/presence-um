package presence.attendance;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import presence.utilities.BasicFunctions;

import java.io.IOException;

public class AttendanceBindStudentCard {
    int row = 0;
    int col = 1;
    int counter = 0;
    BasicFunctions utilities = new BasicFunctions();
    public void bindStudentCard(GridPane embedContainer) throws IOException {
        int counter = 0;
        while (!(counter == 15)) {
            HBox newStudentCard = new HBox();
            utilities.createStudentHBox(newStudentCard, "TEST", "100", "500");
            embedContainer.add(newStudentCard, 1, row);
            ++counter;
            row++;
            if (row == 0 && col == 5) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 138.75);
            }
            System.out.println("Bounded!");
        }
    }
    public void bindStudentAttendanceCell(GridPane embedContainer) throws IOException {
        int counter = 0;
        while (!(counter == 3)) {
            VBox newMeetingCell = new VBox();
            utilities.setPropertyNewMeetingCell(newMeetingCell);
            embedContainer.add(newMeetingCell, 0, row);
            ++counter;
            row++;
            if (row == 0 && col < 5) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 138.75);
            }
            System.out.println("Cell!");
        }
    }
}
