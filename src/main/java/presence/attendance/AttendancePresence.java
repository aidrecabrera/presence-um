package presence.attendance;

import java.io.IOException;

import static presence.attendance.generateAttendance.*;

public class AttendancePresence {
    public static void main(String[] args) throws IOException {
        validateAttendanceSheet();
        attendanceEditor();
    }
}
