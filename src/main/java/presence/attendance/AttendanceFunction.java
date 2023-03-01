package presence.attendance;

import presence.utilities.BasicFunctions;

import java.io.*;

class AttendanceFunction {
    static void generateAttendanceSheet(String paramsATTENDANCE_FILE_PATH) {
        File attendanceFile = new File(paramsATTENDANCE_FILE_PATH);
        if (!attendanceFile.exists()) {
            try {
                System.out.println("File created: " + paramsATTENDANCE_FILE_PATH);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(attendanceFile))) {
                    writer.write("COURSE,STUDENT_ID,STUDENT_NAME\n");
                    writer.flush();
                }
            } catch (IOException e) {
                System.out.println("Failed to create file: " + paramsATTENDANCE_FILE_PATH);
                e.printStackTrace();
            }
        }
    }

    static void initializeAttendanceSheetHeader(String paramsATTENDANCE_FILE_PATH) {
        BasicFunctions DateAPI = new BasicFunctions();
        try {
            // Open the file in read mode
            FileReader fileReader = new FileReader(paramsATTENDANCE_FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the first line and modify it
            String firstLine = bufferedReader.readLine();
            String DateNowForMeetingSession = DateAPI.getCurrentDate();
            String modifiedFirstLine = firstLine + "," + DateNowForMeetingSession;

            // modifiedFirstLine change to date

            // Open the file in write mode
            FileWriter fileWriter = new FileWriter(paramsATTENDANCE_FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the modified first line to the file
            bufferedWriter.write(modifiedFirstLine);
            bufferedWriter.newLine();

            // Write the rest of the file to the BufferedWriter
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + ",UNMARKED");
                bufferedWriter.newLine();
            }

            // Close the BufferedReader, BufferedWriter, FileReader, and FileWriter objects
            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void attendanceEditor(String paramFile, String paramStudentID, String paramAttendanceStatus) throws IOException {
        BasicFunctions util = new BasicFunctions();
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

        // read and edit each row
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length >= 3 && values[1].equals(searchString)) {
                // found a matching row
                if ((values.length == header.length) && !values[colIndex].isBlank() || !values[colIndex].isEmpty()) {
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