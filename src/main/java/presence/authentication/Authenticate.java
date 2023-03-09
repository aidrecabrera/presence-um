package presence.authentication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Authenticate extends AuthenticateFunction implements Logs {
    private static String PRESENCE_USER_INFORMATION_DATABASE;
    private static String PRESENCE_USER_LOG_SHEET;

    public Authenticate() {
        super(PRESENCE_USER_INFORMATION_DATABASE);
        PRESENCE_USER_LOG_SHEET = importData.getDatabaseRequestLogs();
        PRESENCE_USER_INFORMATION_DATABASE = importData.getDatabaseAuthentication();
    }

    public static void DatabaseValidation() {
        createFileIfNotExists(PRESENCE_USER_INFORMATION_DATABASE);
        readUsersFromFile(PRESENCE_USER_INFORMATION_DATABASE);
    }

    protected void register(String userAddress, String userPassword) {
        if (userExists(userAddress)) {
            System.out.println("Username already exists.");
            return;
        }
        AuthenticateProfessorRetrieve newUserInformation = new AuthenticateProfessorRetrieve(userAddress, userPassword);
        registerUser(newUserInformation);
        saveUsersToFile(PRESENCE_USER_INFORMATION_DATABASE);
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
    @Override
    public void requestLogs(String username, boolean successful) {
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

