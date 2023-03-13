package presence.attendance;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import presence.API_CourseSheet;
import presence.API_Utilities;
import presence.MainPresence;
import presence.backend.AttendancePresence;
import presence.scanning.QRScanner;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AttendanceAutomationQR {
    QRScanner apiQRScanner = new QRScanner();
    AttendanceFunction attendanceFunction = new AttendanceFunction();
    AttendanceBindAndCell attendanceBindAndCell = new AttendanceBindAndCell();
    API_Utilities utilities = new API_Utilities();

    @FXML
    private TextArea confirmationLog;

    @FXML
    private Label studentID;

    public AttendanceAutomationQR() throws FileNotFoundException {
    }

    public void apiQQ() {
        apiQRScanner.run();
    }

    public void runUntilNewID(String header, int col) throws IOException {
        String oldID = null;
        while (true) {
            while (true) {
                apiQQ();
                if (apiQRScanner.getStudentID() != null) {
                    String newID = utilities.removeFirstChar(apiQRScanner.getStudentID());
                    System.out.println("Return Student ID: " + newID);
                    attendanceFunction.attendanceEditor(header, newID, "PRESENT");
                    System.out.println("Passed Parameters: " + header + " " + newID + " " + "PRESENT");
                    confirmationLog.appendText("Confirmed Presence for " + newID + "\n");
                    studentID.setText(newID);
                }
                break;
            }
        }
    }

}
