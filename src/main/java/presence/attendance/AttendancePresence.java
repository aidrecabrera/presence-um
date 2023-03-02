package presence.attendance;

import presence.scanning.QuickReadPresence;

import java.io.IOException;

public class AttendancePresence extends AttendanceFunction {
    public static void main(String[] args) throws IOException {

        String AttendanceCSVLocation = "src/main/resources/presence/9709_CCE107_ATTENDANCE_SHEET.csv";
        String AttendanceStatus = "PRESENT"; // STATUS FROM COMBOBOX
        String CURRENT_STUDENT_ID = QuickReadPresence.QR_Read("src/main/resources/presence/test.png");
        attendanceEditor(AttendanceCSVLocation, CURRENT_STUDENT_ID, AttendanceStatus);
    }
}
