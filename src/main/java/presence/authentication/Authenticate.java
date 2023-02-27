package presence.authentication;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Authenticate {
    private static final String USER_FILE_PATH = "src/main/resources/presence/DB_PRESENCE_AUTHENTICATION.csv";
    private static AuthenticateService authenticationService = new AuthenticateService();

    public static void DatabaseValidation() {
        createFileIfNotExists(USER_FILE_PATH);
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

    protected static void register(String userAddress, String userPassword) {
        if (authenticationService.userExists(userAddress)) {
            System.out.println("Username already exists.");
            return;
        }

        AuthenticateUserRetrieval user = new AuthenticateUserRetrieval(userAddress, userPassword);
        authenticationService.registerUser(user);

        System.out.println("Registration successful.");
        authenticationService.saveUsersToFile(USER_FILE_PATH);
    }

     protected static void signIn(String userAddress, String userPassword) {
        if (!authenticationService.userExists(userAddress)) {
            requestLogs(userAddress, false);
            System.out.println("Username not found.");
            return;
        }

        if (!authenticationService.authenticateUser(userAddress, userPassword)) {
            requestLogs(userAddress, false);
            System.out.println("Incorrect password.");
            return;
        }

        System.out.println("Sign in successful.");
        authenticationService.saveUsersToFile(USER_FILE_PATH);
    }
    private static final String UM_PRESENCE_REQUEST_LOGS = "src/main/resources/presence/UM_PRESENCE_REQUEST_LOGS.csv";

    public static void requestLogs(String username, boolean successful) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(UM_PRESENCE_REQUEST_LOGS, true))) {
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

