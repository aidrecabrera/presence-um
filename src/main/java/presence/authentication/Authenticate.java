package um.presence.authentication;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Authenticate {
    private static final String USER_FILE_PATH = "src/main/resources/um/presence/ui/authentication/DB_PRESENCE_AUTHENTICATION.TXT";
    private static AuthenticateService authenticationService;

    public static void main(String[] args) {
        createFileIfNotExists("DB_PRESENCE_AUTHENTICATION.TXT");
        authenticationService = new AuthenticateService();
        authenticationService.readUsersFromFile(USER_FILE_PATH);

        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Enter 1 to register or 2 to sign in: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> register(input);
                case 2 -> signIn(input);
                default -> System.out.println("Invalid choice.");
            }

            System.out.println("Enter 1 to continue or 2 to exit: ");
            int continueChoice = input.nextInt();

            if (continueChoice == 2) {
                isRunning = false;
            }
        }

        authenticationService.saveUsersToFile(USER_FILE_PATH);
    }
    public static void createFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + filePath);
            } catch (IOException e) {
                System.out.println("Failed to create file: " + filePath);
                e.printStackTrace();
            }
        }
    }
    private static void register(Scanner input) {
        System.out.println("Enter a username: ");
        String username = input.next();

        if (authenticationService.userExists(username)) {
            System.out.println("Username already exists.");
            return;
        }

        System.out.println("Enter a password: ");
        String password = input.next();

        AuthenticateUserRetrieval user = new AuthenticateUserRetrieval(username, password);
        authenticationService.registerUser(user);

        System.out.println("Registration successful.");
    }

    private static void signIn(Scanner input) {
        System.out.println("Enter your username: ");
        String username = input.next();

        if (!authenticationService.userExists(username)) {
            System.out.println("Username not found.");
            return;
        }

        System.out.println("Enter your password: ");
        String password = input.next();

        if (!authenticationService.authenticateUser(username, password)) {
            System.out.println("Incorrect password.");
            return;
        }

        System.out.println("Sign in successful.");
    }
}

