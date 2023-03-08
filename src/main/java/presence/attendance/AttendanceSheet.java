package presence.attendance;

import presence.API_Database;
import presence.API_Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface AttendanceSheet {
    API_Database importDatabase = new API_Database();
    API_Database importData = new API_Database();
    API_Utilities util = new API_Utilities();
    API_Utilities DateAPI = new API_Utilities();
    API_Utilities utilities = new API_Utilities();
    void initializeAttendanceSheetHeader();

    void attendanceEditor(String paramFile, String paramStudentID, String paramAttendanceStatus) throws IOException;

    void generateAttendanceSheet();
}
