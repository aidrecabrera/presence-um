package bin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BIN {
    static void manualAttendanceFunction() {
        // The strings to be appended
        String firstString = ",DATE";
        String otherString = ",Absent";
        // The path of the text file
        String filePath = "src/main/resources/presence/9709_CCE107_ATTENDANCE_SHEET.csv";
        // Create a StringBuilder object
        StringBuilder sb = new StringBuilder();

        try {
            // Create a BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            // Read each line of the file
            String line = br.readLine();
            // Initialize a counter variable
            int counter = 1;
            while (line != null) {
                // Append different strings based on the line number
                if (counter == 1) {
                    sb.append(line).append(firstString);
                }
                // Add a new line character
                sb.append(System.lineSeparator());
                // Read the next line
                line = br.readLine();
                // Increment the counter
                counter++;
            }
            // Close the BufferedReader
            br.close();

            // Create a FileWriter object
            FileWriter fw = new FileWriter(filePath);
            // Write the modified content back to the file
            fw.write(sb.toString());
            // Close the FileWriter
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void findIDAppend() throws IOException {
        String filePath = "src/main/resources/presence/9709_CCE107_ATTENDANCE_SHEET.csv";
        String searchString = "Charlie";
        String HEADER_NAME = "Attendance";
        String newData = "PRESENT";

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        int columnToInsert = -1; // initialize column index to -1

        // Read the header row
        String header = br.readLine();
        String[] headerValues = header.split(",");

        // Find the index of the column to insert
        for (int i = 0; i < headerValues.length; i++) {
            if (headerValues[i].equals(HEADER_NAME)) {
                columnToInsert = i;
                break;
            }
        }

        if (columnToInsert == -1) {
            // The header row does not contain the specified header name
            // Append the new header name to the existing header row
            sb.append(header).append(",").append(HEADER_NAME).append("\n");
            columnToInsert = headerValues.length; // new column index is the last column
        } else {
            // The header row already contains the specified header name
            sb.append(header).append("\n");
        }

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length >= 4 && values[3].equals(searchString)) {
                // found a matching row
                if (values.length > columnToInsert && !values[columnToInsert].isEmpty()) {
                    // row already has data in the specified column, skip it
                    sb.append(line).append("\n");
                    System.out.println("Row already has data in the specified column, skipping...");
                } else {
                    // row doesn't have data in the specified column, add it
                    if (values.length == columnToInsert) {
                        // row does not have enough columns, add empty columns up to the specified column
                        for (int i = values.length; i < columnToInsert; i++) {
                            sb.append(",");
                        }
                    }
                    sb.append(line).append(",");
                    sb.append(newData).append("\n");
                    found = true;
                }
            } else {
                // not a matching row, add as is
                sb.append(line).append("\n");
            }
        }
        br.close();

        if (!found) {
            System.out.println("Search string not found in the CSV file");
            return;
        }

        FileWriter writer = new FileWriter(filePath);
        writer.write(sb.toString());
        writer.close();

        System.out.println("Data added to the matching row in the CSV file");
    }
}


