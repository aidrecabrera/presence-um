package presence.attendance;

import presence.scanning.QuickReadPresence;

import java.io.IOException;

public class AttendancePresence {
    private static final String COURSE_SUBJECT = "CCE107";
    private static final String COURSE_CODE = "9709";
    private static final String ATTENDANCE_FILE_PATH = "src/main/resources/presence/" + COURSE_CODE + "_" + COURSE_SUBJECT + "_ATTENDANCE_SHEET.csv";
    public static void main(String[] args) throws IOException {
        AttendanceFunction attendanceFunction = new AttendanceFunction();
        String AttendanceCSVLocation = "src/main/resources/presence/9709_CCE107_ATTENDANCE_SHEET.csv";
        String AttendanceStatus = "PRESENT"; // STATUS FROM COMBOBOX
        String CURRENT_STUDENT_ID = QuickReadPresence.QR_Read("src/main/resources/presence/test.png");
        attendanceFunction.attendanceEditor(AttendanceCSVLocation, CURRENT_STUDENT_ID, AttendanceStatus);
    }
}
