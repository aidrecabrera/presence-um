package presence.attendance;

import javafx.scene.layout.GridPane;
import presence.API_Utilities;

import java.io.IOException;
import java.util.List;

public interface AttendanceBinder {
    API_Utilities utilities = new API_Utilities();

    String[] setAttendanceLabel() throws IOException;

    void bindStudentCard(GridPane embedContainer, int row, int col, int counter) throws IOException;

    void newStudentCell(GridPane embedContainer, int row, int col, int counter) throws IOException;

    List<String> getAttendanceHeaders() throws IOException;
}
