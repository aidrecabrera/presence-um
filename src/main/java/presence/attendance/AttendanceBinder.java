package presence.attendance;

import javafx.scene.layout.GridPane;

import java.io.IOException;

public interface AttendanceBinder {
    void bindStudentCard(GridPane embedContainer) throws IOException;

    void bindStudentAttendanceCell(GridPane embedContainer) throws IOException;
}
