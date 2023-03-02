package presence.authentication;

import presence.database.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Authenticate extends AuthenticateService{
    private static String PRESENCE_USER_INFORMATION_DATABASE;
    private static String PRESENCE_USER_LOG_SHEET;

    Database importData = new Database();
    public Authenticate() {
        super(PRESENCE_USER_INFORMATION_DATABASE);
        this.PRESENCE_USER_LOG_SHEET = importData.getDatabaseRequestLogs();
        this.PRESENCE_USER_INFORMATION_DATABASE = importData.getDatabaseAuthentication();
    }

    public static void DatabaseValidation() {
        createFileIfNotExists(PRESENCE_USER_INFORMATION_DATABASE);
    }
    public static void createFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + filePath);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write("ADMIN EMAIL,ADMIN PASSWORD\n");
                    writer.flush();
                }

            } catch (IOException e) {
                System.out.println("Failed to create file: " + filePath);
                e.printStackTrace();
            }
        }
    }

    protected void register(String userAddress, String userPassword) {
        if (userExists(userAddress)) {
            System.out.println("Username already exists.");
            return;
        }
        AuthenticateUserRetrieval newUserInformation = new AuthenticateUserRetrieval(userAddress, userPassword);
        registerUser(newUserInformation);
        saveUsersToFile(PRESENCE_USER_INFORMATION_DATABASE); // Move this line outside the if-else block
        System.out.println("Registration successful.");
    }

    protected boolean signIn(String userAddress, String userPassword) {
        if (!userExists(userAddress)) {
            requestLogs(userAddress, false);
            System.out.println("Username not found.");
            return false;
        }
        if (!authenticateUser(userAddress, userPassword)) {
            requestLogs(userAddress, false);
            System.out.println("Incorrect password.");
            return false;
        }
        System.out.println("Sign in successful.");
        return true;
    }
    public static void requestLogs(String username, boolean successful) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRESENCE_USER_LOG_SHEET, true))) {
            writer.write("DATE,LOGIN DATE,NAME,STATUS,HASH\n");
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = now.format(formatter);
            String status = successful ? "SUCCESS" : "FAILURE";
            String hash = String.format("%08X", username.hashCode());
            String logLine = String.format("%s, %s, %s, %s\n", timestamp, username, status, hash);
            writer.write(logLine);
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to login log file: " + e.getMessage());
        }
    }
}

