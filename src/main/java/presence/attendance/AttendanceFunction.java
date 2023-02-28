package presence.attendance;

import java.io.*;

public class AttendanceFunction {
    public static void main(String[] args) {

    }
}

class generateAttendance {
    private static final String COURSE_SUBJECT = "CCE107";
    private static final String COURSE_CODE = "9709";
    private static final String ATTENDANCE_FILE_PATH = "src/main/resources/presence/" + COURSE_CODE + "_" + COURSE_SUBJECT + "_ATTENDANCE_SHEET.csv";
    public static void validateAttendanceSheet() {
        generateAttendanceSheet();
    }
    static void generateAttendanceSheet() {
        File attendanceFile = new File(generateAttendance.ATTENDANCE_FILE_PATH);
        if (!attendanceFile.exists()) {
            try {
                System.out.println("File created: " + generateAttendance.ATTENDANCE_FILE_PATH);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(attendanceFile))) {
                    writer.write("COURSE,COURSE_CODE,STUDENT_NAME,STUDENT_NAME\n");
                    writer.flush();
                }

            } catch (IOException e) {
                System.out.println("Failed to create file: " + generateAttendance.ATTENDANCE_FILE_PATH);
                e.printStackTrace();
            }
        }
    }

    static void attendanceEditor() throws IOException {
        String filePath = "src/main/resources/presence/9709_CCE107_ATTENDANCE_SHEET.csv";
        String searchString = "Alice";
        String headerName = "Attendance";
        String newData = "PRESENT"; // the new data to replace the old data with

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

        // read and edit each row
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length >= 4 && values[3].equals(searchString)) {
                // found a matching row
                if (values.length == header.length && !values[colIndex].isEmpty()) {
                    // row already has data in the column, replace it
                    values[colIndex] = newData;
                    line = String.join(",", values);
                    found = true;
                } else {
                    // row doesn't have data in the column, skip it
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
}