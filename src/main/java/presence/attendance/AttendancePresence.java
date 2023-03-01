package presence.attendance;

import java.io.IOException;

public class AttendancePresence {
    public static void main(String[] args) {
        AttendanceFunction attendanceFunction = new AttendanceFunction();
        attendanceFunction.validateAttendanceSheet();
        try {
            attendanceFunction.attendanceEditor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
