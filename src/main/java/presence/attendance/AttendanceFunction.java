package presence.attendance;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;

public abstract class AttendanceFunction implements AttendanceSheet, AttendanceMeeting, AttendanceCalculate, AttendanceBinder {
    private static String COURSE_SUBJECT;
    private static String COURSE_CODE;
    private static final String LOCATION_SHEET_FILE_PATH = "src/main/resources/presence/" + COURSE_CODE + "_" + COURSE_SUBJECT + "_ATTENDANCE_SHEET.csv";

    public AttendanceFunction() throws FileNotFoundException {
    }

    public static void setCourseSubject(String courseSubject) {
        COURSE_SUBJECT = courseSubject;
    }

    public static void setCourseCode(String courseCode) {
        COURSE_CODE = courseCode;
    }

    public static String getCourseSubject() {
        return COURSE_SUBJECT;
    }

    public static String getCourseCode() {
        return COURSE_CODE;
    }

    @Override
    public void createNewMeeting() {

    }
    @Override
    public void markStudentMeetingStatus() {

    }

    @Override
    public void calculateOverallCourseAttendance() {

    }
    @Override
    public void calculateOverallStudentAttendance() {

    }

    @Override
    public void generateAttendanceSheet() {
        File attendanceFile = new File(LOCATION_SHEET_FILE_PATH);
        if (!attendanceFile.exists()) {
            try {
                System.out.println("File created: " + LOCATION_SHEET_FILE_PATH);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(attendanceFile))) {
                    writer.write("COURSE,STUDENT_ID,STUDENT_NAME\n");
                    writer.flush();
                }
            } catch (IOException e) {
                System.out.println("Failed to create file: " + LOCATION_SHEET_FILE_PATH);
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initializeAttendanceSheetHeader() {
        try {
            FileReader fileReader = new FileReader(LOCATION_SHEET_FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String firstLine = bufferedReader.readLine();
            String DateNowForMeetingSession = DateAPI.getCurrentDate();
            String modifiedFirstLine = firstLine + "," + DateNowForMeetingSession;

            FileWriter fileWriter = new FileWriter(LOCATION_SHEET_FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(modifiedFirstLine);
            bufferedWriter.newLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + ",UNMARKED");
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void attendanceEditor(String paramFile, String paramStudentID, String paramAttendanceStatus) throws IOException {
        String filePath = paramFile;
        String searchString = util.removeFirstChar(paramStudentID);
        String headerName = util.getCurrentDate();
        String newData = paramAttendanceStatus; // the new data to replace the old data with

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        StringBuilder sb = new StringBuilder();
        boolean found = false;

        // read the header row and get the index of the column to edit
        String headerRow = br.readLine();
        String[] header = headerRow.split(",");
        int colIndex = -1;
        for (int i = 0; i < header.length; i++) {
            if (header[i].equals(headerName)) {
                colIndex = i;
                break;
            }
        }
        if (colIndex == -1) {
            System.out.println("Header not found in CSV file");
            br.close();
            return;
        }
        sb.append(headerRow).append("\n");

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length >= 3 && values[1].equals(searchString)) {
                if ((values.length == header.length) && !values[colIndex].isBlank() || !values[colIndex].isEmpty()) {
                    values[colIndex] = newData;
                    line = String.join(",", values);
                    found = true;
                } else {
                    System.out.println("Row doesn't have data in the column, skipping...");
                }
            }
            sb.append(line).append("\n");
        }
        br.close();

        if (!found) {
            System.out.println("Search string not found in the CSV file");
            return;
        }

        FileWriter writer = new FileWriter(filePath);
        writer.write(sb.toString());
        writer.close();

        System.out.println("Data edited in the matching row and column in the CSV file");
    }

    int row = 1;
    int col = 0;
    int counter = 0;

    FileReader fileReader = new FileReader("src/main/resources/attendance/9709_CCE107_ATTENDANCE_SHEET.csv");
    BufferedReader ComponentLabelReader = new BufferedReader(fileReader);
    String rowStudentInformation;

    @Override
    public void bindStudentCard(GridPane embedContainer) throws IOException {
        ComponentLabelReader.readLine();
        int counter = 0;
        while ((rowStudentInformation = ComponentLabelReader.readLine()) != null && !(counter == 100)) {
            HBox newStudentCard = new HBox();
            String[] courseInformationArray = rowStudentInformation.split(",");
            utilities.createStudentHBox(newStudentCard, courseInformationArray[2], "100", "500");
            embedContainer.add(newStudentCard, 0, row);
            ++counter;
            row++;
            if (row >= 6) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 100);
            }
        }
    }
    @Override
    public void bindStudentAttendanceCell(GridPane embedContainer) throws IOException {
        while ((rowStudentInformation = ComponentLabelReader.readLine()) != null) {
            VBox newMeetingCell = new VBox();
            utilities.setPropertyNewMeetingCell(newMeetingCell);
            embedContainer.add(newMeetingCell, 1, row);
            ++counter;
            row++;
            if (row == 0 && col < 20) {
                embedContainer.setPrefHeight(embedContainer.getPrefHeight() + 138.75);
                embedContainer.addRow(1);
            }
            System.out.println("Cell!");
        }
    }
}
