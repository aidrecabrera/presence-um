package presence.attendance;

import presence.BasicFunctions;
import presence.Database;

import java.io.IOException;

public interface AttendanceSheet {
    Database importDatabase = new Database();
    Database importData = new Database();
    BasicFunctions util = new BasicFunctions();
    BasicFunctions DateAPI = new BasicFunctions();
    BasicFunctions utilities = new BasicFunctions();

    void initializeAttendanceSheetHeader();
    void attendanceEditor(String paramFile, String paramStudentID, String paramAttendanceStatus) throws IOException;

    void generateAttendanceSheet();
}
