package presence.attendance;

import javafx.scene.layout.GridPane;
import presence.API_Utilities;

import java.io.IOException;

public interface AttendanceBinder {
    API_Utilities utilities = new API_Utilities();
    void bindStudentCard(GridPane embedContainer, int row, int col, int counter) throws IOException;

    void newStudentCell(GridPane embedContainer, int row, int col, int counter) throws IOException;
}
